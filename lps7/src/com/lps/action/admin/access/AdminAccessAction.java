package com.lps.action.admin.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.service.AdminService;
import com.lps.service.impl.UserNotExistsException;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAccessAction extends ActionSupport implements SessionAware, DataResult {

	private static final long serialVersionUID = 5979229100942095638L;

	private AdminService adminServiceImpl;

	private String userName;

	private String password;

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

	public String main() {
		// 检查session 判断是否为刷新
		if (session.get("id") != null) {
			return SUCCESS;
		}
		try {
			String password = adminServiceImpl.findPasswordByUserName(userName);
			int id = adminServiceImpl.findIdByUserName(userName);
			if (password.equals(this.password)) {
				session.put("id", id);
				session.put("userName", userName);
			}
		} catch (UserNotExistsException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("账号或密码错误");
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String getResult() {
		return result.toString();
	}

}
