package com.muthu.news.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.muthu.news.Product;
import com.muthu.news.User;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.exception.CustomException;
import com.muthu.news.mapper.ProductRowMapper;
import com.muthu.news.mapper.UserRowMapper;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private ProductService pService;

	@Override
	public List<User> getAllUser() throws CustomException {
		List<User> allUsers = null;
		logger.info("Fetching all the users.");
		try {
			allUsers = jdbcTemplate.query(MuthuConstants.GET_ALL_USERS, new UserRowMapper());

		} catch (Exception e) {
			logger.error("ERROR occurred while fetching users.");
			logger.error(e.getMessage());
		}
		if (allUsers == null) {
			logger.error("No Users fetched.");
			return null;
		}
		logger.info("Total users fetched : " + allUsers.size());
		return allUsers;
	}

	@Override
	public User addUser(User user) throws CustomException {

		List<Product> products = pService.getAll();
		List<String> papersAvailedNow = new ArrayList<String>(
				Arrays.asList(user.getPapers().replaceAll("\\s", "").split(",")));
		Double updatedPrice = 0.00;

		logger.info("Request to add User with details : " + user.toString());

		for (String paper : papersAvailedNow) {
			for (Product pro : products) {
				if (paper.equalsIgnoreCase(pro.getCode())) {
					logger.info("User availed paper : " + pro.getName());
					updatedPrice = updatedPrice + pro.getPrice();
				}
			}
		}
		user.setBill(updatedPrice);
		user.setStatus("NOT-PAID");
		try {
			jdbcTemplate.update(MuthuConstants.ADD_USER, new Object[] { user.getMob(), user.getName(), user.getReg(),
					user.getPapers(), user.getBill(), user.getStatus() });
		} catch (Exception e) {
			logger.error("ERROR occurred while adding a NEW users.");
			logger.error(e.getMessage());
			return null;
		}
		return user;

	}

	@Override
	public Boolean removeUser(String mob) {
		Boolean decider = false;
		try {
			logger.info("Request to remove using with mobile number : " + mob);
			decider = jdbcTemplate.update(MuthuConstants.DEL_USER, new Object[] { mob }) == 1;
		} catch (Exception e) {
			logger.error("ERROR occurred while removing a user with ID : " + mob);
			logger.error(e.getMessage());
		}
		return decider;
	}

	@Override
	public Boolean updateUser(User user) throws CustomException {
		List<Product> products = pService.getAll();
		Boolean decider = false;
		List<String> papersAvailedNow = new ArrayList<String>(
				Arrays.asList(user.getPapers().replaceAll("\\s", "").split(",")));
		Double updatedPrice = 0.00;
		logger.info("Requst to update a user with details : " + user.toString());
		for (String paper : papersAvailedNow) {
			for (Product pro : products) {
				if (paper.equalsIgnoreCase(pro.getCode())) {
					logger.info("User availed paper : " + pro.getName());
					updatedPrice = updatedPrice + pro.getPrice();
				}
			}
		}
		try {
			decider = jdbcTemplate.update(MuthuConstants.UPDATE_USER, new Object[] { user.getName(), user.getReg(),
					user.getPapers(), updatedPrice, user.getStatus(), user.getMob() }) == 1;
		} catch (Exception e) {
			logger.error("ERROR occurred while updaing users.");
			logger.error(e.getMessage());
		}
		return decider;
	}

	@Override
	public User getAUser(String mob) {
		User user = null;
		logger.info("Fetching a user with ID : " + mob);
		try {
			jdbcTemplate.queryForObject(MuthuConstants.GET_USER_BY_MOB, new Object[] { mob }, new UserRowMapper());
		} catch (Exception e) {
			logger.error("ERROR occurred while fetching a user with ID : " + mob);
			logger.error(e.getMessage());
		}
		return user;
	}

	@Override
	public void updateStatus(String mob) {
		logger.info("Updating payment status with ID : " + mob);
		try {
			jdbcTemplate.update(MuthuConstants.UPDATE_USER_STATUS, new Object[] { "PAID", mob });
		} catch (Exception e) {
			logger.error("ERROR occurred while updating payment status for user with ID : " + mob);
			logger.error(e.getMessage());
		}
	}

	@Override
	public String updateAllUserStatus() {
		logger.info("Updating every users status");
		try {
			jdbcTemplate.update(MuthuConstants.UPDATE_EVERYONE_STATUS);
			return MuthuConstants.SUCCESS_UPDATE_STATUS_MSG;
		}
		catch(Exception e) {
			logger.error("ERROR occurred while updating all users status.");
			logger.error(e.getMessage());
			return MuthuConstants.FAILED_UPDATE_STATUS_MSG;
		}
	}
}
