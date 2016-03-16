package com.xin.demo.action;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements BeanFactoryAware{

	private static final long serialVersionUID = 1L;
	private BeanFactory factory;
	
	/** Set the Bean Factory **/
	public void setBeanFactory(BeanFactory factory) {
		this.factory = factory;
	}
	
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}

	public void excute(){
		System.out.println("baseActionStart");
		sendJson("ciao");
	}
	
	public void sendJson(String respJson) {
		try {
			HttpServletResponse response = getResponse();
			byte[] rtndata = respJson.getBytes("UTF-8");
			response.setContentLength(rtndata.length);
			response.getWriter().write(respJson);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
