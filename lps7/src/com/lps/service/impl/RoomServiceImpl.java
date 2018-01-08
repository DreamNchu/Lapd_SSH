package com.lps.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.RoomDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.Room;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.RoomService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

public class RoomServiceImpl implements RoomService {
	
	/**
	 * 以私有变量的方式保存RoomDAO
	 */
	private RoomDAO dao ;
	
	/**
	 * 将RoomDAO实体类封装到pagebean中
	 */
	private PageBean<Room> pageRoomBean;
	
	/**
	 * 根据房间得到的ServerOrder实体类封装到pagebean中
	 */
	/**
	 * 获取pagebean中Room实体类集合
	 * @return 返回实体类
	 */
	public PageBean<Room> getPageRoomBean() {
		return pageRoomBean;
	}

	/**
	 * 设置Room实体类集合
	 * @param pageRoomBean 封装的Room实体类集合
	 */
	public void setPageRoomBean(PageBean<Room> pageRoomBean) {
		this.pageRoomBean = pageRoomBean;
	}

	private PageBean<ServerOrder> pageServerOrderByRoomBean;


	public PageBean<ServerOrder> getPageServerOrderByRoomBean() {
		return pageServerOrderByRoomBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByRoomBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByRoomBean(PageBean<ServerOrder> pageServerOrderByRoomBean) {
		this.pageServerOrderByRoomBean = pageServerOrderByRoomBean;
	}

	/**
	 * 获取RoomDao实例
	 * @return 返回RoomDao实例
	 */
	public RoomDAO getRoomDao() {
		return dao;
	}

	/**
	 * 设置roomDao实例
	 * @param roomDao
	 */
	public void setRoomDao(RoomDAO roomDao) {
		this.dao = roomDao;
	}

	@Override
	public void save(Room user) {
		dao.save( user);
	}

	@Override
	public void delete(Room user) {
		dao.delete(user);
	}

	/**
	 * 根据id查找房间，返回Room实例
	 */
	@Override
	public Room findById(java.io.Serializable id) throws FindByIdGetNullException {
		Room room = dao.findById(id);
		if(room == null){
			throw new FindByIdGetNullException("根据主键id未找到房间对象");
		}
		return dao.findById(id);
	}
	
	/**
	 * 根据id查找Room实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(Room user) {
		return dao.isExists(user);
	}


	/**
	 * 返回所有Room实例
	 */
	@Override
	public List<Room> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有Room实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据指定属性及其属性值查找Room实例，返回指定Room实例
	 */
	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 根据页面查找页面内所有房间
	 */
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

	/**
	 * 更新Room实例
	 */
	@Override
	public void update(Room entity) {
		dao.update(entity);	
	}

	/**
	 * 根据房间name属性查找，返回Room实例
	 */
	@Override
	public List<Room> findByName(Object name) {
		return dao.findByName(name);
	}

	/**
	 * 根据房间floor属性查找，返回Room实例
	 */
	@Override
	public List<Room> findByFloor(Object floor) {
		return dao.findByFloor(floor);
	}

	/**
	 * 根据房间size属性查找，返回Room实例
	 */
	@Override
	public List<Room> findBySize(Object size) {
		return dao.findBySize(size);
	}
	/**
	 * 查找空闲房间，并返回空闲房间
	 */
	@Override
	public List<Room> findFreeRoom() {
		return dao.findFreeRoom();
	}

	/**
	 * 返回指定房间的所有服务订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(Room entity) {
		return dao.findAllOrders(entity);
	}

	/**
	 * 查找指定页面内根据房间得到的所有订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Room entity, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByRoomBean.init(findOrdersCountByThisType(entity), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(entity, begin, pageServerOrderByRoomBean.getLimit());

		pageServerOrderByRoomBean.setList(list);

		return pageServerOrderByRoomBean;
	}

	/**
	 * 根据指定房间类型查找订单数量
	 */
	@Override
	public long findOrdersCountByThisType(Room entity) {
		return dao.findOrdersCountByThisType(entity);
	}

	/**
	 * 查找今天的订单
	 */
	@Override
	public List<ServerOrder> findTodayOrders(Room entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	/**
	 * 查找前七天的订单
	 */
	@Override
	public List<ServerOrder> findBefore7DayOrders(Room entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找这个月的订单
	 */
	@Override
	public List<ServerOrder> findThisMonthOrders(Room entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找今年的订单
	 */
	@Override
	public List<ServerOrder> findThisYearOrders(Room entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

	@Override
	public <K> Room findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFields(entity, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}
	@Override
	public PropertyRange<Room> createProRangeForOrder(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<Room> pr = new PropertyRange<>();
		
		pr.setName(ServerOrderDAOImpl.ROOM);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<Room> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}
}
