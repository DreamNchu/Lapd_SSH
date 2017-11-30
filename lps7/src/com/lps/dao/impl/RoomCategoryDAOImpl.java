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

import com.lps.dao.RoomCategoryDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.RoomCategory;
import com.lps.model.RoomCategory;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class RoomCategoryDAOImpl  implements RoomCategoryDAO {
	public static final String ROOM_CATEGORY = "roomCategory";
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(RoomCategory transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(RoomCategory persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public RoomCategory findById(int id) {
		return hibernateTemplate.get(RoomCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomCategory> findByProperty(String propertyName, Object value) {
		String queryString = "from RoomCategory as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<RoomCategory>) queryObject.list();
	}

	@Override
	public List<RoomCategory> findByRoomCategory(Object object) {
		return findByProperty(ROOM_CATEGORY, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomCategory> findAll() {
		return (List<RoomCategory>)hibernateTemplate.find("from RoomCategory");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from RoomCategory";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(RoomCategory t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<RoomCategory> findListByLimit(long begin, long limit) {
		String hql="from RoomCategory";
        List<RoomCategory> list=(List<RoomCategory>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	@Override
	public void update(RoomCategory t) {
		hibernateTemplate.update(t);
	}
	
	@Override
	public <K> RoomCategory findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(RoomCategory.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		RoomCategory clockCategory = new RoomCategory();
		Class<? extends RoomCategory> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(RoomCategory.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

}