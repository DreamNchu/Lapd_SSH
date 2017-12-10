package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;

public class InitBasicUpdateDataDto{
	
	private List<UserOrderDto> user;
	
	private List<RoomOrderDto> room;
	
	private List<StatusOrderDto> status;
	
	private List<ClockCategoryOrderDto> clockCategory;
	
	private List<PayPathOrderDto> payType;
	
	private Integer pay;
	
	private Integer realPay;
	
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
			user.add(new UserOrderDto().init(u));
		}
		for (Room r : rooms) {
			room.add(new RoomOrderDto().init(r));
		}
		for (OrderStatus os : orderStatuses) {
			status.add(new StatusOrderDto().init(os));
		}
		for (ClockCategory cc : clockCategorys) {
			clockCategory.add(new ClockCategoryOrderDto().init(cc));
		}
		for (PayPath pp : payPaths) {
			payType.add(new PayPathOrderDto().init(pp));
		}
		return this;
	}
	
	
	public List<UserOrderDto> getUser() {
		return user;
	}

	public void setUser(List<UserOrderDto> user) {
		this.user = user;
	}

	public List<RoomOrderDto> getRoom() {
		return room;
	}

	public void setRoom(List<RoomOrderDto> room) {
		this.room = room;
	}

	public List<StatusOrderDto> getStatus() {
		return status;
	}

	public void setStatus(List<StatusOrderDto> status) {
		this.status = status;
	}

	public List<ClockCategoryOrderDto> getClockCategory() {
		return clockCategory;
	}

	public void setClockCategory(List<ClockCategoryOrderDto> clockCategory) {
		this.clockCategory = clockCategory;
	}

	public List<PayPathOrderDto> getPayType() {
		return payType;
	}

	public void setPayType(List<PayPathOrderDto> payType) {
		this.payType = payType;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getRealPay() {
		return realPay;
	}

	public void setRealPay(int realPay) {
		this.realPay = realPay;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}
