package com.lps.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.dao.WorkRankDAO;
import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;
import com.lps.model.OrderStatus;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.model.basic.BasicModel;
import com.lps.service.WorkRankService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;

public class WorkRankServiceImpl implements WorkRankService {
	
	/**
	 * 以私有变量的方式保存WorkRankDao
	 */
	private WorkRankDAO dao ;
	
	/**
	 * 将WorkRank实体类封装到pagebean中
	 */
	private PageBean<WorkRank> pageBean;

	/**
	 * 获取pagebean中WorkRank实体类集合
	 * @return 返回实体类
	 */
	public PageBean<WorkRank> getPageBean() {
		return pageBean;
	}

	/**
	 * 设置实体类集合
	 * @param pageBean 封装的WorkRank实体类
	 */
	public void setPageBean(PageBean<WorkRank> pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * 获取WorkRankDao实例
	 * @return 返回WorkRankDao实例
	 */
	public WorkRankDAO getWorkRankDao() {
		return dao;
	}

	/**
	 * 设置WorkRankDao实例
	 * @param WorkRankDao
	 */
	public void setWorkRankDao(WorkRankDAO WorkRankDao) {
		this.dao = WorkRankDao;
	}

	/**
	 * 保存WorkRank实例
	 */
	@Override
	public void save(WorkRank WorkRank) {
		dao.save(WorkRank);
	}

	/**
	 * 删除WorkRank实例
	 */
	@Override
	public void delete(WorkRank WorkRank) {
		dao.delete(WorkRank);
	}

	/**
	 * 根据id查找房间，返回WorkRank实例
	 */
	@Override
	public WorkRank findById(java.io.Serializable id) throws FindByIdGetNullException {
		WorkRank workRank = dao.findById(id);
		if(workRank != null){
			throw new FindByIdGetNullException("根据主键id未找到上钟排序对象");
		}
		return dao.findById(id);
	}
	
	/**
	 * 根据id查找WorkRank实例是否存在
	 * @return 存在则返回true，否则返回false
	 */
	@Override
	public boolean isExists(WorkRank user) {
		return dao.isExists(user);
	}

	/**
	 * 返回所有WorkRank实例
	 */
	@Override
	public List<WorkRank> findAll() {
		return dao.findAll();
	}

	/**
	 * 返回所有WorkRank实例的数量
	 */
	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	/**
	 * 根据指定属性及其属性值查找WorkRank实例，返回指定WorkRank实例
	 */
	@Override
	public List<WorkRank> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

//	public WorkRankServiceImpl() throws PagePropertyNotInitException {
//		pageBean.init(findAllCount(), 1);
//	}
	
	
	public PageBean<WorkRank> findByPage(int page) throws PagePropertyNotInitException {
		
		long begin = pageBean.init(findAllCount(), page);

		List<WorkRank> list = dao.findListByLimit( begin, pageBean.getLimit());

		pageBean.setList(list);

		return pageBean;
    }

	/**
	 * 更新WorkRank实例
	 */
	@Override
	public void update(WorkRank entity) {
		dao.update(entity);	
	}

	/**
	 * 根据员工名属性查找，返回WorkRank实例
	 */
	@Override
	public List<WorkRank> findByUser(User user) {
		return dao.findByUser(user);
	}

	/**
	 * 根据排列序号属性查找，返回WorkRank实例
	 */
	@Override
	public List<WorkRank> findByRank(int num) {
		return dao.findByRank(num);
	}

	/**
	 * 根据排钟数属性查找，返回WorkRank实例
	 */
	@Override
	public List<WorkRank> findByRankNum(int num) {
		return dao.findByRankNum(num);
	}

	/**
	 * 根据点钟数属性查找，返回WorkRank实例
	 */
	@Override
	public List<WorkRank> findBySpotNum(int num) {
		return dao.findBySpotNum(num);
	}
	@Override
	public WorkRank findFirstMinRankNum(){
		return dao.findFirstMinRankNum();
	}

	@Override
	public <K> WorkRank findFields(BasicModel<K> entity, Map<String, Class<?>> fields) {
		return dao.findFields(entity, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}
	
	@Override
	public PropertyRange<WorkRank> createPropertyRangeById(java.io.Serializable id1) throws FindByIdGetNullException {
		PropertyRange<WorkRank> pr = new PropertyRange<>();
		
		pr.setName(BasicDAO.ID);
		pr.setMinValue(findById(id1));
		pr.setMaxValue(pr.getMinValue());
		
		return pr;
	}

	@Override
	public void deleteAll(Collection<WorkRank> entities) {
		// TODO Auto-generated method stub
		dao.deleteAll(entities);
	}
}
