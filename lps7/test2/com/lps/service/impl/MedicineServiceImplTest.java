package com.lps.service.impl;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.Medicine;

public class MedicineServiceImplTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static MedicineServiceImpl as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("medicineServiceImpl", MedicineServiceImpl.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}

	@Test
	public void testFindAllOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllOrdersByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOrdersCountByThisType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindTodayOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindBefore7DayOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindThisMonthOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindThisYearOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateProRangeForOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Medicine m = new Medicine();
		m.setMedicineId("sdfsdf");
		m.setPrice(12);
		m.setInventory(1);
		m.setName("ddd");
		m.setShelfLife(new Date());
		m.setVender("sdsdffdssdffsdf");
		m.setSales(12);
		as.save(m);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPropertyStringObject() {
		fail("Not yet implemented");
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
	public void testFindByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFieldsByModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPropertyMapOfStringObject() {
		fail("Not yet implemented");
	}

}
