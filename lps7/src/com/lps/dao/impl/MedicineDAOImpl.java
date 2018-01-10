package com.lps.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.dao.MedicineDAO;
import com.lps.model.Medicine;
import com.lps.model.basic.BasicModel;

public class MedicineDAOImpl implements MedicineDAO{

	@Override
	public void save(Medicine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Medicine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Medicine> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medicine findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Medicine entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Medicine> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Medicine> findListByLimit(long begin, long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Medicine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> Medicine findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
