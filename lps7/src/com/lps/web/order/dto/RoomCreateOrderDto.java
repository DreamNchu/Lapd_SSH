package com.lps.web.order.dto;

public class RoomCreateOrderDto {
	
	public String roomId;
	
	public String roomName;

	public RoomCreateOrderDto() {
		
	}

	public RoomCreateOrderDto(String roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}
	

}
