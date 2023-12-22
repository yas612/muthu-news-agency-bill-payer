package com.muthu.news.service;

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
	

	@SuppressWarnings("unchecked")
	public Boolean checkMob(String mob) {
		try {
		user = jdbcTemplate.queryForObject(MuthuConstants.GET_USER_BY_MOB, 
				new Object[] { mob }, new UserRowMapper());
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		if(user != null) {
		if(user.getMob().equalsIgnoreCase(mob)) {
			return true;
		}
		}
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserInfo(String mob) {
		// TODO Auto-generated method stub
		return user;
	}

}
