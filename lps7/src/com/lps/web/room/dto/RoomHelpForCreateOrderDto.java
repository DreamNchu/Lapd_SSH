package com.lps.web.room.dto;

import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class RoomHelpForCreateOrderDto extends BasicRespondMsgDto /*implements BasicInitDto<RoomHelpForCreateOrderDto>*/ {
	
	private String roomName;
	
	private String roomCategory;
	
	private int roomFloor;
	
	private int roomSize;
	
	private int customerNum;
	
	private boolean isFree;
	
	private boolean isClean;
	
/*	@Override
	public RoomHelpForCreateOrderDto init(Entity obj) throws DtoInitException {
		if (obj != null && obj instanceof Room) {
			Room room = (Room) obj;
			roomName = room.getName();
			roomCategory = room.getRoomCategory().getServerItem();
			roomFloor = room.getFloor();
			roomSize = room.getSize();
			customerNum = room.getCustomerNum();
			isClean = room.getIsClean();
			isFree = room.getIsFree();
			return this;
		}
		throw new DtoInitException();
	}*/



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}



	public String getRoomCategory() {
		return roomCategory;
	}



	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}



	public int getRoomFloor() {
		return roomFloor;
	}



	public void setRoomFloor(int roomFloor) {
		this.roomFloor = roomFloor;
	}



	public int getRoomSize() {
		return roomSize;
	}



	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}



	public int getCustomerNum() {
		return customerNum;
	}



	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}



	public boolean isFree() {
		return isFree;
	}



	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}



	public boolean isClean() {
		return isClean;
	}



	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	
	
	
}
