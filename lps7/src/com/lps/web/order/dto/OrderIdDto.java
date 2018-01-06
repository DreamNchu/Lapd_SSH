package com.lps.web.order.dto;

import com.lps.web.basicmsg.dto.BasicRequestMsgDto;

public class OrderIdDto extends BasicRequestMsgDto{

	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
