package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.Room;
import com.lps.model.RoomCategory;
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
		RoomCategory rc = new RoomCategory("按摩");
		rc.setId(2);
		Room r = new Room("206",2,4,new Date(), rc);
		as.save(r);
		assertEquals(1, as.findByName("205").size());
		assertEquals("205", as.findByName("205").get(0).getName());
		assertEquals(1, as.findByPage(1).getList().size());
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
		assertEquals(4, as.findAll().size());
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

}
