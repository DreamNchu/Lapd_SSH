package com.lps.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.dao.WorkStatusDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.WorkStatus;
import com.lps.model.basic.BasicModel;
import com.lps.service.WorkStatusService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

//@Component("adminServiceImpl")
//@Aspect
public class WorkStatusServiceImpl implements WorkStatusService {

	/**
	 * 以私有变量的方式保存WorkStatusDao
	 */
	private WorkStatusDAO dao;

	/**
	 * 将WorkStatus实体类封装到pagebean中
	 */
	private PageBean<WorkStatus> pageBean;

	/**
	 * 获取pagebean中WorkStatus实体类集合
	 * @return 返回实体类
	 */
	public PageBean<WorkStatus> getPageBean() {
		return pageBean;
	}

	/**
	 * 设置WorkStatus实体类集合
	 * @param pageBean 封装的WorkStatus实体类集合
	 */
	public void setPageBean(PageBean<WorkStatus> pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * 删除WorkStatus实例
	 */
	@Override
	public void delete(WorkStatus workStatus) {
		dao.delete(workStatus);
	}

	/**
	 * 返回所有WorkStatus实例
	 */
	@Override
	public List<WorkStatus> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有WorkStatus实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据id查找房间，返回WorkStatus实例
	 */
	@Override
	public WorkStatus findById(java.io.Serializable id) throws FindByIdGetNullException {
		WorkStatus workStatus = dao.findById(id);
		if(workStatus == null){
			throw new FindByIdGetNullException("根据主键id未找到工作状态对象");
		}
		return dao.findById(id);
	}

	/**
	 * 根据指定属性及其属性值查找WorkStatus实例，返回指定WorkStatus实例
	 */
	@Override
	public List<WorkStatus> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	/**
	 * 根据房间工作状态查找，返回WorkStatus实例
	 */
	@Override
	public List<WorkStatus> findByWorkStatus(Object workStatus) {
		return dao.findByWorkStatus(workStatus);
	}

	/**
	 * 获取WorkStatusDao实例
	 * @return 返回WorkStatusDao实例
	 */
	public WorkStatusDAO getWorkStatusDao() {
		return dao;
	}

	/**
	 * 保存WorkStatus实例
	 */
	@Override
	public void save(WorkStatus workStatus) {
		dao.save(workStatus);
	}

	/**
	 * 设置WorkStatusDao实例
	 * @param workStatusDao
	 */
	public void setWorkStatusDao(WorkStatusDAO workStatusDao) {
		this.dao = workStatusDao;
	}

	/**
	 * 根据id查找WorkStatus实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(WorkStatus user) {
		return dao.isExists(user);
	}
	
	{
//		pageBean.setAllCount(findAllCount(), 1);
	}

	@Override
	public PageBean<WorkStatus> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageBean.init(findAllCount(), page);

		List<WorkStatus> list = dao.findListByLimit( begin, pageBean.getLimit());

		pageBean.setList(list);

		return pageBean;
		
		
	}

	@Override
	public void update(WorkStatus entity) {
		// TODO Auto-generated method stub
		dao.update(entity);
	}

	@Override
	public <K> WorkStatus findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields) {
		return dao.findFieldsByModel(entity, fields);
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		return dao.findByProperty(map);
	}
	
/*	@Override
	public PropertyRange<WorkStatus> createPropertyRangeById(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<WorkStatus> pr = new PropertyRange<WorkStatus>();
		
		pr.setName(BasicDAO.ID);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}*/

	@Override
	public void deleteAll(Collection<WorkStatus> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}
}
