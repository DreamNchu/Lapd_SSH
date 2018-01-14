package com.lps.control.manage;

public class CreateFailedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CreateFailedException() {
	}
	
	public CreateFailedException(String msg) {
		super(msg);
	}
	
}
