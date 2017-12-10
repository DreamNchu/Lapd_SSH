package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.web.page.dto.PageDto;

public class OrderTableDataDto extends PageDto{

	/*
	 * "page":[{"currentPage":"1","allCount":"10","allPage":"10"}],
	 * "transform":[{"back":"TestHref","front":"TestHref"}],
	 * "number":[{"value":"1","link":"TestHref"},{"value":"2","link":"TestHref"}
	 * ,{"value":"3","link":"TestHref"},{"value":"4","link":"TestHref"}] }
	 */

	private List<OrderSingleDataDto> order;

	public OrderTableDataDto() {

	}

	public OrderTableDataDto(List<OrderSingleDataDto> order) {
		super();
		this.order = order;
	}
	/**
	 * 初始化值
	 * @param lOrders
	 * @param queryOrderDto
	 * @param domainName
	 * @param actionName
	 */
	@SuppressWarnings("unchecked")
	public <T> void init(PageBean<T> lOrders, QueryOrderDto queryOrderDto, String domainName, String actionName) {
		
		super.init(lOrders, queryOrderDto, domainName, actionName);
		
		for (ServerOrder serverOrder : (List<ServerOrder>)lOrders.getList()) {
			OrderSingleDataDto osd = new OrderSingleDataDto();
			osd.init(serverOrder);
			this.order.add(osd);
		}
	}
	
	

	public List<OrderSingleDataDto> getOrder() {
		return order;
	}

	public void setOrder(List<OrderSingleDataDto> order) {
		this.order = order;
	}

}
