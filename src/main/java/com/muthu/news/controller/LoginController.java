package com.muthu.news.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.User;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService userService;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping("/loginpage")
	public ModelAndView login() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.LOGIN_PAGE);
		mView.addObject(MuthuConstants.ERROR_MSG, "");
		return mView;
	}

	@RequestMapping("/login")
	public ModelAndView processLogin(@RequestParam(MuthuConstants.MOB) String mob, HttpServletRequest request) {
		Boolean decider = userService.checkMob(mob);
		ModelAndView mView = new ModelAndView();
		User user;
		if (decider) {
			logger.info("User exist with mobile number : " + mob);
			user = userService.getUserInfo(mob);
			if (user.getStatus().equalsIgnoreCase(MuthuConstants.PAID)) {
				mView.addObject(MuthuConstants.DECIDER, MuthuConstants.DISABLER);
			}
			String siteURL = request.getRequestURL().toString();
			String finURL = siteURL.replace(request.getServletPath(), "") + MuthuConstants.URL_PAY_REQ;
			mView.addObject(MuthuConstants.PAY_REQ_URL, finURL);
			mView.setViewName(MuthuConstants.USER_INFO);
			mView.addObject("user", user);
			return mView;
		} else {
			logger.info("User doesn't exist with mobile number : " + mob);
			mView.setViewName(MuthuConstants.LOGIN_PAGE);
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.USER_NOT_EXIST, mob));
			return mView;
		}

	}

	@RequestMapping("/admin")
	public ModelAndView adminLogin() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.ADMIN_PAGE);
		return mView;
	}
	
	/*
	 * @RequestMapping(value = "/admin/logout") public String
	 * logout(HttpServletRequest request) { HttpSession session =
	 * request.getSession(false); if (session != null) { session.invalidate();
	 * session.setMaxInactiveInterval(60*60); } return "redirect:/loginpage";
	 * //Where you go after logout here. }
	 */
}
