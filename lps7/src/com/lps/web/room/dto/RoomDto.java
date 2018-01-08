package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class RoomDto extends BasicRespondMsgDto implements RoomLibraryDto{

/*	@Override
	public OrderStatusDto init(Room obj) throws DtoInitException {
		
		return null;
	}*/

	@Override
	public Room generate() {
		// TODO Auto-generated method stub
		Room room = new Room();
		String id = (String)get(roomId);
		String name = (String)get(roomName);
		String categoryId = (String)get(roomCategoryId);
		String floor = (String)get(roomFloor);
		String size = (String)get(roomSize);
		String free = (String)get(isFree);
		String clean = (String)get(isClean);
		String cNum = (String)get(customerNum);
		String remark = (String)get(roomRemark);
		String addTime = (String)get(roomAddTime);
		if(id != null) {
			room.setId(Integer.parseInt(id));
		}
		
		if(name != null) {
			room.setName(name);
		}
		
		if(categoryId != null) {
			ServerItem si = new ServerItem();
			si.setId(Integer.parseInt(categoryId));
			room.setRoomCategory(si);
		}
		
		if(floor != null) {
			room.setFloor(Integer.parseInt(floor));
		}
		
		if(size != null) {
			room.setSize(Integer.parseInt(size));
		}
		
		if(free != null) {
			room.setIsFree(Boolean.parseBoolean(free));
		}
		
		if(clean != null) {
			room.setClean(Boolean.parseBoolean(clean));
		}
		
		if(cNum != null) {
			room.setCustomerNum(Integer.parseInt(cNum));
		}
		
		if(remark != null) {
			room.setRemark(remark);
		}
		
		if(addTime != null) {
			
			room.setAddTime(WorkDate.toDate(addTime));
		}
			
		return room;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDto init(Room obj) throws DtoInitException {
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
	
	/*	public static void main(String[] args) throws DtoInitException {
		RoomDto rd = new RoomDto();
		Room r1 = new Room();
		r1.setId(4);
		r1.setName("333");
		r1.setAddTime(WorkDate.toDate("2020-3-9"));
		r1.setClean(true);
		r1.setFloor(4);
		r1.setCustomerNum(5);
		r1.setFree(false);
		r1.setRemark("房间正在装修");
		ServerItem rc = new ServerItem();
		rc.setId(6);
		r1.setRoomCategory(rc);
		r1.setSize(5);
		RoomDto rd1 = rd.init(r1);
		System.out.println(rd1.get(isClean));
		System.out.println(rd1.get(isFree));
		System.out.println(rd1.get(customerNum));
		System.out.println(rd1.get(roomAddTime));
		System.out.println(rd1.get(roomCategoryId));
		System.out.println(rd1.get(roomFloor));
		System.out.println(rd1.get(roomId));
		System.out.println(rd1.get(roomName));
		System.out.println(rd1.get(roomRemark));
		System.out.println(rd1.get(roomSize));
		
		RoomDto rd2 = new RoomDto();
		rd2.put("isClean", "true");
		rd2.put("isFree", "true");
		rd2.put("customerNum", "5");
		rd2.put("roomAddTime", "1996-9-9");
		rd2.put("roomCategoryId", "5");
		rd2.put("roomFloor", "7");
		rd2.put("roomId", "3");
		rd2.put("roomName", "312");
		rd2.put("roomRemark", "此房间已装修");
		rd2.put("roomSize", "7");
		Room r2 = rd2.generate();
		System.out.println(r2.getIsClean());
		System.out.println(r2.getIsFree());
		System.out.println(r2.getName());
		System.out.println(r2.getRemark());
		System.out.println(r2.getAddTime());
		System.out.println(r2.getCustomerNum());
		System.out.println(r2.getFloor());
		System.out.println(r2.getFloor());
		System.out.println(r2.getRoomCategory().getId());
		System.out.println(r2.getSize());
		
	} */

}
