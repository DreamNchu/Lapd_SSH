package com.lps.action.operation.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.UserManage;
import com.lps.control.manage.WorkRankManage;
import com.lps.model.User;
import com.lps.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 员工是否签到检查，这将影响着上钟的排名
 * @author 0001
 *
 */
public class UserWorkCheckAction extends ActionSupport 
	implements DataResult,SessionAware {
	
	private Map<String, Object> session ;

	private static final long serialVersionUID = -4013579295942022608L;

	private UserService userServiceImpl;
	
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

	private WorkRankManage workRankManage;

	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}

	private Map<String, Object> map = new HashMap<>();

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 上班签到
	 * 
	 * @return
	 */
	public String checkIn() {

		try {
			int id = Integer.parseInt(session.get("id")+"");
//			User u = userServiceImpl.findById(id);
			User u = userManage.query(id);
			workRankManage.addUserData(u);
		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("您已签到");
//			map.put(MSG, "您已签到");
//			result = WorkJson.toJsonDisableHtmlEscaping(map);
//			return SUCCESS;
		}
		basicMsg.setSuccessMsg("签到成功");
//		map.put(MSG, "签到成功");
//		result = WorkJson.toJsonDisableHtmlEscaping(map);
		return SUCCESS;
	}

	/**
	 * 下班签退
	 * @return
	 */
	public String checkOut() {
		
		try {
			int id = Integer.parseInt(session.get("id")+"");
//			User u = userServiceImpl.findById(id);
			User u = userManage.query(id);
			workRankManage.deleteUserData(u);
		} catch (Exception e) {
//			e.printStackTrace();
//			map.put(MSG, "您已签退");
			basicMsg.setErrorMsg("您已签退");
//			result = WorkJson.toJsonDisableHtmlEscaping(map);
//			return SUCCESS;
		}
		basicMsg.setSuccessMsg("签退成功");
//		map.put(MSG, "签退成功");
//		result = WorkJson.toJsonDisableHtmlEscaping(map);
		return SUCCESS;
		
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
