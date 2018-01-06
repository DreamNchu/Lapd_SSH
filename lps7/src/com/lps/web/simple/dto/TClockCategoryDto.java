package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TClockCategoryDto extends ArrayList<ClockCategoryDto> implements TableInitDto{

	private static final long serialVersionUID = 6746457713473621005L;


	@Override
	public <T extends Entity> void init(List<T> lists) {
		for (Entity entity : lists) {
			ClockCategoryDto ccd = new ClockCategoryDto();
			ccd.init((ClockCategory)entity);
			add(ccd);
		}
	}
	
}
