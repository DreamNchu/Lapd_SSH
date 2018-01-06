package com.lps.web.user.dto;

import com.lps.model.basic.Entity;
import com.lps.web.dto.BasicInitDto;
import com.lps.web.dto.DtoInitException;

public class UserHelpForCreateOrderDto extends UserDto{
	
	private String workStatus;
	private String realName;
	private Integer workId;
	
	/*public String getRealName() {
		return realName;
	}
	public Integer getWorkId() {
		return workId;
	}
	
	public String getWorkStatus() {
		return workStatus;
	}
	public UserHelpForCreateOrderDto init(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			this.realName = user.getRealName();
			this.workId = user.getWorkId();
			this.workStatus = user.getWorkStatus().getWorkStatus();
				
		}
		return this;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}*/
	@Override
	public UserHelpForCreateOrderDto init(Entity obj) throws DtoInitException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
