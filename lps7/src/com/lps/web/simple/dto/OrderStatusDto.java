package com.lps.web.simple.dto;

import com.lps.model.OrderStatus;
import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.BasicInitDto;

public class OrderStatusDto extends BasicRespondMsgDto implements OrderStatusLibrary{
	
	@Override
	public  OrderStatusDto init(OrderStatus obj) {
		if (obj == null) {
			return this;
		}
		OrderStatus os = (OrderStatus)obj;
		map.put(statusId ,os.getId());
		map.put(statusName , os.getOrderstatus());
		
		return  this;
	}
	
	
	
}
