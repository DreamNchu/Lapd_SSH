package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.WorkStatus;

/**
 * interfaceName:PledgeDAO
 * Description:继承自BasicDAO接口，包含查找抵押物的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface PledgeDAO extends BasicDAO<Pledge>, BasicForServerOrderDAO<Pledge, Integer>{

	/**
	 * 根据名字查找,返回抵押物品
	 * <p>
	 * @param pledge 抵押物品对象
	 * @return 返回抵押物品对象的数组
	 */
	List<Pledge> findByName(Object pledge);

}