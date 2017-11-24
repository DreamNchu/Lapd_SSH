package com.lps.dao;
import java.util.List;
import java.util.Set;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;

public interface ClockCategoryDAO extends BasicDAO<ClockCategory>{

	List<ClockCategory> findByClockCategory(Object roomCategory);
	
	/**
	 * 根据ClockCategory对象的ID来查找该钟点类型所有的订单
	 * @param cc 钟点类型ClockCategory对象，必须包含该对象的id属性
	 * @return 返回该查找所有对象的集合
	 */
	Set<ServerOrder> findAllOrderByClockCategory(ClockCategory cc);

	/**
	 * 
	 * @param cc
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<ServerOrder> findOrderByClockCategory(ClockCategory cc, long begin, long limit);
	
}