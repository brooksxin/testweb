package com.ai.educore.dao.impl;

import java.util.List;

import com.ai.educore.bean.User;
import com.ai.educore.dao.BaseDao;
import com.ai.educore.dao.UserDao;

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
