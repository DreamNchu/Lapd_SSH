package com.lps.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.WorkRankDAO;
import com.lps.model.Admin;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class WorkRankDAOImpl implements WorkRankDAO {

	/**
	 * 声明排序号全局常量
	 */
	public static  String RANK = "rank";
	/**
	 * 声明员工名全局常量
	 */
	public static  String USER = "user";
	/**
	 * 声明员工排钟号全局常量
	 */
	public static  String RANK_NUM = "rankNum";
	/**
	 * 声明员工点钟号全局常量
	 */
	public static  String SPOT_NUM = "spotNum";

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
	 * 保存上钟排序实例
	 * @param transientInstance 上钟排序对象
	 */
	@Override
	public void save(WorkRank transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除上钟排序持久化实例
	 * @param persistentInstance 上钟排序对象
	 */
	@Override
	public void delete(WorkRank persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载上钟排序实例，根据id查找
	   *@param id 上钟排序ID
	   *@return 返回加载的上钟排序实例
	   */
	@Override
	public WorkRank findById(java.io.Serializable id) {
		return hibernateTemplate.get(WorkRank.class, id);
	}

	/**
	 * 根据指定属性查找上钟排序列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkRank> findByProperty(String propertyName, Object value) {
		String queryString = "from WorkRank as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);

		return (List<WorkRank>) queryObject.list();
	}

	/**
	 * 查找所有上钟排序实例
	 * @return 返回上钟排序集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkRank> findAll() {
//		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//		session.createCriteria(WorkRank.class)
//		.setFetchMode(USER, FetchMode.JOIN)
//		.list();
	
		
		return (List<WorkRank>)hibernateTemplate.find("from WorkRank");
	}

	/**
	 *统计上钟排序实例个数
	 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from WorkRank";
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

	/**
	 * 根据id查找上钟序列实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(WorkRank user) {
		if (findById(user.getId()) != null)
			return true;
		;
		return false;
	}

	/**
	 * 查找上钟排序实例，查找个数受限于begin，limit
	 */
	@Override
	public List<WorkRank> findListByLimit(long begin, long limit) {
		String hql = "from WorkRank";
		
		HibernateCallback<List<WorkRank>> callBack =  
				new PageHibernateCallback<WorkRank>(hql, new Object[] {}, begin, limit);
		List<WorkRank> list = (List<WorkRank>) this.getHibernateTemplate()
				.execute(callBack);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 更新上钟序列状态
	 */
	@Override
	public void update(WorkRank entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * 根据员工名查找上钟序列
	 * @return 返回上钟序列
	 */
	@Override
	public List<WorkRank> findByUser(User user) {
		return findByProperty(USER, user);
	}

	/**
	 * 根据排序号查找上钟序列
	 * @return 返回上钟序列
	 */
	@Override
	public List<WorkRank> findByRank(int num) {
		return findByProperty(RANK, num);
	}

	/**
	 * 根据排钟序号查找上钟序列
	 * @return 返回上钟序列
	 */
	@Override
	public List<WorkRank> findByRankNum(int num) {
		return findByProperty(RANK_NUM, num);
	}

	/**
	 * 根据点钟序号查找上钟序列
	 * @return 返回上钟序列
	 */
	@Override
	public List<WorkRank> findBySpotNum(int num) {
		return findByProperty(SPOT_NUM, num);
	}
	
	@Override
	public <K> WorkRank findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(WorkRank.class)
			;if(cri != null) cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		WorkRank clockCategory = new WorkRank();
		Class<? extends WorkRank> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(WorkRank.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}

	@Override
	public WorkRank findFirstMinRankNum() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Criteria cri = session.createCriteria(WorkRank.class);
		cri.setProjection(Projections.min(RANK_NUM))
		.setMaxResults(1).setFetchMode(USER, FetchMode.JOIN);
		
		return (WorkRank) cri.uniqueResult();
	}

	@Override
	public void deleteAll(Collection<WorkRank> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

}
