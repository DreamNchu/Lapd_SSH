package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.UserDAO;
import com.lps.dao.impl.AdminDAOImpl;
import com.lps.dao.impl.UserDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDao ;
	
	private PageBean<User> pageUserBean;
	
	public PageBean<User> getPageUserBean() {
		return pageUserBean;
	}

	public void setPageUserBean(PageBean<User> pageUserBean) {
		this.pageUserBean = pageUserBean;
	}

	private PageBean<ServerOrder> pageServerOrderByUserBean;


	public PageBean<ServerOrder> getPageServerOrderByUserBean() {
		return pageServerOrderByUserBean;
	}

	public void setPageServerOrderByUserBean(PageBean<ServerOrder> pageServerOrderByUserBean) {
		this.pageServerOrderByUserBean = pageServerOrderByUserBean;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		userDao.save( user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}


	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	@Override
	public boolean isExists(User user) {
		return userDao.isExists(user);
	}


	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public long findAllCount() {
		return userDao.findAllCount();
	}

	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		return userDao.findByProperty(propertyName, value);
	}

	@Override
	public List<User> findByPassword(Object password) {
		return userDao.findByPassword(password);
	}

	@Override
	public List<User> findByWorkId(Object workId) {
		return userDao.findByWorkId(workId);
	}

	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return userDao.findByTelephonePhone(telephonePhone);
	}

	@Override
	public List<User> findByEmail(Object email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> findByAddress(Object address) {
		return userDao.findByAddress(address);
	}

	@Override
	public List<User> findByAvatar(Object avatar) {
		return userDao.findByAvatar(avatar);
	}

	@Override
	public List<User> findByQuestion(Object question) {
		return userDao.findByQuestion(question);
	}

	@Override
	public List<User> findByAnswer(Object answer) {
		return userDao.findByAnswer(answer);
	}
	
	@Override
	public PageBean<User> findByPage(int page) {
        pageUserBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageUserBean.setAllCount(totalCount);
        
        long limit  = pageUserBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageUserBean.setAllPage(totalpage);
        
        long begin=(page-1) * limit;
        
        List<User> list = userDao.findListByLimit(begin, limit);
        
        pageUserBean.setList(list);
        
        return pageUserBean;
    }

	@Override
	public void update(User t) {
		userDao.update(t);	
	}

	@Override
	public Set<ServerOrder> findAllOrders(User t) {
		return userDao.findAllOrders(t);
	}
	@Override
	public PageBean<ServerOrder> findOrdersByPage(User t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByUserBean.init(findOrdersCountByThisType(t), page);

		List<ServerOrder> list = userDao.findOrdersWithLimit(t, begin, pageServerOrderByUserBean.getLimit());

		pageServerOrderByUserBean.setList(list);

		return pageServerOrderByUserBean;
	}

	@Override
	public List<User> findByRealName(Object realName) {
		return userDao.findByRealName(realName);
	}

	@Override
	public List<User> findByIDCardNo(Object IDCardNo) {
		return userDao.findByIDCardNo(IDCardNo);
	}

	@Override
	public long findOrdersCountByThisType(User t) {
		return userDao.findOrdersCountByThisType(t);
	}

	@Override
	public String findPasswordByUserName(String userName) {
		User user =new  User.Builder()
				.setId(findIdByUserName(userName)).build();
		return findPassword(user);
	}

	@Override
	public <T> String findPassword(BasicModel<T> user) {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		map.put(UserDAOImpl.PASSWORD, String.class);
		return userDao.findFields(user, map).getPassword();
	}

	@Override
	public int findIdByUserName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put(UserDAOImpl.USER_NAME, name);
		List<Integer> list = userDao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}


}
