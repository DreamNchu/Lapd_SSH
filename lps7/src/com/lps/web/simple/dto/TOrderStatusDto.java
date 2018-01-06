package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.OrderStatus;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TOrderStatusDto extends ArrayList<OrderStatusDto> implements TableInitDto<OrderStatus>{

	private static final long serialVersionUID = 6746457713473621005L;

	public static final String name = "orderStatuses";

	@Override
	public  void init(List<OrderStatus> lists) {
		// TODO Auto-generated method stub
		for (Entity entity : lists) {
			OrderStatusDto dto = new OrderStatusDto();
			dto.init((OrderStatus)entity);
			add(dto);
		}
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
