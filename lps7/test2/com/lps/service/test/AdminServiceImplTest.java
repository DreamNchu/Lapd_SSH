package com.lps.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.dao.impl.AdminDAOImpl;
import com.lps.model.Admin;
import com.lps.service.impl.AdminServiceImpl;

public class AdminServiceImplTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static AdminServiceImpl as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("adminServiceImpl", AdminServiceImpl.class);
	}
	
	@AfterClass
	public static void after(){
		ctx.destroy();
	}

	public static void main(String[] args) {
		new AdminServiceImplTest().testAdd();
	}
	
	@Test
	public void testAdd() {
		for(int i = 0; i < 23; i ++){
			as.save(new Admin("С��" + i ,"0002", new java.sql.Timestamp(System.currentTimeMillis())));
		}
	}
	
	@Test
	public void testSession(){
		AdminDAOImpl adi = (AdminDAOImpl)as.getAdminDao();
		assertEquals(AdminDAOImpl.class, as.getAdminDao().getClass());
		System.out.println(adi.getHibernateTemplate().getSessionFactory());
		System.out.println(adi.getHibernateTemplate().getSessionFactory().getCurrentSession());
//		Session session = adi.getHibernateTemplate().getSessionFactory().getCurrentSession();
		//System.out.println(session);
		//System.out.println(session.createQuery("from Admin").list().size());	
//		as.save(new Admin("С��","0002", new java.sql.Timestamp(System.currentTimeMillis())));
	}
	
/*	@Test
	public void testFindPageByLimit() {
		assertEquals(24, as.findByPage(1).getAllCount());
		assertEquals(10, as.findByPage(1).getList().size());
		assertEquals("С��2", as.findByPage(1).getList().get(0).getUserName());
	}*/
	
	@Test
	public void testGetById(){
		Admin admin = as.findById(1);
		System.out.println(admin.getRegisterTime());
		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
//		Assert.assertEquals("С��", admin.getUserName());
	}
	
	@Test
	public void testGetByName(){
		Admin admin = as.findByUserName("С��");
		Assert.assertEquals(new Integer(4), admin.getId());
	}
	
	@Test
	public void testDel(){
		Admin admin = new Admin();
		 admin = as.findById(3);
		as.delete(admin);
	}
	
	@Test
	public void testExists(){
		Admin admin = new Admin();
		admin.setId(1);
		Assert.assertEquals(false, as.isExists(admin));;
	}
	
	@Test
	public void testFindByProperty(){
		AdminDAOImpl adi = (AdminDAOImpl)as.getAdminDao();
		assertEquals(AdminDAOImpl.class, as.getAdminDao().getClass());
		System.out.println(adi.getHibernateTemplate().getSessionFactory());
		Assert.assertEquals("С��0", as.findByProperty(AdminDAOImpl.USER_NAME, "С��0").get(0).getUserName());
		System.out.println(Thread.currentThread());
		System.out.println(adi.getHibernateTemplate().getSessionFactory().getCurrentSession());
	}
	
	
	@Test
	public void testTetByRegisterTime(){
		System.out.println();
//		Assert.assertEquals("С��0", as.findByRegisterTime(new Timestamp(2017,11,21, 00,06,06, 0)).get(0).getUserName());
	}
	
	@Test
	public void testFindAll(){
		Assert.assertNotEquals(0, as.findAll());
	}
	
	@Test
	public void testFindAllCount(){
		Assert.assertEquals(as.findAll().size(), as.findAllCount());
	}
	
	@Test
	public void testUpdate(){
//		Assert.assertEquals(as.findAll().size(), as.findAllCount());
		Admin a = as.findByUserName("С��0");
//		Admin a = as.getByUserName("С��0");
		a.setPassword("8888");
		as.update(a);
	}
	
	@Test
	public void testFindPassword(){
		Admin a = new Admin();
		a.setId(1);
		System.out.println(as.findPassword(a));
	}
	
	@Test
	public void testFindPasswordByUserName(){
		System.out.println(as.findPasswordByUserName("admin"));
	}
	
	@Test
	public void testFindIdByUserName(){
		
		assertEquals(2, as.findIdByUserName("admin2"));
		
	}
	
}
