package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;

/**
 * interfaceName:OrderStatusDAO
 * Description:继承自BasicDAO接口，包含根据各种属性查找工作排班的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface WorkRankDAO extends BasicDAO<WorkRank>{

	/**
	 * 根据员工名查找工作排班
	 * <p>
	 * @param user 员工名
	 * @return 返回工作排班对象的数组
	 */
	public List<WorkRank> findByUser(User user);
	
	/**
	 * 根据排名序号查找工作排班
	 * <p>
	 * @param num 序号
	 * @return 返回工作排班对象的数组
	 */
	public List<WorkRank> findByRank(int num);
	
	/**
	 * 根据排钟查找工作排班
	 * <p>
	 * @param num 排钟
	 * @return 返回工作排班对象的数组
	 */
	public List<WorkRank> findByRankNum(int num);
	
	/**
	 * 根据点钟查找工作排班
	 * <p>
	 * @param num 点钟
	 * @return 返回工作排班对象的数组
	 */
	public List<WorkRank> findBySpotNum(int num);


}