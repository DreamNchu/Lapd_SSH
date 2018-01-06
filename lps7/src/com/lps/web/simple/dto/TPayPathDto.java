package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.model.basic.Entity;
import com.lps.web.dto.TableInitDto;

public class TPayPathDto extends ArrayList<PayPathDto> implements TableInitDto<PayPath>{

	private static final long serialVersionUID = 6746457713473621005L;

	public static final String name = "payPaths";

	@Override
	public void init(List<PayPath> lists) {
		// TODO Auto-generated method stub
		for (Entity entity : lists) {
			PayPathDto dto = new PayPathDto();
			dto.init((PayPath)entity);
			add(dto);
		}
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
