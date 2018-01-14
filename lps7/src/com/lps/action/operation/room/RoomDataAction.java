package com.lps.action.operation.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.RoomManage;
import com.lps.model.Room;
import com.lps.service.RoomService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.WorkJson;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.room.dto.NotRoomObjectException;
import com.lps.web.room.dto.RoomHelpForCreateOrderDto;
import com.lps.web.room.dto.RoomIdDto;
import com.lps.action.basic.ActionSupportLps;

public class RoomDataAction extends ActionSupportLps implements DataResult{

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());
	
	private static final long serialVersionUID = -3719803951152554912L;
	
	private RoomHelpForCreateOrderDto roomHelpForCreateOrderDto;
	
	private RoomIdDto roomIdDto;

	private RoomManage roomManage;
	@Override
	public String getResult() {
		return result.toString();
	}
	
	
	
	public RoomHelpForCreateOrderDto getRoomHelpForCreateOrderDto() {
		return roomHelpForCreateOrderDto;
	}


	public RoomIdDto getRoomIdDto() {
		return roomIdDto;
	}

	public RoomManage getRoomManage() {
		return roomManage;
	}

	public void setRoomHelpForCreateOrderDto(RoomHelpForCreateOrderDto roomHelpForCreateOrderDto) {
		this.roomHelpForCreateOrderDto = roomHelpForCreateOrderDto;
	}

	public void setRoomIdDto(RoomIdDto roomIdDto) {
		this.roomIdDto = roomIdDto;
	}

	public void setRoomManage(RoomManage roomManage) {
		this.roomManage = roomManage;
	}
	/**
	 * 查看工作状态的基本信息
	 * @return
	 * @throws Exception 
	 */
	public String viewWorkRoomData() throws Exception{
		basicMsg.setMsgDto(roomHelpForCreateOrderDto);
		
		Room room = null;
		try {
			room = roomManage.queryRoom(roomIdDto.getRoomId());
			roomHelpForCreateOrderDto.initDto(room);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			roomHelpForCreateOrderDto.appendErrorMsg(e.getMessage());
		} catch (DtoInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			roomHelpForCreateOrderDto.appendErrorMsg(e.getMessage());
		}
		return SUCCESS;
	}
}
