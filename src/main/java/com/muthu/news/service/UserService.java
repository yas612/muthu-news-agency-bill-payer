package com.muthu.news.service;

import java.util.List;

import com.muthu.news.User;
import com.muthu.news.exception.CustomException;

public interface UserService {
	
	public List<User> getAllUser() throws CustomException;
	public User addUser(User user) throws CustomException;
	public Boolean removeUser(String mob);
	public void updateUser(User user) throws CustomException;
	public User getAUser(String mob);

}
