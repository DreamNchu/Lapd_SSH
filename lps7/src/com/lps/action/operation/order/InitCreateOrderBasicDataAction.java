package com.lps.action.operation.order;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lps.action.basic.ActionSupportLps;
import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.OrderManage;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;
import com.lps.service.RoomService;
import com.lps.service.ServerItemService;
import com.lps.service.UserService;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.InitCreateOrderDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;

public class InitCreateOrderBasicDataAction extends ActionSupportLps implements DataResult {

	private static final long serialVersionUID = -5140646258173298787L;

	private InitCreateOrderDto initCreateOrderDto;

	private RoomService roomServiceImpl;

	private ServerItemService serverItemServiceImpl;

	private UserService userServiceImpl;
	
	private OrderManage orderManage;

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	/**
	 * 初始化发订单的基本数据
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String initOrderData() {
		List<Room> listRooms = roomServiceImpl.findAll();
		List<ServerItem> listServerItems = serverItemServiceImpl.findAll();
		List<User> lisUsers = userServiceImpl.findAll();
//		System.out.println(listServerItems.get(0).getClass().getName());
//		System.out.println(listServerItems.getClass().getGenericInterfaces()[0]);
//		System.out.println(lisUsers.get(0).getClass().getName());
		try{
			initCreateOrderDto.init(lisUsers, listRooms, listServerItems);
		} catch (DtoInitException | MapNotInitForClassPathException e) {
			e.printStackTrace();
			initCreateOrderDto.setErrorMsg(e.getMessage() + "\n" + "初始化订单信息失败");
		}

//		String str = WorkJson.toJsonDisableHtmlEscaping(initCreateOrderDto);
//		System.out.println(str);
		
		basicMsg.setMsgDto(initCreateOrderDto);
		
		return SUCCESS;
	}
	
	public String getResult(){
		return result.toString();
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public ServerItemService getServerItemServiceImpl() {
		return serverItemServiceImpl;
	}

	public void setServerItemServiceImpl(ServerItemService serverItemServiceImpl) {
		this.serverItemServiceImpl = serverItemServiceImpl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	public InitCreateOrderDto getInitCreateOrderDto() {
		return initCreateOrderDto;
	}

	public void setInitCreateOrderDto(InitCreateOrderDto initCreateOrderDto) {
		this.initCreateOrderDto = initCreateOrderDto;
	}

}
