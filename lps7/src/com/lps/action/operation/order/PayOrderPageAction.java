package com.lps.action.operation.order;

import com.lps.action.jsonresult.DataResult;
import com.lps.util.WorkJson;
import com.lps.action.basic.ActionSupportLps;

public class PayOrderPageAction extends ActionSupportLps implements DataResult{
	
	private static  long serialVersionUID = 622967630161433205L;
	
	public String payOrderPage(){
		return SUCCESS;
	}
	@Override
	public String getResult() {
		return result.toString();
	}
}
