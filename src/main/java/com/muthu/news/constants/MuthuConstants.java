package com.muthu.news.constants;

public class MuthuConstants {
	
	public static final String ERROR_MSG = "errorMsg";
	public static final String USER_NOT_EXIST = "Your mobile Number %s doesn't exists !!!";
	public static final String DECIDER = "decider";
	public static final String DISABLER = "disabled=\"disabled\"";
	public static final String ALL_PRODUCTS_FETCH_ERROR = "ERROR occured while fetching Product details";
	public static final String ADD_PRODUCT_ERROR_MSG = "ERROR occurred while adding Product with details : %s";
	public static final String ADD_PRODUCT_SUCCESS_MSG = "SUCCESSFULLY added product with details : %s";
	public static final String EDIT_PRODUCT_ERROR_MSG = "ERROR occurred while updating Product with details : %s";
	public static final String EDIT_PRODUCT_SUCCESS_MSG = "SUCCESSFULLY updated product with details : %s";
	public static final String DEL_PRODUCT_SUCCESS_MSG = "Product deletion action for product with code : %s is SUCCESS";
	public static final String DEL_PRODUCT_ERROR_MSG = "Product deletion action for product with code : %s is FAILED";
	public static final String USER_FETCH_ERROR = "ERROR occured while fetching users";
	public static final String DEL_USER_SUCCESS_MSG = "User deletion action for user : %s  is SUCCESS";
	public static final String DEL_USER_ERROR_MSG = "User deletion action for user : %s  is FAILED";
	public static final String ADD_USER_SUCCESS_MSG = "User addition FAILED with info : %s is SUCCESS";
	public static final String ADD_USER_ERROR_MSG = "User addition FAILED with info : %s is FAILED";
	public static final String EDIT_USER_SUCCESS_MSG = "User edit action for user : %s  is SUCCESS";
	public static final String EDIT_USER_ERROR_MSG = "User edit action for user : %s  is FAILED";
	public static final String URL_APPEND = "/pay/verify/";
	public static final String URL_PAY_REQ = "/pay/order/";
	public static final String PAY_REQ_URL = "url";
	public static final String FETCH_PAY_ORDER_URL = "https://api.razorpay.com/v1/orders/%s/payments";
	public static final String SUCCESS_UPDATE_STATUS_MSG = "Successfully updated all status";
	public static final String FAILED_UPDATE_STATUS_MSG = "ERROR occurred while updaing status";
	public static final String PAYMENT_STATUS = "status";
	public static final String EXPECTED_PAY_STATUS = "captured";
	public static final String EMPTY_VALUE = "";
	public static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss";
	
	//json
	public static final String AMOUNT = "amount";
	public static final String CURRENCY = "currency";
	public static final String CURRENCY_UNIT = "INR";
	public static final String RECEIPT = "receipt";
	public static final String RECEIPT_VALUE = "receipt#1";
	public static final String PAYMENT_CAPTURE = "payment_capture";
	public static final String ORDER_ID_VALUE = "orderId";
	public static final String ID = "id";
	public static final String RZ_ID = "rzid";
	public static final String CALLBACK_URL = "callBackUrl";
	
	//status
	public static final String PAID = "PAID";
	public static final String NOT_PAID = "NOT-PAID";
	
	//request param
	public static final String ORDER_ID = "razorpay_order_id";
	public static final String PAY_ID = "razorpay_payment_id";
	public static final String PAY_SIG = "razorpay_signature";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String PREVIOUS_PRICE = "previousPrice";
	public static final String MOB = "mob";
	public static final String REQ_ORDER_ID = "orderId";
	
	//View names
	public static final String LOGIN_PAGE = "login";
	public static final String USER_INFO = "user-info";
	public static final String ADMIN_PAGE = "admin";
	public static final String PAY_PAGE = "pay";
	public static final String PRODUCT_PAGE = "products";
	public static final String ADD_PRODUCT_PAGE = "add-product";
	public static final String EDIT_PRODUCT_PAGE = "edit-product";
	public static final String DEL_PRODUCT_PAGE = "delete-product";
	public static final String USERS_PAGE = "users";
	public static final String EDIT_USER_PAGE = "edituser";
	public static final String DEL_USER_PAGE = "delete-user";
	public static final String ADD_USER_PAGE = "add-user";
	public static final String STATUS_REST_PAGE = "status-reset";
	public static final String PAY_SUCCESS_PAGE = "pay-success";
	

	// user
	public static final String GET_USER_BY_MOB = "SELECT * FROM \"muthuUsers\" WHERE mob =?";
	public static final String GET_ALL_USERS = "SELECT * FROM \"muthuUsers\"";
	public static final String DEL_USER = "DELETE FROM \"muthuUsers\" WHERE mob=?";
	public static final String AFFETCTED_USERS = "SELECT * FROM \"muthuUsers\" WHERE papers LIKE '%param%'";
	public static final String UPDATE_USER_BILL = "UPDATE \"muthuUsers\" SET bill=? WHERE mob=?";
	public static final String UPDATE_USER_STATUS = "UPDATE \"muthuUsers\" SET status=? WHERE mob=?";
	public static final String UPDATE_EVERYONE_STATUS = "UPDATE \"muthuUsers\" SET status='NOT-PAID'";
	public static final String ADD_USER = "INSERT INTO \"muthuUsers\" (mob, name, reg, papers, bill, status)\r\n"
			+ "	VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USER = "UPDATE \"muthuUsers\" SET name=?, reg=?, papers=?, bill=?, status=?\r\n"
			+ "WHERE mob=?";

	// paper
	public static final String GET_ALL_PRODUCT = "SELECT * FROM \"product\"";
	public static final String ADD_PRODUCT = "INSERT INTO \"product\" (code, name, price) VALUES (?, ?, ?)";
	public static final String DEL_PRODUCT = "DELETE FROM \"product\" WHERE code=?";
	public static final String UPDATE_PRODUCT = "UPDATE \"product\" SET price=? WHERE code=?";
	public static final String GET_PRODUCT_BY_CODE = "SELECT * FROM \"product\" WHERE code=?";
	
	//payment
	public static final String GET_ALL_UNPAID_ORDERS = "SELECT * FROM \"payment\" WHERE status='NOT-PAID'";
	public static final String NON_ELIGIBLE_ORDER = "UPDATE \"payment\" SET status='NOT-ELIGIBLE' WHERE orderid=?";
	public static final String CREATE_PAY_RECORD = "INSERT INTO \"payment\" ( orderid, payid, mob, billmonth, "
			+ "paymentdatetime, status) VALUES (?, ?, ?, ?, ?, 'NOT-PAID');";
	public static final String UPDATE_PAY_RECORD = "UPDATE \"payment\" SET payid=?, mob=?, billmonth=?, "
			+ "paymentdatetime=?, status='PAID' WHERE orderid=?";

}
