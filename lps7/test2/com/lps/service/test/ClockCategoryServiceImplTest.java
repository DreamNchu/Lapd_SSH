package com.lps.service.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.ClockCategory;
import com.lps.service.impl.ClockCategoryServiceImpl;

public class ClockCategoryServiceImplTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static ClockCategoryServiceImpl as ;
	
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("clockCategoryServiceImpl", ClockCategoryServiceImpl.class);
	}

	@Test
	public void testDelete() {
		ClockCategory cc = new ClockCategory("休息");
		cc.setId(1);
		as.delete(cc);
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllCount() {
		fail("Not yet implemented");
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
	public void testFindByClockCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClockCategoryDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
//		ClockCategory cc = new ClockCategory("休息");
//		ClockCategory cc = new ClockCategory("点钟");
		ClockCategory cc = new ClockCategory("排钟2");
		as.save(cc);
		as.delete(cc);
	}

	@Test
	public void testIsExists() {
		ClockCategory cc = new ClockCategory("排钟2");
		assertEquals(false, as.isExists(cc));
	}

	@Test
	public void testFindByPage() {
		assertEquals(2, as.findByPage(1).getList().size());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllOrderByClockCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrderByClockCategory() {
		ClockCategory cc = as.findById(1);
		assertEquals(7, as.findOrderByClockCategory(cc, 1).getList().size());
	}

}
