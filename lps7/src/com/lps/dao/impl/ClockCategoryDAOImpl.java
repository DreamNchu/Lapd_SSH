package com.lps.dao.impl;
// default package

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.util.PageHibernateCallback;

public class ClockCategoryDAOImpl implements ClockCategoryDAO {
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
		return (List<ClockCategory>) hibernateTemplate.find("from ClockCategory");
	}

	@Override
	public long findAllCount() {
		String hql = "select count(*) from ClockCategory";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
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
}