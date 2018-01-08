package com.lps.web.annotation.dto;

public class DtoNameNotInitException extends Exception{

	private static final long serialVersionUID = -1461540767634472041L;
	
	
	public DtoNameNotInitException() {
	}
	
	public DtoNameNotInitException(String msg) {
		super(msg);
	}

}
