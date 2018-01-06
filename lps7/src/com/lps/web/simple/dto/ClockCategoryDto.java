package com.lps.web.simple.dto;

import com.lps.model.ClockCategory;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class ClockCategoryDto extends BasicRespondMsgDto implements  ClockCategoryLibrary{
	
	@Override
	public ClockCategoryDto init(ClockCategory obj) {
		
		if (obj == null){
			return this;
		}
		ClockCategory cc = (ClockCategory)obj;
		map.put(clockCategoryId , cc.getId());
		map.put(clockCategoryName , cc.getClockCategory());
		return this;
	}
	
}

