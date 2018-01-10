package com.lps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.model.Medicine;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.MedicineService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public class MedicineServiceImpl implements MedicineService {

	@Override
	public Set<ServerOrder> findAllOrders(Medicine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Medicine t, int page) throws PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findOrdersCountByThisType(Medicine t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ServerOrder> findTodayOrders(Medicine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(Medicine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(Medicine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findThisYearOrders(Medicine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyRange<Medicine> createProRangeForOrder(Serializable id1) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Medicine entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Medicine entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Medicine persistentInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Collection<Medicine> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public Medicine findById(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
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
	public PageBean<Medicine> findByPage(int page) throws PagePropertyNotInitException {
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
