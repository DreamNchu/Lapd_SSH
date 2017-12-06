package com.lps.action.operation.order;

import java.util.List;

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Room;
import com.lps.model.WorkRank;
import com.lps.service.ClockCategoryService;
import com.lps.service.RoomService;
import com.lps.service.WorkRankService;
import com.lps.web.order.dto.InitCreateOrderDto;
import com.opensymphony.xwork2.ActionSupport;

public class InitCreateOrderBasicDataAction extends ActionSupport{

	private static final long serialVersionUID = -5140646258173298787L;

	private InitCreateOrderDto initCreateOrderDto;

	private WorkRankService workRankServiceImpl;

	private RoomService roomServiceImpl;

	private ClockCategoryService clockCategoryServiceImpl;
	
//	private RoomCategoryService 
	
	
	/*@Override
	public String execute(){
		
		
		
		List<WorkRank> listUser = workRankServiceImpl.findAll();
		for (WorkRank workRank : listUser) {
			sendOrderDto.getUserList().add(workRank.getUser());
		}
		
		List<Room> listRoom = roomServiceImpl.findAll();
		initCreateOrderDto.init(lu, listRoom, lrc);
		for (Room room : listRoom) {
			sendOrderDto.getRoomList().add(room);
			sendOrderDto.getRoomCategorySet().add(room.getRoomCategory());
		}
		
		sendOrderDto.setClockCategory(clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK));
		
		return SUCCESS;
	}
	*/

	public WorkRankService getWorkRankServiceImpl() {
		return workRankServiceImpl;
	}

	public void setWorkRankServiceImpl(WorkRankService workRankServiceImpl) {
		this.workRankServiceImpl = workRankServiceImpl;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	public ClockCategoryService getClockCategoryServiceImpl() {
		return clockCategoryServiceImpl;
	}

	public void setClockCategoryServiceImpl(ClockCategoryService clockCategoryServiceImpl) {
		this.clockCategoryServiceImpl = clockCategoryServiceImpl;
	}

	public InitCreateOrderDto getInitCreateOrderDto() {
		return initCreateOrderDto;
	}

	public void setInitCreateOrderDto(InitCreateOrderDto initCreateOrderDto) {
		this.initCreateOrderDto = initCreateOrderDto;
	}

}
