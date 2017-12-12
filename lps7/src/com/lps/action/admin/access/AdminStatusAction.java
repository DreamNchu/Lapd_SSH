package com.lps.action.admin.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminStatusAction extends ActionSupport implements SessionAware, DataResult{

	private static final long serialVersionUID = 5979229100942095638L;

	private Map<String, Object> session;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 登录成功返回success
	 * <p>
	 * 失败返回error
	 */
	public String login() {
		return SUCCESS;
	}
	
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		session.clear();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	

}
