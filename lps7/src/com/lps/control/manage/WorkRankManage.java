package com.lps.control.manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lps.dao.WorkStatusDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.service.WorkRankService;

public class WorkRankManage {

	private WorkRankService workRankServiceImpl;

	public WorkRankManage() {

	}

	public WorkRankService getWorkRankServiceImpl() {
		return workRankServiceImpl;
	}

	public void setWorkRankServiceImpl(WorkRankService workRankServiceImpl) {
		this.workRankServiceImpl = workRankServiceImpl;
	}
	
	public User nextOneNotIn(Set<User> userSet){
		
		if(userSet == null){
			userSet = new HashSet<User>();
		}
		
		List<WorkRank> list = workRankServiceImpl.findAll();
		Collections.sort(list, new Comparator<WorkRank>() {
			@Override
			public int compare(WorkRank o1, WorkRank o2) {
				
				Integer i1 = o1.getRankNum();
				Integer i2 = o2.getRankNum();
				
				if(i1 == null) i1 = 0;
				if(i2 == null) i2 = 0;
				
				return i1 - i2;
			}
		});

		User select = null;
		/**
		 * 选择空闲的员工
		 */
		for (WorkRank workRank : list) {
			User u = workRank.getUser();
			if (u.getWorkStatus().getId() == WorkStatusDAO.FREE) {
				// 找到那便退出
				if(!userSet.contains(u)){
					select = u;
					break;
				}
			}
		}
		return select;
	}
	

	/**
	 * 下一个上钟的员工
	 * 条件要求
	 * <br>
	 * 1.该员工状态必须为空闲
	 * <br>
	 * 2.该员工的排钟数最小且在前列
	 * 
	 * @return
	 */
	public User nextOne() {
		return nextOneNotIn(null);
	}

	/**
	 * 添加员工上钟的工作信息
	 * 
	 * @param u
	 * @return
	 */
	public void addUserData(User u) {
		WorkRank wr = new WorkRank.Builder().setUser(u).build();
		workRankServiceImpl.save(wr);
	}

	public void deleteUserData(User u) {

		List<WorkRank> list = workRankServiceImpl.findByUser(u);

		if (list != null && list.size() > 0) {
			workRankServiceImpl.delete(list.get(0));
		} else {
			throw new NotExistsUserInWorkRankException("该用户没有在上钟排名表中");
		}

	}

	/**
	 * 增加一个点钟数
	 * @param u
	 */
	public void addUserSpotNum(User u) {

		List<WorkRank> list = workRankServiceImpl.findByUser(u);

		if (list != null && list.size() > 0) {
			WorkRank wr = list.get(0);
			wr.setSpotNum(wr.getSpotNum() + 1);
		} else {
			throw new NotExistsUserInWorkRankException("该用户没有在上钟排名表中");
		}

	}

	/**
	 * 减少一个点钟数
	 * @param u
	 */
	public void reduceUserSpotNum(User u) {
		List<WorkRank> list = workRankServiceImpl.findByUser(u);

		if (list != null && list.size() > 0) {
			WorkRank wr = list.get(0);
			wr.setSpotNum(wr.getSpotNum() - 1);
		} else {
			throw new NotExistsUserInWorkRankException("该用户没有在上钟排名表中");
		}
	}
	
	
	/**
	 * 增加一个排钟数
	 * @param u
	 */
	public void addUserRankNum(User u) {

		List<WorkRank> list = workRankServiceImpl.findByUser(u);

		if (list != null && list.size() > 0) {
			WorkRank wr = list.get(0);
			wr.setRankNum(wr.getRankNum() + 1);
		} else {
			throw new NotExistsUserInWorkRankException("该用户没有在上钟排名表中");
		}

	}

	/**
	 * 减少一个排钟数
	 * @param u
	 */
	public void reduceUserRankNum(User u) {
		List<WorkRank> list = workRankServiceImpl.findByUser(u);

		if (list != null && list.size() > 0) {
			WorkRank wr = list.get(0);
			wr.setRankNum(wr.getRankNum() - 1);
		} else {
			throw new NotExistsUserInWorkRankException("该用户没有在上钟排名表中");
		}
	}
	
	

}
