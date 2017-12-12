package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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

import com.lps.dao.PayPathDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.PayPath;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class PayPathDAOImpl implements PayPathDAO, BasicForServerOrderDAO<PayPath, Integer> {
	/**
	 * 声明付费方式全局常量
	 */
	public static final String PAY_PATH = "payPath";
	
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
	 * 保存付费方式持久化实例
	 * @param transientInstance 付费方式对象
	 */
	@Override
	public void save(PayPath transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除付费方式持久化实例
	 * @param persistentInstance 付费方式对象
	 */
	@Override
	public void delete(PayPath persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载付费方式实例，根据id查找
	   *@param id 付费方式ID
	   *@return 返回加载的付费方式实例
	   */
	@Override
	public PayPath findById(int id) {
		return hibernateTemplate.get(PayPath.class, id);
	}

	/**
	 * 根据指定属性查找付费方式列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findByProperty(String propertyName, Object value) {
		String queryString = "from PayPath as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<PayPath>) queryObject.list();
	}

	/**
	 * 根据付费方式查找实例
	 * @return 返回付费方式实例
	 */
	@Override
	public List<PayPath> findByPayPath(Object payPath) {
		return findByProperty(PAY_PATH, payPath);
	}

	/**
	 * 查找付费方式类型实例
	 * @return 返回付费方式集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PayPath> findAll() {
		return (List<PayPath>) hibernateTemplate.find("from PayPath");
	}

	/**
	 *统计付费方式实例个数
	 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from PayPath";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	/**
	 * 根据id查找付费方式实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(PayPath t) {
		return findById(t.getId()) == null ? false : true;
	}

	/**
	 * 查找付费方式实例，查找个数受限于begin，limit
	 */
	@Override
	public List<PayPath> findListByLimit(long begin, long limit) {
		String hql = "from PayPath";
		List<PayPath> list = (List<PayPath>) this.getHibernateTemplate()
				.execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[] {}, begin, limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}
	/**
	 * 更新付费方式
	 */
	@Override
	public void update(PayPath t) {
		hibernateTemplate.update(t);
	}

	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";

	/**
	 * 根据付费方式查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(PayPath t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		PayPath ccTemp = (PayPath) session.createCriteria(PayPath.class).setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	/**
	 * 根据付费方式查找订单，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerOrder> findOrdersWithLimit(PayPath t, long begin, long limit) {
		String hql = "from PayPath cc where cc.id=?";
		HibernateCallback<List<PayPath>> callback = new PageHibernateCallback<PayPath>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<PayPath> temp = this.getHibernateTemplate().execute(callback);

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
	 * 根据指定付费方式查找订单数量，返回订单列表
	 */
	@Override
	public long findOrdersCountByThisType(PayPath property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.PAY_PATH + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> PayPath findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(PayPath.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		PayPath clockCategory = new PayPath();
		Class<? extends PayPath> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(PayPath.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
	
	@Override
	public List<ServerOrder> findOrdersByDateLimit(PayPath pp, Date begin, Date end) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.PAY_PATH, pp))
				.list();
		
		return ccTemp;
	}
	
}