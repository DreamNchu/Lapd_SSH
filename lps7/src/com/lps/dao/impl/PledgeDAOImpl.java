package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import com.lps.dao.PledgeDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.Pledge;
import com.lps.model.Pledge;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class PledgeDAOImpl  implements PledgeDAO, BasicForServerOrderDAO<Pledge, Integer>{
	public static final String PLEDGE = "name";
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
		return findByProperty(PLEDGE, name);
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

	public static final String SERVER_ORDER = "serverOrders";
	@Override
	public Set<ServerOrder> findAllOrders(Pledge t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Pledge ccTemp = (Pledge) session.createCriteria(Pledge.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(Pledge t, long begin, long limit) {
		String hql = "from Pledge cc where cc.id=?";
		HibernateCallback<List<Pledge>> callback = new PageHibernateCallback<Pledge>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<Pledge> temp = this.getHibernateTemplate().execute(callback);

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
	public long findOrdersCountByThisType(Pledge property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.PLEDGE + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> Pledge findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Pledge.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		Pledge clockCategory = new Pledge();
		Class<? extends Pledge> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(Pledge.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
}