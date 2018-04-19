package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
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

import com.lps.dao.WorkStatusDAO;
import com.lps.model.Admin;
import com.lps.model.WorkStatus;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class WorkStatusDAOImpl implements WorkStatusDAO {
	
	/**
	 * 声明员工工作状态全局常量
	 */
	public static  String WORK_STATUS = "workStatus";

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

	/**
	 * 保存员工工作状态实例
	 * @param persistentInstance 工作状态对象
	 */
	@Override
	public void save(WorkStatus persistentInstance) {
		hibernateTemplate.save(persistentInstance);
	}

	/**
	 * 删除员工工作状态持久化实例
	 * @param persistentInstance 工作状态对象
	 */
	@Override
	public void delete(WorkStatus persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载工作状态实例，根据id查找
	   *@param id 工作状态ID
	   *@return 返回加载的工作状态实例
	   */
	@Override
	public WorkStatus findById(java.io.Serializable id) {
		return hibernateTemplate.get(WorkStatus.class, id);
	}

	/**
	 * 根据指定属性查找工作状态列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkStatus> findByProperty(String propertyName, Object value) {
		String queryString = "from WorkStatus as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<WorkStatus>) queryObject.list();
	}

	/**
	 * 根据工作状态查找
	 * @return 返回工作状态
	 */
	@Override
	public List<WorkStatus> findByWorkStatus(Object workStatus) {
		return findByProperty(WORK_STATUS, workStatus);
	}

	/**
	 * 查找所有工作状态实例
	 * @return 返回工作状态集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkStatus> findAll() {
		return (List<WorkStatus>)hibernateTemplate.find("from WorkStatus");
	}

	/**
	 *统计工作状态实例个数
	 */
	@Override
	public long findAllCount() {
		String hql="select count(*) from WorkStatus";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	/**
	 * 根据id查找工作状态实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(WorkStatus entity) {
		return findById(entity.getId()) == null ? false : true;
	}

	/**
	 * 查找工作状态实例，查找个数受限于begin，limit
	 */
	@Override
	public List<WorkStatus> findListByLimit(long begin, long limit) {
		String hql="from WorkStatus";
        @SuppressWarnings("unchecked")
		List<WorkStatus> list=(List<WorkStatus>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

	/**
	 * 更新工作状态
	 */
	@Override
	public void update(WorkStatus entity) {
		hibernateTemplate.update(entity);
	}
	
	@Override
	public <K> WorkStatus findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(WorkStatus.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		WorkStatus clockCategory = new WorkStatus();
		Class<? extends WorkStatus> c = clockCategory.getClass();
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
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(WorkStatus.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

	@Override
	public void deleteAll(Collection<WorkStatus> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

}