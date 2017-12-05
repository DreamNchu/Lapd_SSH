package com.lps.cotrol.manage.test;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.control.manage.OrderManage;

public class OrderCreaterTest {
	
	
	static ClassPathXmlApplicationContext ctx ;
	static OrderManage as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("orderCreater", OrderManage.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void testCreateOrderIntIntInt() {
		System.out.println(as.getWorkRankManage());
		System.out.println(as.getOrderStatusServiceImpl());
		
	}

	@Test
	public void testCreateOrderInt() {
		fail("Not yet implemented");
	}

}
