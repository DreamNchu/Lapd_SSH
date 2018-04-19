package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ServerItem;
import com.lps.model.basic.Entity;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@DtoName("serverItems")
public class TServerItemDto extends ArrayList<ServerItemDto> implements TableInitDto<ServerItem>{

	private static  long serialVersionUID = 6746457713473621005L;

//	public static  String name = "serverItems";

	@Override
	public void init(List<ServerItem> lists) throws DtoInitException {
		for (Entity entity : lists) {
			ServerItemDto dto = new ServerItemDto();
			dto.initDto((ServerItem)entity);
			add(dto);
		}
	}
/*	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}*/
}
