package com.lps.action.user.access;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.dao.impl.UserDAOImpl;
import com.lps.model.User;
import com.lps.web.access.dto.UserSignInDto;
import com.lps.action.basic.ActionSupportLps;

public class UserSignInAction extends ActionSupportLps implements DataResult{

	/**
	 * 
	 */
	private static  long serialVersionUID = -1335015386952489920L;

	private UserSignInDto userSignInDto;
	
	private UserManage userManage;
	
	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}


	public String getResult() {
		return result.toString();
	}

	public UserSignInDto getUserSignInDto() {
		return userSignInDto;
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
			userManage.create(userSignInDto);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage());
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}
	
	/**
	 * 不存在返回 error
	 * 存在返回 success
	 * @return 字符串
	 */
	public String isExists(){
		basicMsg.getMap().put(UserDAOImpl.USER_NAME, userSignInDto.getUserName());
		List<User> lus = userManage.queryByProperties(basicMsg.getMap());
		if(lus!= null && lus.size() == 1){
			return SUCCESS;
		}
		return ERROR;
	}
	
	
}
