package com.lps.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.OrderStatusDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.dao.impl.ClockCategoryDAOImpl;
import com.lps.dao.impl.OrderStatusDAOImpl;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.Admin;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.OrderStatusService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

//@Component("adminServiceImpl")
//@Aspect
public class OrderStatusServiceImpl implements OrderStatusService {

	/**
	 * 以私有变量的方式保存OrderStatusDAO
	 */
	private OrderStatusDAO dao;

	/**
	 * 将OrderStatus实体类封装到pagebean中
	 */
	private PageBean<OrderStatus> pageOrderStatusBean;
	
	/**
	 * 根据订单状态得到的ServerOrder实体类封装到pagebean中
	 */
	private PageBean<ServerOrder> pageServerOrderByOrderStatusBean;

	/**
	 * 删除OrderStatus实例
	 */
	@Override
	public void delete(OrderStatus workStatus) {
		dao.delete(workStatus);
	}

	/**
	 * 返回所有OrderStatus实例
	 */
	@Override
	public List<OrderStatus> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有OrderStatus实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 返回指定订单状态的所有服务订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(OrderStatus entity) {
		return dao.findAllOrders(entity);
	}

	/**
	 * 根据id查找订单状态，返回OrderStatus实例
	 */
	@Override
	public OrderStatus findById(java.io.Serializable id) throws FindByIdGetNullException {
		OrderStatus orderStatus = dao.findById(id);
		if(orderStatus == null){
			throw new FindByIdGetNullException("根据主键id未找到订单状态对象");
		}
		return dao.findById(id);
	}

	/**
	 * 根据订单状态查找，返回OrderStatus实例
	 */
	@Override
	public List<OrderStatus> findByOrderStatus(Object orderStatus) {
		return dao.findByOrderStatus(orderStatus);
	}

	/**
	 * 根据页面查找页面内所有订单状态
	 */
	@Override
	public PageBean<OrderStatus> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageOrderStatusBean.init(findAllCount(), page);

		List<OrderStatus> list = dao.findListByLimit(begin, pageOrderStatusBean.getLimit());

		pageOrderStatusBean.setList(list);

		return pageOrderStatusBean;
	}

	/**
	 * 根据指定属性及其属性值查找OrderStatus实例，返回指定OrderStatus实例
	 */
	@Override
	public List<OrderStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 查找指定页面内根据订单状态得到的所有订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(OrderStatus entity, int page) throws PagePropertyNotInitException {
		long begin= pageServerOrderByOrderStatusBean.init(findOrdersCountByThisType(entity), page);
        
        List<ServerOrder> list = dao.findOrdersWithLimit(entity, begin, pageServerOrderByOrderStatusBean.getLimit());
        
        pageServerOrderByOrderStatusBean.setList(list);
        
        return pageServerOrderByOrderStatusBean;
	}

	/**
	 * 根据指定订单状态类型查找订单数量
	 */
	@Override
	public long findOrdersCountByThisType(OrderStatus entity) {
		return dao.findOrdersCountByThisType(entity);
	}

	/**
	 * 获取adminDao实例
	 * @return 返回adminDao实例
	 */
	public OrderStatusDAO getOrderStatusDao() {
		return dao;
	}

	/**
	 * 获取pagebean中OrderStatus实体类集合
	 * @return 返回实体类
	 */
	public PageBean<OrderStatus> getPageOrderStatusBean() {
		return pageOrderStatusBean;
	}

	/**
	 * 获取pagebean中ServerOrder实体类集合
	 * @return 返回实体类
	 */
	public PageBean<ServerOrder> getPageServerOrderByOrderStatusBean() {
		return pageServerOrderByOrderStatusBean;
	}

	/**
	 * 根据id查找OrderStatus实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(OrderStatus OrderStatus) {
		return dao.isExists(OrderStatus);
	}

	/**
	 * 保存OrderStatus实例
	 */
	@Override
	public void save(OrderStatus orderStatus) {
		dao.save(orderStatus);
	}

	/**
	 * 设置OrderStatusDAO实例
	 * @param orderStatusDao
	 */
	public void setOrderStatusDao(OrderStatusDAO orderStatusDao) {
		this.dao = orderStatusDao;
	}

	/**
	 * 设置OrderStatus实体类集合
	 * @param pageOrderStatusBean 封装的OrderStatus实体类集合
	 */
	public void setPageOrderStatusBean(PageBean<OrderStatus> pageOrderStatusBean) {
		this.pageOrderStatusBean = pageOrderStatusBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByOrderStatusBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByOrderStatusBean(PageBean<ServerOrder> pageServerOrderByOrderStatusBean) {
		this.pageServerOrderByOrderStatusBean = pageServerOrderByOrderStatusBean;
	}
	
	/**
	 * 更新OrderStatus实例
	 */
	@Override
	public void update(OrderStatus entity) {
		dao.update(entity);
	}

	/**
	 * 查找订单状态字段对应的对象
	 */
	@Override
	public String findOrderStatus(OrderStatus orderStatus) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(OrderStatusDAOImpl.ORDER_STATUS, String.class);
		return dao.findFieldsByModel(orderStatus, map).getOrderstatus();
	}

	/**
	 * 根据订单状态查找订单id，存在则返回id，否则返回NOT_EXISTS
	 */
	@Override
	public int findIdByOrderStatus(String orderStatusProperty) {
		Map<String, Object> map = new HashMap<>();
		map.put(OrderStatusDAOImpl.ORDER_STATUS, orderStatusProperty);
		List<Integer> list = dao.findByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}

	/**
	 * 查找今天的订单
	 */
	@Override
	public List<ServerOrder> findTodayOrders(OrderStatus entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	/**
	 * 查找前七天的订单
	 */
	@Override
	public List<ServerOrder> findBefore7DayOrders(OrderStatus entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找这个月的订单
	 */
	@Override
	public List<ServerOrder> findThisMonthOrders(OrderStatus entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找今年的订单
	 */
	@Override
	public List<ServerOrder> findThisYearOrders(OrderStatus entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

	@Override
	public <K> OrderStatus findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		return dao.findFieldsByModel(entity, fields);
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		return dao.findByProperty(map);
	}

	@Override
	public PropertyRange<OrderStatus> createProRangeForOrder(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<OrderStatus> pr = new PropertyRange<OrderStatus>();
		
		pr.setName(ServerOrderDAOImpl.ORDER_STATUS);
		
		pr.setMaxValue(findById(id1));
		pr.setMinValue(pr.getMaxValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<OrderStatus> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}

}
