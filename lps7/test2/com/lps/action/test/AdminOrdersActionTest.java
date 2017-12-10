package com.lps.action.test;

import java.util.Iterator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.action.operation.OrdersAction;
import com.lps.control.manage.WorkRankManage;
import com.lps.model.ServerOrder;

public class AdminOrdersActionTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static OrdersAction as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("adminOrdersAction", OrdersAction.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void testUpdateOrder() {
		as.setOrderId("000000000000001");
		
//		fail("Not yet implemented");
	}

	/*@Test
	public void testViewOrder() {
		as.setOrderId("000000000000001");
		as.setOrderDataDto(new OrderUpdateDataDto());
		as.viewOrder();
		assertEquals(new Integer(1), as.getOrderDataDto().getUser().getId());
	}*/
	@Test
	public void testCreateOrder(){
//		stuffId, roomId, clockCategoryId
		as.setStuffId(1);
		as.setRoomId(1);
		as.setClockCategoryId(1);
		WorkRankManage w = (WorkRankManage) ctx.getBean("workRankManage");
		System.out.println(w.getWorkRankServiceImpl());
	}
	
/*	@Test
	public void testCreateOrderAuto(){
		as.setRoomId(1);
		
		assertEquals("success", as.createOrderAuto());
	}*/

	@Test
	public void testViewStatusOrder() {
		as.setOrderStatusId(1);
		as.viewStatusOrder();
		for (Iterator iterator = as.getList().iterator(); iterator.hasNext();) {
			ServerOrder type = (ServerOrder) iterator.next();
			System.out.println(type);
		}
	}
	
	

	@Test
	public void testViewTodayOrders() {
		as.viewTodayOrders();
		for (Iterator iterator = as.getList().iterator(); iterator.hasNext();) {
			ServerOrder type = (ServerOrder) iterator.next();
			System.out.println(type);
		}
	}

}
