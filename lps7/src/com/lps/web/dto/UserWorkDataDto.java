package com.lps.web.dto;

import java.util.Date;

import com.lps.model.Room;
import com.lps.model.User;

public class UserWorkDataDto {
	
	private User user;
	
	private Room room;
	
	private String startTime;
	
	private String endTime;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
