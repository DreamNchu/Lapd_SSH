package com.lps.service;
import java.util.List;
import java.util.Set;

import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.service.basic.BasicForServerOrderService;
import com.lps.util.PageBean;

public interface ClockCategoryService extends BasicForServerOrderService<ClockCategory>{

	List<ClockCategory> findByClockCategory(Object roomCategory);
	
}