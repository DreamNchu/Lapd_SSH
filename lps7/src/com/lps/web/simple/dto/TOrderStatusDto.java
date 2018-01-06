package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.OrderStatus;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TOrderStatusDto extends ArrayList<OrderStatusDto> implements TableInitDto{

	private static final long serialVersionUID = 6746457713473621005L;


	@Override
	public <T extends Entity> void init(List<T> lists) {
		// TODO Auto-generated method stub
		for (Entity entity : lists) {
			OrderStatusDto dto = new OrderStatusDto();
			dto.init((OrderStatus)entity);
			add(dto);
		}
	}
	
}
