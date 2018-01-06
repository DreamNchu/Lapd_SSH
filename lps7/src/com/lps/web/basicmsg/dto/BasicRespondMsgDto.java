package com.lps.web.basicmsg.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lps.util.WorkJson;

/**
 * 响应数据流
 * @author 0001
 *
 */
public class BasicRespondMsgDto {
	
	protected Map<String , Object> map = new HashMap<>();
	
	public static final String ERROR_MSG = "errorMsg";
	public static final String SUCCESS_MSG = "successMsg";
	
	public BasicRespondMsgDto() {
	}
	
	public void setDefaultErrorMsg(){
		setErrorMsg("执行失败");
	}
	
	public void setDefaultSuccessMsg(){
		setSuccessMsg("执行成功");
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	/**
	 * 默认值为：执行失败
	 * @param value
	 */
	public void setErrorMsg(Object value){
		map.put(ERROR_MSG, value);
	}
	
	public void appendErrorMsg(String value) throws Exception{
		Object obj = getErrorMsg();
		
		if(obj instanceof String){
			String str = (String)obj;
			str.concat(value);
		}else if(obj instanceof StringBuilder){
			StringBuilder sb = (StringBuilder)obj;
			sb.append(value);
		}else{
			throw new Exception("getErrorMsg(),返回值不是字符串类型对象");
		}
		setErrorMsg(obj);
	}
	
	public void appendSuccessMsg(String value) throws Exception{
		Object obj = getSuccessMsg();
		setSuccessMsg(appendMsg(obj, value));
	}
	
	private Object appendMsg(Object obj, String value) throws Exception{
		if(obj instanceof String){
			String str = (String)obj;
			str.concat(value);
		}else if(obj instanceof StringBuilder){
			StringBuilder sb = (StringBuilder)obj;
			sb.append(value);
		}else{
			throw new Exception("getErrorMsg(),返回值不是字符串类型对象");
		}
		return obj;
	}
	
	public Object getErrorMsg(){
		return map.get(ERROR_MSG);
	}
	
	/**
	 * 默认值为：执行成功
	 * @param value
	 */
	public void setSuccessMsg(Object value){
		map.put(SUCCESS_MSG, value);
	}
	
	public Object getSuccessMsg(){
		return map.get(SUCCESS_MSG);
	}


}
