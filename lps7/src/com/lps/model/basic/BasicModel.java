package com.lps.model.basic;

/**
 * 基本的model类中的接口，可以获取model的主键ID
 * @author cyl
 *
 * @param <T> 基本Model所对应的Id的属性类型 
 */
public interface BasicModel<T> {
	
	/**
	 * 返回对象的id
	 * @return 返回对象的id
	 */
	T getId();
	
}
