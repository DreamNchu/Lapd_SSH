package com.lps.dao.impl;
// default package

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import com.lps.dao.ClockCategoryDAO;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class ClockCategoryDAOImpl implements ClockCategoryDAO {
	/**
	 * 声明钟点类型全局常量
	 */
	public static final String CLOCK_CATEGORY = "clockCategory";
	
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
	 * 保存钟点类型持久化实例
	 * @param persistentInstance 钟点类型对象
	 */
	@Override
	public void save(ClockCategory persistentInstance) {
		hibernateTemplate.save(persistentInstance);
	}
	/**
	 * 删除钟点类型持久化实例
	 * @param persistentInstance 钟点类型对象
	 */
	@Override
	public void delete(ClockCategory persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	 /**加载钟点类型实例，根据id查找
	   *@param id 钟点类型ID
	   *@return 返回加载的钟点类型实例
	   */
	@Override
	public ClockCategory findById(java.io.Serializable id) {
		return hibernateTemplate.get(ClockCategory.class, id);
	}

	/**
	 * 根据指定属性查找钟点类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClockCategory> findByProperty(String propertyName, Object value) {
		String queryString = "from ClockCategory as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<ClockCategory>) queryObject.list();
	}

	/**
	 * 根据钟点类型查找实例
	 * @return 返回钟点实例
	 */
	@Override
	public List<ClockCategory> findByClockCategory(Object object) {
		return findByProperty(CLOCK_CATEGORY, object);
	}

	/**
	 * 查找所有钟点类型实例
	 * @return 返回钟点实例集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ClockCategory> findAll() {
		return (List<ClockCategory>) hibernateTemplate.find("from ClockCategory");
	}
/**
 *统计钟点类型实例个数
 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from ClockCategory";
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	/**
	 * 根据id查找钟点类型实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(ClockCategory entity) {
		return findById(entity.getId()) == null ? false : true;
	}

	/**
	 * 查找钟点类型实例，查找个数受限于begin，limit
	 */
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
/**
 * 更新钟点类型实例
 */
	@Override
	public void update(ClockCategory entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";

	/**
	 * 根据钟点类型查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(ClockCategory cc) {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		ClockCategory ccTemp = (ClockCategory) session.createCriteria(ClockCategory.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(cc.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}
/**
 * 根据钟点类型查找订单，查找个数受限于begin，limit
 */
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
/**
 * 根据指定钟点类型查找订单数量，返回订单列表
 */
	@Override
	public long findOrdersCountByThisType(ClockCategory cc) {
		
		String hql = "select count(*) from ServerOrder model where model." 
		+ ServerOrderDAOImpl.CLOCK_CATEGORY + "=" + cc.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
		
	}
	

	@Override
	public <K> ClockCategory findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ClockCategory.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
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
	public <K> List<K> findByProperty(Map<String, Object> map) {
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

	@Override
	public void deleteAll(Collection<ClockCategory> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}
	
}