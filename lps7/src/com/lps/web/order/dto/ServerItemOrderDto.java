package com.lps.web.order.dto;

import com.lps.model.ServerItem;

public class ServerItemOrderDto implements DtoBasicInit<ServerItemOrderDto>{
	
	public int catetgoryId;
	
	public String catetgoryName;
	
	public ServerItemOrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	


	public ServerItemOrderDto(int catetgoryId, String catetgoryName) {
		super();
		this.catetgoryId = catetgoryId;
		this.catetgoryName = catetgoryName;
	}




	@Override
	public ServerItemOrderDto init(Object obj) {
		ServerItem si = (ServerItem)obj;
		catetgoryId = si.getId();
		catetgoryName = si.getServerItem();
		return this;
	}
	
	

}
