package com.lps.action.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lps.action.user.access.UserSignInAction;
import com.lps.web.dto.UserSignInDto;

public class UserSignInActionTest {
	
	static ClassPathXmlApplicationContext ctx ;
	static UserSignInAction as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("userSignInAction", UserSignInAction.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void testSignIn() {
//		fail("Not yet implemented");
		/*UserSignInDto ud = new UserSignInDto("cyl001", "cyl001", "13672246707", new Date(),-1,"你是", "King",null );
		as.setUserSignInDto(ud);
		assertEquals("success",as.signIn());*/
		
	}

	@Test
	public void testIsExists() {
//		UserSignInAction u = new UserSignInAction();
		UserSignInDto ud = new UserSignInDto();
		ud.setUserName("user001");
		as.setUserSignInDto(ud);
		assertEquals("success", as.isExists());
	}

}
