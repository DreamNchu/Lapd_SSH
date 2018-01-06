package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.web.room.dto.RoomOrderDto;
import com.lps.web.simple.dto.ClockCategoryDto;
import com.lps.web.simple.dto.PayPathDto;
import com.lps.web.simple.dto.OrderStatusDto;
import com.lps.web.user.dto.UserOrderDto;

public class InitBasicUpdateDataDto{
	
	/**
	 * 所有用户基本信息
	 */
	private List<UserOrderDto> users;
	/**
	 * 所有房间基本信息
	 */
	private List<RoomOrderDto> rooms;
	/**
	 * 所有订单状态基本信息
	 */
	private List<OrderStatusDto> statuses;
	
	/**
	 * 所有钟点类型基本信息
	 */
	private List<ClockCategoryDto> clockCategorys;
	
	/**
	 * 所有支付方式基本信息
	 */
	private List<PayPathDto> payPaths;
	
	private Float pay;
	
	private Float realPay;
	
	private String orderRemark;
	
	private String orderId;
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private void initSurplus(ServerOrder so){
		pay = so.getPay();
		realPay = so.getRealPay();
		orderRemark = so.getOrderRemark();
		orderId = so.getId();
	}
	
	
	public InitBasicUpdateDataDto init(List<User> users, List<Room> rooms, List<OrderStatus> orderStatuses
			,List<ClockCategory> clockCategorys, List<PayPath> payPaths, ServerOrder so){
		initSurplus(so);
		for (User u : users) {
			this.users.add(new UserOrderDto().init(u));
		}
		for (Room r : rooms) {
			this.rooms.add(new RoomOrderDto().init(r));
		}
		for (OrderStatus os : orderStatuses) {
			this.statuses.add(new OrderStatusDto().init(os));
		}
		for (ClockCategory cc : clockCategorys) {
			this.clockCategorys.add(new ClockCategoryDto().init(cc));
		}
		for (PayPath pp : payPaths) {
			this.payPaths.add(new PayPathDto().init(pp));
		}
		return this;
	}
	
	
	public List<UserOrderDto> getUser() {
		return users;
	}

	public void setUser(List<UserOrderDto> user) {
		this.users = user;
	}

	public List<RoomOrderDto> getRoom() {
		return rooms;
	}

	public void setRoom(List<RoomOrderDto> room) {
		this.rooms = room;
	}

	public List<OrderStatusDto> getStatus() {
		return statuses;
	}

	public void setStatus(List<OrderStatusDto> status) {
		this.statuses = status;
	}

	public List<ClockCategoryDto> getClockCategory() {
		return clockCategorys;
	}

	public void setClockCategory(List<ClockCategoryDto> clockCategory) {
		this.clockCategorys = clockCategory;
	}

	public List<PayPathDto> getPayType() {
		return payPaths;
	}

	public void setPayType(List<PayPathDto> payType) {
		this.payPaths = payType;
	}

	public Float getPay() {
		return pay;
	}

	public void setPay(Float pay) {
		this.pay = pay;
	}

	public Float getRealPay() {
		return realPay;
	}

	public void setRealPay(Float realPay) {
		this.realPay = realPay;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}
