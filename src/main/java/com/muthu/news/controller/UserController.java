package com.muthu.news.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public ModelAndView allUsers(HttpServletRequest request, @RequestParam String page) throws CustomException {
		int recordsPerPage = 50;
		int reqPage = Integer.parseInt(page);
		
		List<User> userlist = service.getAllUser(recordsPerPage, ((reqPage*recordsPerPage)-recordsPerPage));

		int noOfRecords = service.getUsersCounts();

		ModelAndView mView = new ModelAndView();
		mView.setViewName(MuthuConstants.USERS_PAGE);
		if (userlist == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, MuthuConstants.USER_FETCH_ERROR);
			return mView;
		} else {
			Set<String> reg = service.getAllUser().stream().map(User::getReg).collect(Collectors.toSet());
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("noOfPages", noOfPages);
			mView.addObject("reg", reg);
			request.setAttribute("currentPage", page);
			mView.addObject("userlist", userlist);
			return mView;
		}

	}
	
	@RequestMapping("/all/filter/{params}")
	public ModelAndView allUsersByFilter(HttpServletRequest request, @RequestParam String page, @PathVariable String params) throws CustomException {
		int recordsPerPage = 50;
		int reqPage = Integer.parseInt(page);
		
		List<User> userlist = service.getAllUserByFilter(recordsPerPage, ((reqPage*recordsPerPage)-recordsPerPage), params);

		

		ModelAndView mView = new ModelAndView();
		mView.setViewName("users-filters");
		if (userlist == null) {
			mView.addObject(MuthuConstants.ERROR_MSG, MuthuConstants.USER_FETCH_ERROR);
			return mView;
		} else {
			int dummyVal = userlist.size()-1;
			int noOfRecords = Integer.parseInt(userlist.get(dummyVal).getMob());
			userlist.remove(userlist.size()-1);
			Set<String> reg = service.getAllUser().stream().map(User::getReg).collect(Collectors.toSet());
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			mView.addObject("userlist", userlist);
			return mView;
		}

	}
	
	@RequestMapping("/filter/filters")
	public void buildPath(@RequestParam List<String> params, HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("/muthu-news-agency-bill-payer/admin/user/all/filter/");
		if(params.size() == 1) {
			urlBuilder.append(params.get(0));
			urlBuilder.append("filter?page=1");
		}
		else {
			int lastindex = params.size()-1;
			String lastElement = params.get(lastindex);
		for(String url : params) {
			urlBuilder.append(url);
			if(!(url.equalsIgnoreCase(lastElement))) {
			urlBuilder.append("filter");
			}
		}
		urlBuilder.append("?page=1");
		}
		response.sendRedirect(urlBuilder.toString());
	}
	
	@RequestMapping("search/user")
	public ModelAndView searchAUser(@RequestParam String mob) {
		User user = service.getAUser(mob);
		ModelAndView mView = new ModelAndView();
		mView.setViewName("user-search");
		if(user == null) {
			mView.addObject("errorMsg", "User not exist");
			return mView;
		}
		else {
			mView.addObject("user", user);
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
