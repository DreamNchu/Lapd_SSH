package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ServerItem;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TServerItemDto extends ArrayList<ServerItemDto> implements TableInitDto{

	private static final long serialVersionUID = 6746457713473621005L;


	@Override
	public <T extends Entity> void init(List<T> lists) {
		for (Entity entity : lists) {
			ServerItemDto dto = new ServerItemDto();
			dto.init((ServerItem)entity);
			add(dto);
		}
	}
	
}
