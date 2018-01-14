package com.lps.action.user.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.service.UserService;
import com.lps.util.OnLineStatus;
import com.lps.action.basic.ActionSupportLps;

public class UserAccessAction extends ActionSupportLps implements SessionAware{

	private static final long serialVersionUID = 5979229100942095638L;

	private UserService userServiceImpl;

	private String userName;
	
	private String password;
	
	private Map<String, Object> session;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	public String main(){
		//检查session 判断是否为刷新
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	

}
