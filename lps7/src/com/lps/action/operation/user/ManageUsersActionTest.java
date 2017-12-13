package com.lps.action.operation.user;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.util.PagePropertyNotInitException;
import com.lps.web.user.dto.PageLinkTransformUserDto;

public class ManageUsersActionTest {
	static ClassPathXmlApplicationContext ctx;
	static ManageUsersAction as;

	@BeforeClass
	public static void before() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "classpath:config/applicationContext.xml", });
		as = ctx.getBean("manageUsersAction", ManageUsersAction.class);
	}

	@AfterClass
	public static void after() {

		ctx.destroy();

	}

	@Test
	public void testQueryBasicUser() throws PagePropertyNotInitException {
		PageLinkTransformUserDto q = new PageLinkTransformUserDto();
		q.setPage(1);
		as.setPageLinkTransformUserDto(q);
		
		as.queryBasicUser();
		
		System.out.println(as.getResult());
		// fail("Not yet implemented");
	}

}
