package com.lps.web.room.dto;

import java.io.Serializable;
import java.util.Map;

import com.lps.model.Room;
import com.lps.model.User;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.user.dto.UserRequestDto;

public class RoomUpdateDataDto extends RoomRequestDto implements BasicUpdateDto<Room>{


	RoomUpdateDataDto(Map<String, String[]> map) {
		super(map);
	}

	@Override
	public Room update(Room t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
