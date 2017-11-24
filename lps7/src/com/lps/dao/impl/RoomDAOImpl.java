package com.lps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.RoomDAO;
import com.lps.model.Admin;
import com.lps.model.Room;
import com.lps.util.PageHibernateCallback;

public class RoomDAOImpl implements RoomDAO {

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

}
