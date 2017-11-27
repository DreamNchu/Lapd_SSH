package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.RoomDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.service.RoomService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class RoomServiceImpl implements RoomService {
	
	private RoomDAO roomDao ;
	
	private PageBean<Room> pageRoomBean;
	
	public PageBean<Room> getPageRoomBean() {
		return pageRoomBean;
	}

	public void setPageRoomBean(PageBean<Room> pageRoomBean) {
		this.pageRoomBean = pageRoomBean;
	}

	private PageBean<ServerOrder> pageServerOrderByRoomBean;


	public PageBean<ServerOrder> getPageServerOrderByRoomBean() {
		return pageServerOrderByRoomBean;
	}

	public void setPageServerOrderByRoomBean(PageBean<ServerOrder> pageServerOrderByRoomBean) {
		this.pageServerOrderByRoomBean = pageServerOrderByRoomBean;
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

	
	public PageBean<Room> findByPage(int page) throws PagePropertyNotInitException {
		
		
		long begin = pageRoomBean.init(findAllCount(), page);

		List<Room> list = roomDao.findListByLimit( begin, pageServerOrderByRoomBean.getLimit());

		pageRoomBean.setList(list);

		return pageRoomBean;
		
		
		
/*        pageRoomBean.init(allCount, page)
        
        long totalCount= findAllCount();
        
        pageRoomBean.setAllCount(totalCount);
        
        long limit  = pageRoomBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageRoomBean.setAllPage(totalpage);
        //ÿҳ��ʾ�����ݼ���
        long begin=(page-1) * limit;
        
        List<Room> list = roomDao.findListByLimit(begin, limit);
        
        pageRoomBean.setList(list);
        
        return pageRoomBean;*/
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

	@Override
	public Set<ServerOrder> findAllOrders(Room t) {
		return roomDao.findAllOrders(t);
	}

	@Override
	public PageBean<ServerOrder> findOrdersByPage(Room t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByRoomBean.init(findOrdersCountByThisType(t), page);

		List<ServerOrder> list = roomDao.findOrdersWithLimit(t, begin, pageServerOrderByRoomBean.getLimit());

		pageServerOrderByRoomBean.setList(list);

		return pageServerOrderByRoomBean;
	}

	@Override
	public long findOrdersCountByThisType(Room t) {
		return roomDao.findOrdersCountByThisType(t);
	}

}
