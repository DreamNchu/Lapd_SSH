package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicResponseDto;

public class RoomResponseDto extends BasicRespondMsgDto implements RoomLibraryDto, BasicResponseDto<Room>{

	/**
	 * 
	 */
	private static  long serialVersionUID = -3813292612717944690L;


	@Override
	public RoomResponseDto initDto(Room obj) throws DtoInitException {
		// TODO Auto-generated method stub
		if(obj == null) {
			throw new DtoInitException("房间数据转换对象初始化异常");
		}
		Room room = (Room)obj;
		if(room.getId() != null) {
			put(roomId, room.getId()); 
		}
		
		if(room.getName() != null) {
			put(roomName, room.getName());
		}
		
		if(room.getRoomCategory() != null) {
			put(roomCategoryId, room.getRoomCategory().getId());
			put(roomCategoryName, room.getRoomCategory().getServerItem());
		}
		
		if(room.getFloor() != null) {
			put(roomFloor, room.getFloor());
		}
		
		if(room.getSize() != null) {
			put(roomSize, room.getSize());
		}
		
		put(isFree, room.getIsFree());
		put(isClean, room.getIsClean()); 
		
		if(room.getRemark() != null) {
			put(roomRemark, room.getRemark());
		}
		
		if(room.getCustomerNum() != null) {
			put(customerNum, room.getCustomerNum());
		}
		
		if(room.getAddTime() != null) {
			put(roomAddTime, WorkDate.dateToString(room.getAddTime()));
		}
		
		return this;
	}
	
}
