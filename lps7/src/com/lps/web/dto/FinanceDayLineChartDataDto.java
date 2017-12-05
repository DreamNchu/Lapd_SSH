package com.lps.web.dto;

import java.util.Date;

import com.lps.util.WorkDate;

/**
 * 日工作报表折线图分析
 * @author 0001
 *
 */
public class FinanceDayLineChartDataDto extends FinanceLineChartDataBasicDto {
	
	@Override
	public void init() {
		
	}
	

	@Override
	public String refrences(Date date) {
		return WorkDate.getCeilHourTime(date);
	}
	

}
