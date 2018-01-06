package com.lps.action.operation.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.RoomManage;
import com.lps.model.Room;
import com.lps.service.RoomService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.WorkJson;
import com.lps.web.room.dto.NotRoomObjectException;
import com.lps.web.room.dto.RoomHelpForCreateOrderDto;
import com.lps.web.room.dto.RoomIdDto;
import com.opensymphony.xwork2.ActionSupport;

public class RoomDataAction extends ActionSupport implements DataResult{

	private static final long serialVersionUID = -3719803951152554912L;
	
	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());
	
	private RoomHelpForCreateOrderDto roomHelpForCreateOrderDto;
	
	private RoomManage roomManage;

	private RoomIdDto roomIdDto;
	/**
	 * 查看工作状态的基本信息
	 * @return
	 * @throws NotRoomObjectException 
	 */
	public String viewWorkRoomData() throws NotRoomObjectException{
		basicMsg.setMsgDto(roomHelpForCreateOrderDto);
		
		Room room = null;
		try {
			room = roomManage.queryRoom(roomIdDto.getRoomId());
		} catch (FindByIdGetNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roomHelpForCreateOrderDto.init(room);
		return SUCCESS;
	}
	public RoomIdDto getRoomIdDto() {
		return roomIdDto;
	}


	public void setRoomIdDto(RoomIdDto roomIdDto) {
		this.roomIdDto = roomIdDto;
	}



	public RoomManage getRoomManage() {
		return roomManage;
	}

	public void setRoomManage(RoomManage roomManage) {
		this.roomManage = roomManage;
	}

	public RoomHelpForCreateOrderDto getRoomHelpForCreateOrderDto() {
		return roomHelpForCreateOrderDto;
	}

	public void setRoomHelpForCreateOrderDto(RoomHelpForCreateOrderDto roomHelpForCreateOrderDto) {
		this.roomHelpForCreateOrderDto = roomHelpForCreateOrderDto;
	}

}
