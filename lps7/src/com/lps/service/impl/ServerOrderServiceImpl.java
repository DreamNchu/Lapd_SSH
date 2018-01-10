package com.lps.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lps.dao.ServerOrderDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.ServerOrderService;
import com.lps.uenum.CompareLevel;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

//@Component("adminServiceImpl")
//@Aspect
public class ServerOrderServiceImpl implements ServerOrderService {

	/**
	 * 以私有变量的方式保存ServerOrderDAO
	 */
	private ServerOrderDAO dao;

	/**
	 * 将ServerOrder实体类封装到pagebean中
	 */
	private PageBean<ServerOrder> pageServerOrderBean;

	/**
	 * 获取pagebean中ServerOrder实体类集合
	 * 
	 * @return 返回实体类
	 */
	public PageBean<ServerOrder> getPageServerOrderBean() {
		return pageServerOrderBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * 
	 * @param pageServerOrderBean
	 *            封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderBean(PageBean<ServerOrder> pageServerOrderBean) {
		this.pageServerOrderBean = pageServerOrderBean;
	}

	/**
	 * 删除ServerOrder实例
	 */
	@Override
	public void delete(ServerOrder serverOrder) {
		dao.delete(serverOrder);
	}

	/**
	 * 返回所有ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有ServerOrder实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据指定属性及其属性值查找ServerOrder实例，返回指定ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 获取ServerOrderDao实例
	 * 
	 * @return 返回adminDao实例
	 */
	public ServerOrderDAO getServerOrderDao() {
		return dao;
	}

	/**
	 * 保存ServerOrder实例
	 */
	@Override
	public void save(ServerOrder ServerOrder) {
		dao.save(ServerOrder);
	}

	/**
	 * 设置ServerOrderDao实例
	 * 
	 * @param ServerOrderDao
	 */
	public void setServerOrderDao(ServerOrderDAO ServerOrderDao) {
		this.dao = ServerOrderDao;
	}

	/**
	 * 根据id查找ServerOrder实例是否存在
	 * 
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(ServerOrder user) {
		return dao.isExists(user);
	}

	/**
	 * 更新ServerOrder实例
	 */
	@Override
	public void update(ServerOrder entity) {
		dao.update(entity);
	}

	/**
	 * 根据id查找订单，返回ServerOrder实例
	 */
	@Override
	public ServerOrder findById(java.io.Serializable id) throws FindByIdGetNullException {
		ServerOrder serverOrder = dao.findById(id);
		if (serverOrder == null) {
			throw new FindByIdGetNullException("根据主键id未找到订单对象");
		}
		return dao.findById(id);
	}

	/**
	 * 根据付费方式查找，返回ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findByPayPath(Object property) {
		return dao.findByPayPath(property);
	}

	/**
	 * 根据员工对象查找，返回ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findByUser(Object property) {
		return dao.findByUser(property);
	}

	/**
	 * 根据抵押物对象查找，返回ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findByPledge(Object property) {
		return dao.findByPledge(property);
	}

	/**
	 * 根据钟点类型对象查找，返回ServerOrder实例
	 */
	@Override
	public List<ServerOrder> findByClockCategory(Object property) {
		return dao.findByClockCategory(property);
	}

	/**
	 * 查找今日订单
	 */
	@Override
	public List<ServerOrder> findTodayOrder() {
		return dao.findOrdersByDateLimit(WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	/**
	 * 查找指定日期的订单
	 */
	@Override
	public List<ServerOrder> findOrderByDate(Date date) {
		return dao.findOrdersByDateLimit(date, WorkDate.getNextDate(date));
	}

	/**
	 * 查找指定时间区域内的订单
	 * 
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 */
	@Override
	public List<ServerOrder> findOrderByDateLimit(Date begin, Date end) {
		return dao.findOrdersByDateLimit(begin, WorkDate.getNextDate(end));
	}

	/**
	 * 查找低于指定价格的所有订单
	 * 
	 * @param price
	 *            比较价格
	 */
	@Override
	public List<ServerOrder> findAllOrderLessThanPrice(int price) {
		return dao.findOrderByPriceLimit(price, CompareLevel.LESS_THAN);
	}

	/**
	 * 查找指定日期内低于指定价格的订单
	 * 
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param price
	 *            比较价格
	 */
	@Override
	public List<ServerOrder> findOrderLessThanPriceDate(int price, Date begin, Date end) {
		return dao.findOrderByPriceAndDateLimit(price, begin, end, CompareLevel.LESS_THAN);
	}

	/**
	 * 查找高于指定价格的所有订单
	 * 
	 * @param price
	 *            比较价格
	 */
	@Override
	public List<ServerOrder> findOrderMoreThanPrice(int price) {
		return dao.findOrderByPriceLimit(price, CompareLevel.MORE_THAN);
	}

	/**
	 * 查找指定日期内高于指定价格的订单
	 * 
	 * @param begin
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @param price
	 *            比较价格
	 */
	@Override
	public List<ServerOrder> findOrderMoreThanPriceDate(int price, Date begin, Date end) {
		return dao.findOrderByPriceAndDateLimit(price, begin, end, CompareLevel.MORE_THAN);
	}

	/**
	 * 根据页面查找页面内所有服务订单
	 */
	@Override
	public PageBean<ServerOrder> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderBean.init(findAllCount(), page);

		List<ServerOrder> list = dao.findListByLimit(begin, pageServerOrderBean.getLimit());

		pageServerOrderBean.setList(list);

		return pageServerOrderBean;
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders() {
		return dao.findOrdersByDateLimit(WorkDate.getBefore7DayDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findThisMonthOrders() {
		return dao.findOrdersByDateLimit(WorkDate.getBeginOfThisMonthDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public List<ServerOrder> findThisYearOrders() {
		return dao.findOrdersByDateLimit(WorkDate.getBeginOfThisYearDate(), WorkDate.getTomorrowDate());
	}

	@Override
	public <K> ServerOrder findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFieldsByModel(entity, fields);
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		return dao.findByProperty(map);
	}

	@Override
	public PageBean<ServerOrder> findOrdersByPropertyLimit(List<PropertyRange<?>> listPro, int page)
			throws PagePropertyNotInitException {
		long begin = pageServerOrderBean.init(dao.findOrdersByProperyLimitCount(listPro), page);

		List<ServerOrder> list = dao.findOrdersByProperyLimit(listPro, (int) begin,
				(int) pageServerOrderBean.getLimit());

		pageServerOrderBean.setList(list);

		return pageServerOrderBean;

	}

	@Override
	public PropertyRange<?> createPropertyRangeByName(String propertyName, Object o1, Object o2) {
		PropertyRange<?> pr = new PropertyRange<>(propertyName, o1, o2);
		return pr;
	}

	@Override
	public List<ServerOrder> findOrdersByProperyLimit(List<PropertyRange<?>> listPro, int begin, int limit) {
		return dao.findOrdersByProperyLimit(listPro, begin, limit);
	}

	@Override
	public void deleteAll(Collection<ServerOrder> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}

	/*@Override
	public PropertyRange<ServerOrder> createPropertyRangeById(java.io.Serializable id1)
			throws FindByIdGetNullException {
		PropertyRange<ServerOrder> pr = new PropertyRange<>();

		pr.setName(BasicDAO.ID);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());

		return pr;
	}*/
}
