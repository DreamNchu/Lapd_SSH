package com.lps.service.basic;

import java.util.List;
import java.util.Set;

import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public interface BasicForServerOrderService<T> extends BasicService<T> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	Set<ServerOrder> findAllOrders(T t);

	/**
	 * 
	 * @param t
	 * @param page
	 * @return
	 * @throws PagePropertyNotInitException 
	 */
	PageBean<ServerOrder> findAllOrdersByPage(T t, int page) throws PagePropertyNotInitException;

	/**
	 * 
	 * @param t
	 * @return
	 */
	long findOrdersCountByThisType(T t);
	
	
	List<ServerOrder> findTodayOrders(T t);
	/**
	 * 该用户最近七天的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findBefore7DayOrders(T t);
	
	/**
	 * 该用户本月的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findThisMonthOrders(T t);
	
	/**
	 * 本年的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findThisYearOrders(T t);
	
}
