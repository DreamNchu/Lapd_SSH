package com.lps.action.operation.order;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.lps.control.manage.OrderManage;
import com.lps.dao.ClockCategoryDAO;
import com.lps.model.ServerOrder;
import com.lps.service.ServerOrderService;
import com.lps.web.order.dto.CreateOrderDto;
import com.lps.web.order.dto.constant.CreateOrderWay;
import com.opensymphony.xwork2.ActionSupport;

public class CreateOrderAction extends ActionSupport {

	private static final long serialVersionUID = -2770070015331923293L;

	private CreateOrderDto createOrderDto;

	private OrderManage orderManage;

	private ServerOrderService serverOrderServiceImpl;

	private String result;

	@Override
	public String execute() throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
//System.out.println("111"+createOrderDto.getOrderRemark());
		try {
			ServerOrder so = null;
			switch (createOrderDto.getCreateWay()) {
			case CreateOrderWay.rank_order_auto:
				so = orderManage.createOrder(createOrderDto.getRoomId(), createOrderDto.getOrderRemark());
				break;
			case CreateOrderWay.rank_order_handle:
				so = orderManage.createOrder(createOrderDto.getStuffId(), createOrderDto.getRoomId(),
						ClockCategoryDAO.RANK_CLOCK, createOrderDto.getOrderRemark());
				break;
			case CreateOrderWay.spot_order_handle:
				so = orderManage.createOrder(createOrderDto.getStuffId(), createOrderDto.getRoomId(),
						ClockCategoryDAO.SPOT_CLOCK, createOrderDto.getOrderRemark());
				break;
			}
			serverOrderServiceImpl.save(so); // 保存订单
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "创建订单失败");
			result = new Gson().toJson(map);
			return SUCCESS;
		}

		map.put("msg", "创建订单成功");
		result = new Gson().toJson(map);
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

}
