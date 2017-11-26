package com.lps.service.basic;

import java.util.List;

import com.lps.model.PayPath;
import com.lps.model.User;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public interface BasicService<T> {
	
	public boolean isExists(T user);
	
	void save(T transientInstance);

	void delete(T persistentInstance);

	T findById(int id);

	List<T> findByProperty(String propertyName, Object value);

	List<T> findAll();
	
	public long findAllCount();
	
	public PageBean<T> findByPage(int page) throws PagePropertyNotInitException;

	void update(T t);
}
