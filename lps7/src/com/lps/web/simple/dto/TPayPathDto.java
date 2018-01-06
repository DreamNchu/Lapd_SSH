package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TPayPathDto extends ArrayList<PayPathDto> implements TableInitDto{

	private static final long serialVersionUID = 6746457713473621005L;


	@Override
	public <T extends Entity> void init(List<T> lists) {
		// TODO Auto-generated method stub
		for (Entity entity : lists) {
			PayPathDto dto = new PayPathDto();
			dto.init((PayPath)entity);
			add(dto);
		}
	}
	
}
