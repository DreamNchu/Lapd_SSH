package com.lps.action.operation.order;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.lps.dao.OrderStatusDAO;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.order.dto.OrderSingleDataDto;
import com.lps.web.order.dto.PageLinkTransformOrderDto;
import com.lps.web.order.dto.constant.TimeType;

public class ManageOrdersActionTest {
	
	
	static ClassPathXmlApplicationContext ctx ;
	static ManageOrdersAction as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("manageOrdersAction", ManageOrdersAction.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}


	@Test
	public void testQueryBasic() throws PagePropertyNotInitException {
		PageLinkTransformOrderDto pageLinkTransformOrderDto = new PageLinkTransformOrderDto(
				OrderStatusDAO.WAITING_RECEIVE,TimeType.BEFORE7DAYS);
		as.setPageLinkTransformOrderDto(pageLinkTransformOrderDto);
		as.queryBasicOrders();
//		Gson g = new Gson();
//		System.out.println(g.toJson(new OrderSingleDataDto()));
		System.out.println(as.getResult());
	}

}
