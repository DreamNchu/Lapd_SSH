package com.lps.service;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.model.PayPath;
import com.lps.service.basic.BasicForServerOrderService;

public interface PayPathService extends BasicForServerOrderService<PayPath>{

	/**
	 * 根据付费方式查找
	 * @param payPath 付费方式
	 * @return 付费方式的集合
	 */
	List<PayPath> findByPayPath(Object payPath);

	/**
	 * 根据其对应的ID找到PayPath字段
	 * @param payPath 必须包含主键id
	 * @return 返回PayPath的名字
	 */
	String findPayPath(PayPath payPath);
	
	/**
	 * 存在返回id，不存在返回-1
	 * @param payPathProperty
	 * @return
	 */
	int findIdByPayPath(String payPathProperty);
	
}