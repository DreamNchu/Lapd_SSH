package com.lps.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.impl.WorkStatusDAOImpl;
import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.service.impl.WorkStatusServiceImpl;

public class WorkStatusTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static WorkStatusServiceImpl as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		as = ctx.getBean("workStatusServiceImpl", WorkStatusServiceImpl.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}

	@Test
	public void testDelete() {
		WorkStatus ws = as.findById(1);
		as.delete(ws);
	}

	@Test
	public void testFindAll() {
		assertNotEquals(0, as.findAll().size());
	}

	@Test
	public void testFindAllCount() {
		assertEquals(2, as.findAllCount());
	}

	@Test
	public void testFindById() {
		WorkStatus ws = new WorkStatus();
		ws.setId(1);
		as.findById(1);
	}

	@Test
	public void testFindByProperty() {
		assertNotEquals(null, as.findByProperty(WorkStatusDAOImpl.WORK_STATUS, "������"));
	}

	@Test
	public void testFindByWorkStatus() {
		assertNotEquals(null, as.findByWorkStatus("��Ϣ"));
	}

	@Test
	public void testSave() {
		as.save(new WorkStatus("��Ϣ"));
//		as.save(new WorkStatus("������"));
//		as.save(new WorkStatus("������"));
//		as.save(new WorkStatus("����"));
//		WorkStatus ws = as.findById(2);
//		ws.getUsers().add(new User("0003", "0002", "����˭", "cyl", new Timestamp(System.currentTimeMillis()),ws));
//		as.save(new WorkStatus("����"));
//		as.update(ws);
		
	}

}
