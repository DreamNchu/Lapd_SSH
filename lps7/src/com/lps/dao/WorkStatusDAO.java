package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.PayPath;
import com.lps.model.WorkStatus;

/**
 * interfaceName:WorkStatusDAO
 * Description:继承自BasicDAO接口，包含查找工作状态的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface WorkStatusDAO extends BasicDAO<WorkStatus>{
	
	/**
	 * 空闲
	 */
	int FREE = 1;
	/**
	 * 被等待
	 */
	int WAITED = 2;
	/**
	 * 工作钟
	 */
	int WORKING = 3;

	/**
	 * 根据工作状态查找
	 * <p>
	 * @param workStatus 工作状态
	 * @return 返回工作状态对象的数组
	 */
	List<WorkStatus> findByWorkStatus(Object workStatus);

}