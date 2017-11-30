package com.lps.web.dto;

import java.util.Date;

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
	
	private String telephonePhone;
	
	private String birthday;
	
	private int wordId;
	
	private String question;
	
	private String answer;
	
	private Date registerTime;
	
	public UserSignInDto() {
		
	}
	
	public UserSignInDto(String userName, String password, String telephonePhone, String birthday, int wordId,
			String question, String answer, Date registerTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.telephonePhone = telephonePhone;
		this.birthday = birthday;
		this.wordId = wordId;
		this.question = question;
		this.answer = answer;
		this.registerTime = registerTime;
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

	public String getTelephonePhone() {
		return telephonePhone;
	}

	public void setTelephonePhone(String telephonePhone) {
		this.telephonePhone = telephonePhone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
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

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	
}
