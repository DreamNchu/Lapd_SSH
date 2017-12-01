package com.lps.service.impl;

import java.util.List;
import java.util.Set;

import com.lps.dao.RoomDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.service.RoomService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;

public class RoomServiceImpl implements RoomService {
	
	private RoomDAO dao ;
	
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
		return dao;
	}

	public void setRoomDao(RoomDAO userDao) {
		this.dao = userDao;
	}

	@Override
	public void save(Room user) {
		dao.save( user);
	}

	@Override
	public void delete(Room user) {
		dao.delete(user);
	}


	@Override
	public Room findById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public boolean isExists(Room user) {
		return dao.isExists(user);
	}


	@Override
	public List<Room> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	
	public PageBean<Room> findByPage(int page) throws PagePropertyNotInitException {
		
		
		long begin = pageRoomBean.init(findAllCount(), page);

		List<Room> list = dao.findListByLimit( begin, pageServerOrderByRoomBean.getLimit());

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
		dao.update(t);	
	}

	@Override
	public List<Room> findByName(Object name) {
		return dao.findByName(name);
	}

	@Override
	public List<Room> findByFloor(Object floor) {
		return dao.findByFloor(floor);
	}

	@Override
	public List<Room> findBySize(Object size) {
		return dao.findBySize(size);
	}

	@Override
	public List<Room> findFreeRoom() {
		return dao.findFreeRoom();
	}

	@Override
	public Set<ServerOrder> findAllOrders(Room t) {
		return dao.findAllOrders(t);
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Room t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByRoomBean.init(findOrdersCountByThisType(t), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByRoomBean.getLimit());

		pageServerOrderByRoomBean.setList(list);

		return pageServerOrderByRoomBean;
	}

	@Override
	public long findOrdersCountByThisType(Room t) {
		return dao.findOrdersCountByThisType(t);
	}

	
	@Override
	public List<ServerOrder> findTodayOrders(Room t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(Room t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(Room t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(Room t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}
	
}
