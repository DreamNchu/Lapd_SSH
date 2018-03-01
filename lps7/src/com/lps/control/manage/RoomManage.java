package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.service.RoomService;
import com.lps.service.ServerItemService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.room.dto.InitOperationRoomData;

public class RoomManage implements BasicManage<Room>{
	
	private RoomService roomServiceImpl;
	
	private ServerItemService serverItemServiceImpl;
	

	public ServerItemService getServerItemServiceImpl() {
		return serverItemServiceImpl;
	}

	public void setServerItemServiceImpl(ServerItemService serverItemServiceImpl) {
		this.serverItemServiceImpl = serverItemServiceImpl;
	}

	@Override
	public <DTO extends BasicRequestDto<Room>> void create(DTO dto) throws ECreateFailedException {
		roomServiceImpl.save(dto.generate());
	}

	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		Room[] room = new Room[id.length]; 
		int i = 0;
		for (Serializable serializable : id) {
			Room r = roomServiceImpl.findById(serializable);
			for(ServerOrder so :r.getServerOrders()){
				so.setRoom(null);
			}
			room[i ++] = r;
			
		}
		roomServiceImpl.deleteAll(Arrays.asList(room));
	}


	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}


	@Override
	public Room query(Serializable id) throws FindByIdGetNullException {
		return roomServiceImpl.findById(id);
	}


	@Override
	public Room query(Serializable id, List<String> listName) throws FindByIdGetNullException {
		return null;
	}


	@Override
	public <RDto extends BasicResponseDto<Room>> Room query(Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		Room room = roomServiceImpl.findById(id);
		rdto.initDto(room);
		return room;
	}


@Override
	public List<Room> queryAll() {
		return roomServiceImpl.findAll();
	}

	@Override
	public PageBean<Room> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		return roomServiceImpl.findByPage(page);
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


	/**
	 * 根据房间的主键id查询
	 * @param roomId
	 * @return
	 * @throws FindByIdGetNullException 
	 */
	public Room queryRoom(int roomId) throws FindByIdGetNullException{
		return roomServiceImpl.findById(roomId);
	}


	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}


	@Override
	public <DTO extends BasicUpdateDto<Room>> void update(DTO dto) throws FindByIdGetNullException {
        Room room = dto.generate();
		
		room = roomServiceImpl.findById(room.getId());
		roomServiceImpl.update(dto.update(room));
		
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto) throws DtoInitException, MapNotInitForClassPathException {
		InitOperationRoomData iord = (InitOperationRoomData)dto;
		System.out.println(serverItemServiceImpl.findAll().size());
		iord.init(serverItemServiceImpl.findAll());
	}



	
}
