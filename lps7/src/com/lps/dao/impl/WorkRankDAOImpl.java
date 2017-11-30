package com.lps.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.WorkRankDAO;
import com.lps.model.Admin;
import com.lps.model.WorkRank;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.basic.BasicModel;
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
	
	@Override
	public <K> WorkRank findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(WorkRank.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		WorkRank clockCategory = new WorkRank();
		Class<? extends WorkRank> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(WorkRank.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

}
