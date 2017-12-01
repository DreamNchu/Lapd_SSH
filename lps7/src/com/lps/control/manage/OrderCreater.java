package com.lps.control.manage;

import org.joda.time.DateTime;

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

public class OrderCreater {

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

	public String orderIdCreater(int wordId, String roomName1, int clockCategoryId) {
		String userWorkId = format(wordId, userWorkIdLength);
		String roomName = format(roomName1, roomNameLength);
		DateTime dateTime = new DateTime();
		String date = dateTime.toString("yyyyMMddHHmmss");
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
	public ServerOrder createOrder(int stuffId, int roomId, int clockCategory) {
		ServerOrder so = new ServerOrder();
		User u = userServiceImpl.findById(stuffId);
		Room r = roomServiceImpl.findById(roomId);
		ClockCategory cc = clockCategoryServiceImpl.findById(clockCategory);
		OrderStatus os = orderStatusServiceImpl.findById(OrderStatusDAO.WAITING_RECEIVE);
		
		so.setId(orderIdCreater(u.getWorkId(), r.getName(), clockCategory));
		so.setUser(u);  //初始化员工
		so.setRoom(r); //初始化房间
		so.setClockCategory(cc); //初始化钟点类型
		so.setOrderStatus(os); //初始化订单状态
		
		return so;
	}
	
	/**
	 * 自动创建订单
	 * @param roomId
	 * @return
	 */
	public ServerOrder createOrder(int roomId){
		
		ServerOrder so = null;
		User u = workRankManage.nextOne();
		
		if(u != null){ 
			//判断是否有空闲员工，如果有那么执行下面语句
			Room r = roomServiceImpl.findById(roomId);
			ClockCategory cc = clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK);
			OrderStatus os = orderStatusServiceImpl.findById(OrderStatusDAO.WAITING_RECEIVE);
			so = new ServerOrder();
			so.setId(orderIdCreater(u.getWorkId(), r.getName(), cc.getId()));
			so.setUser(u);  //初始化员工
			so.setRoom(r); //初始化房间
			so.setClockCategory(cc); //初始化钟点类型
			so.setOrderStatus(os); //初始化订单状态
			
		}
		
		return so;
	}

	/*public static void main(String[] args) {
		OrderCreater oc = new OrderCreater();
		System.out.println(oc.orderIdCreater(1, "1", 1));
//		System.out.println(oc.format(99, 4));
		
		DateTime dateTime = new DateTime();
		String date = dateTime.toString("yyyyMMddHHmmss");
		System.out.println(date);
	}*/

}
