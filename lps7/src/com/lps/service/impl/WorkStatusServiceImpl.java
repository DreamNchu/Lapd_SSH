package com.lps.service.impl;

import java.util.List;

import com.lps.dao.WorkStatusDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.WorkStatus;
import com.lps.service.WorkStatusService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class WorkStatusServiceImpl implements WorkStatusService {

	private WorkStatusDAO dao;

	private PageBean<WorkStatus> pageBean;

	public PageBean<WorkStatus> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WorkStatus> pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public void delete(WorkStatus workStatus) {
		dao.delete(workStatus);
	}

	@Override
	public List<WorkStatus> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public WorkStatus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<WorkStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<WorkStatus> findByWorkStatus(Object workStatus) {
		return dao.findByWorkStatus(workStatus);
	}

	public WorkStatusDAO getWorkStatusDao() {
		return dao;
	}

	@Override
	public void save(WorkStatus workStatus) {
		dao.save(workStatus);
	}

	public void setWorkStatusDao(WorkStatusDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	@Override
	public boolean isExists(WorkStatus user) {
		return dao.isExists(user);
	}
	
	{
//		pageBean.setAllCount(findAllCount(), 1);
	}

	@Override
	public PageBean<WorkStatus> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageBean.init(findAllCount(), page);

		List<WorkStatus> list = dao.findListByLimit( begin, pageBean.getLimit());

		pageBean.setList(list);

		return pageBean;
		
		
	}

	@Override
	public void update(WorkStatus t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

}
