package com.lps.web.basicmsg.dto;

import java.util.HashMap;
import java.util.Map;

public class BasicMsgDto{
	
	protected Map<String , Object> map = new HashMap<>();
	
	public static final String ERROR_MSG = "errorMsg";
	public static final String SUCCESS_MSG = "successMsg";
	
	public BasicMsgDto() {
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void setErrorMsg(Object value){
		map.put(ERROR_MSG, value);
	}
	
	public Object getErrorMsg(){
		return map.get(ERROR_MSG);
	}
	
	public void setSuccessMsg(Object value){
		map.put(SUCCESS_MSG, value);
	}
	
	public Object getSuccessMsg(){
		return map.get(SUCCESS_MSG);
	}

}
