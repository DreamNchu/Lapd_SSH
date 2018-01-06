package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TClockCategoryDto extends ArrayList<ClockCategoryDto> implements TableInitDto<ClockCategory>{

	private static final long serialVersionUID = 6746457713473621005L;

	public static final String name = "clockCategorys";

	@Override
	public void init(List<ClockCategory> lists) {
		for (ClockCategory entity : lists) {
			ClockCategoryDto ccd = new ClockCategoryDto();
			ccd.init((ClockCategory)entity);
			add(ccd);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
