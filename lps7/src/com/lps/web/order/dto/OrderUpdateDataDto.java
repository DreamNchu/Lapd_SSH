package com.lps.web.order.dto;

public class OrderUpdateDataDto {
	
	
	private String orderId;
	
	private int roomId;
	
	private int statusId;
	
	private int stuffId;
	
	public int getStuffId() {
		return stuffId;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	private int clockCategoryId;
	
	private int payId;
	
	private Integer pay;
	
	private Integer realPay;
	
	private String orderRemark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getClockCategoryId() {
		return clockCategoryId;
	}

	public void setClockCategoryId(int clockCategoryId) {
		this.clockCategoryId = clockCategoryId;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public Integer getRealPay() {
		return realPay;
	}

	public void setRealPay(Integer realPay) {
		this.realPay = realPay;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
	
	
	
	
}