package com.lps.web.room.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.Room;
import com.lps.model.basic.Entity;
import com.lps.web.dto.DtoInitException;
import com.lps.web.dto.TableInitDto;

public class TRoomDto extends ArrayList<RoomDto> implements TableInitDto{

	private static final long serialVersionUID = 6746457713473621005L;


	@Override
	public <T extends Entity> void init(List<T> lists) throws DtoInitException {
		for (Entity entity : lists) {
			RoomDto ccd = new RoomDto();
			ccd.init((Room)entity);
			add(ccd);
		}
	}
	
}
