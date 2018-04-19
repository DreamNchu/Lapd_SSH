package com.lps.web.room.dto;

import java.util.List;

import com.lps.model.ServerItem;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.simple.dto.TServerItemDto;

public class InitOperationRoomData extends BasicRespondMsgDto{
	
	/**
	 * 
	 */
	private static  long serialVersionUID = 8532169645817122319L;
	TServerItemDto serverItems;
	
	public TServerItemDto getServerItems() {
		return serverItems;
	}

	public void setServerItems(TServerItemDto serverItems) {
		this.serverItems = serverItems;
	}

	@SuppressWarnings("unchecked")
	public void init(List<ServerItem> sis) throws DtoInitException, MapNotInitForClassPathException{
		super.initTable(sis);
	}

}
