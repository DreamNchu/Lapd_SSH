package com.lps.service;
import java.util.List;

import com.lps.model.Pledge;
import com.lps.model.Pledge;
import com.lps.service.basic.BasicForServerOrderService;

public interface PledgeService extends BasicForServerOrderService<Pledge>{

	/**
	 * 根据名字查找抵押物品
	 * @param name 名字
	 * @return 抵押物品的集合
	 */
	List<Pledge> findByName(Object name);

	
	/**
	 * 根据其对应的ID找到Pledge字段
	 * @param pledge 必须包含主键id
	 * @return 返回Pledge的名字
	 */
	String findPledge(Pledge pledge);
	
	/**
	 * 存在返回id，不存在返回-1
	 * @param pledgeProperty
	 * @return
	 */
	int findIdByPledge(String pledgeProperty);
}