package com.lps.control.manage;

public class ENotExistsUserInWorkRankException extends RuntimeException {

	private static final long serialVersionUID = 2575756836974505416L;
	
	public ENotExistsUserInWorkRankException() {
		
	}

	public ENotExistsUserInWorkRankException(String msg) {
		super(msg);
	}

}
