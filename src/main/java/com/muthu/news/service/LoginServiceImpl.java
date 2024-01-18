package com.muthu.news.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.muthu.news.User;
import com.muthu.news.constants.MuthuConstants;
import com.muthu.news.mapper.UserRowMapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private User user = null;
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	

	@SuppressWarnings("unchecked")
	public Boolean checkMob(String mob) {
		logger.info("Login request for mobile number : "+mob);
		try {
		user = jdbcTemplate.queryForObject(MuthuConstants.GET_USER_BY_MOB, 
				new Object[] { mob }, new UserRowMapper());
		}
		catch(Exception e) {
			logger.error(e.getStackTrace());
		}
		if(user != null) {
			if(user.getMob().equalsIgnoreCase(mob)) {
				//logger.info("User with mobile number "+mob+" exists");
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserInfo(String mob) {
		logger.info("user with details found : "+user.toString());
		return user;
	}

}
