package com.lps.service;
import java.util.List;

import com.lps.model.WorkStatus;
import com.lps.service.basic.BasicService;

public interface WorkStatusService extends BasicService<WorkStatus>{

	/**
	 * 根据工作状态查找
	 * @param workStatus 订单状态
	 * @return 返回工作状态的集合
	 */
	List<WorkStatus> findByWorkStatus(Object workStatus);
	
}