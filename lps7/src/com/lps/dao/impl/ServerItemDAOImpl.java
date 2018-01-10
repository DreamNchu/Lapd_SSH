package com.lps.dao.impl;
// default package

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
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

import com.lps.dao.ServerItemDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Admin;
import com.lps.model.ServerItem;
import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class ServerItemDAOImpl  implements ServerItemDAO {
	/**
	 * 声明房间类型全局常量
	 */
	public static final String SERVER_ITEM = "serverItem";
	
	public static final String PRICE = "price";
	
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
	 * 保存房间类型持久化实例
	 * @param transientInstance 房间类型对象
	 */
	@Override
	public void save(ServerItem transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除房间类型持久化实例
	 * @param persistentInstance 房间类型对象
	 */
	@Override
	public void delete(ServerItem persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载房间类型实例，根据id查找
	   *@param id 房间类型ID
	   *@return 返回加载的房间类型实例
	   */
	@Override
	public ServerItem findById(java.io.Serializable id) {
		return hibernateTemplate.get(ServerItem.class, id);
	}

	/**
	 * 根据指定属性查找房间类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServerItem> findByProperty(String propertyName, Object value) {
		String queryString = "from ServerItem as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		return (List<ServerItem>) queryObject.list();
	}

	/**
	 * 根据房间类型查找实例
	 * @return 返回房间类型实例
	 */
	@Override
	public List<ServerItem> findByServerItem(Object object) {
		return findByProperty(SERVER_ITEM, object);
	}

	/**
	 * 查找所有房间类型实例
	 * @return 返回房间实例集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ServerItem> findAll() {
//		List<ServerItem> li = (List<ServerItem>)hibernateTemplate.find("from ServerItem");
//		hibernateTemplate.
//		li = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery("from ServerItem").list();
//		System.out.println(li.get(0).getClass().getName());
		
		return (List<ServerItem>)hibernateTemplate.find("from ServerItem");
	}

	/**
	 *统计房间类型实例个数
	 */
	@Override
	public long findAllCount() {
		String hql="select count(*) from ServerItem";
        List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	/**
	 * 根据id查找房间类型实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(ServerItem entity) {
		return findById(entity.getId()) == null ? false : true;
	}

	/**
	 * 查找房间类型实例，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerItem> findListByLimit(long begin, long limit) {
		String hql="from ServerItem";
        List<ServerItem> list=(List<ServerItem>) this.getHibernateTemplate().execute((HibernateCallback<Admin>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
        if(list!=null&&list.size()>0){
            
            return list;
        }
        return null;
	}

	/**
	 * 更新房间类型
	 */
	@Override
	public void update(ServerItem entity) {
		hibernateTemplate.update(entity);
	}
	
	@Override
	public <K> ServerItem findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(ServerItem.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		ServerItem clockCategory = new ServerItem();
		Class<? extends ServerItem> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(ServerItem.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

	@Override
	public void deleteAll(Collection<ServerItem> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

}