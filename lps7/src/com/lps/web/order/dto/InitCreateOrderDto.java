package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.room.dto.TRoomDto;
import com.lps.web.simple.dto.ServerItemDto;
import com.lps.web.simple.dto.TServerItemDto;
import com.lps.web.user.dto.TUserDto;

public class InitCreateOrderDto extends BasicRespondMsgDto {

	private static final long serialVersionUID = 7306645750527617840L;

	private TUserDto users;

	private TRoomDto rooms;

	private TServerItemDto serverItems;

	public InitCreateOrderDto() {
		
	}
	
	/**
	 * 
	 * 
	 * @param mapL
	 * @throws DtoInitException
	 * @throws MapNotInitForClassPathException 
	 */
	@SuppressWarnings("unchecked")
	public void init(List<? extends Entity>...listEntities
											) throws DtoInitException, MapNotInitForClassPathException {
		
		super.initTable(listEntities);
		
		
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

	/*
	 * public List<Integer> getCreateWays() { return createWays; }
	 * 
	 * public void setCreateWays(List<Integer> createWays) { this.createWays =
	 * createWays; }
	 */

}
