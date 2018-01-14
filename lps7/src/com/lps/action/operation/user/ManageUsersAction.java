package com.lps.action.operation.user;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.model.User;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.user.dto.PageLinkTransformUserDto;
import com.lps.web.user.dto.UserResponseDto;
import com.lps.web.user.dto.UserRequestDto;
import com.lps.web.user.dto.UserTableDataDto;
import com.lps.web.user.dto.UserUpdateDataDto;
import com.lps.action.basic.ActionSupportLps;

public class ManageUsersAction extends ActionSupportLps implements DataResult, SessionAware {

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	private static final long serialVersionUID = -8314546487497383936L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Map<String, String[]> data;

	private PageLinkTransformUserDto pageLinkTransformUserDto;

	private Map<String, Object> session;

	private List<Integer> stuffId;

	private UserResponseDto userDataDto;
	
	private UserManage userManage;

	private UserTableDataDto userTableDataDto;

	private UserUpdateDataDto userUpdateDataDto;
	
	
	
	public String addUser() {

		try {
			UserRequestDto userRequestDataDto = new UserRequestDto(data);
//			if(data.get("password") == null)
			data.put("password", new String[]{"123456"});
			userManage.create(userRequestDataDto);
		} catch (Exception e){
			e.printStackTrace();
			basicMsg.setErrorMsg("添加用户失败");
		}

		basicMsg.setSuccessMsg("添加用户成功");
		return SUCCESS;

	}

	public String deleteUsers() {

		try {
			userManage.delete(stuffId.toArray(new Integer[0]));
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage() + "\n" + "删除用户失败");
		}
		basicMsg.setSuccessMsg("删除用户成功");
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public Map<String, String[]> getData() {
		return data;
	}
	
	public PageLinkTransformUserDto getPageLinkTransformUserDto() {
		return pageLinkTransformUserDto;
	}
	
	@Override
	public String getResult() {
		return result.toString();
	}

	public List<Integer> getStuffId() {
		return stuffId;
	}
	
	public UserResponseDto getUserDataDto() {
		return userDataDto;
	}

	public UserManage getUserManage() {
		return userManage;
	}

	public UserTableDataDto getUserTableDataDto() {
		return userTableDataDto;
	}

	public UserUpdateDataDto getUserUpdateDataDto() {
		return userUpdateDataDto;
	}


	/**
	 * 按页面查询的User
	 * 
	 * @return 根据请求返回不同的界面
	 * @throws PagePropertyNotInitException
	 */
	public String queryBasicUser() throws PagePropertyNotInitException {
		
		basicMsg.setMsgDto(userTableDataDto);

		if (pageLinkTransformUserDto != null) {
			if (pageLinkTransformUserDto.getPage() != 0) {
				session.put("userPage", pageLinkTransformUserDto.getPage());
			}
		} else {
			pageLinkTransformUserDto = new PageLinkTransformUserDto();
		}
		pageLinkTransformUserDto.setPage(Integer.parseInt(session.get("userPage") + ""));

		try {
			userTableDataDto.init(userManage.basicQuery(pageLinkTransformUserDto.getPage()), pageLinkTransformUserDto,
					Thread.currentThread().getStackTrace()[1].getMethodName());
		} catch (DtoInitException e) {
			userTableDataDto.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}


	/**
	 * 查询user
	 * 
	 * @return
	 */
	public String queryUser() {
		
//		userDataDto = new UserDataDto();
		basicMsg.setMsgDto(userDataDto);
		int id = stuffId.get(0);
		
		User user;
		try {
			user = userManage.query(id,userDataDto);
			userDataDto.initDto(user);
		} catch (DtoInitException | FindByIdGetNullException e) {
			e.printStackTrace();
			userDataDto.setErrorMsg(e.getMessage());
		}
		
		return SUCCESS;
	}

	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public void setPageLinkTransformUserDto(PageLinkTransformUserDto pageLinkTransformUserDto) {
		this.pageLinkTransformUserDto = pageLinkTransformUserDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setStuffId(List<Integer> userId) {
		this.stuffId = userId;
	}

	public void setUserDataDto(UserResponseDto userDataDto) {
		this.userDataDto = userDataDto;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}

	public void setUserTableDataDto(UserTableDataDto userTableDataDto) {
		this.userTableDataDto = userTableDataDto;
	}

	public void setUserUpdateDataDto(UserUpdateDataDto userUpdateDataDto) {
		this.userUpdateDataDto = userUpdateDataDto;
	}
	public String updateUser() {
		
//		UserUpdateDataDto userUpdateDataDto = new UserUpdateDataDto(data);
		userUpdateDataDto.setMap(data);
		try {
			userManage.update(userUpdateDataDto);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("更新用户数据失败");
		}
		basicMsg.setSuccessMsg("更新用户数据成功");
		return SUCCESS;
	}
}
