package com.lps.service;
import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.service.basic.BasicForServerOrderService;
import com.lps.util.PropertyRange;

public interface OrderStatusService extends BasicForServerOrderService<OrderStatus>{

	/**
	 * 根据订单状态查找
	 * @param orderStatus 订单状态
	 * @return 返回订单状态的集合
	 */
	List<OrderStatus> findByOrderStatus(Object orderStatus);

	
	/**
	 * 根据其对应的ID找到OrderStatus字段
	 * @param orderStatus 必须包含主键id
	 * @return 返回OrderStatus的名字
	 */
	String findOrderStatus(OrderStatus orderStatus);
	
	/**
	 * 存在返回id，不存在返回-1
	 * @param orderStatusProperty
	 * @return
	 */
	int findIdByOrderStatus(String orderStatusProperty);
	
	
	PropertyRange createPropertyRange(int id1, int id2);
	
}