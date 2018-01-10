package com.lps.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.MedicineDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.dao.impl.ComboDAOImpl;
import com.lps.dao.impl.MedicineDAOImpl;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.Medicine;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.MedicineService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;

public class MedicineServiceImpl implements MedicineService{
	
	/**
	 * 以私有变量的方式保存MedicineDAO
	 */
	private MedicineDAO dao;

	public MedicineDAO getDao() {
		return dao;
	}

	public void setDao(MedicineDAO dao) {
		this.dao = dao;
	}

	/**
	 * 将Medicine实体类封装到pagebean中
	 */
	private PageBean<Medicine> pageMedicineBean;

	/**
	 * 根据药品得到的ServerOrder实体类封装到pagebean中
	 */
	private PageBean<ServerOrder> pageServerOrderByMedicineBean;

	/**
	 * 获取pagebean中Medicine实体类集合
	 * @return 返回实体类
	 */
	public PageBean<ServerOrder> getPageServerOrderByMedicineBean() {
		return pageServerOrderByMedicineBean;
	}

	/**
	 * 设置ServerOrder实体类集合
	 * @param pageServerOrderByMedicineBean 封装的ServerOrder实体类集合
	 */
	public void setPageServerOrderByMedicineBean(PageBean<ServerOrder> pageServerOrderByMedicineBean) {
		this.pageServerOrderByMedicineBean = pageServerOrderByMedicineBean;
	}

	/**
	 * 获取pagebean中Medicine实体类集合
	 * @return 返回实体类
	 */
	public PageBean<Medicine> getPageMedicineBean() {
		return pageMedicineBean;
	}

	/**
	 * 设置ClockCategory实体类集合
	 * @param pageMedicineBean 封装的Medicine实体类集合
	 */
	public void setPageMedicineBean(PageBean<Medicine> pageMedicineBean) {
		this.pageMedicineBean = pageMedicineBean;
	}


	@Override
	public Set<ServerOrder> findAllOrders(Medicine t) {
		return dao.findAllOrders(t);
		// TODO Auto-generated method stub
	
	}

	@Override
	public PageBean<ServerOrder> findAllOrdersByPage(Medicine t, int page) throws PagePropertyNotInitException {
		long begin = pageServerOrderByMedicineBean.init(findOrdersCountByThisType(t), page);

		List<ServerOrder> list = dao.findOrdersWithLimit(t, begin, pageServerOrderByMedicineBean.getLimit());

		pageServerOrderByMedicineBean.setList(list);

		return pageServerOrderByMedicineBean;
		// TODO Auto-generated method stub
		
	}

	@Override
	public long findOrdersCountByThisType(Medicine t) {
		return dao.findOrdersCountByThisType(t);
		// TODO Auto-generated method stub
	}

	@Override
	public List<ServerOrder> findTodayOrders(Medicine t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getTodayDate(), WorkDate.getTomorrowDate());
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServerOrder> findBefore7DayOrders(Medicine t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBefore7DayDate(), WorkDate.getTodayDate());
	}
		
		

	@Override
	public List<ServerOrder> findThisMonthOrders(Medicine t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisMonthDate(), WorkDate.getTodayDate());
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServerOrder> findThisYearOrders(Medicine t) {
		return dao.findOrdersByDateLimit(t, WorkDate.getBeginOfThisYearDate(), WorkDate.getTodayDate());
		// TODO Auto-generated method stub
	
	}

	@Override
	public PropertyRange<Medicine> createProRangeForOrder(Serializable id1) throws FindByIdGetNullException {
       
		PropertyRange<Medicine> pr = new PropertyRange<>();
		
		pr.setName(ServerOrderDAOImpl.CLOCK_CATEGORY);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExists(Medicine entity) {
		return dao.isExists(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Medicine entity) {
		dao.save(entity);
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Medicine medicine) {
		dao.delete(medicine);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Collection<Medicine> entities) {
		dao.deleteAll(entities);
		// TODO Auto-generated method stub

	}

	@Override
	public Medicine findById(Serializable id) throws FindByIdGetNullException {
		Medicine medicine = dao.findById(id);
		if(medicine == null){
			throw new FindByIdGetNullException("根据主键id未找到药物对象");
		}
		return dao.findById(id);
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Medicine> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medicine> findAll() {
		return dao.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
		// TODO Auto-generated method stub
	}

	@Override
	public PageBean<Medicine> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageMedicineBean.init(findAllCount(), page);

		List<Medicine> list = dao.findListByLimit(begin, pageMedicineBean.getLimit());

		pageMedicineBean.setList(list);

		return pageMedicineBean;
		// TODO Auto-generated method stub
	
	}

	@Override
	public void update(Medicine entity) {
		dao.update(entity);
		// TODO Auto-generated method stub

	}

	@Override
	public <K> Medicine findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFieldsByModel(entity, fields);
		// TODO Auto-generated method stub
		
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		return dao.findByProperty(map);
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Medicine> findByMedicine(Object medicine) {
		return dao.findByMedicine(medicine);
		// TODO Auto-generated method stub
	
	}

	@Override
	public String findMedicine(Medicine medicine) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(MedicineDAOImpl.MEDICAL, String.class);
		return dao.findFieldsByModel(medicine, map).getName();
		// TODO Auto-generated method stub
	}

	@Override
	public int findIdByMedicine(String medicine) {
		Map<String, Object> map = new HashMap<>();
		map.put(MedicineDAOImpl.MEDICAL, medicine);
		List<Integer> list = dao.findByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
		// TODO Auto-generated method stub
	}


}
