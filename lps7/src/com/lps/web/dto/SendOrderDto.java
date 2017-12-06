package com.lps.web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.lps.model.ClockCategory;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;

/**
 * 发送订单dto
 * @author 0001
 *
 */
public class SendOrderDto {

	private List<User> userList = new ArrayList<>();
	
	private List<Room> roomList = new ArrayList<>();
	
	private Set<ServerItem> roomCategorySet = new TreeSet<>();
	
	private ClockCategory clockCategory = null;
	

	public ClockCategory getClockCategory() {
		return clockCategory;
	}

	public void setClockCategory(ClockCategory clockCategory) {
		this.clockCategory = clockCategory;
	}

	public Set<ServerItem> getRoomCategorySet() {
		return roomCategorySet;
	}

	public void setRoomCategorySet(Set<ServerItem> roomCategorySet) {
		this.roomCategorySet = roomCategorySet;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	
	
}
