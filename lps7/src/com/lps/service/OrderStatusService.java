package com.lps.service;
import java.util.List;

import com.lps.model.OrderStatus;
import com.lps.service.basic.BasicForServerOrderService;

public interface OrderStatusService extends BasicForServerOrderService<OrderStatus>{


	List<OrderStatus> findByOrderStatus(Object roomCategory);

}