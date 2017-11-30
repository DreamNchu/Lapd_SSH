package com.lps.service.basic;

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
	PageBean<ServerOrder> findOrdersByPage(T t, int page) throws PagePropertyNotInitException;

	/**
	 * 
	 * @param t
	 * @return
	 */
	long findOrdersCountByThisType(T t);
}
