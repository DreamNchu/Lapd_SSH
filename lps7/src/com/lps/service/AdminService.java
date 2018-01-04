package com.lps.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.lps.model.Admin;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.service.webuser.WebAccessUtil;

/**
 * 若没有直接说明，则所有的查询都是按照id来判断其结果
 * 
 * @author 0001
 *
 */
public interface AdminService extends BasicService<Admin>, WebAccessUtil {

	/**
	 * 根据名字返回Admin对象
	 * @param name Admin对象的名字
	 * @return 返回Admin对象
	 */
	public Admin findByUserName(String name);

	/**
	 * 根据admin对象的Id获取注册时间
	 * @param admin 必须存在属性id
	 * @return 返回该id对应Admin对象的的注册时间
	 * @throws FindByIdGetNullException 
	 */
	public Date findRegisterTime(Admin admin) throws FindByIdGetNullException;

	/**
	 * 获取admin对象的头像
	 * @param admin 必须存在属性id
	 * @return 返回admin对象的头像
	 * @throws FindByIdGetNullException 
	 */
	public String getAvatar(Admin admin) throws FindByIdGetNullException;

}
