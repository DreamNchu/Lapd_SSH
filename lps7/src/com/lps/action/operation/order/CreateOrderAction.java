package com.lps.action.operation.order;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.OrderManage;
import com.lps.service.ServerOrderService;
import com.lps.util.WorkJson;
import com.lps.web.order.dto.CreateOrderDto;
import com.opensymphony.xwork2.ActionSupport;

public class CreateOrderAction extends ActionSupport implements DataResult{

	private static final long serialVersionUID = -2770070015331923293L;

	private CreateOrderDto createOrderDto;

	private OrderManage orderManage;

	private ServerOrderService serverOrderServiceImpl;

	private String result;
	
	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	@Override
	public String execute() throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			orderManage.createOrder(createOrderDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "创建订单失败");
			result = new Gson().toJson(map);
			return SUCCESS;
		}

		map.put("msg", "创建订单成功");
		result = new Gson().toJson(map);
		logger.debug(result);
		return super.execute();
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(OrderManage orderManage) {
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

	@Override
	public void writeInResult(Object obj){
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}

}
