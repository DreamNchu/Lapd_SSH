package com.lps.dao.impl;

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
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.UserDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.User;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageHibernateCallback;

public class UserDAOImpl implements UserDAO ,BasicForServerOrderDAO<User, Integer>{

	/**
	 * 声明员工账户名全局常量
	 */
	public static final String USER_NAME = "userName";
	/**
	 * 声明员工密码全局常量
	 */
	public static final String PASSWORD = "password";
	/**
	 * 声明员工工号全局常量
	 */
	public static final String WORK_ID = "workId";
	/**
	 * 声明员工电话全局常量
	 */
	public static final String TELEPHONE_PHONE = "telephonePhone";
	/**
	 * 声明员工邮箱全局常量
	 */
	public static final String EMAIL = "email";
	/**
	 * 声明员工地址全局常量
	 */
	public static final String ADDRESS = "address";
	/**
	 * 声明员工头像全局常量
	 */
	public static final String AVATAR = "avatar";
	/**
	 * 声明员工密码找回问题全局常量
	 */
	public static final String QUESTION = "question";
	/**
	 * 声明员工名密码找回问题答案全局常量
	 */
	public static final String ANSWER = "answer";
	/**
	 * 声明员工注册时间全局常量
	 */
	public static final String REGISTER_TIME = "registerTime";
	/**
	 * 声明员工真实姓名全局常量
	 */
	public static final String REAL_NAME = "realName";
	/**
	 * 声明员工id卡号全局常量
	 */
	public static final String ID_CARD_NO = "IDCardNO";
	/**
	 * 声明员工服务订单全局常量
	 */
	public static final String SERVER_ORDER = "serverOrders";

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
	 * 保存员工持久化实例
	 * @param transientInstance 员工对象
	 */
	@Override
	public void save(User transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	/**
	 * 删除员工持久化实例
	 * @param persistentInstance 员工对象
	 */
	@Override
	public void delete(User persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	/**加载员工实例，根据id查找
	   *@param id 员工ID
	   *@return 返回加载的员工实例
	   */
	@Override
	public User findById(java.io.Serializable id) {
		return hibernateTemplate.get(User.class, id);
	}

	/**
	 * 根据指定属性查找员工列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		String queryString = "from User as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		
		return (List<User>) queryObject.list();
	}

	/**
	 * 根据员工名查找员工
	 * @return 返回员工实例
	 */
	public List<User> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/**
	 * 根据员工密码查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/**
	 * 根据员工工号查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByWorkId(Object workId) {
		return findByProperty(WORK_ID, workId);
	}

	/**
	 * 根据员工电话号查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return findByProperty(TELEPHONE_PHONE, telephonePhone);
	}
	
	/**
	 * 根据员工邮箱查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/**
	 * 根据员工地址查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	/**
	 * 根据员工头像查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	/**
	 * 根据员工密码找回问题查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	/**
	 * 根据员工密码找回问题答案查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	/**
	 * 查找所有员工实例
	 * @return 返回员工实例集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return (List<User>)hibernateTemplate.find("from User");
	}
	
	/**
	 *统计用户实例个数
	 */
	@Override
	public long findAllCount() {
		String hql="select count(*) from User";
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	/**
	 * 根据id查找员工实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(User user) {
		if(findById(user.getId()) != null)
			return true;;
		return false;
	}

	/**
	 * 查找员工实例，查找个数受限于begin，limit
	 */
	@Override
	public List<User> findListByLimit(long begin, long limit) {
		String hql="from User u order by u.workId";
		HibernateCallback<List<User>> callback = new PageHibernateCallback<>(hql, new Object[]{}, begin, limit);
        List<User> list=(List<User>) this.getHibernateTemplate().execute(callback);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

	/**
	 * 更新员工
	 */
	@Override
	public void update(User entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * 根据员工查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(User entity) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		User ccTemp = (User) session.createCriteria(User.class)
			.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
			.add(Restrictions.idEq(entity.getId())).uniqueResult();
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	/**
	 * 根据员工查找订单，查找个数受限于begin，limit
	 */
	@Override
	public List<ServerOrder> findOrdersWithLimit(User entity, long begin, long limit) {
		String hql = "from Room cc where cc.id=?";
		HibernateCallback<List<User>> callback = 
				new PageHibernateCallback<User>(hql,new Object[] { entity.getId() }, begin, limit);
		List<User> temp = this.getHibernateTemplate().execute(callback);

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
	 * 根据员工真实姓名查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByRealName(Object realname) {
		return findByProperty(REAL_NAME, realname);
	}

	/**
	 * 根据员工ID卡号查找员工
	 * @return 返回员工实例
	 */
	@Override
	public List<User> findByIDCardNo(Object IDCardNo) {
		return findByProperty(ID_CARD_NO, IDCardNo);
	}

	/**
	 * 根据指定员工查找订单数量，返回订单列表
	 */
	@Override
	public long findOrdersCountByThisType(User property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.USER + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}
	
	@Override
	public <K> User findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		Criteria cri = session.createCriteria(User.class)
			.add(Restrictions.idEq(entity.getId()));
		ProjectionList proList = Projections.projectionList();
		
		for(String field: fields.keySet()){
			proList.add(Projections.groupProperty(field));
		}
		//设置投影条件
		cri.setProjection(proList);
		List<?> list = cri.list();
		
		User clockCategory = new User();
		Class<? extends User> c = clockCategory.getClass();
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

		Criteria cri = session.createCriteria(User.class);
		
		for(String field: map.keySet()){
			cri.add(Restrictions.eq(field, map.get(field)));
		}
		
		cri.setProjection(Projections.id());
		
		@SuppressWarnings("unchecked")
		List<K> listIds = cri.list();
		
		return listIds;
	}
	
	@Override
	public List<ServerOrder> findOrdersByDateLimit(User u, Date begin, Date end) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<ServerOrder> ccTemp = (List<ServerOrder>)session.createCriteria(ServerOrder.class)
				.add(Restrictions.between(ServerOrderDAOImpl.INIT_TIME, begin, end))
				.add(Restrictions.eq(ServerOrderDAOImpl.USER, u))
				.list();
		
		return ccTemp;
	}

	@Override
	public void deleteAll(Collection<User> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

}
