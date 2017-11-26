package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.service.ClockCategoryService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

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
	public PageBean<ServerOrder> findOrdersByPage(ClockCategory cc, int page) throws PagePropertyNotInitException {

		long begin = pageServerOrderByClockCategoryBean.init(findAllCount(), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(cc, begin, pageServerOrderByClockCategoryBean.getLimit());

		pageServerOrderByClockCategoryBean.setList(list);

		return pageServerOrderByClockCategoryBean;
	}

}
