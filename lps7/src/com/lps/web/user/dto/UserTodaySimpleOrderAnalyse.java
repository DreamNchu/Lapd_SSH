package com.lps.web.user.dto;

public class UserTodaySimpleOrderAnalyse {

	private int spotNum;
	
	private int rankNum;
	
	public UserTodaySimpleOrderAnalyse() {
		
	}
	
	public UserTodaySimpleOrderAnalyse(int spotNum, int rankNum, int companyIncome, int mineIncome) {
		super();
		this.spotNum = spotNum;
		this.rankNum = rankNum;
		this.companyIncome = companyIncome;
		this.mineIncome = mineIncome;
	}

	private int companyIncome;
	
	private int mineIncome;
	
	

	public int getSpotNum() {
		return spotNum;
	}

	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}

	public int getRankNum() {
		return rankNum;
	}

	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

	public int getCompanyIncome() {
		return companyIncome;
	}

	public void setCompanyIncome(int companyIncome) {
		this.companyIncome = companyIncome;
	}

	public int getMineIncome() {
		return mineIncome;
	}

	public void setMineIncome(int mineIncome) {
		this.mineIncome = mineIncome;
	}
	
}
