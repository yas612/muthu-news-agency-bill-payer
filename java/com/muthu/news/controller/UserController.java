package com.muthu.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.news.User;
import com.muthu.news.exception.CustomException;
import com.muthu.news.service.UserService;

@RestController
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/all")
	public ModelAndView allUsers() throws CustomException {
		List<User> userlist = service.getAllUser();
		ModelAndView mView = new ModelAndView();
		if(userlist == null) {
			mView.addObject("errorMsg", "ERROR occured while fetching user details");
			mView.setViewName("users");
			return mView;
		}
		else {
		mView.setViewName("users");
		mView.addObject("userlist", userlist);
		return mView;
		}
		
	}
	
	@RequestMapping("/all/editPage/{mob}")
	public ModelAndView editUserPage(@PathVariable String mob) {
		User user = service.getAUser(mob);
		ModelAndView mView = new ModelAndView();
		mView.addObject("user", user);
			mView.setViewName("edituser");
			return mView;
	}
	
	@RequestMapping("/all/editPage/edituser")
	public ModelAndView editUser(@RequestParam String mob, @RequestParam String name, 
			@RequestParam String reg, @RequestParam String papers, @RequestParam Double bill) throws CustomException {
		User user = new User();
		user.setMob(mob);
		user.setName(name);
		user.setReg(reg);
		user.setPapers(papers);
		user.setBill(bill);
		user.setStatus("NOT-PAID");
		service.updateUser(user);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("edituser");
		return mView;
	}
	
	@RequestMapping("/all/delPage/{mob}")
	public ModelAndView delUserPage(@PathVariable String mob) {
		User user = service.getAUser(mob);
		ModelAndView mView = new ModelAndView();
		mView.addObject("mob", user.getMob());
		mView.setViewName("delete-user");
		return mView;
	}
	
	@RequestMapping("/all/delPage/deluser")
	public ModelAndView delUser(@RequestParam String mob) throws CustomException {
		Boolean decider = service.removeUser(mob);
		ModelAndView mView = new ModelAndView();
		if(decider) {
			mView.addObject("msg", "<p>User deletion action for user : "+mob+" is SUCCESS</p>");
		}
		else {
			mView.addObject("msg", "<p>User deletion action for user : "+mob+" is FAILED</p>");
		}
		mView.setViewName("delete-user");
		return mView;
	}
	
	@RequestMapping("/all/adduserPage")
	public ModelAndView addUserPage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("add-user");
		return mView;
	}
	
	@RequestMapping("/all/adduser")
	public ModelAndView addUser(@RequestParam String mob, @RequestParam String name, 
			@RequestParam String reg, @RequestParam String papers, @RequestParam Double bill) throws CustomException {
		User user = new User();
		user.setMob(mob);
		user.setName(name);
		user.setReg(reg);
		user.setPapers(papers);
		user.setBill(0.00);
		User userTocreate = service.addUser(user);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("add-user");
		if(userTocreate == null) {
			mView.addObject("msg", "User addition FAILED with info : "+user.toString());
		}
		
		else {
			mView.addObject("msg", "User addition SUCCESS with info : "+userTocreate.toString());
		}
		return mView;
	}

}
