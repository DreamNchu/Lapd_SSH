package com.lps.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import com.lps.model.OrderStatus;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class RoomDAOImpl implements RoomDAO , BasicForServerOrderDAO<Room, Integer>{

	public static final String NAME = "name";
	public static final String FLOOR = "floor";
	public static final String SIZE = "size";
	public static final String REMARK = "remark";
	public static final String IS_FREE = "isFree";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(Room transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(Room persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public Room findById(int id) {
		return hibernateTemplate.get(Room.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findByProperty(String propertyName, Object value) {
		String queryString = "from Room as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		
		return (List<Room>) queryObject.list();
	}
	public List<Room> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Room> findByFloor(Object floor) {
		return findByProperty(FLOOR, floor);
	}

	public List<Room> findBySize(Object size) {
		return findByProperty(SIZE, size);
	}


	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAll() {
		return (List<Room>)hibernateTemplate.find("from Room");
	}
	
	@Override
	public long findAllCount() {
		String hql="select count(*) from Room";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(Room user) {
		if(findById(user.getId()) != null)
			return true;;
		return false;
	}

	@Override
	public List<Room> findListByLimit(long begin, long limit) {
		String hql="from Room";
        List<Room> list=(List<Room>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	@Override
	public void update(Room t) {
		hibernateTemplate.update(t);
	}

	@Override
	public List<Room> findFreeRoom() {
		return findByProperty(IS_FREE, true);
	}

	public static final String SERVER_ORDER = "serverOrders";
	@Override
	public Set<ServerOrder> findAllOrders(Room t) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Room ccTemp = (Room) session.createCriteria(Room.class)
			.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
			.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(Room t, long begin, long limit) {
		String hql = "from Room cc where cc.id=?";
		HibernateCallback<List<Room>> callback = new PageHibernateCallback<Room>(hql,
				new Object[] { t.getId() }, begin, limit);
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
	public <K> Room findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Room.class)
			.add(Restrictions.idEq(t.getId()));
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
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
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

}
