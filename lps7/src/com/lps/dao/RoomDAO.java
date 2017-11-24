package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Room;

public interface RoomDAO extends BasicDAO<Room>{

	public List<Room> findByName(Object name);

	public List<Room> findByFloor(Object floor) ;

	public List<Room> findBySize(Object size) ;

	public List<Room> findFreeRoom();

}