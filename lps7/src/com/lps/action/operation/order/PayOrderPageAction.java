package com.lps.action.operation.order;

import com.lps.action.jsonresult.DataResult;
import com.lps.util.WorkJson;
import com.opensymphony.xwork2.ActionSupport;

public class PayOrderPageAction extends ActionSupport implements DataResult{
	
	private static final long serialVersionUID = 622967630161433205L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String payOrderPage(){
		
		return SUCCESS;
	}
	
	public void writeInResult(Object obj){
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}

}
