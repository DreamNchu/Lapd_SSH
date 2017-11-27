package com.lps.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.lps.dao.ServerOrderDAO;
import com.lps.model.ServerOrder;
import com.lps.service.ServerOrderService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class ServerOrderServiceImpl implements ServerOrderService {

	private ServerOrderDAO dao;

	private PageBean<ServerOrder> pageServerOrderBean;
	

	public PageBean<ServerOrder> getPageServerOrderBean() {
		return pageServerOrderBean;
	}

	public void setPageServerOrderBean(PageBean<ServerOrder> pageServerOrderBean) {
		this.pageServerOrderBean = pageServerOrderBean;
	}

	@Override
	public void delete(ServerOrder workStatus) {
		dao.delete(workStatus);
	}

	@Override
	public List<ServerOrder> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public ServerOrder findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<ServerOrder> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	public ServerOrderDAO getServerOrderDao() {
		return dao;
	}

	@Override
	public void save(ServerOrder workStatus) {
		dao.save(workStatus);
	}

	public void setServerOrderDao(ServerOrderDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	@Override
	public boolean isExists(ServerOrder user) {
		return dao.isExists(user);
	}

	@Override
	public void update(ServerOrder t) {
		dao.update(t);
	}

	@Override
	public ServerOrder findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findByPayPath(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findByUser(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findByPledge(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findByClockCategory(Object property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findTodayOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderByDateLimit(Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderLessThanPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderLessThanPriceDate(int price, Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderMoreThanPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrderMoreThanPriceDate(int price, Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<ServerOrder> findByPage(int page) throws PagePropertyNotInitException {
		
		return null;
	}


}
