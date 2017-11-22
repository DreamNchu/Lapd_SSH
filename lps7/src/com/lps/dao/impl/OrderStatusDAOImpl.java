package com.lps.dao.impl;
// default package

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.OrderStatusDAO;
import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.model.OrderStatus;
import com.lps.util.PageHibernateCallback;

public class OrderStatusDAOImpl implements OrderStatusDAO {
	// property constants
	public static final String WORK_STATUS = "workStatus";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(OrderStatus transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(OrderStatus persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public OrderStatus findById(int id) {
		return hibernateTemplate.get(OrderStatus.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> findByProperty(String propertyName, Object value) {
		String queryString = "from OrderStatus as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<OrderStatus>) queryObject.list();
	}

	@Override
	public List<OrderStatus> findByOrderStatus(Object workStatus) {
		return findByProperty(WORK_STATUS, workStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> findAll() {
		return (List<OrderStatus>)hibernateTemplate.find("from OrderStatus");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from OrderStatus";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(OrderStatus t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<OrderStatus> findListByLimit(long begin, long limit) {
		String hql="from OrderStatus";
        @SuppressWarnings("unchecked")
		List<OrderStatus> list=(List<OrderStatus>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

	@Override
	public void update(OrderStatus t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}

}