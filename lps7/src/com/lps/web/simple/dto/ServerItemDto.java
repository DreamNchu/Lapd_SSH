package com.lps.web.simple.dto;

import com.lps.model.ServerItem;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class ServerItemDto extends BasicRespondMsgDto implements ServerItemLibrary {

	@Override
	public ServerItemDto init(ServerItem obj) {
		if (obj == null) {
			return this;
		}
		ServerItem si = (ServerItem) obj;
		if (si.getId() != null)
			map.put(serverItemId, si.getId());
		if (si.getServerItem() != null)
			map.put(serverItemName, si.getServerItem());
		if (si.getPrice() != null)
			map.put(price, si.getPrice());
		return this;
	}

}
