package com.lps.service;
import java.util.List;

import com.lps.model.Pledge;
import com.lps.service.basic.BasicForServerOrderService;

public interface PledgeService extends BasicForServerOrderService<Pledge>{


	List<Pledge> findByName(Object workStatus);

}