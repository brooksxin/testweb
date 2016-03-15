package com.ai.educore.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.educore.bean.User;
import com.ai.educore.service.UserService;
import com.ai.educore.service.impl.UserServiceImpl;

import junit.framework.TestCase;

public class Test extends TestCase{
	UserService userService = null;

	protected void setUp(){
//		String paths[] = new String[]{"file:D://MYWorkPlace/demoTest/src/main/resource/spring/spring-all.xml"};
		String paths[] = new String[]{"spring/spring-all.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(paths);
		userService = context.getBean("userService", UserServiceImpl.class);
	}
	
	public void testGetAllUser(){
		List<User> allUser = userService.getAllUser();
		System.out.println("test==============> " + allUser.size());
	}
}
