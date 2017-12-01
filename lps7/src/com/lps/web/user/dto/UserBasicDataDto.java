package com.lps.web.user.dto;

import java.util.Date;

import com.lps.model.User;

public class UserBasicDataDto {
	
	private Integer workId;
	private Date birthday;
	private String telephonePhone;
	private String email;
	private String address;
	private String realName;
	private String avatar;
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserBasicDataDto() {
		
	}
	
	public  UserBasicDataDto initByUser(User user){
		setAddress(user.getAddress());
		setAvatar(user.getAvatar());
		setWorkId(user.getWorkId());
		setTelephonePhone(user.getTelephonePhone());
		setEmail(user.getEmail());
		setAddress(user.getAddress());
		return this;
	}
	
	public User update(User user){
		user.setWorkId(workId);
		user.setBirthday(birthday);
		user.setTelephonePhone(telephonePhone);
		user.setEmail(email);
		user.setAddress(address);
		return user;
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
//	public User u

}
