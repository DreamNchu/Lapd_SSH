package com.lps.web.order.dto;

public class UserCreateOrderDto {
	
	public String stuffId;
	
	public String stuffWorkId;
	
	public UserCreateOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public UserCreateOrderDto(String stuffId, String workId) {
		super();
		this.stuffId = stuffId;
		this.stuffWorkId = workId;
	}
	
	

}
