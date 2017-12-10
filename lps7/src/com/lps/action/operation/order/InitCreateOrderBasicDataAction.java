package com.lps.action.operation.order;

import java.util.List;

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;
import com.lps.service.ClockCategoryService;
import com.lps.service.RoomService;
import com.lps.service.ServerItemService;
import com.lps.service.UserService;
import com.lps.service.WorkRankService;
import com.lps.util.WorkJson;
import com.lps.web.order.dto.InitCreateOrderDto;
import com.opensymphony.xwork2.ActionSupport;

public class InitCreateOrderBasicDataAction extends ActionSupport{

	private static final long serialVersionUID = -5140646258173298787L;

	private InitCreateOrderDto initCreateOrderDto;

	private RoomService roomServiceImpl;

	private ServerItemService serverItemServiceImpl; 
	
	private UserService userServiceImpl;
	
	private String result;
	
	public String initOrderData(){
		List<Room> listRooms = roomServiceImpl.findAll();
		List<ServerItem> listServerItems = serverItemServiceImpl.findAll();
		List<User> lisUsers = userServiceImpl.findAll();
				
		initCreateOrderDto.init(lisUsers, listRooms, listServerItems);
		
		//保存结果
		result =  WorkJson.toJsonDisableHtmlEscaping(initCreateOrderDto);
		return SUCCESS;
	}
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}



	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public ServerItemService getServerItemServiceImpl() {
		return serverItemServiceImpl;
	}


	public void setServerItemServiceImpl(ServerItemService serverItemServiceImpl) {
		this.serverItemServiceImpl = serverItemServiceImpl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}


	public InitCreateOrderDto getInitCreateOrderDto() {
		return initCreateOrderDto;
	}

	public void setInitCreateOrderDto(InitCreateOrderDto initCreateOrderDto) {
		this.initCreateOrderDto = initCreateOrderDto;
	}

}
