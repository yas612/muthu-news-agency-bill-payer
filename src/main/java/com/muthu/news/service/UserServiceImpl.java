package com.muthu.news.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProductService pService;

	@Override
	public List<User> getAllUser() throws CustomException {
		List<User> allUsers;
		try {
		allUsers = jdbcTemplate.query(MuthuConstants.GET_ALL_USERS, new UserRowMapper());
		}
		catch(Exception e) {
			throw new CustomException("Error occured while making DB call");
		}
		if(allUsers == null) {
			return null;
		}
		return allUsers;
	}

	@Override
	public User addUser(User user) throws CustomException {
		
		List<Product> products = pService.getAll();
		List<String> papersAvailedNow = new ArrayList<String>(Arrays.asList(user.getPapers().replaceAll("\\s", "").split(",")));
		Double updatedPrice=0.00;
		
		for(String paper : papersAvailedNow) {
			for(Product pro : products) {
				if(paper.equalsIgnoreCase(pro.getCode())) {
					updatedPrice = updatedPrice+pro.getPrice();
				}
			}
		}
		user.setBill(updatedPrice);
		user.setStatus("NOT-PAID");
		try {
		jdbcTemplate.update(MuthuConstants.ADD_USER, new Object[] {user.getMob(), user.getName(), user.getReg(),
				user.getPapers(), user.getBill(), user.getStatus()});
		}
		catch(Exception e) {
			return null;
		}
		return user;
		
	}

	@Override
	public Boolean removeUser(String mob) {
		return jdbcTemplate.update(MuthuConstants.DEL_USER,new Object[] {mob}) == 1;
		
	}

	@Override
	public void updateUser(User user) throws CustomException {
		List<Product> products = pService.getAll();
		List<String> papersAvailedNow = new ArrayList<String>(Arrays.asList(user.getPapers().replaceAll("\\s", "").split(",")));
		Double updatedPrice=0.00;
		
		for(String paper : papersAvailedNow) {
			for(Product pro : products) {
				if(paper.equalsIgnoreCase(pro.getCode())) {
					updatedPrice = updatedPrice+pro.getPrice();
				}
			}
		}
		try {
			String a = MuthuConstants.UPDATE_USER;
			jdbcTemplate.update(a, new Object[] {user.getName(), user.getReg(),
					user.getPapers(), updatedPrice, user.getStatus(), user.getMob()});
		}
		catch(Exception e) {
			throw new CustomException("ERROR while updation user info of : "+user.getMob()
					+ "info : "+user.toString());
		}
	}

	@Override
	public User getAUser(String mob) {
		User user = jdbcTemplate.queryForObject(MuthuConstants.GET_USER_BY_MOB, new Object[] {mob}, new UserRowMapper());
		return user;
	}

}
