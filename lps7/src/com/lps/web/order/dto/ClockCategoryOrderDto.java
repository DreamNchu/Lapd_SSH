package com.lps.web.order.dto;

import com.lps.model.ClockCategory;

public class ClockCategoryOrderDto implements DtoBasicInit<ClockCategoryOrderDto>{
	
	public Integer clockId;
	
	public String clockName;

	public ClockCategoryOrderDto(Integer clockId, String clockName) {
		super();
		this.clockId = clockId;
		this.clockName = clockName;
	}
	
	public ClockCategoryOrderDto() {
		
	}

	@Override
	public ClockCategoryOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		ClockCategory cc = (ClockCategory)obj;
		clockId = cc.getId();
		clockName = cc.getClockCategory();
		return this;
	}
	
}

