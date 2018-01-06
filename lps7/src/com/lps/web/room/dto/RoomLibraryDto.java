package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.web.dto.BasicInitDto;
import com.lps.web.simple.dto.OrderStatusDto;

public interface RoomLibraryDto extends BasicInitDto<OrderStatusDto, Room>{

	public String roomId = "roomId";

	public String roomName = "roomName";

	public String roomCategory = "roomCategory";
	
	public String roomFloor = "roomFloor";
	
	public String roomSize = "roomSize";
	
	public String customerNum = "customerNum";
	
	public String roomRemark = "roomRemark";
	
	public String roomAddTime = "roomAddTime";
	
	public String isFree = "isFree";
	
	public String isClean = "isClean";

}
