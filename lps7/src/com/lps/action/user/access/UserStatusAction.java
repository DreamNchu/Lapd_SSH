package com.lps.action.user.access;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.basic.ActionSupportLps;
import com.lps.action.jsonresult.DataResult;
import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.service.impl.FindByIdGetNullException;

public class UserStatusAction extends ActionSupportLps
	implements SessionAware, DataResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4382649909834668686L;

	private UserService userServiceImpl;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResult() {
		return result.toString();
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

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

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * 以用户的id作为session登录判断 登录成功返回success
	 * <p>
	 * 失败返回error
	 */
	public String login() {

		// 检查session 判断是否为刷新
		if (session.get("id") != null) {
			int id = Integer.parseInt(session.get("id") + "");
			User user;
			try {
				user = userServiceImpl.findById(id);
				if (user.getUserName().equals(session.get("userName"))) {
					return SUCCESS;
				}
			} catch (FindByIdGetNullException e) {
				e.printStackTrace();
			}
		}
		try {
			String password = userServiceImpl.findPasswordByUserName(userName);
			int id = userServiceImpl.findIdByUserName(userName);
			if (password.equals(this.password)) {
				session.put("id", id);
				session.put("userName", userName);
			}
		} catch (Exception e) {
			basicMsg.setErrorMsg("账号或密码错误");
			return ERROR;
		}
		return SUCCESS;
	}

	public String loginPage(){
		if(session.get("id") == null)
			return SUCCESS;
		
		int id = Integer.parseInt(session.get("id") + "");
		User user;
		try {
			user = userServiceImpl.findById(id);
			if (user.getUserName().equals(session.get("userName"))) {
				return SUCCESS;
			}
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
		}
		return INPUT;
	}

	public String logout() {
		session.clear();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
