package com.lps.control.manage;

import com.lps.model.Room;
import com.lps.service.RoomService;

public class RoomManage {
	
	private RoomService roomServiceImpl;
	

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}


	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}


	/**
	 * 根据房间的主键id查询
	 * @param roomId
	 * @return
	 */
	public Room queryRoom(int roomId){
		return roomServiceImpl.findById(roomId);
	}
	
}
