package com.lps.util;

public class PropertyRange {
	
	private String name;
	private Object maxValue;
	private Object minValue;
	
	public PropertyRange() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PropertyRange(String name,  Object minValue ,Object maxValue) {
		super();
		this.name = name;
		this.maxValue = maxValue;
		this.minValue = minValue;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Object maxValue) {
		this.maxValue = maxValue;
	}
	public Object getMinValue() {
		return minValue;
	}
	public void setMinValue(Object minValue) {
		this.minValue = minValue;
	}
	
	
	
}
