package com.lps.dao.basic;

import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;

public interface BasicDAO<T> {
	
	public void save(T t);
	/**
	 * 根据对象的Id删除
	 * @param admin
	 */
	public void delete(T t);
	
	public T findById(int id);

	/**
	 * 根据对象的id判断是否存在
	 * @param t
	 * @return
	 */
	public boolean isExists(T t);
	
	public List<T> findByProperty(String propertyName, Object value) ;
	
	public  List<T> findAll();
	
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
	 * @param t
	 */
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
