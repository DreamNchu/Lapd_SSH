package com.lps.control.manage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lps.model.User;

public class OrderRefuseUsersManage {

	private Map<String, Set<User>> userRefuseMap = new HashMap<String, Set<User>>(); 
	
	public OrderRefuseUsersManage() {
	}
	
	public void add(String orderId, User u){
		if(userRefuseMap.get(orderId) != null){
			userRefuseMap.put(orderId, new HashSet<User>());
			userRefuseMap.get(orderId).add(u);
		}else{
			userRefuseMap.get(orderId).add(u);
		}
	}
	
	public Set<User> getByOrderId(String orderId){
		return userRefuseMap.get(orderId);
	}
	
	public Map<String, Set<User>> getUserRefuseMap() {
		return userRefuseMap;
	}

	public void setUserRefuseMap(Map<String, Set<User>> userRefuseMap) {
		this.userRefuseMap = userRefuseMap;
	}

}
