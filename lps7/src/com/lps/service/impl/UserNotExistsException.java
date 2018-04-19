package com.lps.service.impl;

/**
 * 用户名不存在
 * @author 0001
 *
 */
public class UserNotExistsException extends RuntimeException {

	private static  long serialVersionUID = -5348896663500245075L;
	
	public UserNotExistsException(){
	}
	
	public UserNotExistsException(String msg) {
		super(msg);
	}
	

}
