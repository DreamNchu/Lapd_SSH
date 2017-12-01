package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.OrderStatusDAO;
import com.lps.dao.impl.ClockCategoryDAOImpl;
import com.lps.dao.impl.OrderStatusDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.service.OrderStatusService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;

//@Component("adminServiceImpl")
//@Aspect
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusDAO dao;

	private PageBean<OrderStatus> pageOrderStatusBean;
	
	private PageBean<ServerOrder> pageServerOrderByOrderStatusBean;

	@Override
	public void delete(OrderStatus workStatus) {
		dao.delete(workStatus);
	}

	@Override
	public List<OrderStatus> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public Set<ServerOrder> findAllOrders(OrderStatus t) {
		return dao.findAllOrders(t);
	}

	@Override
	public OrderStatus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrderStatus> findByOrderStatus(Object workStatus) {
		return dao.findByOrderStatus(workStatus);
	}

	@Override
	public PageBean<OrderStatus> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageOrderStatusBean.init(findAllCount(), page);

		List<OrderStatus> list = dao.findListByLimit(begin, pageOrderStatusBean.getLimit());

		pageOrderStatusBean.setList(list);

		return pageOrderStatusBean;
	}

	@Override
	public List<OrderStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(OrderStatus t, int page) throws PagePropertyNotInitException {
		long begin= pageServerOrderByOrderStatusBean.init(findOrdersCountByThisType(t), page);
        
        List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByOrderStatusBean.getLimit());
        
        pageServerOrderByOrderStatusBean.setList(list);
        
        return pageServerOrderByOrderStatusBean;
	}

	@Override
	public long findOrdersCountByThisType(OrderStatus t) {
		return dao.findOrdersCountByThisType(t);
	}

	public OrderStatusDAO getOrderStatusDao() {
		return dao;
	}

	public PageBean<OrderStatus> getPageOrderStatusBean() {
		return pageOrderStatusBean;
	}

	public PageBean<ServerOrder> getPageServerOrderByOrderStatusBean() {
		return pageServerOrderByOrderStatusBean;
	}

	@Override
	public boolean isExists(OrderStatus user) {
		return dao.isExists(user);
	}

	@Override
	public void save(OrderStatus workStatus) {
		dao.save(workStatus);
	}

	public void setOrderStatusDao(OrderStatusDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	public void setPageOrderStatusBean(PageBean<OrderStatus> pageOrderStatusBean) {
		this.pageOrderStatusBean = pageOrderStatusBean;
	}

	public void setPageServerOrderByOrderStatusBean(PageBean<ServerOrder> pageServerOrderByOrderStatusBean) {
		this.pageServerOrderByOrderStatusBean = pageServerOrderByOrderStatusBean;
	}

	@Override
	public void update(OrderStatus t) {
		dao.update(t);
	}

	@Override
	public String findOrderStatus(OrderStatus orderStatus) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(OrderStatusDAOImpl.WORK_STATUS, String.class);
		return dao.findFields(orderStatus, map).getOrderstatus();
	}

	@Override
	public int findIdByOrderStatus(String orderStatusProperty) {
		Map<String, Object> map = new HashMap<>();
		map.put(OrderStatusDAOImpl.WORK_STATUS, orderStatusProperty);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}

	@Override
	public List<ServerOrder> findTodayOrders(OrderStatus t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(OrderStatus t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(OrderStatus t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(OrderStatus t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

}
