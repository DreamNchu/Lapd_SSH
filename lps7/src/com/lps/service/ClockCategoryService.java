package com.lps.service;
import java.util.List;
import java.util.Set;

import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.basic.BasicService;
import com.lps.util.PageBean;

public interface ClockCategoryService extends BasicService<ClockCategory>{

	List<ClockCategory> findByClockCategory(Object roomCategory);
	
	Set<ServerOrder> findAllOrderByClockCategory(ClockCategory cc);

	PageBean<ServerOrder> findOrderByClockCategory(ClockCategory cc,int page);
	
}