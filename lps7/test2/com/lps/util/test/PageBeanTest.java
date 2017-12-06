package com.lps.util.test;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class PageBeanTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static PageBean<Integer> as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("pageBean", PageBean.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}

	@Test
	public void test() throws PagePropertyNotInitException {
		as.init(100, 5);
		for(int i = 0; i < as.getViewPageNum().size(); i ++){
			System.out.println(as.getViewPageNum());
		}
	}

}
