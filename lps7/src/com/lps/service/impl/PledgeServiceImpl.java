package com.lps.service.impl;

import java.util.List;

import com.lps.dao.PledgeDAO;
import com.lps.model.Pledge;
import com.lps.service.PledgeService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class PledgeServiceImpl implements PledgeService {
	
	private PledgeDAO pledgeDao ;
	
	private PageBean<Pledge> pageBean;

	public PageBean<Pledge> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Pledge> pageBean) {
		this.pageBean = pageBean;
	}
	
	public PledgeDAO getPledgeDao() {
		return pledgeDao;
	}

	public void setPledgeDao(PledgeDAO pledgeDao) {
		this.pledgeDao = pledgeDao;
	}

	@Override
	public void delete(Pledge pledge) {
		pledgeDao.delete( pledge);
	}

	@Override
	public List<Pledge> findAll() {
		return pledgeDao.findAll();
	}

	@Override
	public long findAllCount() {
		return pledgeDao.findAllCount();
	}

	@Override
	public Pledge findById(int id) {
		return pledgeDao.findById(id);
	}

	@Override
	public List<Pledge> findByProperty(String propertyName, Object value) {
		return pledgeDao.findByProperty(propertyName, value);
	}

	@Override
	public List<Pledge> findByName(Object pledge) {
		return pledgeDao.findByName(pledge);
	}

	@Override
	public void save(Pledge pledge) {
		pledgeDao.save(pledge);
	}

	@Override
	public boolean isExists(Pledge user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageBean<Pledge> findByPage(int page) {
		pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //
        long begin=(page-1) * limit;
        
        List<Pledge> list = pledgeDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
	}

	@Override
	public void update(Pledge t) {
		// TODO Auto-generated method stub
		pledgeDao.update(t);
	}



}
