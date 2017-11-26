package com.lps.service;

import java.util.List;

import com.lps.model.Room;
import com.lps.service.basic.BasicForServerOrderService;

public interface RoomService extends BasicForServerOrderService<Room>{
	

	public List<Room> findByName(Object name);

	public List<Room> findByFloor(Object floor) ;

	public List<Room> findBySize(Object size) ;
	
	public List<Room> findFreeRoom();

}