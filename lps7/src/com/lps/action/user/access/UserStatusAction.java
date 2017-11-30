package com.lps.action.user.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.model.Admin;
import com.lps.service.AdminService;
import com.lps.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserStatusAction extends ActionSupport implements SessionAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4382649909834668686L;

	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

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

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * 登录成功返回success
	 * <p>
	 * 失败返回error
	 */
	public String logIn() {
		
		String tempPassword = userServiceImpl.findPasswordByUserName(userName);
		if(tempPassword.equals(password)){
			session.put("userName", userName);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	public String logout() {
		session.clear();
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
