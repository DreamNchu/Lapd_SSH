package com.lps.web.room.dto;

import java.util.Date;
import java.util.Map;

import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicRequestDto;

public class RoomRequestDto implements RoomLibraryDto, BasicRequestDto<Room> {

	public Map<String, String[]> map;

	public RoomRequestDto() {
		// TODO Auto-generated constructor stub
	}

	RoomRequestDto(Map<String, String[]> map) {
		this.map = map;
	}

	public Map<String, String[]> getMap() {
		return map;
	}

	public void setMap(Map<String, String[]> map) {
		this.map = map;
	}

	@Override
	public Room generate() {
		// TODO Auto-generated method stub
		Room room = new Room();
		String[] id = map.get(roomId);
		String[] name = map.get(roomName);
		String[] categoryId = map.get(roomCategoryId);
		String[] floor = map.get(roomFloor);
		String[] size = map.get(roomSize);
		String[] free = map.get(isFree);
		String[] clean = map.get(isClean);
		String[] cNum = map.get(customerNum);
		String[] remark = map.get(roomRemark);
		String[] addTime = map.get(roomAddTime);
		if (id != null) {
			room.setId(Integer.parseInt(id[0]));
		}

		if (name != null) {
			room.setName(name[0]);
		}

		if (categoryId != null) {
			ServerItem si = new ServerItem();
			si.setId(Integer.parseInt(categoryId[0]));
			room.setRoomCategory(si);
		}

		if (floor != null) {
			room.setFloor(Integer.parseInt(floor[0]));
		}

		if (size != null) {
			room.setSize(Integer.parseInt(size[0]));
		}

		if (free != null) {
			room.setIsFree(Boolean.parseBoolean(free[0]));
		}

		if (clean != null) {
			room.setClean(Boolean.parseBoolean(clean[0]));
		}

		if (cNum != null) {
			room.setCustomerNum(Integer.parseInt(cNum[0]));
		}

		if (remark != null) {
			room.setRemark(remark[0]);
		}

		if (addTime != null) {

			room.setAddTime(WorkDate.toDate(addTime[0]));
		}
		room.setAddTime(new Date());
		return room;
	}

}
