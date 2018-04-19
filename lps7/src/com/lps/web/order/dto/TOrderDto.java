package com.lps.web.order.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.ServerOrder;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

/**
 * 对于dto的集合管理，继承于arrayList；
 * @author 0001
 *
 */
@DtoName("orders")
public class TOrderDto extends ArrayList<OrderRespondDto> implements TableInitDto<ServerOrder> {

	/**
	 * 
	 */
	private static  long serialVersionUID = 5072559185596107146L;

	@Override
	public void init(List<ServerOrder> lists) throws DtoInitException {
		for (ServerOrder serverOrder : lists) {
			OrderRespondDto od = new OrderRespondDto();
			od.initDto(serverOrder);
			add(od);
		}
	}

}
