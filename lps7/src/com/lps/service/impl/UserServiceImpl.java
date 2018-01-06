package com.lps.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.UserDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.dao.impl.UserDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.UserService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

public class UserServiceImpl implements UserService {
	
	/**
	 * 以私有变量的方式保存userDAO
	 */
	private UserDAO dao ;
	
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
		return dao;
	}

	/**
	 * 设置userDao实例
	 * @param userDao
	 */
	public void setUserDao(UserDAO userDao) {
		this.dao = userDao;
	}

	/**
	 * 保存user实例
	 */
	@Override
	public void save(User user) {
		dao.save( user);
	}

	/**
	 * 删除user实例
	 */
	@Override
	public void delete(User user) {
		dao.delete(user);
	}

	/**
	 * 根据id查找员工，返回user实例
	 * @throws FindByIdGetNullException 
	 */
	@Override
	public User findById(java.io.Serializable id) throws FindByIdGetNullException {
		User u = dao.findById(id);
		if(u == null)
			throw new FindByIdGetNullException();
		return dao.findById(id);
	}
	
	/**
	 * 根据id查找user实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(User user) {
		return dao.isExists(user);
	}

	/**
	 * 返回所有user实例
	 */
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有user实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据指定属性及其属性值查找user实例，返回指定user实例
	 */
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 根据员工密码属性查找，返回user实例
	 */
	@Override
	public List<User> findByPassword(Object password) {
		return dao.findByPassword(password);
	}

	/**
	 * 根据员工工号属性查找，返回user实例
	 */
	@Override
	public List<User> findByWorkId(Object workId) {
		return dao.findByWorkId(workId);
	}

	/**
	 * 根据员工电话号属性查找，返回user实例
	 */
	@Override
	public List<User> findByTelephonePhone(Object telephonePhone) {
		return dao.findByTelephonePhone(telephonePhone);
	}

	/**
	 * 根据员工邮箱属性查找，返回user实例
	 */
	@Override
	public List<User> findByEmail(Object email) {
		return dao.findByEmail(email);
	}

	/**
	 * 根据员工地址属性查找，返回user实例
	 */
	@Override
	public List<User> findByAddress(Object address) {
		return dao.findByAddress(address);
	}

	/**
	 * 根据员工头像属性查找，返回user实例
	 */
	@Override
	public List<User> findByAvatar(Object avatar) {
		return dao.findByAvatar(avatar);
	}

	/**
	 * 根据员工密码找回问题属性查找，返回user实例
	 */
	@Override
	public List<User> findByQuestion(Object question) {
		return dao.findByQuestion(question);
	}

	/**
	 * 根据员工密码找回问题答案属性查找，返回user实例
	 */
	@Override
	public List<User> findByAnswer(Object answer) {
		return dao.findByAnswer(answer);
	}
	
	/**
	 * 根据页面查找页面内所有员工
	 */
	@Override
	public PageBean<User> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageUserBean.init(findAllCount(), page);

		List<User> list = dao.findListByLimit(begin, pageUserBean.getLimit());

		pageUserBean.setList(list);

		return pageUserBean;
		
    }

	/**
	 * 更新user实例
	 */
	@Override
	public void update(User entity) {
		dao.update(entity);	
	}

	/**
	 * 返回指定员工的所有服务订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(User entity) {
		return dao.findAllOrders(entity);
	}
	
	/**
	 * 查找指定页面内根据员工得到的所有订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(User entity, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByUserBean.init(findOrdersCountByThisType(entity), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(entity, begin, pageServerOrderByUserBean.getLimit());

		pageServerOrderByUserBean.setList(list);

		return pageServerOrderByUserBean;
	}

	@Override
	public List<User> findByRealName(Object realName) {
		return dao.findByRealName(realName);
	}

	@Override
	public List<User> findByIDCardNo(Object IDCardNo) {
		return dao.findByIDCardNo(IDCardNo);
	}

	@Override
	public long findOrdersCountByThisType(User entity) {
		return dao.findOrdersCountByThisType(entity);
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
		return dao.findFields(user, map).getPassword();
	}

	@Override
	public int findIdByUserName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put(UserDAOImpl.USER_NAME, name);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		throw new UserNotExistsException("找不到改用户对象");
	}

	@Override
	public List<ServerOrder> findTodayOrders(User entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(User entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(User entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders(User entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

	@Override
	public <K> User findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFields(entity, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}
	public PropertyRange<User> createPropertyRangeById(java.io.Serializable id1) throws FindByIdGetNullException {
		
		PropertyRange<User> pr = new PropertyRange<>();
		
		pr.setName(BasicDAO.ID);
		
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<User> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}

}
