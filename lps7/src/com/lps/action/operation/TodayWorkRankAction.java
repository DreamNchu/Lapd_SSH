package com.lps.action.operation;

import com.lps.web.dto.WorkRankDto;
import com.opensymphony.xwork2.ActionSupport;

public class TodayWorkRankAction extends ActionSupport{

	private static final long serialVersionUID = -3778277782097803955L;
	
	private WorkRankDto workRankDto;

	public WorkRankDto getWorkRankDto() {
		return workRankDto;
	}

	public void setWorkRankDto(WorkRankDto workRankDto) {
		this.workRankDto = workRankDto;
	}
	
	

}
