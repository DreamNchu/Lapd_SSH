package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;

public class InitCreateOrderDto {
	
	/*
	 *var createOrder={
    "createWays":["1","2","3"],
    "user":[{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"},{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"}],
    "room":[{"roomId":"roomId1","roomName":"roomName1"},{"roomId":"roomId2","roomName":"roomName2"}],
    "roomCategory":[{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"},{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"}]
}
	*/
	
//	private List<Integer> createWays;
	
	private List<UserOrderDto> users;
	
	private List<RoomOrderDto> rooms;
	
	private List<ServerItemOrderDto> serverItems;
	
	
	public InitCreateOrderDto() {
	}
	
	/**
	 * 数据的初始化
	 * @param lu
	 * @param lr
	 * @param lrc
	 */
	public void init(List<User> lu, List<Room> lr, List<ServerItem> lrc){
		for (ServerItem rc : lrc) {
			this.serverItems.add(
					new ServerItemOrderDto().init(rc));
		}
		
		for (User u : lu) {
			this.users.add(new UserOrderDto().init(u));
		}
		
		for (Room room : lr) {
			this.rooms.add(new RoomOrderDto().init(room));
		}
	}
	
	public InitCreateOrderDto(/*List<Integer> createWays,*/ List<UserOrderDto> user, List<RoomOrderDto> room,
			List<ServerItemOrderDto> roomCategory) {
		super();
//		this.createWays = createWays;
		this.users = user;
		this.rooms = room;
		this.serverItems = roomCategory;
	}


	public List<RoomOrderDto> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomOrderDto> room) {
		this.rooms = room;
	}

	public List<ServerItemOrderDto> getServerItems() {
		return serverItems;
	}

	public void setServerItems(List<ServerItemOrderDto> serverItem) {
		this.serverItems = serverItem;
	}

	public List<UserOrderDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserOrderDto> user) {
		this.users = user;
	}

/*	public List<Integer> getCreateWays() {
		return createWays;
	}

	public void setCreateWays(List<Integer> createWays) {
		this.createWays = createWays;
	}*/

	
}
