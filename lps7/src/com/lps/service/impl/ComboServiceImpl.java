package com.lps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.model.Combo;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.ComboService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public class ComboServiceImpl implements ComboService {

	@Override
	public Set<ServerOrder> findAllOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Combo t, int page) throws PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findOrdersCountByThisType(Combo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ServerOrder> findTodayOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findThisYearOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyRange<Combo> createProRangeForOrder(Serializable id1) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Combo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Combo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Combo persistentInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Combo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Combo findById(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Combo> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Combo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean<Combo> findByPage(int page) throws PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Combo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> Combo findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}}
