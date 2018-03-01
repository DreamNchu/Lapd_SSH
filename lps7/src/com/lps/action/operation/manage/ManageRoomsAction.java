package com.lps.action.operation.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.basic.ActionSupportLps;
import com.lps.control.manage.ECreateFailedException;
import com.lps.control.manage.RoomManage;
import com.lps.model.Room;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.page.dto.PageUtil;
import com.lps.web.room.dto.InitOperationRoomData;
import com.lps.web.room.dto.RoomHelpForCreateOrderDto;
import com.lps.web.room.dto.RoomIdDto;
import com.lps.web.room.dto.RoomRequestDto;
import com.lps.web.room.dto.RoomResponseDto;
import com.lps.web.room.dto.RoomTableDataDto;
import com.lps.web.room.dto.RoomUpdateDataDto;

public class ManageRoomsAction extends ActionSupportLps implements SessionAware{

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6496410441337869225L;

	private PageUtil pageUtil;

	private RoomHelpForCreateOrderDto roomHelpForCreateOrderDto;

	private RoomIdDto roomIdDto;

	private List<Integer> roomIds;

	/**
	 * 1.增加： add*(); 2.删除： delete*s(); 3.查询单个：query*(); 4.分页查询：query*sByPage();
	 * 5.更新：update*();
	 * 
	 */

	private RoomManage roomManage;

	private RoomRequestDto roomRequestDto;

	private RoomResponseDto roomResponseDto;

	private RoomTableDataDto roomTableDataDto;

	private RoomUpdateDataDto roomUpdateDataDto;

	private Map<String, Object> session ;
	
	private InitOperationRoomData initOperationRoomData;
	
	
	public InitOperationRoomData getInitOperationRoomData() {
		return initOperationRoomData;
	}

	public void setInitOperationRoomData(InitOperationRoomData initOperationRoomData) {
		this.initOperationRoomData = initOperationRoomData;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String initOperationRoomData(){
		try {
			basicMsg.setMsgDto(initOperationRoomData);
			roomManage.initOperationData(initOperationRoomData);
		} catch (DtoInitException | MapNotInitForClassPathException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}
	
	public String addRoom() {
		
		try {
			roomRequestDto.setMap(data);
			roomManage.create(roomRequestDto);
		} catch (ECreateFailedException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public String deleteRooms() {
		try {
			roomManage.delete(roomIds.toArray(new Serializable[0]));
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public RoomHelpForCreateOrderDto getRoomHelpForCreateOrderDto() {
		return roomHelpForCreateOrderDto;
	}

	public RoomIdDto getRoomIdDto() {
		return roomIdDto;
	}

	public List<Integer> getRoomIds() {
		return roomIds;
	}

	public RoomManage getRoomManage() {
		return roomManage;
	}

	public RoomRequestDto getRoomRequestDto() {
		return roomRequestDto;
	}

	public RoomResponseDto getRoomResponseDto() {
		return roomResponseDto;
	}

	public RoomTableDataDto getRoomTableDataDto() {
		return roomTableDataDto;
	}

	public RoomUpdateDataDto getRoomUpdateDataDto() {
		return roomUpdateDataDto;
	}

	public String queryRoom() {

		basicMsg.setMsgDto(roomResponseDto);

		try {
			roomManage.query(roomIds.get(0), roomResponseDto);
		} catch (FindByIdGetNullException | DtoInitException e) {
			e.printStackTrace();
			roomResponseDto.setDefaultErrorMsg();
		}
		roomResponseDto.setDefaultSuccessMsg();
		return SUCCESS;
	}
	
	public String queryRoomsByPage() {

		basicMsg.setMsgDto(roomTableDataDto);

		if (pageUtil != null) {
			if (pageUtil.getPage() != 0) {
				session.put("roomPage", pageUtil.getPage());
			}
		} else {
			pageUtil = new PageUtil();
		}
		pageUtil.setPage(Integer.parseInt(session.get("roomPage") + ""));

		try {
			roomTableDataDto.init(roomManage.queryByPage(pageUtil.getPage()), pageUtil,
					Thread.currentThread().getStackTrace()[1].getMethodName());
		} catch (DtoInitException | FindByIdGetNullException | PagePropertyNotInitException e) {
			roomTableDataDto.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public void setRoomHelpForCreateOrderDto(RoomHelpForCreateOrderDto roomHelpForCreateOrderDto) {
		this.roomHelpForCreateOrderDto = roomHelpForCreateOrderDto;
	}

	public void setRoomIdDto(RoomIdDto roomIdDto) {
		this.roomIdDto = roomIdDto;
	}

	public void setRoomIds(List<Integer> roomIds) {
		this.roomIds = roomIds;
	}
	

	public void setRoomManage(RoomManage roomManage) {
		this.roomManage = roomManage;
	}
	
	public void setRoomRequestDto(RoomRequestDto roomRequestDto) {
		this.roomRequestDto = roomRequestDto;
	}
	
	public void setRoomResponseDto(RoomResponseDto roomResponseDto) {
		this.roomResponseDto = roomResponseDto;
	}

	public void setRoomTableDataDto(RoomTableDataDto roomTableDataDto) {
		this.roomTableDataDto = roomTableDataDto;
	}


	public void setRoomUpdateDataDto(RoomUpdateDataDto roomUpdateDataDto) {
		this.roomUpdateDataDto = roomUpdateDataDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public String updateRoom() {
		roomUpdateDataDto.setMap(data);
		try {
			roomManage.update(roomUpdateDataDto);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("数据更新失败");
		}
		basicMsg.setSuccessMsg("数据更新成功");
		return SUCCESS;
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
