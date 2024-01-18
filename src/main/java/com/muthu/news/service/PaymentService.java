package com.muthu.news.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.razorpay.RazorpayException;

public interface PaymentService {

	void doPost(HttpServletRequest request, HttpServletResponse response, String mob, String payid, 
			String orderid, String sig) 
			throws ServletException, IOException; 
	void payOrder(HttpServletRequest request, HttpServletResponse response, String amount) 
			  throws RazorpayException, IOException;
}
