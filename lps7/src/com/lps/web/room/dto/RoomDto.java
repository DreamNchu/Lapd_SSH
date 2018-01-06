package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.DtoInitException;
import com.lps.web.simple.dto.OrderStatusDto;

public class RoomDto extends BasicRespondMsgDto implements RoomLibraryDto{

	@Override
	public OrderStatusDto init(Room obj) throws DtoInitException {
		
		
		
		return null;
	}

}
