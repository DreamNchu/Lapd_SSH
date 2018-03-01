package com.lps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.ComboDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.dao.impl.ClockCategoryDAOImpl;
import com.lps.dao.impl.ComboDAOImpl;
import com.lps.dao.impl.MedicineDAOImpl;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.Combo;
import com.lps.model.Medicine;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.ComboService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

public class ComboServiceImpl implements ComboService{
	
	/**
	 * 以私有变量的方式保存ClockCategoryDAO
	 */
	private ComboDAO dao;

	public ComboDAO getDao() {
		return dao;
	}

	public void setDao(ComboDAO dao) {
		this.dao = dao;
	}

	/**
	 * 将Combo实体类封装到pagebean中
	 */
	private PageBean<Combo> pageComboBean;

	/**
	 * 根据套餐得到的ServerOrder实体类封装到pagebean中
	 */
	private PageBean<ServerOrder> pageServerOrderByComboBean;

	/**
	 * 获取pagebean中Combo实体类集合
	 * @return 返回实体类
	 */
	public PageBean<ServerOrder> getPageServerOrderByComboBean() {
		return pageServerOrderByComboBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByComboBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByComboBean(PageBean<ServerOrder> pageServerOrderByComboBean) {
		this.pageServerOrderByComboBean = pageServerOrderByComboBean;
	}

	/**
	 * 获取pagebean中Combo实体类集合
	 * @return 返回实体类
	 */
	public PageBean<Combo> getPageComboBean() {
		return pageComboBean;
	}

	/**
	 * 设置Combo实体类集合
	 * @param pageComboBean 封装的Combo实体类集合
	 */
	public void setPageComboBean(PageBean<Combo> pageComboBean) {
		this.pageComboBean = pageComboBean;
	}


	@Override
	public Set<ServerOrder> findAllOrders(Combo t) {
		return dao.findAllOrders(t);
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Combo t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByComboBean.init(findOrdersCountByThisType(t), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByComboBean.getLimit());

		pageServerOrderByComboBean.setList(list);

		return pageServerOrderByComboBean;
		// TODO Auto-generated method stub
		
	}

	@Override
	public long findOrdersCountByThisType(Combo t) {
		return dao.findOrdersCountByThisType(t);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServerOrder> findTodayOrders(Combo t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(Combo t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	
	}

	@Override
	public List<ServerOrder> findThisMonthOrders(Combo t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServerOrder> findThisYearOrders(Combo t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
		// TODO Auto-generated method stub
	
	}

	@Override
	public PropertyRange<Combo> createProRangeForOrder(java.io.Serializable id1) throws FindByIdGetNullException {

		PropertyRange<Combo> pr = new PropertyRange<>();
		
		pr.setName(ServerOrderDAOImpl.CLOCK_CATEGORY);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExists(Combo entity) {
		return dao.isExists(entity);
		// TODO Auto-generated method stub
	}

	@Override
	public void save(Combo entity) {
		dao.save(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Combo combo) {
		dao.delete(combo);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<Combo> entities) {
		dao.deleteAll(entities);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Combo findById(java.io.Serializable id) throws FindByIdGetNullException {
		Combo combo = dao.findById(id);
		if(combo == null){
			throw new FindByIdGetNullException("根据主键id未找到套餐对象");
		}
		return dao.findById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Combo> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Combo> findAll() {
		return dao.findAll();
		// TODO Auto-generated method stub
	
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageBean<Combo> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageComboBean.init(findAllCount(), page);

		List<Combo> list = dao.findListByLimit(begin, pageComboBean.getLimit());

		pageComboBean.setList(list);

		return pageComboBean;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Combo entity) {
		dao.update(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> Combo findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		return dao.findFieldsByModel(entity, fields);
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		return dao.findByProperty(map);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Combo> findByCombo(Object combo) {
		return dao.findByCombo(combo);
		// TODO Auto-generated method stub
	
	}

	@Override
	public String findCombo(Combo combo) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(ComboDAOImpl.COMBO, String.class);
		return dao.findFieldsByModel(combo, map).getName();
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findIdByCombo(String combo) {
		Map<String, Object> map = new HashMap<>();
		map.put(ComboDAOImpl.COMBO, combo);
		List<Integer> list = dao.findByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
		// TODO Auto-generated method stub
	}

	}
