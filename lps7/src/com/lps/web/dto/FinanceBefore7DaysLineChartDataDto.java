package com.lps.web.dto;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.resource.spi.work.Work;

import org.joda.time.LocalDate;

import com.lps.util.WorkDate;

/**
 * 日工作报表折线图分析
 * @author 0001
 *
 */
public class FinanceBefore7DaysLineChartDataDto extends FinanceLineChartDataBasicDto {

	@Override
	public void init() {
		List<String> list = this.getLabels();
		for(int i= 0; i > - 7; i --){
			list.add(WorkDate.getDayOfMonth(WorkDate.getDateFlexible(i)) + "");
		}
		Collections.reverse(list);
	}

	@Override
	public String refrences(Date date) {
		return WorkDate.getDayOfMonth(date)+"";
	}
	
	

}
