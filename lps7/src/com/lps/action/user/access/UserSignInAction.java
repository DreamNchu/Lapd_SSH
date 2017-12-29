package com.lps.action.user.access;

import java.util.Date;
import java.util.Random;

import com.lps.action.jsonresult.DataResult;
import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.WorkJson;
import com.lps.web.access.dto.UserSignInDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserSignInAction extends ActionSupport implements DataResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1335015386952489920L;

	private UserService userServiceImpl;
	
	private UserSignInDto userSignInDto;
	
	
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

	public UserSignInDto getUserSignInDto() {
		return userSignInDto;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public void setUserSignInDto(UserSignInDto userSignInDto) {
		this.userSignInDto = userSignInDto;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	/**
	 * 注册成功返回success
	 * <p>
	 */
	public String signIn() {
		try {
			Random random = new Random();
			userSignInDto.setWorkId(random.nextInt(1000) + 10000);
			userSignInDto.setRegisterTime(new Date());
			User user = userSignInDto.buildModel();
			userServiceImpl.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, false);
			writeInResult(map);
			return SUCCESS;
		}
		map.put(MSG, true);
		writeInResult(map);
System.out.println(result);
		return SUCCESS;
	}
	
	/**
	 * 不存在返回 error
	 * 存在返回 success
	 * @return 字符串
	 */
	public String isExists(){
		int id = userServiceImpl.findIdByUserName(userSignInDto.getUserName());
		User u = new User();
		u.setId(id);
		if(userServiceImpl.isExists(u))
			return SUCCESS;
		return ERROR;
	}
	
	
	@Override
	public void writeInResult(Object obj){
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}
	

}
