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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.OrderStatusDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;
import com.lps.util.PropertyRange;

public class OrderStatusDAOImpl implements OrderStatusDAO, BasicForServerOrderDAO<OrderStatus, Integer> {
	// property constants
	/**
	 * 声明订单状态全局常量
	 */
	public static final String ORDER_STATUS = "orderStatus";

	/**
	 * 以私有变量的方式保存HibernateTemplate
	 */
	private HibernateTemplate hibernateTemplate;

	/**
	 * 获取HibernateTemplate实例
	 * 
	 * @return HibernateTemplate实例
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * 设置HibernateTemplate实例
	 * 
	 * @param hibernateTemplate
	 *            实例
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 保存订单状态持久化实例
	 * 
	 * @param transientInstance
	 *            订单状态对象
	 */
	@Override
	public void save(OrderStatus transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除订单状态持久化实例
	 * 
	 * @param persistentInstance
	 *            订单状态对象
	 */
	@Override
	public void delete(OrderStatus persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**
	 * 加载订单状态实例，根据id查找
	 * 
	 * @param id
	 *            订单状态ID
	 * @return 返回加载的订单状态实例
	 */
	@Override
	public OrderStatus findById(java.io.Serializable id) {
		return hibernateTemplate.get(OrderStatus.class, id);
	}

	/**
	 * 根据指定属性查找订单状态列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> findByProperty(String propertyName, Object value) {
		String queryString = "from OrderStatus as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<OrderStatus>) queryObject.list();
	}

	/**
	 * 根据订单状态查找实例
	 * 
	 * @return 返回订单状态实例
	 */
	@Override
	public List<OrderStatus> findByOrderStatus(Object orderStatus) {
		return findByProperty(ORDER_STATUS, orderStatus);
	}

	/**
	 * 查找所有订单状态实例
	 * 
	 * @return 返回订单状态集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> findAll() {
		return (List<OrderStatus>) hibernateTemplate.find("from OrderStatus");
	}

	/**
	 * 统计订单状态实例个数
	 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from OrderStatus";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	/**
	 * 根据id查找订单状态实例是否存在
	 * 
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(OrderStatus t) {
		return findById(t.getId()) == null ? false : true;
	}

	/**
	 * 查找订单状态实例，查找个数受限于begin，limit
	 */
	@Override
	public List<OrderStatus> findListByLimit(long begin, long limit) {
		String hql = "from OrderStatus";
		@SuppressWarnings("unchecked")
		List<OrderStatus> list = (List<OrderStatus>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 更新订单状态
	 */
	@Override
	public void update(OrderStatus t) {
		hibernateTemplate.update(t);
	}

	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";

	/**
	 * 根据订单状态查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(OrderStatus t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		OrderStatus ccTemp = (OrderStatus) session.createCriteria(OrderStatus.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN).add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	/**
	 * 根据订单状态查找订单，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerOrder> findOrdersWithLimit(OrderStatus t, long begin, long limit) {
		String hql = "from OrderStatus cc where cc.id=?";
		HibernateCallback<List<OrderStatus>> callback = new PageHibernateCallback<OrderStatus>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<OrderStatus> temp = this.getHibernateTemplate().execute(callback);

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
	 * 根据指定订单状态查找订单数量，返回订单列表
	 */
	@Override
	public long findOrdersCountByThisType(OrderStatus property) {

		String hql = "select count(*) from ServerOrder model where model." + ServerOrderDAOImpl.ORDER_STATUS + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);

	}

	@Override
	public <K> OrderStatus findFieldsByModel(BasicModel t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(OrderStatus.class).add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();

		for (String field : fields.keySet()) {
			proList.add(Projections.groupProperty(field));
		}
		// 设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();

		OrderStatus clockCategory = new OrderStatus();
		Class<? extends OrderStatus> c = clockCategory.getClass();
		int i = 0;

		for (String field : fields.keySet()) {
			String str = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
			try {
				c.getDeclaredMethod(str, fields.get(field)).invoke(clockCategory, list.get(i));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			i++;
		}

		return clockCategory;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(OrderStatus.class);

		for (String field : map.keySet()) {
			cri.add(Restrictions.eq(field, map.get(field)));
		}

		cri.setProjection(Projections.id());

		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();

		return listIds;
	}



	@Override
	public List<ServerOrder> findOrdersByDateLimit(OrderStatus os, Date begin, Date end) {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>) session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.ORDER_STATUS, os)).list();

		return ccTemp;
	}

	@Override
	public void deleteAll(Collection<OrderStatus> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);		
	}

}