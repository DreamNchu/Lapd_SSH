package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.RoomCategoryDAO;
import com.lps.model.RoomCategory;
import com.lps.model.ServerOrder;
import com.lps.service.RoomCategoryService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class RoomCategoryServiceImpl implements RoomCategoryService {

	private RoomCategoryDAO dao;

	private PageBean<RoomCategory> pageRoomCategoryBean;
	
	public PageBean<RoomCategory> getPageRoomCategoryBean() {
		return pageRoomCategoryBean;
	}

	public void setPageRoomCategoryBean(PageBean<RoomCategory> pageRoomCategoryBean) {
		this.pageRoomCategoryBean = pageRoomCategoryBean;
	}

	private PageBean<ServerOrder> pageServerOrderByRoomCategoryBean;

	public PageBean<ServerOrder> getPageServerOrderByRoomCategoryBean() {
		return pageServerOrderByRoomCategoryBean;
	}

	public void setPageServerOrderByRoomCategoryBean(PageBean<ServerOrder> pageServerOrderByRoomCategoryBean) {
		this.pageServerOrderByRoomCategoryBean = pageServerOrderByRoomCategoryBean;
	}

	@Override
	public void delete(RoomCategory roomCategory) {
		dao.delete(roomCategory);
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
	public List<RoomCategory> findByRoomCategory(Object roomCategory) {
		return dao.findByRoomCategory(roomCategory);
	}

	public RoomCategoryDAO getRoomCategoryDao() {
		return dao;
	}

	@Override
	public void save(RoomCategory roomCategory) {
		dao.save(roomCategory);
	}

	public void setRoomCategoryDao(RoomCategoryDAO roomCategoryDao) {
		this.dao = roomCategoryDao;
	}

	@Override
	public boolean isExists(RoomCategory user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<RoomCategory> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageRoomCategoryBean.init(findAllCount(), page);

		List<RoomCategory> list = dao.findListByLimit(begin, pageRoomCategoryBean.getLimit());

		pageRoomCategoryBean.setList(list);

		return pageRoomCategoryBean;
	}

	@Override
	public void update(RoomCategory t) {
		dao.update(t);
	}

}
