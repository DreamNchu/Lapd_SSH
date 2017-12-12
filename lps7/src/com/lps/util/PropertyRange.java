package com.lps.util;

public class PropertyRange<T> {
	
	private String name;
	private T maxValue;
	private T minValue;
	
	public PropertyRange() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PropertyRange(String name,  T minValue ,T maxValue) {
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
	public T getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(T maxValue) {
		this.maxValue = maxValue;
	}
	public T getMinValue() {
		return minValue;
	}
	public void setMinValue(T minValue) {
		this.minValue = minValue;
	}
	
	
	
}
