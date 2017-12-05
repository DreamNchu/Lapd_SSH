package com.lps.web.dto;

import com.lps.model.User;

public class WorkRankDto {
	
	private User user;
	
	private int rank;
	
	private Integer rankNum;
	
	private Integer spotNum;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Integer getRankNum() {
		return rankNum;
	}

	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
	}

	public Integer getSpotNum() {
		return spotNum;
	}

	public void setSpotNum(Integer spotNum) {
		this.spotNum = spotNum;
	}
	
	
	
}
