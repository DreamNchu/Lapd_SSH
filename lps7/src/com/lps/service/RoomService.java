package com.lps.service;

import java.util.List;

import com.lps.model.Room;
import com.lps.service.basic.BasicForServerOrderService;

public interface RoomService extends BasicForServerOrderService<Room>{
	
	/**
	 * 根据房间名字查找
	 * @param name 房间名字
	 * @return 房间的集合
	 */
	public List<Room> findByName(Object name);

	/**
	 * 根据房间楼层查找
	 * @param floor 房间楼层
	 * @return 房间的集合
	 */
	public List<Room> findByFloor(Object floor) ;

	/**
	 * 根据房间大小查找
	 * @param size 房间大小
	 * @return 房间的集合
	 */
	public List<Room> findBySize(Object size) ;
	
	/**
	 * 查找空闲房间
	 * @return 房间集合
	 */
	public List<Room> findFreeRoom();
	
	

}