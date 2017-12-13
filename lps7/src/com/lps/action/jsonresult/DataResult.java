package com.lps.action.jsonresult;

import java.util.HashMap;
import java.util.Map;

public interface DataResult {
	
	String MSG= "msg";
	
	Map<String , Object> map = new HashMap<>();
	
	/**
	 * 返回json数据结果
	 * @return
	 */
	String getResult();
	
	void setResult(String result);
	
	void writeInResult(Object obj);
	
}
