package com.lps.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.UserDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.util.PageHibernateCallback;

public class UserDAOImpl implements UserDAO ,BasicForServerOrderDAO<User, Integer>{

	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String WORK_ID = "workId";
	public static final String TELEPHONE_PHONE = "telephonePhone";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String AVATAR = "avatar";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";
	public static final String REGISTER_TIME = "registerTime";
	public static final String REAL_NAME = "realName";
	public static final String ID_CARD_NO = "IDCardNO";
	public static final String SERVER_ORDER = "serverOrders";

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User transientInstance) {
		hibernateTemplate.save(transientInstance);
	}

	@Override
	public void delete(User persistentInstance) {
		hibernateTemplate.delete(persistentInstance);
	}

	@Override
	public User findById(int id) {
		return hibernateTemplate.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		String queryString = "from User as model where model." + propertyName + "= ?";
		Query queryObject = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, value);
		
		return (List<User>) queryObject.list();
	}

	public List<User> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	@Override
	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@Override
	public List<User> findByWorkId(Object workId) {
		return findByProperty(WORK_ID, workId);
	}

	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return findByProperty(TELEPHONE_PHONE, telephonePhone);
	}
	
	@Override
	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	@Override
	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	@Override
	public List<User> findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	@Override
	public List<User> findByQuestion(Object question) {
		return findByProperty(QUESTION, question);
	}

	@Override
	public List<User> findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return (List<User>)hibernateTemplate.find("from User");
	}
	
	@Override
	public long findAllCount() {
		String hql="select count(*) from User";
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        return (long)list.get(0);
	}

	@Override
	public boolean isExists(User user) {
		if(findById(user.getId()) != null)
			return true;;
		return false;
	}

	@Override
	public List<User> findListByLimit(long begin, long limit) {
		String hql="from User";
		HibernateCallback<List<User>> callback = new PageHibernateCallback<>(hql, new Object[]{}, begin, limit);
        List<User> list=(List<User>) this.getHibernateTemplate().execute(callback);
        if(list!=null&&list.size()>0){
            return list;
        }
        return null;
	}

	@Override
	public void update(User t) {
		hibernateTemplate.update(t);
	}

	@Override
	public Set<ServerOrder> findAllOrders(User t) {
		
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();

		User ccTemp = (User) session.createCriteria(User.class)
			.setFetchMode(SERVER_ORDER, FetchMode.JOIN)
			.add(Restrictions.idEq(t.getId())).list().get(0);
		Set<ServerOrder> sos = (Set<ServerOrder>) ccTemp.getServerOrders();

		return sos;
	}

	@Override
	public List<ServerOrder> findOrdersWithLimit(User t, long begin, long limit) {
		String hql = "from Room cc where cc.id=?";
		HibernateCallback<List<ClockCategory>> callback = 
				new PageHibernateCallback<ClockCategory>(hql,new Object[] { t.getId() }, begin, limit);
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

	@Override
	public List<User> findByRealName(Object answer) {
		return findByProperty(REAL_NAME, answer);
	}

	@Override
	public List<User> findByIDCardNo(Object IDCardNo) {
		return findByProperty(ID_CARD_NO, IDCardNo);
	}

	@Override
	public long findOrdersCountByThisType(User property) {
		String hql = "select count(*) from ServerOrder model where model." 
				+ ServerOrderDAOImpl.USER + "="
				+ property.getId();
		List<?> list = (List<?>) this.getHibernateTemplate().find(hql);
		return (long) list.get(0);
	}

}
