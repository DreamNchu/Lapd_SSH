package com.lps.web.orderchart.dto;

public class OrderChartRequestDto {

	private int timeType;
	
	private int population;
	
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public OrderChartRequestDto() {
	}

	public OrderChartRequestDto(int timeType, int population) {
		super();
		this.timeType = timeType;
		this.population = population;
	}

	public int getTimeType() {
		return timeType;
	}

	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
}
