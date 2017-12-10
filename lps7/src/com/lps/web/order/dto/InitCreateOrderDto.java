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
	
	private List<UserOrderDto> user;
	
	private List<RoomOrderDto> room;
	
	private List<ServerItemOrderDto> roomCategory;
	
	
	public InitCreateOrderDto() {
		
	}
	
	public void init(List<User> lu, List<Room> lr, List<ServerItem> lrc){
		for (ServerItem rc : lrc) {
			this.roomCategory.add(
					new ServerItemOrderDto().init(rc));
		}
		
		for (User u : lu) {
			this.user.add( new UserOrderDto().init(u));
		}
		
		for (Room room : lr) {
			this.room.add(new RoomOrderDto().init(room));
		}
	}
	
	public InitCreateOrderDto(List<Integer> createWay, List<UserOrderDto> user, List<RoomOrderDto> room,
			List<ServerItemOrderDto> roomCategory) {
		super();
		this.createWay = createWay;
		this.user = user;
		this.room = room;
		this.roomCategory = roomCategory;
	}



	public List<RoomOrderDto> getRoom() {
		return room;
	}

	public void setRoom(List<RoomOrderDto> room) {
		this.room = room;
	}

	public List<ServerItemOrderDto> getServerItem() {
		return roomCategory;
	}

	public void setServerItem(List<ServerItemOrderDto> roomCategory) {
		this.roomCategory = roomCategory;
	}

	public List<UserOrderDto> getUser() {
		return user;
	}

	public void setUser(List<UserOrderDto> user) {
		this.user = user;
	}

	public List<Integer> getCreateWay() {
		return createWay;
	}

	public void setCreateWay(List<Integer> createWay) {
		this.createWay = createWay;
	}

	
}
