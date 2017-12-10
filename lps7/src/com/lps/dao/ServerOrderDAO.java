package com.lps.dao;
import java.util.Date;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.uenum.CompareLevel;
import com.lps.util.PropertyRange;

public interface ServerOrderDAO extends BasicDAO<ServerOrder> {
	
	ServerOrder findById(String id);

	List<ServerOrder> findByPayPath(Object property);
	
	List<ServerOrder> findByUser(Object property);
	
	List<ServerOrder> findByPledge(Object property);
	
	List<ServerOrder> findByClockCategory(Object property);
	
	
	/**
	 * 找到该时间区域的所有人的订单, 以订单的刚产生的时间为比较依据
	 * @param begin 开始的时间
	 * @param end 结束的时间
	 * @return 返回该段时间内的所有人的订单列表
	 */
	List<ServerOrder> findOrdersByDateLimit(Date begin, Date end);
	
	/**
	 * 
	 * @param price
	 * @param begin
	 * @param end
	 * @param cl
	 * @return
	 */
	List<ServerOrder> findOrderByPriceAndDateLimit(int price,
			Date begin, Date end, CompareLevel cl);
	
	
	List<ServerOrder> findOrderByPriceLimit(int price, CompareLevel cl);
	
	
	/**
	 * 查找listPro条件中的订单
	 * @param os
	 * @param listPro
	 * @param begin
	 * @param limit
	 * @return
	 */
	List<ServerOrder> findOrdersByProperyLimit(List<PropertyRange> listPro, int begin, int limit);
	
	/**
	 * 查找条件中的总个数
	 */
	public long findOrdersByProperyLimitCount( List<PropertyRange> listPro);
	
	
}