package com.lps.web.dto;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

public  class FinanceLineChartDataBasicDtoTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static FinanceLineChartDataBasicDto as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("financeDayLineChartDataDto", FinanceLineChartDataBasicDto.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void test() {
		Gson gson = new Gson();
		as.getDataSet().replace("data", 10.0);
		String str = gson.toJson(as);
		System.out.println(str);
	}
	
	

}
