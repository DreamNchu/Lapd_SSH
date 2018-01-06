package com.lps.web.order.dto;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.PageDto;

public class OrderTableDataDto extends PageDto{

	private List<OrderDto> orders;

	public OrderTableDataDto() {

	}

	public OrderTableDataDto(List<OrderDto> order) {
		super();
		this.orders = order;
	}
	/**
	 * 初始化值
	 * @param lOrders
	 * @param pageLinkTransformOrderDto
	 * @param domainName
	 * @param actionName
	 */
	@SuppressWarnings("unchecked")
	public <T> void init(PageBean<T> lOrders, PageAble pageLinkTransformOrderDto, String domainName, String actionName) {
		
		super.init(lOrders, pageLinkTransformOrderDto, domainName, actionName);
		
		for (ServerOrder serverOrder : (List<ServerOrder>)lOrders.getList()) {
			OrderDto osd = new OrderDto();
			osd.init(serverOrder);
			this.orders.add(osd);
		}
		
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> order) {
		this.orders = order;
	}

}
