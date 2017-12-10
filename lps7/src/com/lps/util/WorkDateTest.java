package com.lps.util;

import org.joda.time.LocalDate;
import org.junit.Test;

public class WorkDateTest {

	@Test
	public void test() {
//		System.out.println(WorkDate.getTodayDate());
//		System.out.println(WorkDate.getBefore7DayDate());
//		System.out.println(WorkDate.getCeilHourTime(new Date()));
//		System.out.println(WorkDate.getDayOfMonth(new Date()));
		System.out.println(WorkDate.getTime(null));
		LocalDate ld = new LocalDate(2017, 1, 1);
		LocalDate ld3 = ld.plusDays(1);
		LocalDate ld2 = new LocalDate(2017, 1, 1);
		System.out.println(ld.equals(ld2));
//		System.out.println(ld == ld3);
//		System.out.println(WorkDate.addTime(new Date(), 1,2,2));
	}

}
