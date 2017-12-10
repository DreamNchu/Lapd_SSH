package com.lps.web.order.dto;

import com.lps.model.Room;

public class RoomOrderDto implements DtoBasicInit<RoomOrderDto>{
	
	public Integer roomId;
	
	public String roomName;

	public RoomOrderDto() {
		
	}

	public RoomOrderDto(Integer roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}

	@Override
	public RoomOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		Room r = (Room)obj;
		roomId = r.getId();
		roomName = r.getName();
		return this;
	}
	

}
