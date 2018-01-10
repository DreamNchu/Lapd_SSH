package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.simple.dto.OrderStatusDto;

public interface RoomLibraryDto extends BasicRequestDto<Room>, BasicResponseDto<Room>{

	public String roomId = "roomId";

	public String roomName = "roomName";
	
	public String roomCategory = "roomCategory";

	public String roomCategoryName = "roomCategoryName";
	
	public String roomCategoryId = "roomCategoryId";
	
	public String roomFloor = "roomFloor";
	
	public String roomSize = "roomSize";
	
	public String customerNum = "customerNum";
	
	public String roomRemark = "roomRemark";
	
	public String roomAddTime = "roomAddTime";
	
	public String isFree = "isFree";
	
	public String isClean = "isClean";

}
