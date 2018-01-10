package com.lps.control.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lps.model.Room;
import com.lps.service.RoomService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.dto.BasicRequestDto;

public class RoomManage implements BasicManage<Room>{
	
	private RoomService roomServiceImpl;
	

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}


	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}


	/**
	 * 根据房间的主键id查询
	 * @param roomId
	 * @return
	 * @throws FindByIdGetNullException 
	 */
	public Room queryRoom(int roomId) throws FindByIdGetNullException{
		return roomServiceImpl.findById(roomId);
	}


	@Override
	public <DTO extends BasicRequestDto<Room>> void create(DTO dto) throws CreateFailedException {
		// TODO Auto-generated method stub
//		Room room = 
	}


	@Override
	public <DTO extends BasicRequestDto<Room>> void update(DTO dto) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Room query(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Room query(Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PageBean<Room> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Room> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Room> queryByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Room> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
