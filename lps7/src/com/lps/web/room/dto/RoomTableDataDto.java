package com.lps.web.room.dto;

import com.lps.model.Room;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.page.dto.TablePage;
import com.lps.web.page.dto.PageAble;

public class RoomTableDataDto extends TablePage<Room>{

	private static final long serialVersionUID = 8310657762814860723L;
	
	TRoomDto rooms;
	
	public TRoomDto getRooms() {
		return rooms;
	}

	public void setRooms(TRoomDto rooms) {
		this.rooms = rooms;
	}

	@Override
	public void init(PageBean<Room> pageBean, PageAble pageAble, String actionName) throws DtoInitException {
		// TODO Auto-generated method stub
		super.init(pageBean, pageAble, actionName);
		
		if(pageBean.getList() == null){
			return ;
		}
		rooms.init(pageBean.getList());
		
	}

}
