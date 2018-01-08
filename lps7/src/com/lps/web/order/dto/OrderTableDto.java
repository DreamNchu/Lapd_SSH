package com.lps.web.order.dto;

import java.lang.reflect.Field;
import java.util.List;

import org.jboss.jandex.Main;

import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.page.dto.BasicPageDto;
import com.lps.web.page.dto.PageAble;

public class OrderTableDto extends BasicPageDto<ServerOrder>{

	private static final long serialVersionUID = 3806945311759118584L;
	
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
	@SuppressWarnings("unchecked")
	public void init(PageBean<ServerOrder> lOrders, PageAble pageLinkTransformOrderDto, String actionName) throws DtoInitException {
		
		super.init(lOrders, pageLinkTransformOrderDto, actionName);
		
		orders.init(lOrders.getList());
		
		/*for (ServerOrder serverOrder : (List<ServerOrder>)lOrders.getList()) {
			OrderDto osd = new OrderDto();
			osd.init(serverOrder);
			this.orders.add(osd);
		}*/
		
	}
	
public static void main(String[] args) {
	Class cla = OrderTableDto.class;
	System.out.println(cla = cla.getSuperclass());
	System.out.println(cla = cla.getSuperclass());
	System.out.println(cla = cla.getSuperclass());
	System.out.println(cla = cla.getSuperclass());
	System.out.println(cla = cla.getSuperclass());
	System.out.println(cla = cla.getSuperclass());
//	while(clacla.getSuperclass())
//	for(Field field : .getDeclaredFields()){
//		System.out.println(field.getName());
//	}
}

}
