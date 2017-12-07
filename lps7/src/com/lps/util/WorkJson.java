package com.lps.util;

import com.google.gson.Gson;

public class WorkJson {

	public static Gson gson = new Gson();
	
	public static String toJsonString(Object obj){
		return gson.toJson(obj);
	}
	
}
