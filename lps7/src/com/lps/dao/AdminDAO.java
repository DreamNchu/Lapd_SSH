package com.lps.dao;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;

/**
 * 
 * @author 0001
 *
 */
public interface AdminDAO extends BasicDAO<Admin>{
	
	public Admin getByUserName(String name);
	
}
