package com.muthu.news.service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.muthu.news.MuthuPayment;
import com.muthu.news.SecretManager;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.mapper.PaymentRowMapper;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	private UserService service;

	@Autowired
	private SecretManager manager;

	@Autowired
	private JdbcTemplate template;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response, String mob, String payid,
			String orderid, String sig) throws ServletException, IOException {
		RazorpayClient razorpay = null;
		logger.info("Payment has been done by user : " + mob + " for order id : " + orderid
				+ " & verification is in progress");
		try {
			razorpay = new RazorpayClient(manager.getKey(), manager.getSecret());
			JSONObject options = new JSONObject();
			options.put(MuthuConstants.ORDER_ID, orderid);
			options.put(MuthuConstants.PAY_ID, payid);
			options.put(MuthuConstants.PAY_SIG, sig);

			boolean status = Utils.verifyPaymentSignature(options, manager.getSecret());
			if (status) {
				Payment payment = razorpay.payments.fetch(payid);
				String finalPayStatus = payment.get(MuthuConstants.PAYMENT_STATUS);

				if (finalPayStatus.equalsIgnoreCase(MuthuConstants.EXPECTED_PAY_STATUS)) {

					logger.info("Payment verification is SUCCESS for user : " + mob + " for order id : " + orderid);
					service.updateStatus(mob);
					updatePayRec(payid, mob, orderid);
				}

			} else {
				logger.error("Payment verification FAILED for user : " + mob + " for order id : " + orderid);
			}
		} catch (Exception e) {
			logger.error("ERROR while verifying payment for user : " + mob + " for order id : " + orderid);
			logger.error(e.getMessage());
		}

	}

	@Override
	public void payOrder(HttpServletRequest request, HttpServletResponse response, String reqAmount)
			throws RazorpayException, IOException {

		int finalAmount = (Double.valueOf(reqAmount).intValue() * 100);
		logger.info("Payment has been request for amount : " + reqAmount);
		RazorpayClient razorpay = null;
		Order order = null;
		JSONObject orderRes = new JSONObject();
		String reqURL = request.getRequestURL().toString();
		String finURL = reqURL.replace(request.getServletPath(), "") + MuthuConstants.URL_APPEND;
		String imgUrl = reqURL.replace(request.getServletPath(), "") + "/resources/img/logo.png";
		try {
			razorpay = new RazorpayClient(manager.getKey(), manager.getSecret());

			JSONObject orderRequest = new JSONObject();
			orderRequest.put(MuthuConstants.AMOUNT, finalAmount);
			orderRequest.put(MuthuConstants.CURRENCY, MuthuConstants.CURRENCY_UNIT);
			orderRequest.put(MuthuConstants.RECEIPT, MuthuConstants.RECEIPT_VALUE);
			orderRequest.put(MuthuConstants.PAYMENT_CAPTURE, true);

			logger.info("Order request for amount : " + reqAmount + " -> " + orderRequest.toString());
			order = razorpay.orders.create(orderRequest);

			logger.info("Order has been created for amount : " + reqAmount + " -> " + order.toString());
			orderRes.put(MuthuConstants.AMOUNT, order.get(MuthuConstants.AMOUNT).toString());
			orderRes.put(MuthuConstants.REQ_ORDER_ID, order.get(MuthuConstants.ID).toString());
			orderRes.put(MuthuConstants.RZ_ID, manager.getKey());
			orderRes.put(MuthuConstants.CALLBACK_URL, finURL);
			orderRes.put("imgUrl", imgUrl);

			createPayRec(order.get(MuthuConstants.ID).toString());

		} catch (Exception e) {
			logger.error("Payment request for amount " + reqAmount + " FAILED.");
			logger.error(e.getMessage());
		}

		response.getWriter().append(orderRes.toString());

	}

	protected void createPayRec(String orderid) {

		logger.info("Creating a payment record for order id : " + orderid);
		try {
			template.update(MuthuConstants.CREATE_PAY_RECORD, new Object[] { orderid, MuthuConstants.EMPTY_VALUE,
					MuthuConstants.EMPTY_VALUE, MuthuConstants.EMPTY_VALUE, MuthuConstants.EMPTY_VALUE });
		} catch (Exception e) {
			logger.error("creating payment record for order id : " + orderid + " is FAILED");
			logger.error(e.getMessage());
		}

	}

	protected void updatePayRec(String payid, String mob, String orderid) {

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern(MuthuConstants.DATE_FORMAT);
		String dateWithTimeStamp = dateformatter.format(date);

		try {
			template.update(MuthuConstants.UPDATE_PAY_RECORD,
					new Object[] { payid, mob, date.getMonth().toString(), dateWithTimeStamp, orderid });
		} catch (Exception e) {
			logger.error("creating payment record for order id : " + orderid + " is FAILED");
			logger.error(e.getMessage());
		}

	}

	public void updatePaymentDetail() throws RazorpayException {
		List<MuthuPayment> payments = null;
		RazorpayClient razorpay = null;
		logger.info("Process started to update unprocessed order");
		try {
			payments = template.query(MuthuConstants.GET_ALL_UNPAID_ORDERS, new PaymentRowMapper());
			razorpay = new RazorpayClient(manager.getKey(), manager.getSecret());

			if (!CollectionUtils.isEmpty(payments)) {
				logger.info("Number of unprocessed order is : " + payments.size());
				for (MuthuPayment payment : payments) {
					logger.info("Fetching payment detail from Razorpay for order id : " + payment.getOrderid());
					List<Payment> possiblePayments = razorpay.orders.fetchPayments(payment.getOrderid());
					if (!CollectionUtils.isEmpty(possiblePayments)) {
						logger.info("Number of payments found for order id : " + payment.getOrderid() + " is "
								+ possiblePayments.size());
						for (Payment pay : possiblePayments) {
							if (pay != null) {
								if (pay.get("status").toString().equalsIgnoreCase("captured")) {
									logger.info("Payment status is captured");
									logger.info("Updating payment record in payment table");
									String num = pay.get("contact").toString();
									updatePayRec(pay.get("id").toString(), num.replace("+91", "").toString(),
											payment.getOrderid());
									logger.info("Updating payment record in users table");
									service.updateStatus(payment.getMob());
									logger.info("Scheduled updation process ENDED");

								} else {
									logger.info("No payment is made against orderid : " + payment.getOrderid()
											+ " & marking it as NOT-ELIGIBLE");
									template.update(MuthuConstants.NON_ELIGIBLE_ORDER,
											new Object[] { payment.getOrderid() });
								}

							} else {
								logger.error("Payment object retrieved is NULL");
							}
						}
					}
					else {
						template.update(MuthuConstants.NON_ELIGIBLE_ORDER,
								new Object[] { payment.getOrderid() });
					}
				}
			}

		} catch (Exception e) {
			logger.error("ERROR occurred while updating scheduled payment process");
			logger.error(e.getMessage());
		}

	}

}
