package com.lps.web.orderchart.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderChartDto {
	
	private List<Long> income = new ArrayList<>();
	
	private List<Long> orderCount = new ArrayList<>();

	private int timeType;

	public int getTimeType() {
		return timeType;
	}

	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}

	public List<Long> getIncome() {
		return income;
	}

	public void setIncome(List<Long> income) {
		this.income = income;
	}

	public List<Long> getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(List<Long> orderCount) {
		this.orderCount = orderCount;
	}
	
	
	
}
