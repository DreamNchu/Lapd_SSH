package com.lps.web.order.dto;

import com.lps.model.User;

public class UserOrderDto implements DtoBasicInit<UserOrderDto>{
	
	public Integer stuffId;
	
	public Integer stuffWorkId;
	
	public UserOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public UserOrderDto(Integer stuffId, Integer stuffWorkId) {
		super();
		this.stuffId = stuffId;
		this.stuffWorkId = stuffWorkId;
	}

	public Integer getStuffId() {
		return stuffId;
	}

	public void setStuffId(Integer stuffId) {
		this.stuffId = stuffId;
	}



	public Integer getStuffWorkId() {
		return stuffWorkId;
	}

	public void setStuffWorkId(Integer stuffWorkId) {
		this.stuffWorkId = stuffWorkId;
	}

	public UserOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		User u = (User) obj;
		stuffId = u.getId();
		stuffWorkId = u.getWorkId();
		return this;
	}
	
	

}
