package com.lps.action.user.operation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.OrderStatusService;
import com.lps.service.ServerOrderService;
import com.lps.service.UserService;
import com.lps.web.user.dto.UserOrderDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserOrdersAction extends ActionSupport 
implements SessionAware, RequestAware{

	
	private static final long serialVersionUID = 2904315649040287708L;

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
	 * 更新字段
	 * @return 成功返回success
	 */
	public String updateOrder(){
		ServerOrder so = serverOrderServiceImpl.findById(userOrderDataDto.getId());
		userOrderDataDto.update(so);
		serverOrderServiceImpl.update(so);
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
	 * 当天的所有订单
	 * @return 成功返回success
	 */
	public String viewTodayOrders(){
		User u = new User();
		u.setId((int)session.get("id"));
		this.list = userServiceImpl.findTodayOrders(u);
		return SUCCESS;
	}
	
	/**
	 * 查看待接收的订单
	 * @return 根据请求返回不同的界面
	 */
	public String viewStatusOrder(){
		User u = new User.Builder().setId((int)session.get("id")).build();
		String orderStatus = (String)request.get("orderStatus");
		OrderStatus os = orderStatusService.findByOrderStatus(orderStatus).get(0);
		//找到今日该状态下的所有订单
		List<ServerOrder> listTemp = orderStatusService.findTodayOrders(os);
		//找对对应人物的订单
		for (Iterator<ServerOrder> iterator = listTemp.iterator(); iterator.hasNext();) {
			ServerOrder serverOrder = (ServerOrder) iterator.next();
			if(serverOrder.getUser().getId() == u.getId())
				this.list.add(serverOrder);
		}
		return orderStatus;
	}



}
