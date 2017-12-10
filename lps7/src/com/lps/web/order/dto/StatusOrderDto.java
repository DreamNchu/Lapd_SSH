package com.lps.web.order.dto;

import javax.validation.constraIntegers.NotNull;

import com.lps.model.OrderStatus;

public class StatusOrderDto implements DtoBasicInit<StatusOrderDto>{
	
	public Integer statusId;
	
	public String statusName;
	
	public StatusOrderDto() {

	}
	
	

	public StatusOrderDto(Integer statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}



	@Override
	public  StatusOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		OrderStatus os = (OrderStatus)obj;
		statusId = os.getId();
		statusName = os.getOrderstatus();
		
		return  this;
	}
	
	
	
}
