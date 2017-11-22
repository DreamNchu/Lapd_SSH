package com.lps.service.impl;

import java.util.List;

import com.lps.dao.RoomDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.service.RoomService;
import com.lps.util.PageBean;

public class RoomServiceImpl implements RoomService {
	
	private RoomDAO userDao ;
	
	private PageBean<Room> pageBean;

	public PageBean<Room> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Room> pageBean) {
		this.pageBean = pageBean;
	}

	public RoomDAO getRoomDao() {
		return userDao;
	}

	public void setRoomDao(RoomDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(Room user) {
		userDao.save( user);
	}

	@Override
	public void delete(Room user) {
		userDao.delete(user);
	}


	@Override
	public Room findById(int id) {
		return userDao.findById(id);
	}
	
	@Override
	public boolean isExists(Room user) {
		return userDao.isExists(user);
	}


	@Override
	public List<Room> findAll() {
		return userDao.findAll();
	}

	@Override
	public long findAllCount() {
		return userDao.findAllCount();
	}

	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		return userDao.findByProperty(propertyName, value);
	}

	
	public PageBean<Room> findByPage(int page) {
        pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //每页显示的数据集合
        long begin=(page-1) * limit;
        
        List<Room> list = userDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
    }

	@Override
	public void update(Room t) {
		userDao.update(t);	
	}

	@Override
	public List<Room> findByName(Object name) {
		return userDao.findByName(name);
	}

	@Override
	public List<Room> findByFloor(Object floor) {
		return userDao.findByFloor(floor);
	}

	@Override
	public List<Room> findBySize(Object size) {
		return userDao.findBySize(size);
	}


}
