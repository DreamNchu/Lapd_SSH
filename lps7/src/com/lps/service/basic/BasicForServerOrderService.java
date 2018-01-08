package com.lps.service.basic;

import java.util.List;
import java.util.Set;

import com.lps.model.ServerOrder;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public interface BasicForServerOrderService<ENTITY> extends BasicService<ENTITY> {
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	Set<ServerOrder> findAllOrders(ENTITY t);

	/**
	 * 
	 * @param t
	 * @param page
	 * @return
	 * @throws PagePropertyNotInitException 
	 */
	PageBean<ServerOrder> findAllOrdersByPage(ENTITY t, int page) throws PagePropertyNotInitException;

	/**
	 * 
	 * @param t
	 * @return
	 */
	long findOrdersCountByThisType(ENTITY t);
	
	
	List<ServerOrder> findTodayOrders(ENTITY t);
	/**
	 * 该用户最近七天的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findBefore7DayOrders(ENTITY t);
	
	/**
	 * 该用户本月的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findThisMonthOrders(ENTITY t);
	
	/**
	 * 本年的工作订单
	 * @param t
	 * @return
	 */
	List<ServerOrder> findThisYearOrders(ENTITY t);
	
	PropertyRange<ENTITY> createProRangeForOrder(java.io.Serializable id1) throws FindByIdGetNullException;
}
