package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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

import com.lps.dao.ServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.ServerOrder;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.uenum.CompareLevel;
import com.lps.util.PageHibernateCallback;

public class ServerOrderDAOImpl  implements ServerOrderDAO{
	public static final String PAY_PATH = "payPath";
	public static final String ROOM = "room";
	public static final String USER = "user";
	public static final String PLEDGE = "pledge";
	public static final String CLOCK_CATEGORY = "clockCategory";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String REAL_PAY = "realPay";
	public static final String PAY = "pay";
	public static final String INIT_TIME = "initTime";
	public static final String RECEIVE_TIME = "receiveTime";
	public static final String FINISH_TIME = "finishTime";
	public static final String PAY_TIME = "payTime";
	
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(ServerOrder transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(ServerOrder persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**
	 * replace by @see {@link #findById(String)}
	 */
	@Override
	@Deprecated
	public ServerOrder findById(int id) {
		return null;
	}
	
	@Override
	public ServerOrder findById(String id) {
		return hibernateTemplate.get(ServerOrder.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerOrder> findByProperty(String propertyName, Object property) {
		String queryString = "from ServerOrder as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, property);
		return (List<ServerOrder>) queryObject.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerOrder> findAll() {
		return (List<ServerOrder>)hibernateTemplate.find("from ServerOrder");
	}

	@Override
	public long findAllCount() {
		String hql="select count(*) from ServerOrder";
        List<?> list=(List<?>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(ServerOrder t) {
		return findById(t.getId()) == null ? false : true;
	}

	@Override
	public List<ServerOrder> findListByLimit(long begin, long limit) {
		String hql="from ServerOrder";
		HibernateCallback<List<ServerOrder>> callBack = 
				new PageHibernateCallback<ServerOrder>(hql, new Object[]{}, begin, limit);
        List<ServerOrder> list=
        		(List<ServerOrder>) this.getHibernateTemplate()
        		.execute(callBack);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

	@Override
	public void update(ServerOrder t) {
		hibernateTemplate.update(t);
	}

	/*public static final String SERVER_ORDER = "serverOrders";
	@Override
	public Set<ServerOrder> findAllOrders(ServerOrder t) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		ServerOrder ccTemp = (ServerOrder) session.createCriteria(ServerOrder.class)
				.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
				.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(ServerOrder t, long begin, long limit) {
		String hql = "from ServerOrder cc where cc.id=?";
		HibernateCallback<List<ServerOrder>> callback = new PageHibernateCallback<ServerOrder>(hql,
				new Object[] { t.getId() }, begin, limit);
		List<ServerOrder> temp = this.getHibernateTemplate().execute(callback);

		Set<ServerOrder> set = null;
		if (temp != null && temp.size() > 0) {
			set = temp.get(0).getServerOrders();
		}
		List<ServerOrder> list = new ArrayList<ServerOrder>(set);

		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}*/

	@Override
	public List<ServerOrder> findByPayPath(Object property) {
		return findByProperty(PAY_PATH, property);
	}

	@Override
	public List<ServerOrder> findByUser(Object property) {
		return findByProperty(USER, property);
	}

	@Override
	public List<ServerOrder> findByPledge(Object property) {
		return findByProperty(PLEDGE, property);
	}

	@Override
	public List<ServerOrder> findByClockCategory(Object property) {
		return findByProperty(CLOCK_CATEGORY, property);
	}


	@Override
	public List<ServerOrder> findOrdersByDateLimit(Date begin, Date end) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(INIT_TIME, begin, end))
				.list();
		
		return ccTemp;
	}
	
	

	@Override
	public List<ServerOrder> findOrderByPriceAndDateLimit(int price, Date begin, Date end, CompareLevel cl) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(INIT_TIME, begin, end));
		
		if(cl.equals(CompareLevel.LESS_THAN)){
			cri.add(Restrictions.lt(REAL_PAY, price));
		}else if(cl.equals(CompareLevel.MORE_THAN)){
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
				
		if(cl.equals(CompareLevel.LESS_THAN)){
			cri.add(Restrictions.lt(REAL_PAY, price));
		}else if(cl.equals(CompareLevel.MORE_THAN)){
			cri.add(Restrictions.gt(REAL_PAY, price));
		}
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = cri.list();
		
		return ccTemp;
	}
	
	@Override
	public <K> ServerOrder findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerOrder.class)
			.add(Restrictions.idEq(t.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		ServerOrder clockCategory = new ServerOrder();
		Class<? extends ServerOrder> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(ServerOrder.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

	
}