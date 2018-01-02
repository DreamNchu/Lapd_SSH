package com.lps.service.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.impl.ServerItemDAOImpl;
import com.lps.model.ServerItem;
import com.lps.service.impl.ServerItemServiceImpl;

public class RoomCategoryServiceTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static ServerItemServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("roomCategoryServiceImpl", ServerItemServiceImpl.class);
	}



	@Test
	public void testDelete() {
		ServerItem rc = as.findById(1);
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
		assertEquals(as.findByProperty(ServerItemDAOImpl.SERVER_ITEM, "洗脚").size(), 1);
		
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
		ServerItem rc = new ServerItem("洗脚");
		as.save(rc);
	}

	@Test
	public void testSetRoomCategoryDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		ServerItem rc = new ServerItem();
		rc.setId(1);
		as.isExists(rc);
	}

	@Test
	public void testFindByPage() {
		fail("Not yet implemented");
	}

/*	@Test
	public void testUpdate() {
		ServerItem rc = as.findById(1);
		rc.setRoomCategory("足浴");
		as.update(rc);
//		rc.setId(id);
	}
*/
}
