package com.lps.web.dto;

import java.util.Date;

import com.lps.model.User;

public class UserSignInDto {

//	1.用户名
//	2.密码
//	3.电话号码
//	4.生日
//	5.随机工号
//	6.密保问题
//	7.密保答案
//	8.注册时间
	
	private String userName;
	
	private String password;
	
	private String password2;
	
	private String telephonePhone;

	private int workId;
	
	public User buildModel(){
		return new User(null, userName, password, workId, null, telephonePhone, null, null, null, question, answer, registerTime, null);
	}
	
	private String question;
	
	private String answer;
	
	private Date registerTime;
	
	public UserSignInDto() {
		
	}
	
	public UserSignInDto(String userName, String password, String telephonePhone, int workId,
			String question, String answer, Date registerTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.telephonePhone = telephonePhone;
		this.workId = workId;
		this.question = question;
		this.answer = answer;
		this.registerTime = registerTime;
	}
	
	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getAnswer() {
		return answer;
	}
	
	public String getPassword() {
		return password;
	}

	public String getPassword2() {
		return password2;
	}

	public String getQuestion() {
		return question;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public String getTelephonePhone() {
		return telephonePhone;
	}

	public String getUserName() {
		return userName;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setTelephonePhone(String telephonePhone) {
		this.telephonePhone = telephonePhone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
