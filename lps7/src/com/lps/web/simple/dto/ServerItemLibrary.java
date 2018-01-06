package com.lps.web.simple.dto;

import com.lps.model.ServerItem;
import com.lps.web.dto.BasicInitDto;

public interface ServerItemLibrary extends BasicInitDto<ServerItemDto,ServerItem>{
	
	public String serverItemId = "serverItemId";
	
	public String serverItemName = "serverItemName";
	
	public String price = "price";

}
