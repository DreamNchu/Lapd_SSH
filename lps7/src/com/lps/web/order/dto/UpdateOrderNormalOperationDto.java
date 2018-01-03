package com.lps.web.order.dto;

import com.lps.permission.Permission;

/**
 * 正常状态下订单的更新
 * @author 0001
 *
 */
public class UpdateOrderNormalOperationDto {
	
	private String orderId;
	
	private Permission permission;
	
	private int pay;
	
	private int realPay;
	
	private int payPath;
	
	private int orderStatusId;
	
	private int stuffId;
	
	public UpdateOrderNormalOperationDto() {
	}
	
	public int getStuffId() {
		return stuffId;
	}

	public int getPayPath() {
		return payPath;
	}

	public void setPayPath(int payPath) {
		this.payPath = payPath;
	}


	public void setStuffId(int userId) {
		this.stuffId = userId;
	}


	public UpdateOrderNormalOperationDto(String orderId, Permission permission, int pay, int realPay, int orderStatusId,
			int stuffId) {
		super();
		this.orderId = orderId;
		this.permission = permission;
		this.pay = pay;
		this.realPay = realPay;
		this.orderStatusId = orderStatusId;
		this.stuffId = stuffId;
	}



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
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

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	
	

}
