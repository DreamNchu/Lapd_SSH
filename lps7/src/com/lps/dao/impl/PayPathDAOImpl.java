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

import com.lps.dao.PayPathDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.PayPath;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class PayPathDAOImpl implements PayPathDAO, BasicForServerOrderDAO<PayPath, Integer> {
	public static final String PAY_PATH = "payPath";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(PayPath transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(PayPath persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public PayPath findById(int id) {
		return hibernateTemplate.get(PayPath.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findByProperty(String propertyName, Object value) {
		String queryString = "from PayPath as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<PayPath>) queryObject.list();
	}

	@Override
	public List<PayPath> findByPayPath(Object payPath) {
		return findByProperty(PAY_PATH, payPath);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findAll() {
		return (List<PayPath>) hibernateTemplate.find("from PayPath");
	}

	@Override
	public long findAllCount() {
		String hql = "select count(*) from PayPath";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	@Override
	public boolean isExists(PayPath t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<PayPath> findListByLimit(long begin, long limit) {
		String hql = "from PayPath";
		List<PayPath> list = (List<PayPath>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	@Override
	public void update(PayPath t) {
		hibernateTemplate.update(t);
	}

	public static final String SERVER_ORDER = "serverOrders";

	@Override
	public Set<ServerOrder> findAllOrders(PayPath t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		PayPath ccTemp = (PayPath) session.createCriteria(PayPath.class).setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(PayPath t, long begin, long limit) {
		String hql = "from PayPath cc where cc.id=?";
		HibernateCallback<List<PayPath>> callback = new PageHibernateCallback<PayPath>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<PayPath> temp = this.getHibernateTemplate().execute(callback);

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
	public long findOrdersCountByThisType(PayPath property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.PAY_PATH + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> PayPath findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(PayPath.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		PayPath clockCategory = new PayPath();
		Class<? extends PayPath> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(PayPath.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
	
}