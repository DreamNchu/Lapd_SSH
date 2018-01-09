package com.lps.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.RoomDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class RoomDAOImpl implements RoomDAO , BasicForServerOrderDAO<Room, Integer>{

	/**
	 * 声明房间名字全局常量
	 */
	public static final String NAME = "name";
	/**
	 * 声明房间楼层全局常量
	 */
	public static final String FLOOR = "floor";
	/**
	 * 声明房间大小全局常量
	 */
	public static final String SIZE = "size";
	/**
	 * 声明房间备注全局常量
	 */
	public static final String REMARK = "remark";
	/**
	 * 声明空闲房间全局常量
	 */
	public static final String IS_FREE = "isFree";

	/**
	 * 以私有变量的方式保存HibernateTemplate
	 */
	private HibernateTemplate hibernateTemplate;

	/**
	 * 获取HibernateTemplate实例
	 * @return HibernateTemplate实例
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * 设置HibernateTemplate实例
	 * @param hibernateTemplate 实例
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 保存房间持久化实例
	 * @param transientInstance 房间对象
	 */
	@Override
	public void save(Room transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除房间持久化实例
	 * @param persistentInstance 房间对象
	 */
	@Override
	public void delete(Room persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载房间实例，根据id查找
	   *@param id 房间ID
	   *@return 返回加载的房间实例
	   */
	@Override
	public Room findById(java.io.Serializable id) {
		return hibernateTemplate.get(Room.class, id);
	}

	/**
	 * 根据指定属性查找房间
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		String queryString = "from Room as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		
		return (List<Room>) queryObject.list();
	}
	/**
	 * 根据房间名字查找实例
	 * @return 返回房间实例
	 */
	public List<Room> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/**
	 * 根据房间楼层查找实例
	 * @return 返回房间实例
	 */
	public List<Room> findByFloor(Object floor) {
		return findByProperty(FLOOR, floor);
	}

	/**
	 * 根据房间大小查找实例
	 * @return 返回房间实例
	 */
	public List<Room> findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	/**
	 * 查找所有房间实例
	 * @return 返回房间实例集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAll() {
		return (List<Room>)hibernateTemplate.find("from Room");
	}
	
	/**
	 *统计房间实例个数
	 */
	@Override
	public long findAllCount() {
		String hql="select count(*) from Room";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	/**
	 * 根据id查找房间实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(Room user) {
		if(findById(user.getId()) != null)
			return true;;
		return false;
	}

	/**
	 * 查找房间实例，查找个数受限于begin，limit
	 */
	@Override
	public List<Room> findListByLimit(long begin, long limit) {
		String hql="from Room";
        List<Room> list=(List<Room>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	/**
	 * 更新房间
	 */
	@Override
	public void update(Room entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public List<Room> findFreeRoom() {
		return findByProperty(IS_FREE, true);
	}

	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";
	
	/**
	 * 查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(Room entity) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Room ccTemp = (Room) session.createCriteria(Room.class)
			.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
			.add(Restrictions.idEq(entity.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(Room entity, long begin, long limit) {
		String hql = "from Room cc where cc.id=?";
		HibernateCallback<List<Room>> callback = new PageHibernateCallback<Room>(hql,
				new Object[] { entity.getId() }, begin, limit);
		List<Room> temp = this.getHibernateTemplate().execute(callback);

		Set<ServerOrder> set = null;
		if (temp != null && temp.size() > 0) {
			set = temp.get(0).getServerOrders();
		}
		List<ServerOrder> list = new ArrayList<ServerOrder>(set);

		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public long findOrdersCountByThisType(Room property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.ROOM + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> Room findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Room.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		Room clockCategory = new Room();
		Class<? extends Room> c = clockCategory.getClass();
		int i = 0;
		
		for(String field: fields.keySet()){
			String str ="set" + field.substring(0,1).toUpperCase()+field.substring(1);
			try {
				c.getDeclaredMethod(str, fields.get(field)).invoke(clockCategory, list.get(i));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			i ++;
		}
		
		return clockCategory;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Room.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
	
	@Override
	public List<ServerOrder> findOrdersByDateLimit(Room u, Date begin, Date end) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.ROOM, u))
				.list();
		
		return ccTemp;
	}

	@Override
	public void deleteAll(Collection<Room> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

}
