package com.lps.control.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;
import com.lps.web.order.dto.constant.TimeType;

public class TimeTypeResolve implements TimeType{
	
	/**
	 * 根据时间来分析时间间隔
	 * 默认分法
	 * @param propertyName
	 * @param timeType
	 * @return
	 */
	public static List<PropertyRange> resolveTimeToProRange(String propertyName,  int timeType){
		List<Date> date2s = resolveTimeType(timeType);
		
		List<PropertyRange> list = new ArrayList<>();
		
		DateTime ld = new DateTime(date2s.get(0));
		
		DateTime ld2 = new DateTime(date2s.get(1));
		
		DateTime dt = ld;
		DateTime dt2 = null;
		
		int splitUnit = 0;
		
		switch(timeType){
		case DAY:
			splitUnit = SPLIT_BY_HOUR;
			break;
		case BEFORE7DAYS:
			splitUnit = SPLIT_BY_DAY;
			break;
		case THIS_MONTH:
			splitUnit = SPLIT_BY_DAY;
			break;
		case THIS_YEAR:
			splitUnit = SPLIT_BY_MONTH;
			break;
		}
		
		switch(splitUnit){
		case SPLIT_BY_HOUR:
			ld = ld.plusHours(12);
			do {
				dt = ld;
				dt2 = dt.plusHours(1);
				ld = dt2;
				PropertyRange pr = 
						new PropertyRange(propertyName,dt.toDate(),dt2.toDate());
				list.add(pr);
				
			} while (dt2.isBefore(ld2));
			break;
		case SPLIT_BY_DAY:
			do {
				dt = ld;
				dt2 = dt.plusDays(1);
				ld = dt2;
				PropertyRange pr = 
						new PropertyRange(propertyName,dt.toDate(),dt2.toDate());
				list.add(pr);
				
			} while (dt2.isBefore(ld2));
			break;
		case SPLIT_BY_MONTH:
			do {
				dt = ld;
				dt2 = dt.plusMonths(1);
				ld = dt2;
				PropertyRange pr = 
						new PropertyRange(propertyName,dt.toDate(),dt2.toDate());
				list.add(pr);
			} while (dt2.isBefore(ld2));
			break;
		case SPLIT_BY_YEAR:
			do {
				dt = ld;
				dt2 = dt.plusYears(1);
				ld = dt2;
				PropertyRange pr = 
						new PropertyRange(propertyName,dt.toDate(),dt2.toDate());
				list.add(pr);
			} while (dt2.isBefore(ld2));
			break;
		}
		
		return list;
	}
	
	public static List<Date> resolveTimeType(int timeType){
		List<Date> list = new ArrayList<>(2);
		switch(timeType){
		case DAY:
			list.add(0,WorkDate.getTodayDate());
			list.add(1,WorkDate.getTomorrowDate());
			break;
		case BEFORE7DAYS:
			list.add(0,WorkDate.getBefore7DayDate());
			list.add(1,WorkDate.getTomorrowDate());
			break;
		case THIS_MONTH:
			list.add(0,WorkDate.getBeginOfThisMonthDate());
			list.add(1,WorkDate.getTomorrowDate());
			break;
		case THIS_YEAR:
			list.add(0,WorkDate.getBeginOfThisYearDate());
			list.add(1,WorkDate.getTomorrowDate());
			break;
		}
		
		return list;
	}

}
