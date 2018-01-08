package com.lps.web.order.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ServerOrder;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@DtoName("orders")
public class TOrderDto extends ArrayList<ServerOrder> implements TableInitDto<ServerOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5072559185596107146L;

	@Override
	public void init(List<ServerOrder> lists) throws DtoInitException {
		// TODO Auto-generated method stub
		
	}

}
