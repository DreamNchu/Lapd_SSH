package com.lps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.dao.TestDAO;
import com.lps.dao.impl.TestImpl;
import com.lps.model.Test;
import com.lps.model.basic.BasicModel;
import com.lps.service.TestService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class TestServiceImpl implements TestService{
	
	private TestImpl dao;

	public TestDAO getDao() {
		return dao;
	}

	public void setDao(TestImpl dao) {
		this.dao = dao;
	}

	@Override
	public boolean isExists(Test entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Test entity) {
		dao.save(entity);
	}

	@Override
	public void delete(Test persistentInstance) {
		dao.delete(persistentInstance);
	}

	@Override
	public void deleteAll(Collection<Test> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Test findById(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<Test> findByPage(int page) throws PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Test entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Override
	public <K> Test findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findPasswordByUserName(String userName) throws UserNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> String findPassword(BasicModel<T> t) throws UserNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findIdByUserName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
