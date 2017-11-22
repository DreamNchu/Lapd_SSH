package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.OrderStatus;

public interface OrderStatusDAO extends BasicDAO<OrderStatus>{

	List<OrderStatus> findByOrderStatus(Object workStatus);

}