package com.lps.web.workrank.dto;

import com.lps.model.WorkRank;

public class WorkRankSingleDataDto extends WorkRankDto{
	
	/**
	 * 
	 */
	private static  long serialVersionUID = -7134431869002674930L;

	/*private int index;
	
	private int stuffId;
	
	private int workId;

	private String realName;

	private int rankNum;
	
	private int spotNum;
	
	public WorkRankSingleDataDto() {
		
	}
	
	public WorkRankSingleDataDto(int index, int workId, String realName, int rankNum, int spotNum) {
		super();
		this.index = index;
		this.workId = workId;
		this.realName = realName;
		this.rankNum = rankNum;
		this.spotNum = spotNum;
	}
	
	
	public int getIndex() {
		return index;
	}

	public int getRankNum() {
		return rankNum;
	}


	public String getRealName() {
		return realName;
	}





	public int getSpotNum() {
		return spotNum;
	}





	public int getStuffId() {
		return stuffId;
	}





	public int getWorkId() {
		return workId;
	}

	*//**
	 * 
	 * @param index 序号
	 * @param workRank
	 * @return
	 * @throws WorkRankSingleDataInitException
	 *//*
	public WorkRankSingleDataDto init(int index, WorkRank workRank) throws WorkRankSingleDataInitException{
		if(workRank == null || index == 0){
			throw new WorkRankSingleDataInitException();
		}
		this.index = index;
		this.workId = workRank.getUser().getWorkId();
		this.stuffId = workRank.getUser().getId();
		this.realName = workRank.getUser().getRealName();
		
		this.rankNum = workRank.getRankNum();
		this.spotNum = workRank.getSpotNum();
		
		return this;
	}
	

	public void setIndex(int index) {
		this.index = index;
	}

	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}*/
	
}
