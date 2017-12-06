package com.lps.action.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.dao.WorkStatusDAO;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.ServerOrderService;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;
import com.lps.web.dto.UserWorkDataDto;
import com.opensymphony.xwork2.ActionSupport;


public class UserWorkDataAction extends ActionSupport{

	private static final long serialVersionUID = 4257097318892616866L;

	private UserService userServiceImpl;
	
	private ServerOrderService serverOrderServiceImpl;
	
	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	private PageBean<User> pageUsers;
	
	public PageBean<User> getPageUsers() {
		return pageUsers;
	}

	public void setPageUsers(PageBean<User> pageUsers) {
		this.pageUsers = pageUsers;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
//	private List<Room> listRoom;
	private List<UserWorkDataDto> listWorkStatus = new ArrayList<UserWorkDataDto>();
	
	public List<UserWorkDataDto> getListWorkStatus() {
		return listWorkStatus;
	}

	public void setListWorkStatus(List<UserWorkDataDto> listWorkStatus) {
		this.listWorkStatus = listWorkStatus;
	}

	/**
	 * 1.拿到所有用户
	 * <br>
	 * 2.如果用户在工作，
	 * <br>a.拿到所在的房间 
	 * <br>b.拿到工作开始的房间 
	 * <br>c.估算预计结束时间 
	 * @return
	 * @throws PagePropertyNotInitException 
	 */
	public String viewUsersByPage() throws PagePropertyNotInitException{
		
		this.pageUsers = userServiceImpl.findByPage(page);
		this.page = (int) this.pageUsers.getPage();
		
		Map<String, Object> propertyMap = new HashMap<>();
		for (User u : this.pageUsers.getList()) {
			//如果在工作，查找订单
			UserWorkDataDto uw = new UserWorkDataDto();
			uw.setUser(u);
			if(u.getWorkStatus().getId() == WorkStatusDAO.WORKING){
				propertyMap.put(ServerOrderDAOImpl.USER, u);
				propertyMap.put(ServerOrderDAOImpl.FINISH_TIME, null);
				List<ServerOrder> soList = serverOrderServiceImpl.findIdByProperty(propertyMap);
				ServerOrder so = null; 
				so = soList.get(0);
				uw.setRoom(so.getRoom());
				uw.setStartTime(WorkDate.getTime(so.getReceiveTime()));
				//简答计算往后退一个小时
				Date d = WorkDate.addTime(so.getReceiveTime(), 1, 0, 0);
				uw.setEndTime(WorkDate.getTime(d));
			}else{
				uw.setRoom(null);
				uw.setStartTime(null);
				uw.setEndTime(null);
			}
			listWorkStatus.add(uw);
		}
		return SUCCESS;
	}
	
}
