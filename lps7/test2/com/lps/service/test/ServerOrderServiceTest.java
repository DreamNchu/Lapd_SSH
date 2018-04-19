/*package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.OrderStatusService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.service.impl.OrderStatusServiceImpl;
import com.lps.service.impl.ServerOrderServiceImpl;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public class ServerOrderServiceTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static ServerOrderServiceImpl as ;
	static OrderStatusService os;
	
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
		os = ctx.getBean("orderStatusServiceImpl", OrderStatusServiceImpl.class);
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
		Random ra = new Random();
		
		for(int i = 0; i < 5000; i ++) {
			PayPath payPath = new PayPath(); payPath.setId(i % 4 + 1);
			Room room = new Room(); room.setId(i % 4 + 1);
			User user = new User(); user.setId( ra.nextInt(5) + 1);
			Pledge pledge = new Pledge(); pledge.setId(i % 3 + 1);
			ClockCategory clockCategory = new ClockCategory(); 
			clockCategory.setId(i % 2 + 1);
			OrderStatus orderStatus = new OrderStatus(); orderStatus.setId(i % 6 + 1);
			DateTime dt = new DateTime(2017, ra.nextInt(12) + 1, ra.nextInt(27) + 1, ra.nextInt(12), 0);
			ServerOrder so = new ServerOrder("11000000000" + i ,payPath , room, user, pledge, clockCategory,
					orderStatus, dt.toDate(), dt.plusMinutes(5).toDate(),dt.plusHours(1).toDate() , 100, 100, new Date(), "001");
			if(i % 100 == 0)
				System.out.println("i = " + i);
			as.save(so);
		}
		
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
	
	@Test
	public void testFindOrdersByProperyLimit() throws PagePropertyNotInitException{
		List<PropertyRange> listPro = new ArrayList<>();
		PropertyRange pro = new PropertyRange();
		pro.setName(ServerOrderDAOImpl.ORDER_STATUS);
		pro.setMinValue(os.findById(1));
		pro.setMaxValue(os.findById(1));
		listPro.add(pro);
	}
	
	@Test 
	public void testFindFieldsByModel(){
		ServerOrder so = new ServerOrder();
		User u = new User();
		u.setId(1);
		so.setUser(u);
		so.setId("0009010112018441022056370002");
		Map<String, Class<?>> map = new HashMap<>();
		map.put(ServerOrderDAOImpl.USER, User.class);
		map.put(ServerOrderDAOImpl.CLOCK_CATEGORY, ClockCategory.class);
		ServerOrder soo = as.findFieldsByModel(so, map);
		System.out.println(soo.getUser().getRealName());
	}
	
	@Test
	public void testDelete() throws FindByIdGetNullException{
		ServerOrder so = as.findById("000901011201801102023330001");
		System.out.println("so.getRoom().getId() = {" + so.getRoom().getId());
		as.delete(so);
	}

}
*/