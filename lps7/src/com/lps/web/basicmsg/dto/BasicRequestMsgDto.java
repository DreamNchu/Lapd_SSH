package com.lps.web.basicmsg.dto;

public abstract class BasicRequestMsgDto{

	@SuppressWarnings("unchecked")
	public <T> T getNativeObject(){
		return (T)this;
	}
	
}
