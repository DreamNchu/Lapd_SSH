package com.lps.control.manage;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.lps.web.dto.FinanceLineChartDataBasicDto;

public class FinanceManageTest {
	

	static ClassPathXmlApplicationContext ctx ;
	static FinanceManage as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("financeManage", FinanceManage.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void testGetDayLineChartDataAnalizy() {
		
		FinanceLineChartDataBasicDto fl = as.getDayLineChartDataAnalizy();
		Gson g = new Gson();
		String str = g.toJson(fl);
		System.out.println(str);
	}

	@Test
	public void testGetBefore7DaysLineChartDataAnalizy() {
		FinanceLineChartDataBasicDto fl = as.getBefore7DaysLineChartDataAnalizy();
		Gson g = new Gson();
		String str = g.toJson(fl);
		System.out.println(str);
	}

}
