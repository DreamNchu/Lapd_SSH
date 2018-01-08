package com.lps.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lps.web.page.dto.PageAble;

public class PageLinkParamCreater {

//	private int kkkk = 1111;
	/**
	 * paramName=paramValue ...
	 * @return
	 */
	public static String createLinkParam(PageAble pageAble){
		Field[] fields = pageAble.getClass().getDeclaredFields();
		String domainName = pageAble.getDomainName();
		StringBuilder str = new StringBuilder();
        for(int i=0;i<fields.length;i++){
        //设置私有属性允许访问
        fields[i].setAccessible(true);
        String copy = null;
        if(domainName == null){
        	domainName = "";
        }else{
        	copy = domainName + ".";
        }
        //得到属性值
         try {
			Object field = fields[i].get(pageAble);
			str.append(copy + fields[i].getName() + "=" + field +"&");
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
        }
		return str.toString();
	}
	
	public static String createLinkParam(Map<String ,Object> mapP, String domainName){
		StringBuilder str = new StringBuilder();
		String copy = null;
		if(domainName == null){
        	domainName = "";
        }else{
        	copy = domainName + ".";
        }
		for (String name : mapP.keySet()) {
			str.append(copy + name + "=" + mapP.get(name) +"&");
		}
		return str.toString();
	}
	
	public static String createLinkParam(String name , Object value, String domainName){
		Map<String ,Object> mapP = new HashMap<String, Object>();
		mapP.put(name, value);
		return createLinkParam(mapP, domainName);
	}
	
}
