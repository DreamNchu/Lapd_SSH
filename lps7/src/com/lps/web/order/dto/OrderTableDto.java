package com.lps.web.order.dto;

import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.TablePage;

public class OrderTableDto extends TablePage<ServerOrder>{

	private static  long serialVersionUID = 3806945311759118584L;
	
	private TOrderDto orders;

	public TOrderDto getOrders() {
		return orders;
	}

	public void setOrders(TOrderDto orders) {
		this.orders = orders;
	}

	public OrderTableDto() {

	}

	public OrderTableDto(TOrderDto order) {
		super();
		this.orders = order;
	}
	/**
	 * 初始化值
	 * @param lOrders
	 * @param pageLinkTransformOrderDto
	 * @param domainName
	 * @param actionName
	 * @throws DtoInitException 
	 */
	public void init(PageBean<ServerOrder> lOrders, PageAble pageLinkTransformOrderDto, String actionName) throws DtoInitException {
		
		super.init(lOrders, pageLinkTransformOrderDto, actionName);
		
		orders.init(lOrders.getList());
		
	}
	
}
