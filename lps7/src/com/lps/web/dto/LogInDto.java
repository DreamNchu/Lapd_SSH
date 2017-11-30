package com.lps.web.dto;

public class LogInDto {

	private String name;

	private String password;
	
	public LogInDto() {
	}
	
	public LogInDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
