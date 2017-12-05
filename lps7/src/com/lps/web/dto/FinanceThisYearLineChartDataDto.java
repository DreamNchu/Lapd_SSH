package com.lps.web.dto;

import java.util.Date;

import org.joda.time.LocalDate;

/**
 * 日工作报表折线图分析
 * @author 0001
 *
 */
public class FinanceThisYearLineChartDataDto extends FinanceLineChartDataBasicDto {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String refrences(Date date) {
		LocalDate ld = new LocalDate(date);
		
		return ld.getMonthOfYear() + "";
	}
	
	

}
