package com.ai.educore.service.impl;

import java.util.List;

import com.ai.educore.bean.User;
import com.ai.educore.dao.UserDao;
import com.ai.educore.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> getAllUser() {
		List<User> allUser = userDao.getAllUser();
		System.out.println("service================> " + allUser.size());
		return allUser;
	}
	
}
