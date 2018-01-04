package com.lps.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lps.web.basicmsg.dto.BasicMsgDto;

public class WorkJson {

	/*public static Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation().create();
	
	public static String toJsonDisableHtmlEscaping(Object obj){
		return gson.toJson(obj);
	}*/
	
	public static Gson gsonH = new GsonBuilder()
			.serializeNulls()
			.disableHtmlEscaping().create();
	
	public static String toJsonDisableHtmlEscaping(BasicMsgDto obj){
		return gsonH.toJson(obj).replaceAll("null", "\"\"");
	}
	
}
