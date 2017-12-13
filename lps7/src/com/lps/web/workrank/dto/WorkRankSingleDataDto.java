package com.lps.web.workrank.dto;

import com.lps.model.User;
import com.lps.model.WorkRank;

public class WorkRankSingleDataDto {
	
	private int index;
	
	private int workId;
	
	private String realName;
	
	private int rankNum;
	
	private int spotNum;
	
	
	public WorkRankSingleDataDto(int index, int workId, String realName, int rankNum, int spotNum) {
		super();
		this.index = index;
		this.workId = workId;
		this.realName = realName;
		this.rankNum = rankNum;
		this.spotNum = spotNum;
	}

	/**
	 * 
	 * @param index 序号
	 * @param workRank
	 * @return
	 * @throws WorkRankSingleDataInitException
	 */
	public WorkRankSingleDataDto init(int index, WorkRank workRank) throws WorkRankSingleDataInitException{
		if(workRank == null || index == 0){
			throw new WorkRankSingleDataInitException();
		}
		this.index = index;
		this.workId = workRank.getUser().getWorkId();
		this.realName = workRank.getUser().getRealName();
		
		this.rankNum = workRank.getRankNum();
		this.spotNum = workRank.getSpotNum();
		
		return this;
	}


	public int getRankNum() {
		return rankNum;
	}





	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}





	public int getSpotNum() {
		return spotNum;
	}





	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}





	public WorkRankSingleDataDto() {
		// TODO Auto-generated constructor stub
	}
	




	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
}
