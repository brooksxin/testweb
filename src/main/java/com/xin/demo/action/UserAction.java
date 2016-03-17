package com.xin.demo.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xin.demo.bean.User;
import com.xin.demo.service.UserService;

public class UserAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}
	
	//获取用户数量
	public void excuteUserCounts(){
		System.out.println("userActionStart");
		List<User> allUser = userService.getAllUser();
		String message = "test ========= > " + allUser.size();
		getResponse().setContentType(message);
		sendJson(message);
	}
}
