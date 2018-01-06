package com.lps.web.simple.dto;

import com.lps.model.OrderStatus;
import com.lps.web.dto.BasicInitDto;

public interface OrderStatusLibrary extends BasicInitDto<OrderStatusDto,OrderStatus>{
	
	public String statusId = "statusId";
	
	public String statusName = "statusName";

}
