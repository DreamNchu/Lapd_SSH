package com.lps.action.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.action.admin.access.AdminStatusAction;
import com.lps.web.dto.LogInDto;

public class AdminLogInActionTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static AdminStatusAction as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("adminLogInAction", AdminStatusAction.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void testExecute() throws Exception {
		
//		as.setAdminLogInDto(new LogInDto("admin", "admin"));
		
//		assertEquals("success", as.execute());
		
	}

}
