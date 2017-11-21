package com.lps.service.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.service.impl.UserServiceImpl;
import com.lps.service.impl.WorkStatusServiceImpl;

public class UserWorkStatusTests {
	
	static ClassPathXmlApplicationContext ctx ;
	static WorkStatusServiceImpl asw ;
	static UserServiceImpl asu ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
		asw = ctx.getBean("workStatusServiceImpl", WorkStatusServiceImpl.class);
		asu = ctx.getBean("userServiceImpl", UserServiceImpl.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}
	
	@Test
	public void testSaveUnion(){
		SessionFactory sf = ctx.getBean("sessionFactory", SessionFactory.class);
		Session session = sf.openSession();
		session.getTransaction().begin();
		
		
//		WorkStatus ws = new WorkStatus("ÐÝÏ¢2");
		WorkStatus ws = asw.findByWorkStatus("ÐÝÏ¢").get(0);
		WorkStatus wsn = (WorkStatus) session.get(WorkStatus.class, ws.getId());
		assertEquals(1, wsn.getUsers().size());
//		WorkStatus ws = (WorkStatus) session.get(WorkStatus.class, 14);
//		System.out.println(ws.getWorkStatus());
//		User u = new User("0004", "0002", "ÄãÊÇË­", "cyl", new Timestamp(System.currentTimeMillis()),ws);
//		ws.getUsers().add(u);
//		session.save(ws);
//		session.save(u);
		session.getTransaction().commit();
		session.close();
		
	}
}
