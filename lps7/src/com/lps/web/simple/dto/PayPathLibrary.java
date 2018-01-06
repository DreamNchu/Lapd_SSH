package com.lps.web.simple.dto;

import com.lps.model.PayPath;
import com.lps.web.dto.BasicInitDto;

public interface PayPathLibrary extends BasicInitDto<PayPathDto,PayPath> {
	
	public String payId = "payId";

	public String payPath = "payPath";

}
