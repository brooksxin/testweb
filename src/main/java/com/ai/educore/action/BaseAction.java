package com.ai.educore.action;

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

	
}
