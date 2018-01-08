package com.lps.web.simple.dto;

import com.lps.model.ClockCategory;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface ClockCategoryLibrary extends BasicRequestDto<ClockCategory>, BasicResponseDto<ClockCategory>{

	public String clockCategoryId = "clockCategoryId";
	
	public String clockCategoryName = "clockCategoryName";
	
}
