package com.lps.dao.impl;
// default package

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.RoomCategoryDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.RoomCategory;
import com.lps.model.ServerOrder;
import com.lps.util.PageHibernateCallback;

public class RoomCategoryDAOImpl  implements RoomCategoryDAO, BasicForServerOrderDAO<RoomCategory, Integer>{
	public static final String ROOM_CATEGORY = "roomCategory";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(RoomCategory transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(RoomCategory persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public RoomCategory findById(int id) {
		return hibernateTemplate.get(RoomCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomCategory> findByProperty(String propertyName, Object value) {
		String queryString = "from RoomCategory as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<RoomCategory>) queryObject.list();
	}

	@Override
	public List<RoomCategory> findByRoomCategory(Object object) {
		return findByProperty(ROOM_CATEGORY, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomCategory> findAll() {
		return (List<RoomCategory>)hibernateTemplate.find("from RoomCategory");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from RoomCategory";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(RoomCategory t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<RoomCategory> findListByLimit(long begin, long limit) {
		String hql="from RoomCategory";
        List<RoomCategory> list=(List<RoomCategory>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	@Override
	public void update(RoomCategory t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(RoomCategory t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		OrderStatus ccTemp = (OrderStatus) session.get(OrderStatus.class, t.getId());
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(RoomCategory t, long begin, long limit) {
		String hql = "from RoomCategory cc where cc.id=?";
		HibernateCallback<List<ClockCategory>> callback = new PageHibernateCallback<ClockCategory>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<ClockCategory> temp = this.getHibernateTemplate().execute(callback);

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
}