package com.lps.web.orderchart.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.User;
import com.lps.web.user.dto.UserDataDto;

public class OrderChartInitDto {

	private List<UserDataDto> user ;

	
	public void init(List<User> us){
		for (User u : us) {
			UserDataDto ud = new UserDataDto();
			ud.init(u);
			user.add(ud);
		}
	}


	public List<UserDataDto> getUser() {
		return user;
	}


	public void setUser(List<UserDataDto> user) {
		this.user = user;
	}
	
	
}
