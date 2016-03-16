package com.xin.demo.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xin.demo.action.UserAction;
import com.xin.demo.bean.User;
import com.xin.demo.service.UserService;
import com.xin.demo.service.impl.UserServiceImpl;

import junit.framework.TestCase;

public class Test extends TestCase{
	UserService userService = null;
	UserAction userAction = null;

	protected void setUp(){
//		String paths[] = new String[]{"file:D://MYWorkPlace/demoTest/src/main/resource/spring/spring-all.xml"};
		String paths[] = new String[]{"spring/spring-all.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(paths);
		userService = context.getBean("userService", UserServiceImpl.class);
		userAction = context.getBean("userAction", UserAction.class);
		
	}
	
	public void testGetAllUser(){
		userAction.excuteUserCounts();
//		List<User> allUser = userService.getAllUser();
//		System.out.println("test==============> " + allUser.size());
	}
}
