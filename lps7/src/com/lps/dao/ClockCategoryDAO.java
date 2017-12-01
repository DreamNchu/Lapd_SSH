package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.ClockCategory;

public interface ClockCategoryDAO extends BasicDAO<ClockCategory> , BasicForServerOrderDAO<ClockCategory, Integer>{
	/**
	 * 点钟
	 */
	int SPOT_CLOCK = 1;
	/**
	 * 排钟
	 */
	int RANK_CLOCK = 2;

	List<ClockCategory> findByClockCategory(Object clockCategory);
	
}