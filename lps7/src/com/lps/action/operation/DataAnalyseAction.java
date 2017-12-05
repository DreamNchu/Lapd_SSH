package com.lps.action.operation;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class DataAnalyseAction extends ActionSupport implements ServletResponseAware{

	private static final long serialVersionUID = 4352752556594351852L;
	
	private HttpServletResponse response;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
	
	
	
	
	
	
	
	
	
	

	
	

}
