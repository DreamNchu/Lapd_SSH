package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.OrderStatusDAO;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.service.OrderStatusService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusDAO dao;

	private PageBean<OrderStatus> pageOrderStatusBean;
	
	private PageBean<ServerOrder> pageServerOrderByOrderStatusBean;

	public PageBean<ServerOrder> getPageServerOrderByOrderStatusBean() {
		return pageServerOrderByOrderStatusBean;
	}

	public void setPageServerOrderByOrderStatusBean(PageBean<ServerOrder> pageServerOrderByOrderStatusBean) {
		this.pageServerOrderByOrderStatusBean = pageServerOrderByOrderStatusBean;
	}

	public PageBean<OrderStatus> getPageBean() {
		return pageOrderStatusBean;
	}

	public void setPageBean(PageBean<OrderStatus> pageBean) {
		this.pageOrderStatusBean = pageBean;
	}

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
	public OrderStatus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrderStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<OrderStatus> findByOrderStatus(Object workStatus) {
		return dao.findByOrderStatus(workStatus);
	}

	public OrderStatusDAO getOrderStatusDao() {
		return dao;
	}

	@Override
	public void save(OrderStatus workStatus) {
		dao.save(workStatus);
	}

	public void setOrderStatusDao(OrderStatusDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	@Override
	public boolean isExists(OrderStatus user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<OrderStatus> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageOrderStatusBean.init(findAllCount(), page);

		List<OrderStatus> list = dao.findListByLimit(begin, pageOrderStatusBean.getLimit());

		pageOrderStatusBean.setList(list);

		return pageOrderStatusBean;
	}

	@Override
	public void update(OrderStatus t) {
		dao.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(OrderStatus t) {
		return dao.findAllOrders(t);
	}

	@Override
	public PageBean<ServerOrder> findOrdersByPage(OrderStatus t, int page) throws PagePropertyNotInitException {
		long begin= pageServerOrderByOrderStatusBean.init(findAllCount(), page);
        
        List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByOrderStatusBean.getLimit());
        
        pageServerOrderByOrderStatusBean.setList(list);
        
        return pageServerOrderByOrderStatusBean;
	}

}
