package com.lps.web.simple.dto;

import com.lps.model.ClockCategory;
import com.lps.web.dto.BasicInitDto;

public interface ClockCategoryLibrary extends BasicInitDto<ClockCategoryDto, ClockCategory>{

	public String clockCategoryId = "clockCategoryId";
	
	public String clockCategoryName = "clockCategoryName";
	
}
