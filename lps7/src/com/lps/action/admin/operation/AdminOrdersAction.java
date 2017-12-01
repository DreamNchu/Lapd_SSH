package com.lps.action.admin.operation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.control.manage.OrderCreater;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.OrderStatusService;
import com.lps.service.ServerOrderService;
import com.lps.service.UserService;
import com.lps.web.user.dto.UserOrderDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class AdminOrdersAction extends ActionSupport 
implements SessionAware, RequestAware{

	private static final long serialVersionUID = -8244094131580240319L;

	private Map<String, Object> session ;
	
	private Map<String, Object> request ;
	
	private UserService userServiceImpl ;
	
	private ServerOrderService serverOrderServiceImpl;
	
	private UserOrderDataDto userOrderDataDto;
	
	/**
	 * 订单状态服务管理
	 */
	private OrderStatusService orderStatusService;
	

	/**
	 * 存储表信息
	 */
	private List<ServerOrder> list;
	
	private OrderCreater orderCreater;
	
	
	public OrderCreater getOrderCreater() {
		return orderCreater;
	}

	public void setOrderCreater(OrderCreater orderCreater) {
		this.orderCreater = orderCreater;
	}

	public OrderStatusService getOrderStatusService() {
		return orderStatusService;
	}

	public void setOrderStatusService(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}


	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public UserOrderDataDto getUserOrderDataDto() {
		return userOrderDataDto;
	}
	

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public void setUserOrderDataDto(UserOrderDataDto userOrderDataDto) {
		this.userOrderDataDto = userOrderDataDto;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	/**
	 * 创建一个订单
	 * @return
	 */
	public String createOrder(){
		int stuffId = (int) request.get("stuffId");
		int roomId = (int)request.get("roomId");
		int clockCategory = (int)request.get("clockCategoryId");
		//创建订单
		ServerOrder so = orderCreater.createOrder(stuffId, roomId, clockCategory);
		serverOrderServiceImpl.save(so); //保存订单
		return SUCCESS;
	}
	
	/**
	 * 系统自动创建订单
	 * @return 成功创建返回success,否则返回error
	 */
	public String createOrderAuto(){
		int roomId = (int)request.get("roomId");
		//创建订单
		ServerOrder so = orderCreater.createOrder(roomId);
		if(so == null)
			return ERROR;
		serverOrderServiceImpl.save(so); //保存订单
		return SUCCESS;
	}
	
	
	/**
	 * 查看待接收的订单
	 * @return 根据请求返回不同的界面
	 */
	public String viewStatusOrder(){
		String orderStatus = (String)request.get("orderStatus");
		OrderStatus os = orderStatusService.findByOrderStatus(orderStatus).get(0);
		//找到今日该状态下的所有订单
		this.list = orderStatusService.findTodayOrders(os);
		
		return orderStatus;
	}
	
	
	/**
	 * 当天的所有订单
	 * @return 成功返回success
	 */
	public String viewTodayOrders(){
		this.list = serverOrderServiceImpl.findTodayOrder();
		return SUCCESS;
	}

	/**
	 * 通过id获取相应订单
	 * @return 成功返回success
	 */
	public String viewOrder(){
		ServerOrder so = serverOrderServiceImpl.findById(userOrderDataDto.getId());
		//数据映射
		userOrderDataDto.initByServerOrder(so);
		return SUCCESS;
	}
	
	
	/**
	 * 更新字段
	 * @return 成功返回success
	 */
	public String updateOrder(){
		ServerOrder so = serverOrderServiceImpl.findById(userOrderDataDto.getId());
		//更新已经更改的字段
		userOrderDataDto.update(so);
		serverOrderServiceImpl.update(so);
		return SUCCESS;
	}
	

}
