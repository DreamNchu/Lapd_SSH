package com.lps.web.order.dto;

import com.lps.model.ClockCategory;

public class ClockCategoryOrderDto implements DtoBasicInit<ClockCategoryOrderDto>{
	
	public Integer clockCategoryId;
	
	public String clockCategoryName;

	public ClockCategoryOrderDto(Integer clockCategoryId, String clockCategoryName) {
		super();
		this.clockCategoryId = clockCategoryId;
		this.clockCategoryName = clockCategoryName;
	}
	
	public ClockCategoryOrderDto() {
		
	}

	@Override
	public ClockCategoryOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		ClockCategory cc = (ClockCategory)obj;
		clockCategoryId = cc.getId();
		clockCategoryName = cc.getClockCategory();
		return this;
	}
	
}

