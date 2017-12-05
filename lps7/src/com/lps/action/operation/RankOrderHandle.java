package com.lps.action.operation;

import java.util.List;

import com.lps.control.manage.WorkRankManage;
import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Room;
import com.lps.model.WorkRank;
import com.lps.service.ClockCategoryService;
import com.lps.service.RoomService;
import com.lps.service.WorkRankService;
import com.lps.web.dto.SendOrderDto;
import com.opensymphony.xwork2.ActionSupport;

public class RankOrderHandle extends ActionSupport{

	private static final long serialVersionUID = -1349453592754086439L;
	
	private WorkRankService workRankServiceImpl;
	
	private RoomService roomServiceImpl;
	
	private ClockCategoryService clockCategoryServiceImpl;
	

	public ClockCategoryService getClockCategoryServiceImpl() {
		return clockCategoryServiceImpl;
	}

	public void setClockCategoryServiceImpl(ClockCategoryService clockCategoryServiceImpl) {
		this.clockCategoryServiceImpl = clockCategoryServiceImpl;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	private SendOrderDto sendOrderDto = new SendOrderDto();
	
	public SendOrderDto getSendOrderDto() {
		return sendOrderDto;
	}

	public void setSendOrderDto(SendOrderDto sendOrderDto) {
		this.sendOrderDto = sendOrderDto;
	}

	public WorkRankService getWorkRankServiceImpl() {
		return workRankServiceImpl;
	}

	public void setWorkRankServiceImpl(WorkRankService workRankServiceImpl) {
		this.workRankServiceImpl = workRankServiceImpl;
	}

	@Override
	public String execute(){
		List<WorkRank> listUser = workRankServiceImpl.findAll();
		for (WorkRank workRank : listUser) {
			sendOrderDto.getUserList().add(workRank.getUser());
		}
		
		List<Room> listRoom = roomServiceImpl.findAll();
		for (Room room : listRoom) {
			sendOrderDto.getRoomList().add(room);
			sendOrderDto.getRoomCategorySet().add(room.getRoomCategory());
		}
		
		sendOrderDto.setClockCategory(clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK));
		
		return SUCCESS;
	}

}
