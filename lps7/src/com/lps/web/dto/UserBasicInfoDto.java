package com.lps.web.dto;

import java.util.Date;

public class UserBasicInfoDto {
	
	private Integer workId;
	private Date birthday;
	private String telephonePhone;
	private String email;
	private String address;
	private String avatar;
	
	public UserBasicInfoDto() {
		
	}
	
	public UserBasicInfoDto(Integer workId, Date birthday, String telephonePhone, String email, String address,
			String avatar) {
		super();
		this.workId = workId;
		this.birthday = birthday;
		this.telephonePhone = telephonePhone;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
	}



	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTelephonePhone() {
		return telephonePhone;
	}
	public void setTelephonePhone(String telephonePhone) {
		this.telephonePhone = telephonePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

}
