package com.lps.service;
import java.util.List;

import com.lps.model.RoomCategory;
import com.lps.model.RoomCategory;
import com.lps.service.basic.BasicService;

public interface RoomCategoryService extends BasicService<RoomCategory>{

	/**
	 * 根据房间状态查找
	 * @param roomCategory 房间状态
	 * @return 房间状态的集合
	 */
	List<RoomCategory> findByRoomCategory(Object roomCategory);

	/**
	 * 根据其对应的ID找到RoomCategory字段
	 * @param roomCategory 必须包含主键id
	 * @return 返回RoomCategory的名字
	 */
	String findRoomCategory(RoomCategory roomCategory);
	
	/**
	 * 存在返回id，不存在返回-1
	 * @param roomCategoryProperty
	 * @return
	 */
	int findIdByRoomCategory(String roomCategoryProperty);
	
	
}