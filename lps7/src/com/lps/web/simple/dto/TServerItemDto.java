package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ServerItem;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TServerItemDto extends ArrayList<ServerItemDto> implements TableInitDto<ServerItem>{

	private static final long serialVersionUID = 6746457713473621005L;

	public static final String name = "serverItems";

	@Override
	public void init(List<ServerItem> lists) {
		for (Entity entity : lists) {
			ServerItemDto dto = new ServerItemDto();
			dto.init((ServerItem)entity);
			add(dto);
		}
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
