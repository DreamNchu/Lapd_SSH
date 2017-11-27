package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.WorkStatus;

/**
 * interfaceName:PayPathDAO
 * Description:继承自BasicDAO接口，包含查找付费方式的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface PayPathDAO extends BasicDAO<PayPath>, BasicForServerOrderDAO<PayPath, Integer>{

	/**
	 * 根据付费方式查找,返回付费方式
	 * <p>
	 * @param payPath 付费方式对象
	 * @return 返回付费方式对象的数组
	 */
	List<PayPath> findByPayPath(Object payPath);

}