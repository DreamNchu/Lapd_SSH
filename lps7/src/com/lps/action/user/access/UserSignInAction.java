package com.lps.action.user.access;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.dao.impl.UserDAOImpl;
import com.lps.model.User;
import com.lps.web.access.dto.UserSignInDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserSignInAction extends ActionSupport implements DataResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1335015386952489920L;

	private UserSignInDto userSignInDto;
	
	private UserManage userManage;
	
	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}


//	private String result;

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
//		basicMsg.setMsgDto(msgDto);
		try {
			Random random = new Random();
			userSignInDto.setWorkId(random.nextInt(1000) + 10000);
			userSignInDto.setRegisterTime(new Date());
//			User user = userSignInDto.buildModel();
			userManage.create(userSignInDto);
//			userServiceImpl.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage());
//			map.put(MSG, false);
//			writeInResult(map);
//			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
//		map.put(MSG, true);
//		writeInResult(map);
//System.out.println(result);
		return SUCCESS;
	}
	
	/**
	 * 不存在返回 error
	 * 存在返回 success
	 * @return 字符串
	 */
	public String isExists(){
		basicMsg.getMap().put(UserDAOImpl.USER_NAME, userSignInDto.getUserName());
		List<User> lus = userManage.queryIdByProperties(basicMsg.getMap());
//		int id = userServiceImpl.findIdByUserName(userSignInDto.getUserName());
		User u = new User();
		if(lus!= null && lus.size() == 1){
			return SUCCESS;
		}
//		u.setId(id);
//		if(userServiceImpl.isExists(u))
		return ERROR;
	}
	
	
}
