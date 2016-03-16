package com.xin.demo.service.impl;

import java.util.List;

import com.xin.demo.bean.User;
import com.xin.demo.dao.UserDao;
import com.xin.demo.service.UserService;

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
