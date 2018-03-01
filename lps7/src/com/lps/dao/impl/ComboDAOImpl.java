package com.lps.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.ComboDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.Combo;
import com.lps.model.Medicine;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class ComboDAOImpl implements ComboDAO{
	
	/**
	 * 声明钟点类型全局常量
	 */
	public static final String COMBO = "combo";
	
	/**
	 * 以私有变量的方式保存HibernateTemplate
	 */
	private HibernateTemplate hibernateTemplate;

	/**
	 * 获取HibernateTemplate实例
	 * @return HibernateTemplate实例
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * 设置HibernateTemplate实例
	 * @param hibernateTemplate 实例
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void save(Combo entity) {
		hibernateTemplate.save(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Combo entity) {
		hibernateTemplate.delete(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Combo> entities) {
		hibernateTemplate.deleteAll(entities);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Combo findById(java.io.Serializable id) {
		return hibernateTemplate.get(Combo.class, id);
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isExists(Combo entity) {
		return findById(entity.getId()) == null ? false : true;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Combo> findByProperty(String propertyName, Object value) {
		String queryString = "from Combo as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<Combo>) queryObject.list();
		// TODO Auto-generated method stub
	}

	@Override
	public List<Combo> findAll() {
		return (List<Combo>) hibernateTemplate.find("from Combo");
		// TODO Auto-generated method stub

	}

	@Override
	public long findAllCount() {
		String hql = "select count(*) from Combo";
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Combo> findListByLimit(long begin, long limit) {
		String hql = "from ClockCategory";
		List<Combo> list = (List<Combo>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Combo entity) {
		hibernateTemplate.update(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> Combo findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Combo.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		Combo combo = new Combo();
		Class<? extends Combo> c = combo.getClass();
		int i = 0;
		
		for(String field: fields.keySet()){
			String str ="set" + field.substring(0,1).toUpperCase()+field.substring(1);
			try {
				c.getDeclaredMethod(str, fields.get(field)).invoke(combo, list.get(i));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			i ++;
		}
		
		return combo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Combo.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Combo> findByCombo(Object combo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ServerOrder> findAllOrders(Combo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findOrdersCountByThisType(Combo property) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(Combo t, long begin, long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> findOrdersByDateLimit(Combo t, Date begin, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
