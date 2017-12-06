package com.lps.service;
import java.util.List;

import com.lps.model.ServerItem;
import com.lps.model.ServerItem;
import com.lps.service.basic.BasicService;

public interface ServerItemService extends BasicService<ServerItem>{

	/**
	 * 根据房间状态查找
	 * @param roomCategory 房间状态
	 * @return 房间状态的集合
	 */
	List<ServerItem> findByServerItem(Object roomCategory);

	/**
	 * 根据其对应的ID找到ServerItem字段
	 * @param serverItem 必须包含主键id
	 * @return 返回ServerItem的名字
	 */
	String findServerItem(ServerItem serverItem);
	
	/**
	 * 存在返回id，不存在返回-1
	 * @param roomCategoryProperty
	 * @return
	 */
	int findIdByServerItem(String roomCategoryProperty);
	
	
}