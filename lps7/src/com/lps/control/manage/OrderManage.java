package com.lps.control.manage;

import java.util.Date;

import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.OrderStatusDAO;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.ClockCategoryService;
import com.lps.service.OrderStatusService;
import com.lps.service.RoomService;
import com.lps.service.UserService;
import com.lps.util.WorkDate;

public class OrderManage {

	private UserService userServiceImpl;

	private RoomService roomServiceImpl;

	private ClockCategoryService clockCategoryServiceImpl;
	
	private OrderStatusService orderStatusServiceImpl;
	
	private WorkRankManage workRankManage;
	
	private int userWorkIdLength ;
	
	private int roomNameLength;
	
	private int indexLength;
	
	
	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}

	public int getUserWorkIdLength() {
		return userWorkIdLength;
	}

	public void setUserWorkIdLength(int userWorkIdLength) {
		this.userWorkIdLength = userWorkIdLength;
	}

	public int getRoomNameLength() {
		return roomNameLength;
	}

	public void setRoomNameLength(int roomNameLength) {
		this.roomNameLength = roomNameLength;
	}

	public int getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(int indexLength) {
		this.indexLength = indexLength;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}
	
	public OrderStatusService getOrderStatusServiceImpl() {
		return orderStatusServiceImpl;
	}

	public void setOrderStatusServiceImpl(OrderStatusService orderStatusServiceImpl) {
		this.orderStatusServiceImpl = orderStatusServiceImpl;
	}

	public ClockCategoryService getClockCategoryServiceImpl() {
		return clockCategoryServiceImpl;
	}

	public void setClockCategoryServiceImpl(ClockCategoryService clockCategoryServiceImpl) {
		this.clockCategoryServiceImpl = clockCategoryServiceImpl;
	}

	public static int i = 1;

	/**
	 * 订单id的生成
	 * @param wordId
	 * @param roomName1
	 * @param clockCategoryId
	 * @return
	 */
	private String orderIdCreater(int wordId, String roomName1, int clockCategoryId) {
		String userWorkId = format(wordId, userWorkIdLength);
		String roomName = format(roomName1, roomNameLength);
		String date = WorkDate.getNowDateTime();
		String index = format(i ++, indexLength);
		String orderId = userWorkId + roomName + clockCategoryId + date + index;
		return orderId;
	}
/**
 * 订单格式化
 * @param value
 * @param length
 * @return
 */
	private String format(int value, int length) {
		return format(String.valueOf(value), length);
	}

	/**
	 * 订单格式化
	 * @param value
	 * @param length
	 * @return
	 */
	private String format(String value, int length) {
		int strLen = value.length();
		if (strLen < length) {
			while (strLen < length) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(value);// 左补0
				value = sb.toString();
				strLen = value.length();
			}
		}
		return value;
	}

	/**
	 * 创建一个订单
	 * @param stuffId
	 * @param roomId
	 * @param clockCategory
	 * @return
	 */
	public ServerOrder createOrder(int stuffId, int roomId, int clockCategory, String orderRemark) {
		
		User u = userServiceImpl.findById(stuffId);
		Room r = roomServiceImpl.findById(roomId);
		ClockCategory cc = clockCategoryServiceImpl.findById(clockCategory);
		
		return createNormalOrder(u, r, cc,orderRemark);
	}
	
	/**
	 * 正常情况创建订单
	 * @param user
	 * @param room
	 * @param clockCategory
	 * @return
	 */
	public ServerOrder createNormalOrder(User user, Room room, ClockCategory clockCategory, String orderRemark){
		ServerOrder so = new ServerOrder();
		so.setId(orderIdCreater(user.getWorkId(), room.getName(), clockCategory.getId()));
		so.setUser(user);  //初始化员工
		so.setRoom(room); //初始化房间
		so.setClockCategory(clockCategory); //初始化钟点类型
		OrderStatus os = orderStatusServiceImpl.findById(OrderStatusDAO.WAITING_RECEIVE);
		so.setOrderStatus(os); //初始化订单状态
		so.setInitTime(new Date());
		so.setOrderRemark(orderRemark);
		return so;
	}
	
	/**
	 * 自动创建订单
	 * @param roomId
	 * @return
	 */
	public ServerOrder createOrder(int roomId, String orderRemark){
		
		ServerOrder so = null;
		User u = workRankManage.nextOne();
		
		if(u != null){ 
			//判断是否有空闲员工，如果有那么执行下面语句
			Room r = roomServiceImpl.findById(roomId);
			ClockCategory cc = clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK);
			
			return createNormalOrder(u, r, cc,orderRemark);
		}else{ //所有员工都没有空
//			Room r = roomServiceImpl.findById(roomId);
//			ClockCategory cc = clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK);
			
		}
		
		return so;
	}

}
