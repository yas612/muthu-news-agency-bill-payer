package com.muthu.news.service;

import com.muthu.news.User;

public interface LoginService {
	
	public Boolean checkMob(String mob);
	public User getUserInfo(String mob);

}
