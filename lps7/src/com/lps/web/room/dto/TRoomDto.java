package com.lps.web.room.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.Room;
import com.lps.model.basic.Entity;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@DtoName("rooms")
public class TRoomDto extends ArrayList<RoomDto> implements TableInitDto<Room>{

	private static final long serialVersionUID = 6746457713473621005L;

	public static final String name = "rooms";

	@Override
	public void init(List<Room> lists) throws DtoInitException {
		for (Entity entity : lists) {
			RoomDto ccd = new RoomDto();
			ccd.init((Room)entity);
			add(ccd);
		}
	}


	/*@Override
	public String getName() {
		return name;
	}*/
	
}
