package com.lps.service;
import java.util.List;

import com.lps.model.WorkStatus;
import com.lps.service.basic.BasicService;

public interface WorkStatusService extends BasicService<WorkStatus>{


	List<WorkStatus> findByWorkStatus(Object workStatus);
	
}