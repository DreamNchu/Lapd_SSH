package com.lps.service;
import java.util.List;

import com.lps.model.OrderStatus;
import com.lps.service.basic.BasicService;

public interface OrderStatusService extends BasicService<OrderStatus>{


	List<OrderStatus> findByOrderStatus(Object roomCategory);

}