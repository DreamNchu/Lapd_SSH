package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.PayPathDAO;
import com.lps.dao.impl.OrderStatusDAOImpl;
import com.lps.dao.impl.PayPathDAOImpl;
import com.lps.model.PayPath;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.PayPathService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;

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
	public PageBean<ServerOrder> findAllOrdersByPage(PayPath t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByPayPathBean.init(
				findOrdersCountByThisType(t), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByPayPathBean.getLimit());

		pageServerOrderByPayPathBean.setList(list);

		return pageServerOrderByPayPathBean;
	}

	@Override
	public long findOrdersCountByThisType(PayPath t) {
		return dao.findOrdersCountByThisType(t);
	}

	@Override
	public String findPayPath(PayPath payPath) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(PayPathDAOImpl.PAY_PATH, String.class);
		return dao.findFields(payPath, map).getPayPath();
	}

	@Override
	public int findIdByPayPath(String payPathProperty) {
		Map<String, Object> map = new HashMap<>();
		map.put(PayPathDAOImpl.PAY_PATH, payPathProperty);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}
	
	@Override
	public List<ServerOrder> findTodayOrders(PayPath t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(PayPath t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(PayPath t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(PayPath t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}


	@Override
	public <K> PayPath findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return dao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

}
