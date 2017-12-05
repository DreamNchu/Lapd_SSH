package com.lps.action.operation;

import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.service.AdminService;
import com.lps.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserModifyPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1295443170006330180L;


	private UserService userServiceImpl;
	
	private String oldPassword;
	private String newPassword;
	private int id;
	
	/**
	 * 成功返回success，失败返回error
	 * @return
	 */
	public String modifyPasswordWithOld(){
		
		User user = userServiceImpl.findById(id);
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			userServiceImpl.update(user);
			return SUCCESS;
		}
		return ERROR;
	}
	
	private String question ;
	
	private String answerr;
	
	/**
	 * 根据密保修改密码
	 * @return
	 */
	public String modifyPasswordByQuestion(){
		User user = userServiceImpl.findById(id);
		if(user.getQuestion().equals(question) 
				&&user.getAnswer().equals(answerr)){
			user.setPassword(newPassword);
			userServiceImpl.update(user);
			return SUCCESS;
		}
		return ERROR;
	}
	
	private String oldAnswer;
	
	private String newAnswer;

	/**
	 * 修改密保
	 * @return
	 */
	public String modifyQuestion(){
		User user = userServiceImpl.findById(id);
		if(user.getAnswer().equals(oldAnswer)){
			user.setAnswer(newAnswer);
			userServiceImpl.update(user);
			return SUCCESS;
		}
		return ERROR;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerr() {
		return answerr;
	}

	public void setAnswerr(String answerr) {
		this.answerr = answerr;
	}

	public String getOldAnswer() {
		return oldAnswer;
	}

	public void setOldAnswer(String oldAnswer) {
		this.oldAnswer = oldAnswer;
	}

	public String getNewAnswer() {
		return newAnswer;
	}

	public void setNewAnswer(String newAnswer) {
		this.newAnswer = newAnswer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
