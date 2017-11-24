package com.lps.service.impl;

import java.util.List;

import com.lps.dao.RoomDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.service.RoomService;
import com.lps.util.PageBean;

public class RoomServiceImpl implements RoomService {
	
	private RoomDAO roomDao ;
	
	private PageBean<Room> pageBean;

	public PageBean<Room> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Room> pageBean) {
		this.pageBean = pageBean;
	}

	public RoomDAO getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDAO userDao) {
		this.roomDao = userDao;
	}

	@Override
	public void save(Room user) {
		roomDao.save( user);
	}

	@Override
	public void delete(Room user) {
		roomDao.delete(user);
	}


	@Override
	public Room findById(int id) {
		return roomDao.findById(id);
	}
	
	@Override
	public boolean isExists(Room user) {
		return roomDao.isExists(user);
	}


	@Override
	public List<Room> findAll() {
		return roomDao.findAll();
	}

	@Override
	public long findAllCount() {
		return roomDao.findAllCount();
	}

	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		return roomDao.findByProperty(propertyName, value);
	}

	
	public PageBean<Room> findByPage(int page) {
        pageBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageBean.setAllCount(totalCount);
        
        long limit  = pageBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageBean.setAllPage(totalpage);
        //ÿҳ��ʾ�����ݼ���
        long begin=(page-1) * limit;
        
        List<Room> list = roomDao.findListByLimit(begin, limit);
        
        pageBean.setList(list);
        
        return pageBean;
    }

	@Override
	public void update(Room t) {
		roomDao.update(t);	
	}

	@Override
	public List<Room> findByName(Object name) {
		return roomDao.findByName(name);
	}

	@Override
	public List<Room> findByFloor(Object floor) {
		return roomDao.findByFloor(floor);
	}

	@Override
	public List<Room> findBySize(Object size) {
		return roomDao.findBySize(size);
	}

	@Override
	public List<Room> findFreeRoom() {
		return roomDao.findFreeRoom();
	}

}
