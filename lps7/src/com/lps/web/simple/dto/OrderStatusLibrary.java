package com.lps.web.simple.dto;

import com.lps.model.OrderStatus;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface OrderStatusLibrary extends BasicRequestDto<OrderStatus>, BasicResponseDto<OrderStatus>{
	
	public String orderStatusId = "orderStatusId";
	
	public String orderStatusName = "orderStatusName";

}
