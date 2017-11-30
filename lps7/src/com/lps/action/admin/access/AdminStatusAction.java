package com.lps.action.admin.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.model.Admin;
import com.lps.service.AdminService;
import com.lps.web.dto.LogInDto;
import com.opensymphony.xwork2.ActionSupport;

public class AdminStatusAction extends ActionSupport implements SessionAware{

	private AdminService adminServiceImpl;

	private String userName;
	
	private String password;
//	private LogInDto adminLogInDto;
	
	private Map<String, Object> session;

	
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

	public AdminService getAdminServiceImpl() {
		return adminServiceImpl;
	}

	public void setAdminServiceImpl(AdminService adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	/**
	 * 登录成功返回success
	 * <p>
	 * 失败返回error
	 */
	public String login() {
		
		Admin temp = adminServiceImpl.findByUserName(userName);
		if(temp.getPassword().equals(password)){
			session.put("userName", userName);
			return SUCCESS;
		}
		return ERROR;
		
	}
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		session.remove("userName");
		session.clear();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

}
