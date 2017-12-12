package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.util.PropertyRange;

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
	 * 待接收
	 */
	int WAITING_RECEIVE = 1;
	/**
	 * 服务中
	 */
	int SERVICING = 2;
	/**
	 * 等待支付
	 */
	int WAITING_PAY = 3;
	/**
	 * 订单完成，支付完成
	 */
	int FINISH = 4;
	
	/**
	 * 订单没有人接收，那么挂起
	 */
	int SUSPEND = 5;
	
	/**
	 * 订单失效
	 */
	int INVALID = 6;
	
	/**
	 * 根据订单状态查找,返回订单状态
	 * <p>
	 * @param orderStatus 订单状态对象
	 * @return 返回订单状态对象的数组
	 */

	List<OrderStatus> findByOrderStatus(Object orderStatus);
	
	
	
}