package com.lps.dao;
import java.util.Date;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.OrderStatus;

/**
 * interfaceName:OrderStatusDAO
 * Description:继承自BasicDAO接口，包含查找订单状态的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface OrderStatusDAO extends BasicDAO<OrderStatus>, BasicForServerOrderDAO<OrderStatus, Integer>{
	/**
	 * 根据订单状态查找,返回订单状态
	 * <p>
	 * @param OrderStatus 订单状态对象
	 * @return 返回订单状态对象的数组
	 */

	List<OrderStatus> findByOrderStatus(Object orderStatus);
	
}