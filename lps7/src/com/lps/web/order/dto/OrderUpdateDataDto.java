package com.lps.web.order.dto;

import com.lps.model.ServerOrder;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;
import com.lps.web.dto.BasicUpdateDto;

public class OrderUpdateDataDto extends BasicRequestMsgDto<ServerOrder> implements BasicUpdateDto<ServerOrder>{
	
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

	@Override
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerOrder update(ServerOrder t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}