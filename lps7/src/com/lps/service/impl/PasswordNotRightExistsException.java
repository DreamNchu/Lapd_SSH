package com.lps.service.impl;

public class PasswordNotRightExistsException extends RuntimeException {

	private static  long serialVersionUID = -5348896663500245075L;
	
	public PasswordNotRightExistsException() {
	}
	
	public PasswordNotRightExistsException(String msg) {
		super(msg);
	}
	

}
