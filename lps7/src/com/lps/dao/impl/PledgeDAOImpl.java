package com.lps.dao.impl;
// default package

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.PledgeDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.Pledge;
import com.lps.model.ServerOrder;
import com.lps.util.PageHibernateCallback;

public class PledgeDAOImpl  implements PledgeDAO, BasicForServerOrderDAO<Pledge, Integer>{
	public static final String NAME = "name";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(Pledge transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(Pledge persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public Pledge findById(int id) {
		return hibernateTemplate.get(Pledge.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pledge> findByProperty(String propertyName, Object value) {
		String queryString = "from Pledge as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<Pledge>) queryObject.list();
	}

	@Override
	public List<Pledge> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pledge> findAll() {
		return (List<Pledge>)hibernateTemplate.find("from Pledge");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from Pledge";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(Pledge t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<Pledge> findListByLimit(long begin, long limit) {
		String hql="from Pledge";
        List<Pledge> list=(List<Pledge>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	@Override
	public void update(Pledge t) {
		hibernateTemplate.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(Pledge t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		OrderStatus ccTemp = (OrderStatus) session.get(OrderStatus.class, t.getId());
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(Pledge t, long begin, long limit) {
		String hql = "from Pledge cc where cc.id=?";
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