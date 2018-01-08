package com.lps.web.simple.dto;

import com.lps.model.ServerItem;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface ServerItemLibrary extends BasicRequestDto<ServerItem>, BasicResponseDto<ServerItem>{
	
	public String serverItemId = "serverItemId";
	
	public String serverItemName = "serverItemName";
	
	public String price = "price";

}
