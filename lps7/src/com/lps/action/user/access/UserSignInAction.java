package com.lps.action.user.access;

import com.lps.service.UserService;
import com.lps.web.dto.UserSignInDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserSignInAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1335015386952489920L;

	private UserService userServiceImpl;
	
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	private UserSignInDto userSignInDto;

	public UserSignInDto getUserSignInDto() {
		return userSignInDto;
	}

	public void setUserSignInDto(UserSignInDto userSignInDto) {
		this.userSignInDto = userSignInDto;
	}

	/**
	 * 登录成功返回success
	 * <p>
	 * 失败返回error
	 */
	public String SignIn() {
		
		
		return SUCCESS;
		
		
	}
	

}
