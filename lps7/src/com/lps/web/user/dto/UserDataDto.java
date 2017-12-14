package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.util.WorkDate;

public class UserDataDto {
	// User u;
	private Integer id;
	private String workStatus;
	private String userName;
	private String password;
	private Integer workId;
	private String birthday;
	private String telephonePhone;
	private String email;
	private String address;
	private String avatar;
	private String question;
	private String answer;
	private String registerTime;
	private String realName;
	private String IDCardNo;

	public UserDataDto() {

	}

	public UserDataDto(Integer id, String workStatus, String userName, String password, Integer workId, String birthday,
			String telephonePhone, String email, String address, String avatar, String question, String answer,
			String registerTime, String realName, String iDCardNo) {
		super();
		this.id = id;
		this.workStatus = workStatus;
		this.userName = userName;
		this.password = password;
		this.workId = workId;
		this.birthday = birthday;
		this.telephonePhone = telephonePhone;
		this.email = email;
		this.address = address;
		this.avatar = avatar;
		this.question = question;
		this.answer = answer;
		this.registerTime = registerTime;
		this.realName = realName;
		this.IDCardNo = iDCardNo;
	}

	public void init(User user) {
		id = user.getId();
		if (user.getWorkStatus() != null)
			workStatus = user.getWorkStatus().getWorkStatus();
		userName = user.getUserName();
		password = user.getPassword();
		workId = user.getWorkId();
		if (user.getBirthday() != null)
			birthday = WorkDate.dateToString(user.getBirthday());
		telephonePhone = user.getTelephonePhone();
		email = user.getEmail();
		address = user.getAddress();
		avatar = user.getAvatar();
		question = user.getQuestion();
		answer = user.getAnswer();
		if (user.getRegisterTime() != null)
			registerTime = WorkDate.dateTimeToString(user.getRegisterTime());
		realName = user.getRealName();
		IDCardNo = user.getIDCardNo();

	}
	
	public User generateUser(){
		User u =new User.Builder()
				.setUserName(userName).setPassword("123456")
				.setAddress(address).setWorkId(workId)
				.setBirthday(WorkDate.toDate(birthday)).setTelephonePhone(telephonePhone)
				.setEmail(email)
				.setAvatar(avatar).setQuestion(question)
				.setAnswer(answer).setRegisterTime(WorkDate.toDate(registerTime))
				.setRealName(realName).setIDCardNo(IDCardNo)
				.build();
		return u;
	}
	
	/**
	 * 更新数据时用的
	 * @param user
	 * @return
	 */
	public User update(User user){
		
		if(userName != null) user.setUserName(userName);
		if(password != null) user.setPassword(password);
		if(address != null) user.setAddress(address);
		if(workId != null) user.setWorkId(workId);
		if(birthday != null && !birthday.equals("")) user.setBirthday(WorkDate.toDate(birthday));
		if(telephonePhone != null) user.setTelephonePhone(telephonePhone);
		if(email != null) user.setEmail(email);
		if(avatar != null) user.setAvatar(avatar);
		if(registerTime != null &&!registerTime.equals("")) user.setRegisterTime(WorkDate.toDate(registerTime));
		if(realName != null) user.setRealName(realName);
		if(IDCardNo != null) user.setIDCardNo(IDCardNo);
		
		return user;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIDCardNo() {
		return IDCardNo;
	}

	public void setIDCardNo(String iDCardNo) {
		IDCardNo = iDCardNo;
	}

}
