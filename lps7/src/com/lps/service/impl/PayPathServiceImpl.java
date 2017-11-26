package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.PayPathDAO;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.PayPathService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class PayPathServiceImpl implements PayPathService {

	private PayPathDAO dao;

	private PageBean<PayPath> pagePayPathBean;

	public PageBean<PayPath> getPagePayPathBean() {
		return pagePayPathBean;
	}

	public void setPagePayPathBean(PageBean<PayPath> pagePayPathBean) {
		this.pagePayPathBean = pagePayPathBean;
	}

	private PageBean<ServerOrder> pageServerOrderByPayPathBean;

	public PageBean<ServerOrder> getPageServerOrderByPayPathBean() {
		return pageServerOrderByPayPathBean;
	}

	public void setPageServerOrderByPayPathBean(PageBean<ServerOrder> pageServerOrderByPayPathBean) {
		this.pageServerOrderByPayPathBean = pageServerOrderByPayPathBean;
	}

	public PayPathDAO getPayPathDao() {
		return dao;
	}

	public void setPayPathDao(PayPathDAO payPathDao) {
		this.dao = payPathDao;
	}

	@Override
	public void delete(PayPath payPath) {
		dao.delete(payPath);
	}

	@Override
	public List<PayPath> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public PayPath findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<PayPath> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<PayPath> findByPayPath(Object payPath) {
		return dao.findByPayPath(payPath);
	}

	@Override
	public void save(PayPath payPath) {
		dao.save(payPath);
	}

	@Override
	public boolean isExists(PayPath user) {
		return false;
	}

	@Override
	public PageBean<PayPath> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pagePayPathBean.init(findAllCount(), page);

		List<PayPath> list = dao.findListByLimit(begin, pagePayPathBean.getLimit());

		pagePayPathBean.setList(list);

		return pagePayPathBean;
	}

	@Override
	public void update(PayPath t) {
		dao.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(PayPath t) {
		return dao.findAllOrders(t);
	}

	@Override
	public PageBean<ServerOrder> findOrdersByPage(PayPath t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByPayPathBean.init(findAllCount(), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByPayPathBean.getLimit());

		pageServerOrderByPayPathBean.setList(list);

		return pageServerOrderByPayPathBean;
	}

}
