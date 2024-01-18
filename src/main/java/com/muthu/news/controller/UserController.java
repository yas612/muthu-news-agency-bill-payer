package com.muthu.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.Product;
import com.muthu.news.User;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.exception.CustomException;
import com.muthu.news.service.ProductService;
import com.muthu.news.service.UserService;

@RestController
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ProductService pService;

	@RequestMapping("/all")
	public ModelAndView allUsers() throws CustomException {
		List<User> userlist = service.getAllUser();
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.USERS_PAGE);
		if (userlist == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, MuthuConstants.USER_FETCH_ERROR);
			return mView;
		} else {
			mView.addObject("userlist", userlist);
			return mView;
		}

	}

	@RequestMapping("/all/editPage/{mob}")
	public ModelAndView editUserPage(@PathVariable String mob) throws CustomException {
		User user = service.getAUser(mob);
		List<Product> products = pService.getAll();
		ModelAndView mView = new ModelAndView();
		mView.addObject("productlist", products);
		mView.addObject("user", user);
		mView.setViewName(MuthuConstants.EDIT_USER_PAGE);
		return mView;
	}

	@RequestMapping("/all/editPage/edituser")
	public ModelAndView editUser(@RequestParam String mob, @RequestParam String name, @RequestParam String reg,
			@RequestParam String updatedPapers, @RequestParam Double bill) throws CustomException {
		User user = new User();
		user.setMob(mob);
		user.setName(name);
		user.setReg(reg);
		user.setPapers(updatedPapers);
		user.setBill(bill);
		user.setStatus(MuthuConstants.NOT_PAID);
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.EDIT_USER_PAGE);
		Boolean decider = service.updateUser(user);
		if (decider) {
			mView.addObject(MuthuConstants.ERROR_MSG,
					String.format(MuthuConstants.EDIT_USER_SUCCESS_MSG, user.toString()));
		} else {
			mView.addObject(MuthuConstants.ERROR_MSG,
					String.format(MuthuConstants.EDIT_USER_ERROR_MSG, user.toString()));
		}

		return mView;
	}

	@RequestMapping("/all/delPage/{mob}")
	public ModelAndView delUserPage(@PathVariable String mob) {
		User user = service.getAUser(mob);
		ModelAndView mView = new ModelAndView();
		mView.addObject("mob", user.getMob());
		mView.setViewName(MuthuConstants.DEL_USER_PAGE);
		return mView;
	}

	@RequestMapping("/all/delPage/deluser")
	public ModelAndView delUser(@RequestParam String mob) throws CustomException {
		Boolean decider = service.removeUser(mob);
		ModelAndView mView = new ModelAndView();
		if (decider) {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.DEL_USER_SUCCESS_MSG, mob));
		} else {
			mView.addObject(MuthuConstants.ERROR_MSG, String.format(MuthuConstants.DEL_USER_ERROR_MSG, mob));
		}
		mView.setViewName(MuthuConstants.DEL_USER_PAGE);
		return mView;
	}

	@RequestMapping("/all/adduserPage")
	public ModelAndView addUserPage() throws CustomException {
		List<Product> products = pService.getAll();
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.ADD_USER_PAGE);
		mView.addObject("productlist", products);
		return mView;
	}

	@RequestMapping("/all/adduser")
	public ModelAndView addUser(@RequestParam String mob, @RequestParam String name, @RequestParam String reg,
			@RequestParam String papers, @RequestParam Double bill) throws CustomException {
		User user = new User();
		user.setMob(mob);
		user.setName(name);
		user.setReg(reg);
		user.setPapers(papers);
		user.setBill(0.00);
		User userTocreate = service.addUser(user);
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.ADD_USER_PAGE);
		if (userTocreate == null) {
			mView.addObject(MuthuConstants.ERROR_MSG,
					String.format(MuthuConstants.ADD_USER_ERROR_MSG, user.toString()));
		}

		else {
			mView.addObject(MuthuConstants.ERROR_MSG,
					String.format(MuthuConstants.ADD_USER_SUCCESS_MSG, user.toString()));
		}
		return mView;
	}

	@RequestMapping("/all/reset/page")
	public ModelAndView updateAllUsersStatusPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.STATUS_REST_PAGE);
		return mView;
	}
	
	@RequestMapping("/all/reset/status")
	public ModelAndView updateAllUsersStatus() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.STATUS_REST_PAGE);
		String msg = service.updateAllUserStatus();
		mView.addObject(MuthuConstants.ERROR_MSG, msg);
		return mView;
	}

}
