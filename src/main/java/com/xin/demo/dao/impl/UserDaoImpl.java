package com.xin.demo.dao.impl;

import java.util.List;

import com.xin.demo.bean.User;
import com.xin.demo.dao.BaseDao;
import com.xin.demo.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao{
	
	public List<User> getAllUser() {
		List<User> userList = getSqlMapClientTemplate().queryForList("UserDaoImpl.getAllUser");
		return userList;
	}
	
	public int getAllUserCount(){
		List<User> queryForList = getSqlMapClientTemplate().queryForList("UserDaoImpl.getAllUser");
		return queryForList.size();
	}
}
