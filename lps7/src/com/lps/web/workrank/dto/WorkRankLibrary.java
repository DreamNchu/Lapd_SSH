package com.lps.web.workrank.dto;

import com.lps.model.WorkRank;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface WorkRankLibrary extends BasicRequestDto<WorkRank> , BasicResponseDto<WorkRank>{
	
	String index = "index";
	
	String workRankId  = "workRankId";
	
	String stuffId = "stuffId";
	
	String workId = "workId";

	String realName = "realName";

	String rankNum = "rankNum";
	
	String spotNum = "spotNum";

}
