package com.lps.dao.basic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;

public interface BasicDAO<T> {
	
	String ID = "id";
	
	/**
	 * 根据对象的id保存
	 * @param entity 指定对象
	 */
	public void save(T entity);
	/**
	 * 根据对象的Id删除
	 * @param entity 指定对象
	 */
	public void delete(T entity);
	
	/**
	 * 批量删除
	 * @param entity
	 */
	public void deleteAll(Collection<T> entities);
	
	/**
	 * 根据id查找指定对象	 
	 * @param id ID
	 * @return 指定对象
	 */
	public T findById(Serializable id);

	/**
	 * 根据对象的id判断是否存在
	 * @param entity 指定对象
	 * @return 返回true则代表存在，否则不存在
	 */
	public boolean isExists(T entity);
	
	/**
	 * 根据指定属性查找指定对象列表
	 * @param propertyName 指定属性名
	 * @param value 属性值
	 * @return 指定对象列表
	 */
	public List<T> findByProperty(String propertyName, Object value) ;
	
	/**
	 * 查找所有指定对象
	 * @return 指定对象列表
	 */
	public  List<T> findAll();
	
	/**
	 * 查找指定对象的数量
	 * @return 数量
	 */
	public long findAllCount();
	
	/**
	 * 根据开始的下标begin，以及该从该下标开始的limit个数
	 * @param begin 开始值的下标
	 * @param limit 从该下标开始的limit个数
	 * @return 返回该范围内的list
	 */
	List<T> findListByLimit(long begin, long limit);
	
	/**
	 * 更新已经改完的字段
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 返回所需要字段对应的对象
	 * @param <K> 主键类型
	 * @param entity 必须包含id属性
	 * @param fields 字段名称集合
	 * @return 返回所需要字段对应的对象
	 */
	<K> T findFields(BasicModel<K> entity, Map<String, Class<?>> fields);
	
	/**
	 * 根据属性名获取id
	 * @param map 属性的名字和值
	 * @return
	 */
	<K> List<K> findIdByProperty(Map<String , Object> map);
		

}
