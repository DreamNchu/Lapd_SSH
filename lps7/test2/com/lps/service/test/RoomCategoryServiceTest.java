package com.lps.service.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.impl.RoomCategoryDAOImpl;
import com.lps.model.RoomCategory;
import com.lps.service.impl.RoomCategoryServiceImpl;

public class RoomCategoryServiceTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static RoomCategoryServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("roomCategoryServiceImpl", RoomCategoryServiceImpl.class);
	}



	@Test
	public void testDelete() {
		RoomCategory rc = as.findById(1);
		as.delete(rc);
	}

	@Test
	public void testFindAll() {
		assertEquals(2, as.findAll().size());
	}

	@Test
	public void testFindAllCount() {
		assertEquals(2, as.findAllCount());
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByProperty() {
		assertEquals(as.findByProperty(RoomCategoryDAOImpl.ROOM_CATEGORY, "洗脚").size(), 1);
		
	}

	@Test
	public void testFindByRoomCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRoomCategoryDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		RoomCategory rc = new RoomCategory("洗脚");
		as.save(rc);
	}

	@Test
	public void testSetRoomCategoryDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		RoomCategory rc = new RoomCategory();
		rc.setId(1);
		as.isExists(rc);
	}

	@Test
	public void testFindByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		RoomCategory rc = as.findById(1);
		rc.setRoomCategory("足浴");
		as.update(rc);
//		rc.setId(id);
	}

}
