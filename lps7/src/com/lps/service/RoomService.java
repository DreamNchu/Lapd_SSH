package com.lps.service;

import java.util.List;

import com.lps.model.Room;
import com.lps.service.basic.BasicService;
import com.lps.util.PageBean;

public interface RoomService extends BasicService<Room>{
	

	public List<Room> findByName(Object name);

	public List<Room> findByFloor(Object floor) ;

	public List<Room> findBySize(Object size) ;

}