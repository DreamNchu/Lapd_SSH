package com.lps.action.operation.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.WorkJson;
import com.lps.web.user.dto.UserDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserDataAction extends ActionSupport implements SessionAware, DataResult {

	private static final long serialVersionUID = 8391361256010015414L;

	private Map<String, Object> session;

	private UserDataDto userDataDto;

	private UserService userServiceImpl;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public UserDataDto getUserDataDto() {
		return userDataDto;
	}

	public void setUserDataDto(UserDataDto userDataDto) {
		this.userDataDto = userDataDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public String execute() throws Exception {

		int id = Integer.parseInt(session.get("id") + "");
		User user = userServiceImpl.findById(id);
		userDataDto.init(user);

		return super.execute();
	}
	
	public String userData() throws Exception{
		return execute();
	}

	/**
	 * 修改数据
	 * @return
	 */
	public String modifyData() {
		
		int id = Integer.parseInt(session.get("id") + "");
		try {
			User user = userServiceImpl.findById(id);
			userDataDto.update(user);
			userServiceImpl.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "修改失败");
			return SUCCESS;
		}
		map.put(MSG, "修改成功");
		writeInResult(map);
		return SUCCESS;
	}

	public void writeInResult(Object obj) {
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}

}
