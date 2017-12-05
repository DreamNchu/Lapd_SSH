package com.lps.action.operation;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.service.impl.UserServiceImpl;
import com.lps.web.dto.UserBasicDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserDataAction extends ActionSupport implements SessionAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3471903966307713794L;
	
	private Map<String, Object> session ;
	
	private UserBasicDataDto userBasicDataDto;
	
	private UserService userServiceImpl ;
	

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public UserBasicDataDto getUserBasicDataDto() {
		return userBasicDataDto;
	}

	public void setUserBasicDataDto(UserBasicDataDto userBasicDataDto) {
		this.userBasicDataDto = userBasicDataDto;
	}

	/**
	 * 查看数据
	 * @return 成功返回success
	 */
	public String viewBasicData(){
		
		int id = (int) session.get("id");
		User u = userServiceImpl.findById(id);
		userBasicDataDto.initByUser(u);
		
		return SUCCESS;
	}
	/**
	 * 更新数据
	 * @return 成功返回success
	 */
	public String updateBasicData(){
		int id = (int) session.get("id");
		User u = userServiceImpl.findById(id);
		userBasicDataDto.update(u);
		userServiceImpl.update(u);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
