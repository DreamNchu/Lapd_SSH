package com.lps.service;

import java.util.List;

import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.service.basic.BasicService;

public interface WorkRankService extends BasicService<WorkRank>{

	public List<WorkRank> findByUser(User user);
	
	public List<WorkRank> findByRank(int num);
	
	public List<WorkRank> findByRankNum(int num);
	
	public List<WorkRank> findBySpotNum(int num);


}