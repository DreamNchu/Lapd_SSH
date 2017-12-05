package com.lps.action.operation;

import com.lps.control.manage.WorkRankManage;
import com.lps.model.User;
import com.lps.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserWorkCheckAction extends ActionSupport{

	private static final long serialVersionUID = -4013579295942022608L;
	
	private UserService userServiceImpl;
	
	private int id;
	
	private WorkRankManage workRankManage;
	
	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}

	/**
	 * 上班签到
	 * @return
	 */
	public String checkIn(){
		User u = userServiceImpl.findById(id);
		workRankManage.addUserData(u);
		return SUCCESS;
	}
	
	public String checkOut(){
		User u = userServiceImpl.findById(id);
		workRankManage.deleteUserData(u);
		return SUCCESS;
	}


}
