package com.lps.service;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.service.basic.BasicForServerOrderService;

public interface PayPathService extends BasicForServerOrderService<PayPath>{


	List<PayPath> findByPayPath(Object workStatus);

}