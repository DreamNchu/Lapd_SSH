package com.lps.web.order.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.lps.action.operation.OrdersAction;

public class InitCreateOrderDtoTest {
	

	static ClassPathXmlApplicationContext ctx ;
	static InitCreateOrderDto as ;
	
	
	@BeforeClass
	public static void before(){
		ctx = new ClassPathXmlApplicationContext(new String[]{
				"classpath:config/applicationContext.xml",
		});
		as = ctx.getBean("initCreateOrderDto", InitCreateOrderDto.class);
	}
	
	@AfterClass
	public static void after(){
		
		ctx.destroy();
		
	}

	@Test
	public void test() {
		Gson gson = new Gson();
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		List<RoomCategoyCreateOrderDto> lr = new ArrayList<>();
		List<RoomCreateOrderDto> lc = new ArrayList<>();
		List<UserCreateOrderDto> lu = new ArrayList<>();
		
		lr.add(new RoomCategoyCreateOrderDto("r1", "r11"));
		lr.add(new RoomCategoyCreateOrderDto("r2", "r22"));
		
		lc.add(new RoomCreateOrderDto("room1", "room11"));
		lc.add(new RoomCreateOrderDto("room2", "room22"));
		
		lu.add(new UserCreateOrderDto("lu1", "lu11"));
		lu.add(new UserCreateOrderDto("lu2", "lu2"));
		InitCreateOrderDto ic = new InitCreateOrderDto(list, lu, lc, lr);
		
		as.setCreateWay(list);
		as.setRoom(lc);
		as.setUser(lu);
		
		System.out.println(gson.toJson(as));
	}

}
