package com.lps.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.PledgeDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.dao.impl.PayPathDAOImpl;
import com.lps.dao.impl.PledgeDAOImpl;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.Pledge;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.PledgeService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

//@Component("adminServiceImpl")
//@Aspect
public class PledgeServiceImpl implements PledgeService {
	
	/**
	 * 以私有变量的方式保存PledgeDAO
	 */
	private PledgeDAO dao ;
	
	/**
	 * 将pledge实体类封装到pagebean中
	 */
	private PageBean<Pledge> pagePledgeBean;
	
	/**
	 * 根据抵押物得到的ServerOrder实体类封装到pagebean中
	 */
	/**
	 * 获取pagebean中pledge实体类集合
	 * @return 返回实体类
	 */
	public PageBean<Pledge> getPagePledgeBean() {
		return pagePledgeBean;
	}

	/**
	 * 设置pledge实体类集合
	 * @param pagePledgeBean 封装的Pledge实体类集合
	 */
	public void setPagePledgeBean(PageBean<Pledge> pagePledgeBean) {
		this.pagePledgeBean = pagePledgeBean;
	}

	private PageBean<ServerOrder> pageServerOrderByPledgeBean;

	public PledgeDAO getPledgeDao() {
		return dao;
	}

	/**
	 * 设置PledgeDAO实例
	 * @param pledgeDao
	 */
	public void setPledgeDao(PledgeDAO pledgeDao) {
		this.dao = pledgeDao;
	}

	/**
	 * 删除Pledge实例
	 */
	@Override
	public void delete(Pledge pledge) {
		dao.delete( pledge);
	}

	/**
	 * 返回所有Pledge实例
	 */
	@Override
	public List<Pledge> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有Pledge实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据id查找抵押物，返回Pledge实例
	 */
	@Override
	public Pledge findById(java.io.Serializable id) throws FindByIdGetNullException {
		Pledge pledge = dao.findById(id);
		if(pledge == null){
			throw new FindByIdGetNullException("根据主键id未找到抵押物品对象");
		}
		return dao.findById(id);
	}

	/**
	 * 根据指定属性及其属性值查找Pledge实例，返回指定Pledge实例
	 */
	@Override
	public List<Pledge> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 根据名字查找Pledge实例，返回指定Pledge实例
	 */
	@Override
	public List<Pledge> findByName(Object pledge) {
		return dao.findByName(pledge);
	}

	/**
	 * 保存Pledge实例
	 */
	@Override
	public void save(Pledge pledge) {
		dao.save(pledge);
	}

	/**
	 * 根据id查找Pledge实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(Pledge user) {
		return false;
	}

	/**
	 * 根据页面查找页面内所有抵押物
	 */
	@Override
	public PageBean<Pledge> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pagePledgeBean.init(findAllCount(), page);

		List<Pledge> list = dao.findListByLimit(begin, pagePledgeBean.getLimit());

		pagePledgeBean.setList(list);

		return pagePledgeBean;
	}

	/**
	 * 更新Pledge实例
	 */
	@Override
	public void update(Pledge entity) {
		dao.update(entity);
	}

	/**
	 * 返回指定抵押物的所有服务订单
	 */
	@Override
	public Set<ServerOrder> findAllOrders(Pledge entity) {
		return dao.findAllOrders(entity);
	}

	/**
	 * 查找指定页面内根据抵押物得到的所有订单
	 */
	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Pledge entity, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByPledgeBean.init(findOrdersCountByThisType(entity), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(entity, begin, pageServerOrderByPledgeBean.getLimit());

		pageServerOrderByPledgeBean.setList(list);

		return pageServerOrderByPledgeBean;
	}

	/**
	 * 根据指定抵押物类型查找订单数量
	 */
	@Override
	public long findOrdersCountByThisType(Pledge entity) {
		return dao.findOrdersCountByThisType(entity);
	}

	/**
	 * 查找抵押物字段对应的对象
	 */
	@Override
	public String findPledge(Pledge pledge) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(PledgeDAOImpl.PLEDGE, String.class);
		return dao.findFields(pledge, map).getName();
	}

	/**
	 * 根据抵押物查找订单id，存在则返回id，否则返回NOT_EXISTS
	 */
	@Override
	public int findIdByPledge(String pledgeProperty) {
		Map<String, Object> map = new HashMap<>();
		map.put(PledgeDAOImpl.PLEDGE, pledgeProperty);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}

	/**
	 * 查找今天的订单
	 */
	@Override
	public List<ServerOrder> findTodayOrders(Pledge entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
	}

	/**
	 * 查找前七天的订单
	 */
	@Override
	public List<ServerOrder> findBefore7DayOrders(Pledge entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找这个月的订单
	 */
	@Override
	public List<ServerOrder> findThisMonthOrders(Pledge entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
	}

	/**
	 * 查找今年的订单
	 */
	@Override
	public List<ServerOrder> findThisYearOrders(Pledge entity) {
		return dao.findOrdersByDateLimit(entity, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
	}

	@Override
	public <K> Pledge findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFields(entity, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

	@Override
	public PropertyRange<Pledge> createProRangeForOrder(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<Pledge> pr = new PropertyRange<>();
		
		pr.setName(ServerOrderDAOImpl.PLEDGE);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<Pledge> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}

}
