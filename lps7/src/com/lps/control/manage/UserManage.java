package com.lps.control.manage;

import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class UserManage {

	private UserService userServiceImpl;
	
	public UserManage() {
		
	}
	
	public void addUser(){
		
	}
	
	public PageBean<User> basicQuery(int page) throws PagePropertyNotInitException{
		return userServiceImpl.findByPage(page);
	}
	
//	public void 
	

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
}
