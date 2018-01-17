package com.lps.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.metamodel.domain.Hierarchical;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lps.dao.TestDAO;
import com.lps.model.Admin;
import com.lps.model.Test;
import com.lps.model.basic.BasicModel;

public class TestImpl implements TestDAO{
	
	/**
	 * 以私有变量的方式保存HibernateTemplate
	 */
	private HibernateTemplate hibernateTemplate;

	/**
	 * 获取HibernateTemplate实例
	 * 
	 * @return HibernateTemplate实例
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * 设置HibernateTemplate实例
	 * 
	 * @param hibernateTemplate
	 *            实例
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public void save(Test entity) {
		hibernateTemplate.save(entity);
	}

	@Override
	public void delete(Test entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void deleteAll(Collection<Test> entities) {
		// TODO Auto-generated method stub
		hibernateTemplate.deleteAll(entities);
	}

	@Override
	public Test findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Test entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Test> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> findAll() {
		return (List<Test>) hibernateTemplate.find("from Test");
	}

	@Override
	public long findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Test> findListByLimit(long begin, long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Test entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(entity);
	}

	@Override
	public <K> Test findFieldsByModel(BasicModel<K> entity, Map<String, Class<?>> fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> List<K> findByProperty(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}	

}
