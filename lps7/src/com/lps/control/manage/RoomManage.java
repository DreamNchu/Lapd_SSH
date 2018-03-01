package com.lps.control.manage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.service.RoomService;
import com.lps.service.ServerItemService;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.room.dto.InitOperationRoomData;

@Component
public class RoomManage extends AbstractManage<Room> {

	@Autowired
	public RoomManage(BasicService<Room> service) {
		super(service);
	}

	@Autowired
	private ServerItemService serverItemServiceImpl;
	

	public ServerItemService getServerItemServiceImpl() {
		return serverItemServiceImpl;
	}

	public void setServerItemServiceImpl(ServerItemService serverItemServiceImpl) {
		this.serverItemServiceImpl = serverItemServiceImpl;
	}

	@Override
	public void delete(java.io.Serializable... id) throws FindByIdGetNullException {
		Room[] room = new Room[id.length]; 
		int i = 0;
		for (java.io.Serializable serializable : id) {
			Room r = service.findById(serializable);
			for(ServerOrder so :r.getServerOrders()){
				so.setRoom(null);
			}
			room[i ++] = r;
			
		}
		service.deleteAll(Arrays.asList(room));
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


	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto) throws DtoInitException, MapNotInitForClassPathException {
		InitOperationRoomData iord = (InitOperationRoomData)dto;
		iord.init(serverItemServiceImpl.findAll());
	}

}
