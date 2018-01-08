package com.lps.web.simple.dto;

import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface PayPathLibrary extends BasicRequestDto<PayPath> , BasicResponseDto<PayPath>{
	
	public String payPathId = "payPathId";

	public String payPathName = "payPathName";

}
