package com.muthu.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.User;
import com.muthu.news.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService userService;

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("login");
		mView.addObject("errorMsg", "");

		return mView;
	}

	@RequestMapping("/login")
	public ModelAndView processLogin(@RequestParam("mob") String mob) {
		Boolean decider = userService.checkMob(mob);
		ModelAndView mView = new ModelAndView();
		User user;
		if (decider) {
			user = userService.getUserInfo(mob);
			if(user.getStatus().equalsIgnoreCase("PAID")) {
				mView.addObject("decider", "disabled=\"disabled\"");
			}
			mView.setViewName("user-info");
			mView.addObject("user", user);
			return mView;
		} else {

			mView.setViewName("login");
			mView.addObject("errorMsg", "Your mobile Number "+mob+ " doesn't exists !!!");
			return mView;
		}

	}
	
	@RequestMapping("/admin")
	public ModelAndView adminLogin() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("admin");

		return mView;
	}
}
