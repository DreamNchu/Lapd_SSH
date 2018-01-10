package com.lps.dao.basic;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;
import com.lps.util.PropertyRange;

public interface BasicForServerOrderDAO<T extends ModelLinkServerOrder<K> , K> extends BasicDAO<T>{
	
	/**
	 * 根据该对象的ID来查找该类型所有的订单 {@link ServerOrder}
	 * @param t {@link BasicModel}对象
	 * @return 返回该查找所有对象的集合
	 * 
	 */
	Set<ServerOrder> findAllOrders(T t);
	
	/**
	 * 查找指定类型订单的数量
	 * @param property 订单类型
	 * @return 订单数量
	 */
	long findOrdersCountByThisType(T property);

	/**
	 * 根据该对象的ID来查找订单，订单的条数受限于begin，limit
	 * @param t {@link BasicModel}对象
	 * @param begin 开始下标
	 * @param limit 从开始下标后limit个数
	 * @return 返回订单列表
	 */
	List<ServerOrder> findOrdersWithLimit(T t, long begin, long limit);
	
	/**
	 * 根据该对象的ID来查找订单，订单的条数受限于begin，end
	 * @param t {@link BasicModel}对象
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @return 返回订单列表
	 */
	List<ServerOrder> findOrdersByDateLimit(T t, Date begin, Date end);


}
