package com.lps.action.operation.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.BasicManage;
import com.lps.control.manage.CreateFailedException;
import com.lps.control.manage.CreateOrderFailedException;
import com.lps.service.ServerOrderService;
import com.lps.web.order.dto.CreateOrderDto;
import com.opensymphony.xwork2.ActionSupport;

public class CreateOrderAction extends ActionSupport implements DataResult {

	private static final long serialVersionUID = -2770070015331923293L;

	private CreateOrderDto createOrderDto;

	private BasicManage orderManage;

	private ServerOrderService serverOrderServiceImpl;

	private String result;

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	/**
	 * 创建订单
	 */
	@Override
	public String execute() {

		try {
			orderManage.create(createOrderDto);
		} catch (CreateFailedException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage());
		}
		return SUCCESS;
		
	}

	public BasicManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(BasicManage orderManage) {
		this.orderManage = orderManage;
	}

	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

}
