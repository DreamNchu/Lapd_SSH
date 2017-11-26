package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.PledgeDAO;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.ServerOrder;
import com.lps.service.PledgeService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class PledgeServiceImpl implements PledgeService {
	
	private PledgeDAO dao ;
	
	private PageBean<Pledge> pagePledgeBean;
	
	public PageBean<Pledge> getPagePledgeBean() {
		return pagePledgeBean;
	}

	public void setPagePledgeBean(PageBean<Pledge> pagePledgeBean) {
		this.pagePledgeBean = pagePledgeBean;
	}

	private PageBean<ServerOrder> pageServerOrderByPledgeBean;

	public PledgeDAO getPledgeDao() {
		return dao;
	}

	public void setPledgeDao(PledgeDAO pledgeDao) {
		this.dao = pledgeDao;
	}

	@Override
	public void delete(Pledge pledge) {
		dao.delete( pledge);
	}

	@Override
	public List<Pledge> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public Pledge findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Pledge> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<Pledge> findByName(Object pledge) {
		return dao.findByName(pledge);
	}

	@Override
	public void save(Pledge pledge) {
		dao.save(pledge);
	}

	@Override
	public boolean isExists(Pledge user) {
		return false;
	}

	@Override
	public PageBean<Pledge> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pagePledgeBean.init(findAllCount(), page);

		List<Pledge> list = dao.findListByLimit(begin, pagePledgeBean.getLimit());

		pagePledgeBean.setList(list);

		return pagePledgeBean;
	}

	@Override
	public void update(Pledge t) {
		dao.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(Pledge t) {
		return dao.findAllOrders(t);
	}

	@Override
	public PageBean<ServerOrder> findOrdersByPage(Pledge t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByPledgeBean.init(findAllCount(), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByPledgeBean.getLimit());

		pageServerOrderByPledgeBean.setList(list);

		return pageServerOrderByPledgeBean;
	}



}
