package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.joda.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.ServerOrder;
import com.lps.service.impl.ServerOrderServiceImpl;
import com.lps.util.PagePropertyNotInitException;

public class ServerOrderServiceTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static ServerOrderServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("serverOrderServiceImpl", ServerOrderServiceImpl.class);
	}



	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetServerOrderDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		ServerOrder so = new ServerOrder();
		so.setId("000000000000001");
		
		assertEquals(true, as.isExists(so));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIdString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPayPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPledge() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByClockCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindTodayOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderByDate() {
		
//		assertEquals(0, as.findOrderByDate(new DateTime().toDate()).size());
		assertEquals(15, as.findOrderByDate(new LocalDate(2017,11,26).toDate()).size());
		
	}

	@Test
	public void testFindOrderByDateLimit() {
//		fail("Not yet implemented");
//		assertEquals(15, as.findOrderByDateLimit(new LocalDate(2017,11,26).toDate(),new LocalDate(2017,11,27).toDate()).size());
		assertEquals(15, as.findOrderByDateLimit(new LocalDate(2017,11,26).toDate(),new LocalDate(2017,11,26).toDate()).size());
//		assertEquals(0, as.findOrderByDateLimit(new LocalDate(2017,10,26).toDate(),new LocalDate(2017,11,25).toDate()).size());
	}

	@Test
	public void testFindAllOrderLessThanPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderLessThanPriceDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderMoreThanPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderMoreThanPriceDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPage() throws PagePropertyNotInitException {
		assertEquals(15, as.findByPage(1).getAllCount());
	}

}
