package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.OrderStatus;
import com.lps.service.impl.OrderStatusServiceImpl;
import com.lps.util.PagePropertyNotInitException;

public class OrderStatusServiceImplTest {
	
	
	static ClassPathXmlApplicationContext ctx ;
	static OrderStatusServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("orderStatusServiceImpl", OrderStatusServiceImpl.class);
	}

	

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllCount() {
		assertEquals(4, as.findAllCount());
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByOrderStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllOrders() {
		
	}

	@Test
	public void testFindOrdersByPage() throws PagePropertyNotInitException {
		OrderStatus os = new OrderStatus();
		os.setId(1);
		assertEquals(7, as.findAllOrdersByPage(os, 1).getList().size());
		assertEquals(null, as.findAllOrdersByPage(os, 2));
	}

	@Test
	public void testFindOrdersCountByThisType() {
		OrderStatus os = new OrderStatus();
		os.setId(1);
		assertEquals(7, as.findOrdersCountByThisType(os));
	}

}
