package com.lps.control.manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lps.dao.WorkStatusDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.service.WorkRankService;

public class WorkRankManage {
	
	private WorkRankService workRankServiceImpl;
	

	public WorkRankService getWorkRankServiceImpl() {
		return workRankServiceImpl;
	}

	public void setWorkRankServiceImpl(WorkRankService workRankServiceImpl) {
		this.workRankServiceImpl = workRankServiceImpl;
	}
	
	/**
	 * 下一个上钟的员工
	 * @return
	 */
	public User nextOne(){
		
		List<WorkRank> list = workRankServiceImpl.findAll();
		Collections.sort( list,new Comparator<WorkRank>() {  
            @Override  
            public int compare(WorkRank o1, WorkRank o2) {  
            	int i = o1.getRankNum() - o2.getRankNum();
            	return i;
            }  
        });
		
		User select = null;
		/**
		 * 选择空闲的员工
		 */
		for (WorkRank workRank : list) {
			User u = workRank.getUser();
			if(u.getWorkStatus().getId() == WorkStatusDAO.FREE){
				//找到那便退出
				select = u;
				break;
			}
		}
		return select;
	}
	
	

}
