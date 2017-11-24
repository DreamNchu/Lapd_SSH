package com.lps.service;
import java.util.List;

import com.lps.model.Pledge;
import com.lps.service.basic.BasicService;

public interface PledgeService extends BasicService<Pledge>{


	List<Pledge> findByName(Object workStatus);

}