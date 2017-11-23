package com.lps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.WorkRankDAO;
import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.util.PageHibernateCallback;

public class WorkRankDAOImpl implements WorkRankDAO {

	public static final String RANK = "rank";
	public static final String USER = "user";
	public static final String RANK_NUM = "rankNum";
	public static final String SPOT_NUM = "spotNum";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(WorkRank transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(WorkRank persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public WorkRank findById(int id) {
		return hibernateTemplate.get(WorkRank.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkRank> findByProperty(String propertyName, Object value) {
		String queryString = "from WorkRank as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);

		return (List<WorkRank>) queryObject.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WorkRank> findAll() {
		return (List<WorkRank>) hibernateTemplate.find("from WorkRank");
	}

	@Override
	public long findAllCount() {
		String hql = "select count(*) from WorkRank";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	@Override
	public boolean isExists(WorkRank user) {
		if (findById(user.getId()) != null)
			return true;
		;
		return false;
	}

	@Override
	public List<WorkRank> findListByLimit(long begin, long limit) {
		String hql = "from WorkRank";
		List<WorkRank> list = (List<WorkRank>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	@Override
	public void update(WorkRank t) {
		hibernateTemplate.update(t);
	}

	@Override
	public List<WorkRank> findByUser(User user) {
		return findByProperty(USER, user);
	}

	@Override
	public List<WorkRank> findByRank(int num) {
		return findByProperty(RANK, num);
	}

	@Override
	public List<WorkRank> findByRankNum(int num) {
		return findByProperty(RANK_NUM, num);
	}

	@Override
	public List<WorkRank> findBySpotNum(int num) {
		return findByProperty(SPOT_NUM, num);
	}

}
