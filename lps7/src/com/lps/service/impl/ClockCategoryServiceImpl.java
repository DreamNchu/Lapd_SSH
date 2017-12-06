package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.impl.ClockCategoryDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.model.ClockCategory;
import com.lps.service.ClockCategoryService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;

public class ClockCategoryServiceImpl implements ClockCategoryService {

	private ClockCategoryDAO dao;

	private PageBean<ClockCategory> pageClockCategoryBean;

	private PageBean<ServerOrder> pageServerOrderByClockCategoryBean;

	public PageBean<ServerOrder> getPageServerOrderByClockCategoryBean() {
		return pageServerOrderByClockCategoryBean;
	}

	public void setPageServerOrderByClockCategoryBean(PageBean<ServerOrder> pageServerOrderByClockCategoryBean) {
		this.pageServerOrderByClockCategoryBean = pageServerOrderByClockCategoryBean;
	}

	public PageBean<ClockCategory> getPageClockCategoryBean() {
		return pageClockCategoryBean;
	}

	public void setPageClockCategoryBean(PageBean<ClockCategory> pageClockCategoryBean) {
		this.pageClockCategoryBean = pageClockCategoryBean;
	}

	@Override
	public void delete(ClockCategory roomCategory) {
		dao.delete(roomCategory);
	}

	@Override
	public List<ClockCategory> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public ClockCategory findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<ClockCategory> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<ClockCategory> findByClockCategory(Object roomCategory) {
		return dao.findByClockCategory(roomCategory);
	}

	public ClockCategoryDAO getClockCategoryDao() {
		return dao;
	}

	@Override
	public void save(ClockCategory roomCategory) {
		dao.save(roomCategory);
	}

	public void setClockCategoryDao(ClockCategoryDAO roomCategoryDao) {
		this.dao = roomCategoryDao;
	}

	@Override
	public boolean isExists(ClockCategory user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<ClockCategory> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageClockCategoryBean.init(findAllCount(), page);

		List<ClockCategory> list = dao.findListByLimit(begin, pageClockCategoryBean.getLimit());

		pageClockCategoryBean.setList(list);

		return pageClockCategoryBean;
	}

	@Override
	public void update(ClockCategory t) {
		dao.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(ClockCategory cc) {
		return dao.findAllOrders(cc);
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(ClockCategory cc, int page) throws PagePropertyNotInitException {

		long begin = pageServerOrderByClockCategoryBean.init(findOrdersCountByThisType(cc), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(cc, begin, pageServerOrderByClockCategoryBean.getLimit());

		pageServerOrderByClockCategoryBean.setList(list);

		return pageServerOrderByClockCategoryBean;
	}

	@Override
	public long findOrdersCountByThisType(ClockCategory t) {
		return dao.findOrdersCountByThisType(t);
	}

	@Override
	public String findClockCategory(ClockCategory clockCategory) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(ClockCategoryDAOImpl.CLOCK_CATEGORY, String.class);
		return dao.findFields(clockCategory, map).getClockCategory();
	}

	@Override
	public int findIdByClockCategory(String clockCategory) {
		Map<String, Object> map = new HashMap<>();
		map.put(ClockCategoryDAOImpl.CLOCK_CATEGORY, clockCategory);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}
	
	@Override
	public List<ServerOrder> findTodayOrders(ClockCategory t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(ClockCategory t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(ClockCategory t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(ClockCategory t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}
	
	@Override
	public <K> ClockCategory findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return dao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

}
