package com.lps.util;

import java.util.Date;

import org.junit.Test;

public class WorkDateTest {

	@Test
	public void test() {
//		System.out.println(WorkDate.getTodayDate());
//		System.out.println(WorkDate.getBefore7DayDate());
		System.out.println(WorkDate.getCeilHourTime(new Date()));
		System.out.println(WorkDate.getDayOfMonth(new Date()));
		System.out.println(WorkDate.getTime(new Date()));
		System.out.println(WorkDate.addTime(new Date(), 1,2,2));
	}

}
