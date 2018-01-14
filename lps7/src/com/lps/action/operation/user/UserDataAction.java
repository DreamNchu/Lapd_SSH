package com.lps.action.operation.user;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.basic.ActionSupportLps;
import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.model.User;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.user.dto.UserDataDto;
import com.lps.web.user.dto.UserResponseDto;
import com.lps.web.user.dto.UserHelpForCreateOrderDto;
import com.lps.web.user.dto.UserIdDto;
import com.lps.web.user.dto.UserUpdateDataDto;

public class UserDataAction extends ActionSupportLps implements SessionAware, DataResult {

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());
	private static final long serialVersionUID = 8391361256010015414L;

	private Map<String, Object> session;

	private UserResponseDto userDataDto;
	
	private UserHelpForCreateOrderDto userHelpForCreateOrderDto;

	private UserIdDto userIdDto;

	private UserManage userManage;

	private UserUpdateDataDto userUpdateDataDto;


	/**
	 * 查看员工信息
	 */
	@Override
	public String execute() throws Exception {

		int id = Integer.parseInt(session.get("id") + "");
//		User user = userServiceImpl.findById(id);
		userManage.query(id,userDataDto);
//		userDataDto.initDto(user);
		basicMsg.setMsgDto(userDataDto);
//		basicMsg

		return super.execute();
	}
	
	public UserHelpForCreateOrderDto getUserHelpForCreateOrderDto() {
		return userHelpForCreateOrderDto;
	}

	public UserIdDto getUserIdDto() {
		return userIdDto;
	}

	public UserManage getUserManage() {
		return userManage;
	}
	
	public UserUpdateDataDto getUserUpdateDataDto() {
		return userUpdateDataDto;
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	public String modifyData() {
		
		try {
			userUpdateDataDto.setMap(data);
			userManage.update(userUpdateDataDto);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setUserDataDto(UserDataDto userDataDto) {
		this.userDataDto = userDataDto;
	}
	
	public void setUserHelpForCreateOrderDto(UserHelpForCreateOrderDto userHelpForCreateOrderDto) {
		this.userHelpForCreateOrderDto = userHelpForCreateOrderDto;
	}

	public void setUserIdDto(UserIdDto userIdDto) {
		this.userIdDto = userIdDto;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}
	
	public void setUserUpdateDataDto(UserUpdateDataDto userUpdateDataDto) {
		this.userUpdateDataDto = userUpdateDataDto;
	}

	public String userData() throws Exception{
		return execute();
	}

	/**
	 * 查看员工工作状态信息
	 * @return
	 */
	public String viewAdminUserWorkData(){
		
		int id = userIdDto.getStuffId();
		basicMsg.setMsgDto(userHelpForCreateOrderDto);
		User user;
		try {
			user = userManage.query(id,userHelpForCreateOrderDto);
//			userHelpForCreateOrderDto.initDto(user);
		} catch (FindByIdGetNullException | DtoInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userHelpForCreateOrderDto.setDefaultErrorMsg();
		}
//				userServiceImpl.findById(id);
//		writeInResult(userHelpForCreateOrderDto);
		userHelpForCreateOrderDto.setDefaultSuccessMsg();
		
//logger.debug(result);

		return SUCCESS;
	}

}
