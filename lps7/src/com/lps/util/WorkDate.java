package com.lps.util;

import java.util.Date;

import org.joda.time.LocalDate;


public class WorkDate {
	
	public static final int TODAY_OFF_SET = 0;
	public static final int TOMORROW_OFF_SET = 1;
	public static final int BEFORE_7_DAYS__OFF_SET = -7;
	
	public static Date getTodayDate(){
		return getDateFlexible(TODAY_OFF_SET);
	}
	
	public static Date getTomorrowDate(){
		return getDateFlexible(TOMORROW_OFF_SET);
	}
	
	public static Date getBefore7DayDate(){
		return getDateFlexible(BEFORE_7_DAYS__OFF_SET);
	}

	/**
	 * 以现在时间为基础，返回以后的日期或者以前的日期，以后的offSet为正值，以前的为扶植
	 * @param offSet 日期相差天数
	 * @return 返回那天的日期
	 */
	public static Date getDateFlexible(int offSet){
		LocalDate localDate = new LocalDate();
		return localDate.plusDays(offSet).toDate();
	}

	public static Date getNextDate(Date date){
		if(date == null)
			return getTodayDate();
		LocalDate localDate = new LocalDate(date);
		return localDate.plusDays(TOMORROW_OFF_SET).toDate();
	}
	
	/**
	 * 得到该年初的日期
	 * @param date 参考日期
	 * @return 返回该年初的日期
	 */
	public static Date getBeginOfYeatDate(Date date){
		LocalDate localDate = new LocalDate(date);
		int year = localDate.getYear();
		return getBeginOfMonthDate(year, 0);
	}
	
	/**
	 * 返回该月月初的日期
	 * @param date 参考日期
	 * @return 返回该月月初的日期
	 * 
	 */
	public static Date getBeginOfMonthDate(Date date){
		LocalDate localDate = new LocalDate(date);
		int year = localDate.getYear();
		int month = localDate.getMonthOfYear();
		return getBeginOfMonthDate(year, month);
	}
	
	/**
	 * 本月的月初的日期
	 * @return
	 */
	public static Date getBeginOfThisMonthDate(){
		return getBeginOfMonthDate(new Date());
	}
	/**
	 * 本年年初的日期
	 * @return
	 */
	public static Date getBeginOfThisYearDate(){
		return getBeginOfYeatDate(new Date());
	}
	
	/**
	 * 返回该月月初的日期
	 * @param year 年份
	 * @param month 月份
	 * @return 返回该月月初的日期
	 */
	public static Date getBeginOfMonthDate(int year ,int month){
		LocalDate localDate = new LocalDate(year, month, 1);
		return localDate.toDate();
	}

}
