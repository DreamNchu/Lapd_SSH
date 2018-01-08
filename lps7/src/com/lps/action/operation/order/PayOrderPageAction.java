package com.lps.action.operation.order;

import com.lps.action.jsonresult.DataResult;
import com.lps.util.WorkJson;
import com.opensymphony.xwork2.ActionSupport;

public class PayOrderPageAction extends ActionSupport implements DataResult{
	
	private static final long serialVersionUID = 622967630161433205L;
	
	public String payOrderPage(){
		return SUCCESS;
	}
	@Override
	public String getResult() {
		return result.toString();
	}
}
