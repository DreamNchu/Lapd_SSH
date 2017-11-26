package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.ClockCategory;

public interface ClockCategoryDAO extends BasicDAO<ClockCategory> , BasicForServerOrderDAO<ClockCategory, Integer>{

	List<ClockCategory> findByClockCategory(Object roomCategory);
	
}