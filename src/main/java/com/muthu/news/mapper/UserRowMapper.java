package com.muthu.news.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.muthu.news.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setMob(rs.getString("mob"));
		user.setName(rs.getString("name"));
		user.setReg(rs.getString("reg"));
		user.setPapers(rs.getString("papers"));
		user.setBill(rs.getDouble("bill"));
		user.setStatus(rs.getString("status"));
		return user;
	}

}
