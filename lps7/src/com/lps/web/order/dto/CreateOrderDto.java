package com.lps.web.order.dto;

import java.util.Set;

import com.lps.web.basicmsg.dto.BasicRequestMsgDto;

public class CreateOrderDto extends BasicRequestMsgDto {
	
	private int createWays;
	
 	private int stuffId;
 	
 	private int roomId;
 	
 	private Set<Integer> serverItemIds;

	public Set<Integer> getServerItemIds() {
		return serverItemIds;
	}

	public void setServerItemIds(Set<Integer> serverItemIds) {
		this.serverItemIds = serverItemIds;
	}

	private String orderRemark;
 	
	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public int getCreateWays() {
		return createWays;
	}

	public void setCreateWays(int createWays) {
		this.createWays = createWays;
	}

	public int getStuffId() {
		return stuffId;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

/*	public int getServerItemId() {
		return serverItemId;
	}

	public void setServerItemId(int serverItemId) {
		this.serverItemId = serverItemId;
	}*/


}
