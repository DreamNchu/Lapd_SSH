package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;

public class InitCreateOrderDto {
	
	/*
	 *var createOrder={
    "createWay":["1","2","3"],
    "user":[{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"},{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"}],
    "room":[{"roomId":"roomId1","roomName":"roomName1"},{"roomId":"roomId2","roomName":"roomName2"}],
    "roomCategory":[{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"},{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"}]
}
	*/
	
	private List<Integer> createWay;
	
	private List<UserCreateOrderDto> user;
	
	private List<RoomCreateOrderDto> room;
	
	private List<ServerItemCreateOrderDto> roomCategory;
	
	
	public InitCreateOrderDto() {
		
	}
	
	public void init(List<User> lu, List<Room> lr, List<ServerItem> lrc){
		for (ServerItem rc : lrc) {
			this.roomCategory.add(
					new ServerItemCreateOrderDto(
							rc.getId() + "", rc.getServerItem()));
		}
		
		for (User u : lu) {
			this.user.add(new UserCreateOrderDto(u.getId() + "", u.getWorkId()+""));
		}
		
		for (Room room : lr) {
			this.room.add(new RoomCreateOrderDto(room.getId()+"", room.getName()));
		}
	}
	
	public InitCreateOrderDto(List<Integer> createWay, List<UserCreateOrderDto> user, List<RoomCreateOrderDto> room,
			List<ServerItemCreateOrderDto> roomCategory) {
		super();
		this.createWay = createWay;
		this.user = user;
		this.room = room;
		this.roomCategory = roomCategory;
	}



	public List<RoomCreateOrderDto> getRoom() {
		return room;
	}

	public void setRoom(List<RoomCreateOrderDto> room) {
		this.room = room;
	}

	public List<ServerItemCreateOrderDto> getServerItem() {
		return roomCategory;
	}

	public void setServerItem(List<ServerItemCreateOrderDto> roomCategory) {
		this.roomCategory = roomCategory;
	}

	public List<UserCreateOrderDto> getUser() {
		return user;
	}

	public void setUser(List<UserCreateOrderDto> user) {
		this.user = user;
	}

	public List<Integer> getCreateWay() {
		return createWay;
	}

	public void setCreateWay(List<Integer> createWay) {
		this.createWay = createWay;
	}

	
}
