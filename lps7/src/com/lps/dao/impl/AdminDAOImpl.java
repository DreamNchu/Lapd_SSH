package com.lps.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
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

import com.lps.dao.AdminDAO;
import com.lps.model.Admin;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class AdminDAOImpl implements AdminDAO {

	/**
	 * 声明管理员账户名全局常量
	 */
	public static  String USER_NAME = "userName";
	/**
	 * 声明管理员密码全局常量
	 */
	public static  String PASSWORD = "password";
	/**
	 * 声明管理员头像全局常量
	 */
	public static  String AVATAR = "avatar";
	/**
	 * 声明管理员注册时间全局常量
	 */
	public static  String REGISTER_TIME = "registerTime";
	
	public transient static  Map<String, Class<?>> mapDataType = new HashMap<>();
	
	static{
//		mapDataType.put(ID, Integer.class);
//		mapDataType.put(REGISTER_TIME, java.util.Date.class);
	}

//	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
//		for(Field f: AdminDAOImpl.class.getDeclaredFields()){
		
//			Class[] types =  AdminDAOImpl.class.getInterfaces();
//			System.out.println(types[0].getInterfaces()[0].getTypeParameters()[0].getGenericDeclaration());
//			String s = ((ParameterizedType)types[0].getInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
//			System.out.println(Class.forName(s));
		
//			System.out.println(((ParameterizedType)types[0].getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName());
//			System.out.println(types[types.length - 1].getClass().getGenericInterfaces()[0].getTypeName());
//			System.out.println(((ParameterizedType) types[types.length - 1]).getActualTypeArguments()[0].getTypeName());
			
			/*if(Modifier.isStatic(f.getModifiers())){
				System.out.println("---" + f.getName());
				System.out.println(f.get(AdminDAOImpl.class));
			}*/
//		}
//	}
	
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
	 * 保存Admin持久化实例
	 * 
	 * @param admin
	 *            管理员对象
	 */
	@Override
	public void save(Admin admin) {
		hibernateTemplate.save(admin);
	}

	/**
	 * 删除Admin持久化实例
	 * 
	 * @param admin
	 *            管理员对象
	 */
	@Override
	public void delete(Admin admin) {
		hibernateTemplate.delete(admin);
	}

	/**
	 * 加载admin实例，根据id查找
	 * 
	 * @param id
	 *            管理员ID，需要加载admin实例的主键值
	 * @return 返回加载的admin实例
	 */
	@Override
	public Admin findById(java.io.Serializable id) {
		return hibernateTemplate.get(Admin.class, id);
	}

	/**
	 * 根据id查找admin实例是否存在
	 * 
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(Admin admin) {
		if (findById(admin.getId()) != null)
			return true;
		;
		return false;
	}

	/**
	 * 根据管理员账户名查找管理员实例是否存在
	 * 
	 * @return 存在则返回管理员对象，否则返回null
	 */
	@Override
	public Admin getByUserName(String persistentInstance) {
		List<?> tempList = hibernateTemplate.find("from Admin a where a.userName = '" + persistentInstance + "'");
		if (tempList.size() > 0)
			return (Admin) tempList.get(0);
		return null;
	}

	/*
	 * @Override public List<Admin> getByRegisterTime(Timestamp
	 * persistentInstance) { return findByProperty(REGISTER_TIME,
	 * persistentInstance); }
	 */
	/**
	 * 根据指定属性查找管理员列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findByProperty(String propertyName, Object value) {
		String queryString = "from Admin as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		// System.out.println(Thread.currentThread());
		return (List<Admin>) queryObject.list();
	}

	/**
	 * 查找所有admin实例
	 */
	@Override
	public List<Admin> findAll() {
		return (List<Admin>) hibernateTemplate.find("from Admin");
	}

	/**
	 * 统计管理员实例个数
	 */
	@Override
	public long findAllCount() {
		String hql = "select count(*) from Admin";

		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);

		return (long) list.get(0);
	}

	/**
	 * 查找管理员实例，查找个数受限于begin，limit
	 */
	@Override
	public List<Admin> findListByLimit(long begin, long limit) {
		String hql = "from Admin";
		HibernateCallback<List<Admin>> callback = new PageHibernateCallback<Admin>(hql, new Object[] {}, begin, limit);
		List<Admin> list = (List<Admin>) this.getHibernateTemplate().execute(callback);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 更新admin实例
	 * 
	 * @param entity
	 *            需要更新的 admin实例
	 */
	@Override
	public void update(Admin entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public <K> Admin findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {

		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Admin.class);
		if (cri != null)
			cri.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();

		for (String field : fields.keySet()) {
			proList.add(Projections.groupProperty(field));
		}
		// 设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		if (list != null && list.size() > 0) {
			Admin admin = new Admin();
			Class<? extends Admin> c = admin.getClass();
			int i = 0;

			for (String field : fields.keySet()) {
				String str = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
				try {
					c.getDeclaredMethod(str, fields.get(field)).invoke(admin, list.get(i));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				i++;
			}
			return admin;
		}
		return null;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(Admin.class);

		for (String field : map.keySet()) {
			cri.add(Restrictions.eq(field, map.get(field)));
		}

		cri.setProjection(Projections.id());

		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();

		return listIds;

	}

	@Override
	public void deleteAll(Collection<Admin> entities) {
		hibernateTemplate.deleteAll(entities);
	}

}
