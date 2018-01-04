package com.lps.web.orderchart.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.web.basicmsg.dto.BasicMsgDto;

/**
 * 订单图表dto
 * @author 0001
 *
 */
public class OrderChartDto extends BasicMsgDto{
	
	private List<Long> income ;
	
	private List<Long> orderCount ;
	
	private List<Long> orderRankCount ;
	
	private List<Long> orderSpotCount;
	
	public List<Long> getOrderSpotCount() {
		return orderSpotCount;
	}

	public void setOrderSpotCount(List<Long> orderSpotCount) {
		this.orderSpotCount = orderSpotCount;
	}

	public List<Long> getOrderRankCount() {
		return orderRankCount;
	}

	public void setOrderRankCount(List<Long> orderRankCount) {
		this.orderRankCount = orderRankCount;
	}

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
