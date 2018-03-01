package com.lps.service.basic;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public interface BasicService<ENTITY extends BasicModel> {
	/**
	 * 不存在常量
	 */
	int NOT_EXISTS = -1;
	
	boolean isExists(ENTITY entity);
	
	void save(ENTITY entity);

	void delete(ENTITY persistentInstance);
	
	void deleteAll(Collection<ENTITY> entities);
	
	ENTITY findById(java.io.Serializable id) throws FindByIdGetNullException;

	List<ENTITY> findByProperty(String propertyName, Object value);

	List<ENTITY> findAll();
	
	/**
	 * 找到所有的{@code <T>}在数据库中的个数
	 * @return 返回找到所有的{@code <T>}在数据库中的个数
	 */
	public long findAllCount();
	
	public PageBean<ENTITY> findByPage(int page) throws PagePropertyNotInitException;

	void update(ENTITY entity);
	
	/**
	 * 返回所需要字段对应的对象
	 * @param <K> 主键类型
	 * @param entity 必须包含id属性
	 * @param fields 字段名称集合
	 * @return 返回所需要字段对应的对象
	 */
	<K> ENTITY findFieldsByModel(BasicModel entity, Map<String, Class<?>> fields);
	
	/**
	 * 根据属性名获取id
	 * @param map 属性的名字和值
	 * @return
	 */
	<K> List<K> findByProperty(Map<String , Object> map);
	
}
