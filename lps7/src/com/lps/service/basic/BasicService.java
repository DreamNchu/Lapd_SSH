package com.lps.service.basic;

import java.util.List;
import java.util.Map;

import com.lps.model.PayPath;
import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

public interface BasicService<T> {
	/**
	 * 不存在常量
	 */
	int NOT_EXISTS = -1;
	
	boolean isExists(T user);
	
	void save(T transientInstance);

	void delete(T persistentInstance);
	
//	void delete(@SuppressWarnings("unchecked") T... fields);

	T findById(int id);

	List<T> findByProperty(String propertyName, Object value);

	List<T> findAll();
	
	/**
	 * 找到所有的{@code <T>}在数据库中的个数
	 * @return 返回找到所有的{@code <T>}在数据库中的个数
	 */
	public long findAllCount();
	
	public PageBean<T> findByPage(int page) throws PagePropertyNotInitException;

	void update(T t);
	
	/**
	 * 返回所需要字段对应的对象
	 * @param <K> 主键类型
	 * @param t 必须包含id属性
	 * @param fields 字段名称集合
	 * @return 返回所需要字段对应的对象
	 */
	<K> T findFields(BasicModel<K> t, Map<String, Class<?>> fields);
	
	/**
	 * 根据属性名获取id
	 * @param map 属性的名字和值
	 * @return
	 */
	<K> List<K> findIdByProperty(Map<String , Object> map);
	
	
}
