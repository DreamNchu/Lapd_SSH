package com.lps.action.operation.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lps.action.basic.ActionSupportLps;
import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.CreateFailedException;
import com.lps.control.manage.OrderManage;
import com.lps.web.order.dto.CreateOrderDto;

public class CreateOrderAction extends ActionSupportLps implements DataResult {

	private static final long serialVersionUID = -2770070015331923293L;

	private CreateOrderDto createOrderDto;

	private OrderManage orderManage;

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	/**
	 * 创建订单
	 * @throws CreateFailedException 
	 */
	@Override
	public String execute() throws CreateFailedException {

		try {
			
			orderManage.create(createOrderDto);
			
		} catch (CreateFailedException e) {
			basicMsg.setErrorMsg("订单发布失败");
			throw e;
		}
		basicMsg.setSuccessMsg("订单发布成功");
		return SUCCESS;
		
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	public CreateOrderDto getCreateOrderDto() {
		return createOrderDto;
	}

	public void setCreateOrderDto(CreateOrderDto createOrderDto) {
		this.createOrderDto = createOrderDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String getResult() {
		return result.toString();
	}
}
