package com.lps.web.order.dto;

import com.lps.model.ServerOrder;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;

public class OrderIdDto extends BasicRequestMsgDto<ServerOrder>{

	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
