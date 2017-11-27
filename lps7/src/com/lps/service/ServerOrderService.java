package com.lps.service;
import java.util.Date;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.service.basic.BasicService;

public interface ServerOrderService extends BasicService<ServerOrder> {
	
	ServerOrder findById(String id);

	List<ServerOrder> findByPayPath(Object property);
	
	List<ServerOrder> findByUser(Object property);
	
	List<ServerOrder> findByPledge(Object property);
	
	List<ServerOrder> findByClockCategory(Object property);
	
	/**
	 * 返回今天的左右员工订单列表, 以订单的刚产生的时间为比较依据
	 * @return 返回今天的左右员工订单列表
	 */ 
	List<ServerOrder> findTodayOrder();
	
	/**
	 * 根据日期找到该天所有人的订单, 以订单的刚产生的时间为比较依据
	 * @param date 改天日期
	 * @return 放回该天所有人的订单
	 */
	List<ServerOrder> findOrderByDate(Date date);
	
	/**
	 * 找到该时间区域的所有人的订单, 以订单的刚产生的时间为比较依据
	 * @param begin 开始的时间
	 * @param end 结束的时间
	 * @return 返回该段时间内的所有人的订单列表
	 */
	List<ServerOrder> findOrderByDateLimit(Date begin, Date end);
	
	/**
	 * 找到交易价格比price低的订单
	 * @param price 比较价格
	 * @return 返回交易价格比price高的订单
	 */
	List<ServerOrder> findOrderLessThanPrice(int price);
	
	/**
	 * 
	 * @param price
	 * @param begin
	 * @param end
	 * @return
	 */
	List<ServerOrder> findOrderLessThanPriceDate(int price, Date begin, Date end);
	
	/**
	 * 找到交易价格比price高的订单
	 * @param price 比较价格
	 * @return 返回交易价格比price高的订单
	 */
	List<ServerOrder> findOrderMoreThanPrice(int price);
	
	/**
	 * 
	 * @param price
	 * @param begin
	 * @param end
	 * @return
	 */
	List<ServerOrder> findOrderMoreThanPriceDate(int price, Date begin, Date end);
	
	
}