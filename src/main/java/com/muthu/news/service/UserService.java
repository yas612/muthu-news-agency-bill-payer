package com.muthu.news.service;

import java.util.List;
import java.util.Map;

import com.muthu.news.User;
import com.muthu.news.exception.CustomException;

public interface UserService {
	
	public List<User> getAllUser(int limit, int offSet) throws CustomException;
	public List<User> getAllUserByFilter(int limit, int offSet, String filters) throws CustomException;
	public List<User> getAllUser();
	public int getUsersCounts();
	public User addUser(User user) throws CustomException;
	public Boolean removeUser(String mob);
	public Boolean updateUser(User user, Boolean billDecider) throws CustomException;
	public User getAUser(String mob);
	public void updateStatus(String mob);
	public String updateAllUserStatus();

}
