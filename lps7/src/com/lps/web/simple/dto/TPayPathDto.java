package com.lps.web.simple.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.PayPath;
import com.lps.model.basic.Entity;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;
@DtoName("payPaths")
public class TPayPathDto extends ArrayList<PayPathDto> implements TableInitDto<PayPath>{

	private static  long serialVersionUID = 6746457713473621005L;

//	public static  String name = "payPaths";

	@Override
	public void init(List<PayPath> lists) throws DtoInitException {
		// TODO Auto-generated method stub
		for (Entity entity : lists) {
			PayPathDto dto = new PayPathDto();
			dto.initDto((PayPath)entity);
			add(dto);
		}
	}
	
/*	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}*/
}
