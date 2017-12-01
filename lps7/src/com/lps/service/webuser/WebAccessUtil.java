package com.lps.service.webuser;

import com.lps.model.Admin;
import com.lps.model.basic.BasicModel;

/**
 * Web登录，注册的工具接口
 * @author 0001
 *
 */
public interface WebAccessUtil {

	/**
	 * 根据用户名返回密码
	 * @param userName 用户名
	 * @return 返回密码
	 */
	String findPasswordByUserName(String userName);
	
	/**
	 * 根据对象的id找到密码
	 * @param <T> 基本的model类型
	 * @return 返回密码
	 */
	public <T> String findPassword(BasicModel<T> t);
	
	/**
	 * 如果只是单纯的查找id的话，那么这种方法的效率最高
	 * 
	 * 通过对象的userName找到对应字段的id
	 * 
	 * @param name userName
	 * @return id
	 */
	public int findIdByUserName(String name);
	
}
