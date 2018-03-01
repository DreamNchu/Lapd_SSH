package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.ServerOrderDAO;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.uenum.CompareLevel;
import com.lps.util.PageHibernateCallback;
import com.lps.util.PropertyRange;

public class ServerOrderDAOImpl implements ServerOrderDAO {
	/**
	 * 声明付费方式全局常量
	 */
	public static final String PAY_PATH = "payPath";
	/**
	 * 声明房间全局常量
	 */
	public static final String ROOM = "room";
	/**
	 * 声明用户名全局常量
	 */
	public static final String USER = "user";
	/**
	 * 声明抵押物全局常量
	 */
	public static final String PLEDGE = "pledge";
	/**
	 * 声明钟点类型全局常量
	 */
	public static final String CLOCK_CATEGORY = "clockCategory";
	/**
	 * 声明订单状态全局常量
	 */
	public static final String ORDER_STATUS = "orderStatus";
	/**
	 * 声明实际支付全局常量
	 */
	public static final String REAL_PAY = "realPay";
	/**
	 * 声明消费全局常量
	 */
	public static final String PAY = "pay";
	/**
	 * 声明订单发起时间全局常量
	 */
	public static final String INIT_TIME = "initTime";
	/**
	 * 声明订单接受时间全局常量
	 */
	public static final String RECEIVE_TIME = "receiveTime";
	/**
	 * 声明订单完成时间全局常量
	 */
	public static final String FINISH_TIME = "finishTime";
	/**
	 * 声明订单付费时间全局常量
	 */
	public static final String PAY_TIME = "payTime";

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
	 * 保存服务订单持久化实例
	 * 
	 * @param transientInstance
	 *            服务订单对象
	 */
	@Override
	public void save(ServerOrder transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除服务订单持久化实例
	 * 
	 * @param persistentInstance
	 *            服务订单对象
	 */
	@Override
	public void delete(ServerOrder persistentInstance) {
//System.out.println(persistentInstance.getRoom().getId());
		hibernateTemplate.delete(persistentInstance);
	}

	/**
	 * replace by @see {@link #findById(String)}
	 */

	/**
	 * 加载服务订单实例，根据id查找
	 * 
	 * @param id
	 *            服务订单ID
	 * @return 返回加载的服务订单实例
	 */
	@Override
	public ServerOrder findById(java.io.Serializable id) {
		return hibernateTemplate.get(ServerOrder.class, id);
	}

	/**
	 * 根据指定属性查找服务订单列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServerOrder> findByProperty(String propertyName, Object property) {
		String queryString = "from ServerOrder as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, property);
		return (List<ServerOrder>) queryObject.list();
	}

	/**
	 * 查找所有服务订单实例
	 * 
	 * @return 返回服务订单集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServerOrder> findAll() {
		return (List<ServerOrder>) hibernateTemplate.find("from ServerOrder");
	}

	/**
	 * 统计服务订单实例个数
	 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from ServerOrder";
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	/**
	 * 根据id查找服务订单实例是否存在
	 * 
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(ServerOrder entity) {
		return findById(entity.getId()) == null ? false : true;
	}

	/**
	 * 查找服务订单实例，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerOrder> findListByLimit(long begin, long limit) {
		String hql = "from ServerOrder";
		HibernateCallback<List<ServerOrder>> callBack = new PageHibernateCallback<ServerOrder>(hql, new Object[] {},
				begin, limit);
		List<ServerOrder> list = (List<ServerOrder>) this.getHibernateTemplate().execute(callBack);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 更新服务订单状态
	 */
	@Override
	public void update(ServerOrder entity) {
		hibernateTemplate.update(entity);
	}

	/*
	 * public static final String SERVER_ORDER = "serverOrders";
	 * 
	 * @Override public Set<ServerOrder> findAllOrders(ServerOrder entity) {
	 * Session session =
	 * hibernateTemplate.getSessionFactory().getCurrentSession();
	 * 
	 * ServerOrder ccTemp = (ServerOrder)
	 * session.createCriteria(ServerOrder.class) .setFetchMode(SERVER_ORDER,
	 * FetchMode.JOIN) .add(Restrictions.idEq(entity.getId())).list().get(0);
	 * Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();
	 * 
	 * return sos; }
	 * 
	 * @Override public List<ServerOrder> findOrdersWithLimit(ServerOrder
	 * entity, long begin, long limit) { String hql =
	 * "from ServerOrder cc where cc.id=?"; HibernateCallback<List<ServerOrder>>
	 * callback = new PageHibernateCallback<ServerOrder>(hql, new Object[] {
	 * entity.getId() }, begin, limit); List<ServerOrder> temp =
	 * this.getHibernateTemplate().execute(callback);
	 * 
	 * Set<ServerOrder> set = null; if (temp != null && temp.size() > 0) { set =
	 * temp.get(0).getServerOrders(); } List<ServerOrder> list = new
	 * ArrayList<ServerOrder>(set);
	 * 
	 * if (list != null && list.size() > 0) { return list; } return null; }
	 */

	/**
	 * 根据付费方式查找服务订单
	 * 
	 * @return 返回服务订单实例
	 */
	@Override
	public List<ServerOrder> findByPayPath(Object property) {
		return findByProperty(PAY_PATH, property);
	}

	/**
	 * 根据员工名查找服务订单
	 * 
	 * @return 返回服务订单实例
	 */
	@Override
	public List<ServerOrder> findByUser(Object property) {
		return findByProperty(USER, property);
	}

	/**
	 * 根据抵押物查找服务订单
	 * 
	 * @return 返回服务订单实例
	 */
	@Override
	public List<ServerOrder> findByPledge(Object property) {
		return findByProperty(PLEDGE, property);
	}

	/**
	 * 根据钟点类型查找服务订单
	 * 
	 * @return 返回服务订单实例
	 */
	@Override
	public List<ServerOrder> findByClockCategory(Object property) {
		return findByProperty(CLOCK_CATEGORY, property);
	}

	/**
	 * 根据日期查找订单，查找受限于开始日期，结束日期
	 */
	@Override
	public List<ServerOrder> findOrdersByDateLimit(Date begin, Date end) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>) session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(INIT_TIME, begin, end)).list();

		return ccTemp;
	}

	/**
	 * 根据价格，日期查找订单，查找受限于价格，开始日期，结束日期
	 */
	@Override
	public List<ServerOrder> findOrderByPriceAndDateLimit(int price, Date begin, Date end, CompareLevel cl) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class).add(Restrictions.between(INIT_TIME, begin, end));

		if (cl.equals(CompareLevel.LESS_THAN)) {
			cri.add(Restrictions.lt(REAL_PAY, price));
		} else if (cl.equals(CompareLevel.MORE_THAN)) {
			cri.add(Restrictions.gt(REAL_PAY, price));
		}
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = cri.list();

		return ccTemp;
	}

	@Override
	public List<ServerOrder> findOrderByPriceLimit(int price, CompareLevel cl) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class);

		if (cl.equals(CompareLevel.LESS_THAN)) {
			cri.add(Restrictions.lt(REAL_PAY, price));
		} else if (cl.equals(CompareLevel.MORE_THAN)) {
			cri.add(Restrictions.gt(REAL_PAY, price));
		}
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = cri.list();

		return ccTemp;
	}

	@Override
	public <K> ServerOrder findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//		hibernateTemplate.`

		Criteria cri = session.createCriteria(ServerOrder.class);
		
		if (entity != null)
			cri.add(Restrictions.idEq(entity.getId()));

		ProjectionList proList = Projections.projectionList();

		for (String field : fields.keySet()) {
			proList.add(Projections.groupProperty(field));
		}
		// 设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();

		ServerOrder serverOrder = null;

		int i = 0;
		if (list != null && list.size() > 0) {
			serverOrder = new ServerOrder();
			Class<? extends ServerOrder> c = serverOrder.getClass();
			for (String field : fields.keySet()) {
				String str = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
				try {
					c.getDeclaredMethod(str, fields.get(field)).invoke(serverOrder, list.get(i));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				i++;
			}
		}

		return serverOrder;
	}

	// public List<ServerOrder> findByLimit(){

	// }

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class);

		for (String field : map.keySet()) {
			cri.add(Restrictions.eq(field, map.get(field)));
		}

		cri.setProjection(Projections.id());

		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();

		return listIds;
	}

	@Override
	public long findOrdersByProperyLimitCount(List<PropertyRange<?>> listPro) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class);

		for (PropertyRange<?> p : listPro) {
			cri.add(Restrictions.between(p.getName(), p.getMinValue(), p.getMaxValue()));
		}

		cri.setProjection(Projections.rowCount());
		return (long) cri.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerOrder> findOrdersByProperyLimit(List<PropertyRange<?>> listPro, int begin, int limit) {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		List<ServerOrder> ccTemp = null;
		Criteria cri = session.createCriteria(ServerOrder.class);

		for (PropertyRange<?> p : listPro) {
			// System.out.println(p.getMinValue());
			// System.out.println(p.getMaxValue());
			if(p != null)
				cri.add(Restrictions.between(p.getName(), p.getMinValue(), p.getMaxValue()));
		}
		cri.addOrder(Order.asc(ServerOrderDAOImpl.INIT_TIME));
		cri.setFirstResult(begin);
		cri.setMaxResults(limit);
		ccTemp = cri.list();

		return ccTemp;

	}

	@Override
	public void deleteAll(Collection<ServerOrder> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
//		for (ServerOrder serverOrder : entities) {
//			hibernateTemplate.delete(serverOrder);
//		}
	}

}