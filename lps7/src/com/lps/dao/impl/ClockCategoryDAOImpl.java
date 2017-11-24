package com.lps.dao.impl;
// default package

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.util.PageHibernateCallback;

public class ClockCategoryDAOImpl  implements ClockCategoryDAO{
	public static final String ROOM_CATEGORY = "roomCategory";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(ClockCategory transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(ClockCategory persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public ClockCategory findById(int id) {
		return hibernateTemplate.get(ClockCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClockCategory> findByProperty(String propertyName, Object value) {
		String queryString = "from ClockCategory as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<ClockCategory>) queryObject.list();
	}

	@Override
	public List<ClockCategory> findByClockCategory(Object object) {
		return findByProperty(ROOM_CATEGORY, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClockCategory> findAll() {
		return (List<ClockCategory>)hibernateTemplate.find("from ClockCategory");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from ClockCategory";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(ClockCategory t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<ClockCategory> findListByLimit(long begin, long limit) {
		String hql="from ClockCategory";
        List<ClockCategory> list=(List<ClockCategory>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	@Override
	public void update(ClockCategory t) {
		hibernateTemplate.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrderByClockCategory(ClockCategory cc) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		ClockCategory ccTemp = hibernateTemplate.get(ClockCategory.class, cc.getId());
//		Set<ServerOrder> sos = ccTemp.getServerOrders();
		
		ClockCategory ccTemp = (ClockCategory) session.get(ClockCategory.class, cc.getId());
		Set<ServerOrder> sos =  (Set<ServerOrder>)ccTemp.getServerOrders(); 
		
		return sos;
	}

	@Override
	public List<ServerOrder> findOrderByClockCategory(ClockCategory cc, long begin, long limit) {
		String hql="from ClockCategory cc where cc.id=:id";
		HibernateCallback<List<ServerOrder>> callback =  new PageHibernateCallback<ServerOrder>(hql, new Object[]{cc.getId()}, begin, limit);
        List<ServerOrder> list=(List<ServerOrder>) this.getHibernateTemplate().execute(callback);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}
}