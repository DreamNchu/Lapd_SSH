package com.lps.web.order.dto;

import com.lps.model.ServerItem;

public class ServerItemOrderDto implements DtoBasicInit<ServerItemOrderDto>{
	
	public int serverItemId;
	
	public String serverItemName;
	
	public ServerItemOrderDto() {
	}
	
	public ServerItemOrderDto(int catetgoryId, String catetgoryName) {
		super();
		this.serverItemId = catetgoryId;
		this.serverItemName = catetgoryName;
	}

	@Override
	public ServerItemOrderDto init(Object obj) {
		ServerItem si = (ServerItem)obj;
		serverItemId = si.getId();
		serverItemName = si.getServerItem();
		return this;
	}
	
	

}
