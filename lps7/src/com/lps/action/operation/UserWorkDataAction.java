package com.lps.action.operation;

import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class UserWorkDataAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257097318892616866L;

	private UserService userServiceImpl;
	
	private PageBean<User> pageUsers;

	public PageBean<User> getPageUsers() {
		return pageUsers;
	}

	public void setPageUsers(PageBean<User> pageUsers) {
		this.pageUsers = pageUsers;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String viewUsersByPage(){
		this.pageUsers = userServiceImpl.findByPage(page);
		return SUCCESS;
	}
	
}
