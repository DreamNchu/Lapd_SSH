package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.web.order.dto.DtoBasicInit;

public class UserOrderDto implements DtoBasicInit<UserOrderDto>{
	
	public Integer stuffId;
	
	public Integer workId;
	
	public UserOrderDto() {
	}

	public UserOrderDto(Integer stuffId, Integer workId) {
		super();
		this.stuffId = stuffId;
		this.workId = workId;
	}

	public Integer getStuffId() {
		return stuffId;
	}

	public void setStuffId(Integer stuffId) {
		this.stuffId = stuffId;
	}



	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public UserOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		User u = (User) obj;
		stuffId = u.getId();
		workId = u.getWorkId();
		return this;
	}
	
	

}
