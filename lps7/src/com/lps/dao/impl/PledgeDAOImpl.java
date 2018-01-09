package com.lps.dao.impl;
// default package

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

import com.lps.dao.PledgeDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.Pledge;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class PledgeDAOImpl  implements PledgeDAO, BasicForServerOrderDAO<Pledge, Integer>{
	/**
	 * 声明抵押物品名全局常量
	 */
	public static final String PLEDGE = "name";
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
	 * 保存抵押物持久化实例
	 * @param transientInstance 抵押物对象
	 */
	@Override
	public void save(Pledge transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除抵押物持久化实例
	 * @param persistentInstance 抵押物对象
	 */
	@Override
	public void delete(Pledge persistentInstance) {
		
		hibernateTemplate.delete(persistentInstance);
		
	}

	/**加载抵押物实例，根据id查找
	   *@param id 抵押物ID
	   *@return 返回加载的抵押物实例
	   */
	@Override
	public Pledge findById(java.io.Serializable id) {
		return hibernateTemplate.get(Pledge.class, id);
	}

	
	/**
	 * 根据指定属性查找抵押物列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pledge> findByProperty(String propertyName, Object value) {
		String queryString = "from Pledge as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<Pledge>) queryObject.list();
	}

	/**
	 * 根据抵押物名字查找实例
	 * @return 返回抵押物实例
	 */
	@Override
	public List<Pledge> findByName(Object name) {
		return findByProperty(PLEDGE, name);
	}

	/**
	 * 查找所有抵押物品实例
	 * @return 返回抵押物品集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pledge> findAll() {
		return (List<Pledge>)hibernateTemplate.find("from Pledge");
	}

	/**
	 *统计抵押物品实例个数
	 */
	@Override
	public long findAllCount() {
		String hql="select count(*) from Pledge";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	/**
	 * 根据id查找抵押物实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(Pledge entity) {
		return findById(entity.getId()) == null ? false : true;
	}

	/**
	 * 查找抵押物品实例，查找个数受限于begin，limit
	 */
	@Override
	public List<Pledge> findListByLimit(long begin, long limit) {
		String hql="from Pledge";
        List<Pledge> list=(List<Pledge>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	/**
	 * 更新抵押物
	 */
	@Override
	public void update(Pledge entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";
	
	/**
	 * 根据抵押物查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(Pledge entity) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Pledge ccTemp = (Pledge) session.createCriteria(Pledge.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(entity.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	/**
	 * 根据抵押物查找订单，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerOrder> findOrdersWithLimit(Pledge entity, long begin, long limit) {
		String hql = "from Pledge cc where cc.id=?";
		HibernateCallback<List<Pledge>> callback = new PageHibernateCallback<Pledge>(hql,
				new Object[] { entity.getId() }, begin, limit);
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

	/**
	 * 根据指定抵押物查找订单数量，返回订单列表
	 */
	@Override
	public long findOrdersCountByThisType(Pledge property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.PLEDGE + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> Pledge findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Pledge.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
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
	public <K> List<K> findByProperty(Map<String, Object> map) {
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
	
	@Override
	public List<ServerOrder> findOrdersByDateLimit(Pledge p, Date begin, Date end) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.PLEDGE, p))
				.list();
		
		return ccTemp;
	}

	@Override
	public void deleteAll(Collection<Pledge> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}
	
}