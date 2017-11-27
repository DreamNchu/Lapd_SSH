package com.lps.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;


public class WorkDate {
	
	public static final int TODAY_OFF_SET = 0;
	public static final int TOMORROW_OFF_SET = 1;
	public static final int BEFORE_7_DAYS__OFF_SET = -7;
	
//	private DateTime todayDate ;
	
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

	public class Lately7Day{
		
		private Date begin;
		
		private Date end;
		
		public void reflush(){
//			WorkDate.this.todayDate = new Date();
		}

		public Date getBegin() {
			return begin;
		}

		public void setBegin(Date begin) {
			this.begin = begin;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}
		
		
	}

}
