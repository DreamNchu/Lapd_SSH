package com.lps.service;

import java.util.List;

import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.service.basic.BasicService;

public interface WorkRankService extends BasicService<WorkRank>{

	/**
	 * 根据员工名查找上钟序列
	 * @param user 员工账号
	 * @return 返回上钟序列
	 */
	public List<WorkRank> findByUser(User user);
	
	/**
	 * 根据序号查找上钟序列
	 * @param 序号 员工序号
	 * @return 返回上钟序列
	 */
	public List<WorkRank> findByRank(int num);
	
	/**
	 * 根据排钟类型查找上钟序列
	 * @param rankNum 排钟数
	 * @return 返回上钟序列
	 */
	public List<WorkRank> findByRankNum(int rankNum);
	
	/**
	 * 根据点钟类型查找上钟序列
	 * @param spotNum 点钟数
	 * @return 返回上钟序列
	 */
	public List<WorkRank> findBySpotNum(int spotNum);


}