package com.lps.service;
import java.util.Date;
import java.util.List;

import com.lps.model.ServerOrder;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public interface ServerOrderService extends BasicService<ServerOrder> {
	
	/**
	 * 根据付费方式返回订单列表
	 * @param property 付费方式
	 * @return 订单列表
	 */
	List<ServerOrder> findByPayPath(Object property);
	
	/**
	 * 根据员工名返回订单列表
	 * @param property 员工名
	 * @return 订单列表
	 */
	List<ServerOrder> findByUser(Object property);
	
	/**
	 * 根据抵押物品返回订单列表
	 * @param property 抵押物品
	 * @return 订单列表
	 */
	List<ServerOrder> findByPledge(Object property);
	
	/**
	 * 根据钟点类型返回订单列表
	 * @param property 钟点类型
	 * @return 订单列表
	 */
	List<ServerOrder> findByClockCategory(Object property);
	
	/**
	 * 返回今天的所有员工订单列表, 以订单的刚产生的时间为比较依据
	 * @return 返回今天的所有员工订单列表
	 */ 
	List<ServerOrder> findTodayOrder();
	
	/**
	 * 根据日期找到该天所有人的订单, 以订单的刚产生的时间为比较依据
	 * @param date 该天日期
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
	List<ServerOrder> findAllOrderLessThanPrice(int price);
	
	/**
	 * 找到指定时间区域内交易价格比price低的订单
	 * @param price 比较价格
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 返回指定时间区域内交易价格比price低的订单列表
	 */
	List<ServerOrder> findOrderLessThanPriceDate(int price, Date begin, Date end);
	
	/**
	 * 找到交易价格比price高的订单
	 * @param price 比较价格
	 * @return 返回交易价格比price高的订单
	 */
	List<ServerOrder> findOrderMoreThanPrice(int price);
	
	/**
	 * 找到指定时间区域内交易价格比price高的订单
	 * @param price 比较价格
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 返回指定时间区域内交易价格比price高的订单列表
	 */
	List<ServerOrder> findOrderMoreThanPriceDate(int price, Date begin, Date end);
	
	/**
	 * 最近七天的所有员工工作订单
	 * @return ServerOrder 数组
	 */
	List<ServerOrder> findBefore7DayOrders();
	
	
	/**
	 * 当月的订单
	 * @return
	 */
	List<ServerOrder> findThisMonthOrders();
	
	/**
	 * 本年的工作订单
	 * @return
	 */
	List<ServerOrder> findThisYearOrders();
	
	public List<ServerOrder> findOrdersByProperyLimit( List<PropertyRange<?>> listPro, int begin,
			int limit);
	
	PageBean<ServerOrder> findOrdersByPropertyLimit(List<PropertyRange<?>> listPro, int page) throws PagePropertyNotInitException;	
	
	PropertyRange<?> createPropertyRangeByName(String propertyName, Object o1, Object o2);
}