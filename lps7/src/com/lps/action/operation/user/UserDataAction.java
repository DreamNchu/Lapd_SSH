package com.lps.action.operation.user;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.model.User;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.WorkJson;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.user.dto.UserDataDto;
import com.lps.web.user.dto.UserHelpForCreateOrderDto;
import com.lps.web.user.dto.UserIdDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserDataAction extends ActionSupport implements SessionAware, DataResult {

	private static final long serialVersionUID = 8391361256010015414L;
	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	private Map<String, Object> session;

	private UserDataDto userDataDto;
	
	private UserManage userManage;

//	private UserService userServiceImpl;

	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}


	public String getResult() {
		return result.toString();
	}

/*	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
*/
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
	
	
	private UserIdDto userIdDto;

	public UserIdDto getUserIdDto() {
		return userIdDto;
	}

	public void setUserIdDto(UserIdDto userIdDto) {
		this.userIdDto = userIdDto;
	}

	/**
	 * 查看员工信息
	 */
	@Override
	public String execute() throws Exception {

		int id = Integer.parseInt(session.get("id") + "");
//		User user = userServiceImpl.findById(id);
		User user = userManage.query(id);
		userDataDto.init(user);
		basicMsg.setMsgDto(userDataDto);
//		basicMsg

		return super.execute();
	}
	
	private UserHelpForCreateOrderDto userHelpForCreateOrderDto;
	
	public UserHelpForCreateOrderDto getUserHelpForCreateOrderDto() {
		return userHelpForCreateOrderDto;
	}

	public void setUserHelpForCreateOrderDto(UserHelpForCreateOrderDto userHelpForCreateOrderDto) {
		this.userHelpForCreateOrderDto = userHelpForCreateOrderDto;
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
			user = userManage.query(id);
			userHelpForCreateOrderDto.init(user);
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
	
	public String userData() throws Exception{
		return execute();
	}

	/**
	 * 修改数据
	 * @return
	 */
	public String modifyData() {
		
//		int id = Integer.parseInt(session.get("id") + "");
		try {
//			User user = userServiceImpl.findById(id);
//			userDataDto.update(user);
			userManage.update(userDataDto);
//			userServiceImpl.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
//			map.put(MSG, "修改失败");
//			return SUCCESS;
		}
//		map.put(MSG, "修改成功");
		basicMsg.setDefaultSuccessMsg();
//		writeInResult(map);
		return SUCCESS;
	}

}
