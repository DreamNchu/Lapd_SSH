package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.User;
import com.lps.model.WorkRank;

public interface WorkRankDAO extends BasicDAO<WorkRank>{

	public List<WorkRank> findByUser(User user);
	
	public List<WorkRank> findByRank(int num);
	
	public List<WorkRank> findByRankNum(int num);
	
	public List<WorkRank> findBySpotNum(int num);


}