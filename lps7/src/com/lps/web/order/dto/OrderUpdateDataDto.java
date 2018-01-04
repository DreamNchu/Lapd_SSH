package com.lps.web.order.dto;

public class OrderUpdateDataDto {
	
	
	private String orderId;
	
	private int roomId;
	
	private int statusId;
	
	private int stuffId;
	
	private int clockCategoryId;

	private int payPathId;

	private Float pay;
	
	private Float realPay;
	
	private String orderRemark;
	
	
	
	public int getClockCategoryId() {
		return clockCategoryId;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public Float getPay() {
		return pay;
	}

	public int getPayPathId() {
		return payPathId;
	}

	public Float getRealPay() {
		return realPay;
	}

	public int getRoomId() {
		return roomId;
	}

	public int getStatusId() {
		return statusId;
	}

	public int getStuffId() {
		return stuffId;
	}

	public void setClockCategoryId(int clockCategoryId) {
		this.clockCategoryId = clockCategoryId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public void setPay(Float pay) {
		this.pay = pay;
	}

	public void setPayPathId(int payId) {
		this.payPathId = payId;
	}

	public void setRealPay(Float realPay) {
		this.realPay = realPay;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}
	
}