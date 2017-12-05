package com.lps.control.manage;

public class NotExistsUserInWorkRankException extends RuntimeException {

	private static final long serialVersionUID = 2575756836974505416L;
	
	public NotExistsUserInWorkRankException() {
		
	}

	public NotExistsUserInWorkRankException(String msg) {
		super(msg);
	}

}
