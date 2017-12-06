package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.ClockCategory;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.service.impl.RoomServiceImpl;

public class RoomServiceTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static RoomServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("roomServiceImpl", RoomServiceImpl.class);
	}


	@Test
	public void testSave() {
		ServerItem rc = new ServerItem("按摩");
		rc.setId(2);
		Room r = new Room("206",2,4,new Date(), rc, false);
		as.save(r);
		assertEquals(false, as.findByName("206").get(0).getIsFree());
		as.delete(r);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		//pass
//		assertEquals(4, as.findAll().size());
		System.out.println(as.findAll().get(0));
	}

	@Test
	public void testFindAllCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
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
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByFloor() {
		assertEquals(4, as.findByFloor(2).size());
	}

	@Test
	public void testFindBySize() {
		assertEquals(4, as.findBySize(4).size());
	}
	
	@Test
	public void testFindAllOrders(){
		Room r = new Room();
		r.setId(1);
		;
		assertEquals(7, as.findAllOrders(r).size());
	}
	
	@Test
	public void testFindOrdersCountByThisType(){
		Room cc = as.findById(1);
		assertEquals(7, as.findOrdersCountByThisType(cc));
		
	}

}
