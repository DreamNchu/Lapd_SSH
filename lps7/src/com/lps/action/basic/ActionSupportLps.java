package com.lps.action.basic;

import java.util.Map;

import com.lps.action.jsonresult.DataResult;
import com.opensymphony.xwork2.ActionSupport;

public class ActionSupportLps extends ActionSupport implements DataResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2888891847337870502L;
	
	protected Map<String , String[]> data ;
	
	public Map<String, String[]> getData() {
		return data;
	}

	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	@Override
	public String getResult() {
		return result.toString();
	}
	
	

}
