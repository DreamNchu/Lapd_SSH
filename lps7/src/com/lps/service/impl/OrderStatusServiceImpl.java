package com.lps.service.impl;

import java.util.List;

import com.lps.dao.OrderStatusDAO;
import com.lps.model.OrderStatus;
import com.lps.service.OrderStatusService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class OrderStatusServiceImpl implements OrderStatusService {

	private OrderStatusDAO dao;

	private PageBean<OrderStatus> pageBean;

	public PageBean<OrderStatus> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<OrderStatus> pageBean) {
		this.pageBean = pageBean;
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
	public PageBean<OrderStatus> findByPage(int page) {
		pageBean.setPage(page);

		long totalCount = findAllCount();

		pageBean.setAllCount(totalCount);

		long limit = pageBean.getLimit();

		long totalpage = (long) Math.ceil(totalCount / limit);

		pageBean.setAllPage(totalpage);
		// 每页显示的数据集合
		long begin = (page - 1) * limit;

		List<OrderStatus> list = dao.findListByLimit(begin, limit);

		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void update(OrderStatus t) {
		dao.update(t);
	}

}
