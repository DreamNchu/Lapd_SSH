package com.lps.web.order.dto;

public class CreateOrderDto {
	
	private int createWay;
	
 	private int stuffId;
 	
 	private int roomId;
 	
 	private int roomCategoryId;
 	

	public int getCreateWay() {
		return createWay;
	}

	public void setCreateWay(int createWay) {
		this.createWay = createWay;
	}

	public int getStuffId() {
		return stuffId;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomCategoryId() {
		return roomCategoryId;
	}

	public void setRoomCategoryId(int roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}
 	

}
