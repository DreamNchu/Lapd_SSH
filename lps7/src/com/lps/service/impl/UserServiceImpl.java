package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.UserDAO;
import com.lps.dao.impl.UserDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkDate;

public class UserServiceImpl implements UserService {
	
	/**
	 * 以私有变量的方式保存userDAO
	 */
	private UserDAO userDao ;
	
	/**
	 * 将user实体类封装到pagebean中
	 */
	private PageBean<User> pageUserBean;
	
	/**
	 * 根据员工得到的ServerOrder实体类封装到pagebean中
	 */
	/**
	 * 获取user实体类集合
	 * @return 返回实体类
	 */
	public PageBean<User> getPageUserBean() {
		return pageUserBean;
	}

	/**
	 * 设置user实体类集合
	 * @param pageUserBean admin实体类
	 */
	public void setPageUserBean(PageBean<User> pageUserBean) {
		this.pageUserBean = pageUserBean;
	}

	private PageBean<ServerOrder> pageServerOrderByUserBean;


	public PageBean<ServerOrder> getPageServerOrderByUserBean() {
		return pageServerOrderByUserBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByUserBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByUserBean(PageBean<ServerOrder> pageServerOrderByUserBean) {
		this.pageServerOrderByUserBean = pageServerOrderByUserBean;
	}

	/**
	 * 获取userDao实例
	 * @return 返回userDao实例
	 */
	public UserDAO getUserDao() {
		return userDao;
	}

	/**
	 * 设置userDao实例
	 * @param userDao
	 */
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * 保存user实例
	 */
	@Override
	public void save(User user) {
		userDao.save( user);
	}

	/**
	 * 删除user实例
	 */
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	/**
	 * 根据id查找员工，返回user实例
	 */
	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	/**
	 * 根据id查找user实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(User user) {
		return userDao.isExists(user);
	}

	/**
	 * 返回所有user实例
	 */
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	/**
	 * 返回所有user实例的数量
	 */
	@Override
	public long findAllCount() {
		return userDao.findAllCount();
	}

	/**
	 * 根据指定属性及其属性值查找user实例，返回指定user实例
	 */
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		return userDao.findByProperty(propertyName, value);
	}

	/**
	 * 根据员工密码属性查找，返回user实例
	 */
	@Override
	public List<User> findByPassword(Object password) {
		return userDao.findByPassword(password);
	}

	/**
	 * 根据员工工号属性查找，返回user实例
	 */
	@Override
	public List<User> findByWorkId(Object workId) {
		return userDao.findByWorkId(workId);
	}

	/**
	 * 根据员工电话号属性查找，返回user实例
	 */
	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return userDao.findByTelephonePhone(telephonePhone);
	}

	/**
	 * 根据员工邮箱属性查找，返回user实例
	 */
	@Override
	public List<User> findByEmail(Object email) {
		return userDao.findByEmail(email);
	}

	/**
	 * 根据员工地址属性查找，返回user实例
	 */
	@Override
	public List<User> findByAddress(Object address) {
		return userDao.findByAddress(address);
	}

	/**
	 * 根据员工头像属性查找，返回user实例
	 */
	@Override
	public List<User> findByAvatar(Object avatar) {
		return userDao.findByAvatar(avatar);
	}

	/**
	 * 根据员工密码找回问题属性查找，返回user实例
	 */
	@Override
	public List<User> findByQuestion(Object question) {
		return userDao.findByQuestion(question);
	}

	/**
	 * 根据员工密码找回问题答案属性查找，返回user实例
	 */
	@Override
	public List<User> findByAnswer(Object answer) {
		return userDao.findByAnswer(answer);
	}
	
	/**
	 * 根据页面查找页面内所有员工
	 */
	@Override
	public PageBean<User> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageUserBean.init(findAllCount(), page);

		List<User> list = userDao.findListByLimit(begin, pageUserBean.getLimit());

		pageUserBean.setList(list);

		return pageUserBean;
		
    }

	/**
	 * 更新user实例
	 */
	@Override
	public void update(User t) {
		userDao.update(t);	
	}

	/**
	 * 返回指定员工的所有服务订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(User t) {
		return userDao.findAllOrders(t);
	}
	
	/**
	 * 查找指定页面内根据员工得到的所有订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(User t, int page) throws PagePropertyNotInitException {
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

	@Override
	public List<ServerOrder> findTodayOrders(User t) {
		return userDao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(User t) {
		return userDao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(User t) {
		return userDao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(User t) {
		return userDao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

	@Override
	public <K> User findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return userDao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return userDao.findIdByProperty(map);
	}


}
