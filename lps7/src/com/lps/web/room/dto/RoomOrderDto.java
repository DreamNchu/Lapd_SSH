package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.model.basic.Entity;
import com.lps.web.dto.BasicRequestDto;

public class RoomOrderDto extends RoomResponseDto{
	
	public Integer roomId;
	
	public String roomName;

	public RoomOrderDto(){
		
	}

	public RoomOrderDto(Integer roomId, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
	}

/*	@Override
	public RoomOrderDto init(Entity obj) {
		if (obj == null) {
			return this;
		}
		Room r = (Room)obj;
		roomId = r.getId();
		roomName = r.getName();
		return this;
	}*/
	

}
