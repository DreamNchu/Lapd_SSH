package com.lps.web.simple.dto;

import com.lps.model.ServerItem;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class ServerItemDto extends BasicRespondMsgDto implements ServerItemLibrary{
	
	@Override
	public ServerItemDto init(ServerItem obj) {
		if(obj == null){
			return this;
		}
		ServerItem si = (ServerItem)obj;
		map.put(serverItemId , si.getId());
		map.put(serverItemName , si.getServerItem());
		map.put(price , si.getPrice());
		return this;
	}
	
	

}
