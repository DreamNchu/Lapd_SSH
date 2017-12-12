package com.lps.service;

import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.service.basic.BasicForServerOrderService;

public interface ClockCategoryService extends BasicForServerOrderService<ClockCategory> {

	/**
	 * 根据钟点类型（排钟，点钟）查找
	 * 
	 * @param clockCategory
	 *            钟点类型
	 * @return 钟点类型的集合
	 */
	List<ClockCategory> findByClockCategory(Object clockCategory);

	/**
	 * 根据其对应的ID找到ClockCategory字段
	 * 
	 * @param clockCategory
	 *            必须包含主键id
	 * @return 返回ClockCategory的名字
	 */
	String findClockCategory(ClockCategory clockCategory);

	/**
	 * 存在返回id，不存在返回-1
	 * 
	 * @param clockCategory
	 * @return
	 */
	int findIdByClockCategory(String clockCategory);

}