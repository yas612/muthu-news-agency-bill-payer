package com.muthu.news.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muthu.news.SecretManager;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.controller.LoginController;
import com.razorpay.Order;
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

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response, String mob, String payid,
			String orderid, String sig) throws ServletException, IOException {
		RazorpayClient razorpay = null;
		logger.info("Payment has been done by user : "+mob+ "for order id : "+orderid);
		try {
			razorpay = new RazorpayClient(manager.getKey(), manager.getSecret());
			JSONObject options = new JSONObject();
			options.put(MuthuConstants.ORDER_ID, orderid);
			options.put(MuthuConstants.PAY_ID, payid);
			options.put(MuthuConstants.PAY_SIG, sig);

			boolean status = Utils.verifyPaymentSignature(options, manager.getSecret());
			if (status) {
				logger.info("Payment verification is SUCCESS for user : "+mob+ "for order id : "+orderid);
				service.updateStatus(mob);
			} else {
				logger.error("Payment verification FAILED for user : "+mob+ "for order id : "+orderid);
			}
		} catch (Exception e) {
			logger.error("ERROR while verifying payment for user : "+mob+ "for order id : "+orderid);
			logger.error(e.getMessage());
		}

	}

	@Override
	public void payOrder(HttpServletRequest request, HttpServletResponse response, String reqAmount)
			throws RazorpayException, IOException {

		int finalAmount = (Integer.parseInt(reqAmount) * 100);
		logger.info("Payment has been request for amount : "+reqAmount);
		RazorpayClient razorpay = null;
		Order order = null;
		JSONObject orderRes = new JSONObject();
		String reqURL = request.getRequestURL().toString();
		String finURL = reqURL.replace(request.getServletPath(), "")+MuthuConstants.URL_APPEND;
		try {
			razorpay = new RazorpayClient(manager.getKey(), manager.getSecret());

			JSONObject orderRequest = new JSONObject();
			orderRequest.put(MuthuConstants.AMOUNT, finalAmount);
			orderRequest.put(MuthuConstants.CURRENCY, MuthuConstants.CURRENCY_UNIT);
			orderRequest.put(MuthuConstants.RECEIPT, MuthuConstants.RECEIPT_VALUE);
			orderRequest.put(MuthuConstants.PAYMENT_CAPTURE, true);

			logger.info("Order request for amount : "+reqAmount+" -> "+orderRequest.toString());
			order = razorpay.orders.create(orderRequest);

			logger.info("Order has been created for amount : "+reqAmount+" -> "+order.toString());
			orderRes.put(MuthuConstants.AMOUNT, order.get(MuthuConstants.AMOUNT).toString());
			orderRes.put(MuthuConstants.ORDER_ID, order.get(MuthuConstants.ID).toString());
			orderRes.put(MuthuConstants.RZ_ID, manager.getKey());
			orderRes.put(MuthuConstants.CALLBACK_URL, finURL);
			
		} catch (Exception e) {
			logger.error("Payment request for amount "+reqAmount+" FAILED.");
			logger.error(e.getMessage());
		}
		
		response.getWriter().append(orderRes.toString());

	}

}
