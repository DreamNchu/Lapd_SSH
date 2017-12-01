package com.lps.dao.impl;
// default package

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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.PayPath;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class ClockCategoryDAOImpl implements ClockCategoryDAO {
	public static final String CLOCK_CATEGORY = "clockCategory";
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
		return findByProperty(CLOCK_CATEGORY, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClockCategory> findAll() {
		return (List<ClockCategory>) hibernateTemplate.find("from ClockCategory");
	}

	@Override
	public long findAllCount() {
		String hql = "select count(*) from ClockCategory";
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	@Override
	public boolean isExists(ClockCategory t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<ClockCategory> findListByLimit(long begin, long limit) {
		String hql = "from ClockCategory";
		List<ClockCategory> list = (List<ClockCategory>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void update(ClockCategory t) {
		hibernateTemplate.update(t);
	}

	public static final String SERVER_ORDER = "serverOrders";

	@Override
	public Set<ServerOrder> findAllOrders(ClockCategory cc) {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		ClockCategory ccTemp = (ClockCategory) session.createCriteria(ClockCategory.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(cc.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(ClockCategory cc, long begin, long limit) {
		String hql = "from ClockCategory cc where cc.id=?";

		HibernateCallback<List<ClockCategory>> callback = new PageHibernateCallback<ClockCategory>(hql,
				new Object[] { cc.getId() }, begin, limit);
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

	@Override
	public long findOrdersCountByThisType(ClockCategory cc) {
		
		String hql = "select count(*) from ServerOrder model where model." 
		+ ServerOrderDAOImpl.CLOCK_CATEGORY + "=" + cc.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
		
	}
	

	@Override
	public <K> ClockCategory findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ClockCategory.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		ClockCategory clockCategory = new ClockCategory();
		Class<? extends ClockCategory> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(ClockCategory.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
	
	@Override
	public List<ServerOrder> findOrdersByDateLimit(ClockCategory cc, Date begin, Date end) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.CLOCK_CATEGORY, cc))
				.list();
		
		return ccTemp;
	}
	
}