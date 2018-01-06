package com.lps.action.operation.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.model.User;
import com.lps.service.UserService;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkJson;
import com.lps.web.user.dto.PageLinkTransformUserDto;
import com.lps.web.user.dto.UserDataDto;
import com.lps.web.user.dto.UserTableDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class ManageUsersAction extends ActionSupport implements DataResult, SessionAware {

	private static final long serialVersionUID = -8314546487497383936L;

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	private Map<String, Object> session;

	private List<Integer> stuffId;

	private UserTableDataDto userTableDataDto;

	private UserManage userManage;

	private PageLinkTransformUserDto pageLinkTransformUserDto;

	private UserDataDto userDataDto;

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String addUser() {

		try {
			userManage.save(userDataDto);
		} catch (Exception e) {
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

	/**
	 * 根据时间查看各种订单类型
	 * 
	 * @return 根据请求返回不同的界面
	 * @throws PagePropertyNotInitException
	 */
	public String queryBasicUser() throws PagePropertyNotInitException {
		// 找到今日该状态下的所有订单
		basicMsg.setMsgDto(userTableDataDto);

		if (pageLinkTransformUserDto != null) {
			if (pageLinkTransformUserDto.getPage() != 0) {
				session.put("userPage", pageLinkTransformUserDto.getPage());
			}
		} else {
			pageLinkTransformUserDto = new PageLinkTransformUserDto();
		}
		pageLinkTransformUserDto.setPage(Integer.parseInt(session.get("userPage") + ""));

		userTableDataDto.init(userManage.basicQuery(pageLinkTransformUserDto.getPage()), pageLinkTransformUserDto,
				pageLinkTransformUserDto.getDomainName(), Thread.currentThread().getStackTrace()[1].getMethodName());

		return SUCCESS;
	}

	/**
	 * 查询user
	 * 
	 * @return
	 */
	public String queryUser() {
		userDataDto = new UserDataDto();
		int id = stuffId.get(0);
		userManage.addUser();
		User user = userServiceImpl.findById(id);
//		userManage.
		userDataDto.init(user);
		userTableDataDto.getUser().add(userDataDto);
		result = WorkJson.toJsonDisableHtmlEscaping(userTableDataDto);

		logger.debug(result);
		return SUCCESS;
	}

	public String updateUser() {
		Map<String, Object> map = new HashMap<>();
		boolean isError = false;
		try {
			userServiceImpl.update(userDataDto.update(userServiceImpl.findById(userDataDto.getId())));
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "更新用户数据失败");
			isError = true;
		}
		if (!isError)
			map.put(MSG, "更新用户数据成功");
		result = WorkJson.toJsonDisableHtmlEscaping(map);
		return SUCCESS;
	}

	public UserDataDto getUserDataDto() {
		return userDataDto;
	}

	public void setUserDataDto(UserDataDto userDataDto) {
		this.userDataDto = userDataDto;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getResult() {
		return result;
	}

	@Override
	public void setResult(String result) {
		this.result = result;
	}

	public UserTableDataDto getUserTableDataDto() {
		return userTableDataDto;
	}

	public void setUserTableDataDto(UserTableDataDto userTableDataDto) {
		this.userTableDataDto = userTableDataDto;
	}

	public UserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}

	public PageLinkTransformUserDto getPageLinkTransformUserDto() {
		return pageLinkTransformUserDto;
	}

	public void setPageLinkTransformUserDto(PageLinkTransformUserDto pageLinkTransformUserDto) {
		this.pageLinkTransformUserDto = pageLinkTransformUserDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public List<Integer> getStuffId() {
		return stuffId;
	}

	public void setStuffId(List<Integer> userId) {
		this.stuffId = userId;
	}

	public void writeInResult(Object obj) {
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}

}
