package com.lps.service.impl;

import java.util.List;

import com.lps.dao.RoomCategoryDAO;
import com.lps.model.User;
import com.lps.model.RoomCategory;
import com.lps.service.RoomCategoryService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class RoomCategoryServiceImpl implements RoomCategoryService {

	private RoomCategoryDAO dao;

	private PageBean<RoomCategory> pageBean;

	public PageBean<RoomCategory> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<RoomCategory> pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public void delete(RoomCategory workStatus) {
		dao.delete(workStatus);
	}

	@Override
	public List<RoomCategory> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public RoomCategory findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<RoomCategory> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<RoomCategory> findByRoomCategory(Object workStatus) {
		return dao.findByRoomCategory(workStatus);
	}

	public RoomCategoryDAO getRoomCategoryDao() {
		return dao;
	}

	@Override
	public void save(RoomCategory workStatus) {
		dao.save(workStatus);
	}

	public void setRoomCategoryDao(RoomCategoryDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	@Override
	public boolean isExists(RoomCategory user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<RoomCategory> findByPage(int page) {
		pageBean.setPage(page);

		long totalCount = findAllCount();

		pageBean.setAllCount(totalCount);

		long limit = pageBean.getLimit();

		long totalpage = (long) Math.ceil(totalCount / limit);

		pageBean.setAllPage(totalpage);
		// 每页显示的数据集合
		long begin = (page - 1) * limit;

		List<RoomCategory> list = dao.findListByLimit(begin, limit);

		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void update(RoomCategory t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

}
