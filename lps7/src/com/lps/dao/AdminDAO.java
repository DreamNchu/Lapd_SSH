package com.lps.dao;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;

/**
 * interfaceName:AdminDAO
 * Description:继承自BasicDAO接口，包含查找管理员的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface AdminDAO extends BasicDAO<Admin>{
	
	/**
	 * 根据用户名查找管理员,找到返回Admin对象,否则返回null
	 * <p>
	 * @param name 管理员名字 String类型
	 * @return 管理员对象
	 */
	public Admin getByUserName(String name);
	
}
