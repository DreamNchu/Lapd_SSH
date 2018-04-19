package com.lps.action.admin.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.basic.ActionSupportLps;
import com.lps.action.jsonresult.DataResult;

public class AdminStatusAction extends ActionSupportLps implements SessionAware, DataResult{

	private static  long serialVersionUID = 5979229100942095638L;

	private Map<String, Object> session;
	
	private String result;
	
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
	@Override
	public String getResult() {
		return result;
	}

}
