package com.lps.service.impl;

import java.util.List;
import java.util.Map;

import com.lps.dao.WorkRankDAO;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.basic.BasicModel;
import com.lps.service.WorkRankService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class WorkRankServiceImpl implements WorkRankService {
	
	private WorkRankDAO dao ;
	
	private PageBean<WorkRank> pageBean;
	
	public WorkRankServiceImpl(){
		
	}
	
	public PageBean<WorkRank> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WorkRank> pageBean) {
		this.pageBean = pageBean;
	}

	public WorkRankDAO getWorkRankDao() {
		return dao;
	}

	public void setWorkRankDao(WorkRankDAO userDao) {
		this.dao = userDao;
	}

	@Override
	public void save(WorkRank user) {
		dao.save( user);
	}

	@Override
	public void delete(WorkRank user) {
		dao.delete(user);
	}


	@Override
	public WorkRank findById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public boolean isExists(WorkRank user) {
		return dao.isExists(user);
	}


	@Override
	public List<WorkRank> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public List<WorkRank> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

//	public WorkRankServiceImpl() throws PagePropertyNotInitException {
//		pageBean.init(findAllCount(), 1);
//	}
	
	
	public PageBean<WorkRank> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageBean.init(findAllCount(), page);

		List<WorkRank> list = dao.findListByLimit( begin, pageBean.getLimit());

		pageBean.setList(list);

		return pageBean;
    }

	@Override
	public void update(WorkRank t) {
		dao.update(t);	
	}

	@Override
	public List<WorkRank> findByUser(User user) {
		return dao.findByUser(user);
	}

	@Override
	public List<WorkRank> findByRank(int num) {
		return dao.findByRank(num);
	}

	@Override
	public List<WorkRank> findByRankNum(int num) {
		return dao.findByRankNum(num);
	}

	@Override
	public List<WorkRank> findBySpotNum(int num) {
		return dao.findBySpotNum(num);
	}
	@Override
	public WorkRank findFirstMinRankNum(){
		return dao.findFirstMinRankNum();
	}

	@Override
	public <K> WorkRank findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return dao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

}
