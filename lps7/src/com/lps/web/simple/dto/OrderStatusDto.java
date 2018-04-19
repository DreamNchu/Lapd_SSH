package com.lps.web.simple.dto;

import com.lps.model.OrderStatus;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class OrderStatusDto extends BasicRespondMsgDto implements OrderStatusLibrary{
	
	/**
	 * 
	 */
	private static  long serialVersionUID = 6424035019476502051L;

	@SuppressWarnings("unchecked")
	@Override
	public  OrderStatusDto initDto(OrderStatus obj) throws DtoInitException {
		if (obj == null) {
			throw new DtoInitException("订单类型数据转换对象初始化异常");
		}
		OrderStatus os = (OrderStatus)obj;
		if(os.getId() != null)
			put(orderStatusId , os.getId());
		if(os.getOrderstatus() != null)
			put(orderStatusName , os.getOrderstatus());
		
		return this;
	}

	@Override
	public OrderStatus generate() {
		// TODO Auto-generated method stub
		OrderStatus os = new OrderStatus();
		String id = (String)get(orderStatusId);
		String name = (String)get(orderStatusName);
		if(id != null) {
			os.setId(Integer.parseInt(id));
		}
		
		if(name != null) {
			os.setOrderstatus(name);
		}
		return os;
	}

/*	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
/*	public static void main(String[] args) throws DtoInitException {
		OrderStatusDto osd = new OrderStatusDto();
		osd.put("orderStatusId", "3");
		osd.put("orderStatusName", "www");
		OrderStatus os1 = osd.generate();
		System.out.println(os1.getId());
		System.out.println(os1.getOrderstatus());
		
		OrderStatus os2 = new OrderStatus();
		os2.setId(2);
		os2.setOrderstatus("付款时间");
		OrderStatusDto osd2 = osd.init(os2);
        System.out.println(osd2.get(orderStatusId));
        System.out.println(osd2.get(orderStatusName));
	}	*/
	
}
