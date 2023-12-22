package com.muthu.news.constants;

public class MuthuConstants {
	
	//user
	public static final String GET_USER_BY_MOB = "SELECT * FROM \"muthuUsers\" WHERE mob =?";
	public static final String GET_ALL_USERS = "SELECT * FROM \"muthuUsers\"";
	public static final String DEL_USER = "DELETE FROM \"muthuUsers\" WHERE mob=?";
	public static final String ADD_USER = "INSERT INTO \"muthuUsers\" (mob, name, reg, papers, bill, status)\r\n"
			+ "	VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USER = "UPDATE \"muthuUsers\" SET name=?, reg=?, papers=?, bill=?, status=?\r\n"
			+ "WHERE mob=?";
	
	//product
	public static final String GET_ALL_PRODUCT = "SELECT * FROM \"product\"";
	public static final String ADD_PRODUCT = "INSERT INTO \"product\" (code, name, price) VALUES (?, ?, ?)";
	public static final String DEL_PRODUCT = "DELETE FROM \"product\" WHERE code=?";
	public static final String UPDATE_PRODUCT = "UPDATE \"product\" SET price=? WHERE code=?";
	public static final String GET_PRODUCT_BY_CODE = "SELECT * FROM \"product\" WHERE code=?";

}
