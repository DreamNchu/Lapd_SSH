package com.lps.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.dao.impl.ClockCategoryDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.ClockCategoryService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

public class ClockCategoryServiceImpl implements ClockCategoryService {

	/**
	 * 以私有变量的方式保存ClockCategoryDAO
	 */
	private ClockCategoryDAO dao;

	/**
	 * 将ClockCategory实体类封装到pagebean中
	 */
	private PageBean<ClockCategory> pageClockCategoryBean;

	/**
	 * 根据钟点类型得到的ServerOrder实体类封装到pagebean中
	 */
	private PageBean<ServerOrder> pageServerOrderByClockCategoryBean;

	/**
	 * 获取pagebean中ClockCategory实体类集合
	 * @return 返回实体类
	 */
	public PageBean<ServerOrder> getPageServerOrderByClockCategoryBean() {
		return pageServerOrderByClockCategoryBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByClockCategoryBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByClockCategoryBean(PageBean<ServerOrder> pageServerOrderByClockCategoryBean) {
		this.pageServerOrderByClockCategoryBean = pageServerOrderByClockCategoryBean;
	}

	/**
	 * 获取pagebean中ClockCategory实体类集合
	 * @return 返回实体类
	 */
	public PageBean<ClockCategory> getPageClockCategoryBean() {
		return pageClockCategoryBean;
	}

	/**
	 * 设置ClockCategory实体类集合
	 * @param pageClockCategoryBean 封装的ClockCategory实体类集合
	 */
	public void setPageClockCategoryBean(PageBean<ClockCategory> pageClockCategoryBean) {
		this.pageClockCategoryBean = pageClockCategoryBean;
	}

	/**
	 * 删除ClockCategory实例
	 */
	@Override
	public void delete(ClockCategory clockCategory) {
		dao.delete(clockCategory);
	}
/**
 * 返回所有ClockCategory实例
 */
	@Override
	public List<ClockCategory> findAll() {
		return dao.findAll();
	}
	/**
	 * 返回所有ClockCategory实例数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据id查找，返回所有ClockCategory实例
     */
	@Override
	public ClockCategory findById(java.io.Serializable id) throws FindByIdGetNullException {
		ClockCategory clockCategory = dao.findById(id);
		if(clockCategory != null){
			throw new FindByIdGetNullException("根据主键id未找到钟点类型对象");
		}
		return dao.findById(id);
	}

	/**
	 * 根据指定属性及其属性值查找实例，返回指定ClockCategory实例
	 */
	@Override
	public List<ClockCategory> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}
	
	/**
	 * 根据clockCategory属性查找，返回ClockCategory实例
	 */
	@Override
	public List<ClockCategory> findByClockCategory(Object clockCategory) {
		return dao.findByClockCategory(clockCategory);
	}

	/**
	 * 获取ClockCategoryDAO实例
	 * @return 返回ClockCategoryDAO实例
	 */
	public ClockCategoryDAO getClockCategoryDao() {
		return dao;
	}

	/**
	 * 保存ClockCategory实例
	 */
	@Override
	public void save(ClockCategory clockCategory) {
		dao.save(clockCategory);
	}

	/**
	   * 设置ClockCategoryDAO实例
	   * @param ClockCategoryDao
	   */
	public void setClockCategoryDao(ClockCategoryDAO ClockCategoryDao) {
		this.dao = ClockCategoryDao;
	}

	/**
	 * 根据id查找ClockCategory实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(ClockCategory ClockCategory) {
		return dao.isExists(ClockCategory);
	}

	/**
	 * 根据页面查找页面内所有钟点类型
	 */
	@Override
	public PageBean<ClockCategory> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageClockCategoryBean.init(findAllCount(), page);

		List<ClockCategory> list = dao.findListByLimit(begin, pageClockCategoryBean.getLimit());

		pageClockCategoryBean.setList(list);

		return pageClockCategoryBean;
	}

	/**
	 * 更新ClockCategory实例
	 */
	@Override
	public void update(ClockCategory entity) {
		dao.update(entity);
	}

	/**
	 * 根据ClockCategory查找所有订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(ClockCategory cc) {
		return dao.findAllOrders(cc);
	}

	/**
	 * 返回指定钟点类型的所有服务订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(ClockCategory cc, int page) throws PagePropertyNotInitException {

		long begin = pageServerOrderByClockCategoryBean.init(findOrdersCountByThisType(cc), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(cc, begin, pageServerOrderByClockCategoryBean.getLimit());

		pageServerOrderByClockCategoryBean.setList(list);

		return pageServerOrderByClockCategoryBean;
	}

	/**
	 * 根据指定房钟点类型查找订单数量
	 */
	@Override
	public long findOrdersCountByThisType(ClockCategory entity) {
		return dao.findOrdersCountByThisType(entity);
	}

	/**
	 * 查找钟点类型字段对应的对象
	 */
	@Override
	public String findClockCategory(ClockCategory clockCategory) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(ClockCategoryDAOImpl.CLOCK_CATEGORY, String.class);
		return dao.findFields(clockCategory, map).getClockCategory();
	}

	/**
	 * 根据钟点类型查找订单id，存在则返回id，否则返回NOT_EXISTS
	 */
	@Override
	public int findIdByClockCategory(String clockCategory) {
		Map<String, Object> map = new HashMap<>();
		map.put(ClockCategoryDAOImpl.CLOCK_CATEGORY, clockCategory);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}
	
	/**
	 * 查找今天的订单
	 */
	@Override
	public List<ServerOrder> findTodayOrders(ClockCategory entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	/**
	 * 查找前面7天的订单
	 */
	@Override
	public List<ServerOrder> findBefore7DayOrders(ClockCategory entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找这个月的订单
	 */
	@Override
	public List<ServerOrder> findThisMonthOrders(ClockCategory entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找今年的订单
	 */
	@Override
	public List<ServerOrder> findThisYearOrders(ClockCategory entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}
	
	@Override
	public <K> ClockCategory findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFields(entity, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}
	
	@Override
	public PropertyRange<ClockCategory> createPropertyRangeById(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<ClockCategory> pr = new PropertyRange<>();
		
		pr.setName(BasicDAO.ID);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<ClockCategory> entities) {
		dao.deleteAll(entities);
	}

}
