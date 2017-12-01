package com.lps.service.impl;

import java.util.List;

import com.lps.dao.WorkRankDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.service.WorkRankService;
import com.lps.util.PageBean;

public class WorkRankServiceImpl implements WorkRankService {
	
	private WorkRankDAO dao ;
	
	private PageBean<WorkRank> pageBean;

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

	
	public PageBean<WorkRank> findByPage(int page) {
        pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //ÿҳ��ʾ�����ݼ���
        long begin=(page-1) * limit;
        
        List<WorkRank> list = dao.findListByLimit(begin, limit);
        
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

}
