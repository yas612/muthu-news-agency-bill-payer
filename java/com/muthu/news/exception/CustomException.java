package com.muthu.news.exception;

public class CustomException extends Exception{
	
private static final long serialVersionUID = -2903268500100321707L;
	/**
	 * Parameterized constructor
	 * @param message
	 */
	public CustomException(String message)
	{
		super(message);
	}

}
