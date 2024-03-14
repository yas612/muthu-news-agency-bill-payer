package com.muthu.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.service.PaymentService;
import com.muthu.news.constants.MuthuConstants;
import com.razorpay.RazorpayException;

@Controller
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@RequestMapping("/order/{amount}")
	public void payOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable String amount)
			throws RazorpayException, IOException {
		service.payOrder(request, response, amount);
	}

	@PostMapping("/verify/{mob}")
	protected ModelAndView doPost(HttpServletRequest request, HttpServletResponse response, @PathVariable String mob,
			@RequestParam(MuthuConstants.PAY_ID) String payid, @RequestParam(MuthuConstants.ORDER_ID) String orderid,
			@RequestParam(MuthuConstants.PAY_SIG) String sig) throws ServletException, IOException {
		service.doPost(request, response, mob, payid, orderid, sig);
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.PAY_PAGE);
		return mView;
	}

	@RequestMapping("/page")
	public ModelAndView pay() {

		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.PAY_PAGE);
		return mView;
	}

}
