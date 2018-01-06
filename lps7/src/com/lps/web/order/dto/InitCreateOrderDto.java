package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.User;
import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.DtoInitException;
import com.lps.web.room.dto.TRoomDto;
import com.lps.web.simple.dto.ServerItemDto;
import com.lps.web.simple.dto.TServerItemDto;
import com.lps.web.user.dto.TUserDto;

public class InitCreateOrderDto extends BasicRespondMsgDto{
	
	/*
	 *var createOrder={
    "createWays":["1","2","3"],
    "user":[{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"},{"stuffId":"stuffId1","stuffworkId":"stuffworkId1"}],
    "room":[{"roomId":"roomId1","roomName":"roomName1"},{"roomId":"roomId2","roomName":"roomName2"}],
    "roomCategory":[{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"},{"catetgoryId":"categoryId1","catetgoryName":"catetgoryName1"}]
}
	*/
	
//	private List<Integer> createWays;
	
	private TUserDto users;
	
	private TRoomDto rooms;
	
	private TServerItemDto serverItems;
	
	
	public InitCreateOrderDto() {
	}
	
	/**
	 * 数据的初始化
	 * @param lu
	 * @param lr
	 * @param lrc
	 * @throws DtoInitException 
	 */
	public void init(List<User> lu, List<Room> lr, List<ServerItem> lrc) throws DtoInitException{
		
		serverItems.init(lrc);
		
		users.init(lu);
		
		rooms.init(lr);
	}
	

	public TRoomDto getRooms() {
		return rooms;
	}

	public void setRooms(TRoomDto room) {
		this.rooms = room;
	}

	public List<ServerItemDto> getServerItems() {
		return serverItems;
	}

	public void setServerItems(TServerItemDto serverItem) {
		this.serverItems = serverItem;
	}

	public TUserDto getUsers() {
		return users;
	}

	public void setUsers(TUserDto user) {
		this.users = user;
	}

/*	public List<Integer> getCreateWays() {
		return createWays;
	}

	public void setCreateWays(List<Integer> createWays) {
		this.createWays = createWays;
	}*/

	
}
