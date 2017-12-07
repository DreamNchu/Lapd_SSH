package com.lps.action.operation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.lps.control.manage.OrderManage;
import com.lps.control.manage.OrderRefuseUsersManage;
import com.lps.control.manage.WorkRankManage;
import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.OrderStatusDAO;
import com.lps.dao.WorkStatusDAO;
import com.lps.model.OrderStatus;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.OrderStatusService;
import com.lps.service.ServerOrderService;
import com.lps.service.UserService;
import com.lps.service.WorkStatusService;
import com.lps.web.dto.OrderDataDto;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersAction extends ActionSupport implements SessionAware, RequestAware,ServletResponseAware {

	private static final long serialVersionUID = -8244094131580240319L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  private javax.servlet.http.HttpServletResponse response;  
	    // 获得HttpServletResponse对象  
	    @Override  
	    public void setServletResponse(HttpServletResponse response)  
	    {  
	        this.response = response;  
	    }    

	private Map<String, Object> session;

	private Map<String, Object> request;

	private UserService userServiceImpl;

	private ServerOrderService serverOrderServiceImpl;

	/**
	 * 订单状态服务管理
	 */
	private OrderStatusService orderStatusServiceImpl;

	private OrderManage orderManage;

	private OrderDataDto orderDataDto;

	/**
	 * 存储表信息
	 */
	private List<ServerOrder> list;

	/**
	 * 员工的主键id
	 */
	private int stuffId;

	/**
	 * 房间的主键id
	 */
	private int roomId;

	/**
	 * 钟点类型主键id
	 */
	private int clockCategoryId;

	/**
	 * 订单状态主键id
	 */
	private int orderStatusId;

	/**
	 * 订单主键id
	 */
	private String orderId;

	private WorkRankManage workRankManage;

	private WorkStatusService workStatusServiceImpl;

	private OrderRefuseUsersManage orderRefuseUsersManage;
	
	private String createOrderResult ;

	public String getCreateOrderResult() {
		return createOrderResult;
	}

	public void setCreateOrderResult(String createOrderResult) {
		this.createOrderResult = createOrderResult;
	}
	
	
	
	public String main(){
		return SUCCESS;
	}
	

	public int getClockCategoryId() {
		return clockCategoryId;
	}

	public List<ServerOrder> getList() {
		return list;
	}

	public OrderDataDto getOrderDataDto() {
		return orderDataDto;
	}

	public String getOrderId() {
		return orderId;
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public OrderRefuseUsersManage getOrderRefuseUsersManage() {
		return orderRefuseUsersManage;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public OrderStatusService getOrderStatusServiceImpl() {
		return orderStatusServiceImpl;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public int getRoomId() {
		return roomId;
	}

	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public int getStuffId() {
		return stuffId;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public WorkStatusService getWorkStatusServiceImpl() {
		return workStatusServiceImpl;
	}
	
	public void setClockCategoryId(int clockCategoryId) {
		this.clockCategoryId = clockCategoryId;
	}

	public void setList(List<ServerOrder> list) {
		this.list = list;
	}

	public void setOrderDataDto(OrderDataDto orderDataDto) {
		this.orderDataDto = orderDataDto;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	public void setOrderRefuseUsersManage(OrderRefuseUsersManage orderRefuseUsersManage) {
		this.orderRefuseUsersManage = orderRefuseUsersManage;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public void setOrderStatusServiceImpl(OrderStatusService orderStatusServiceImpl) {
		this.orderStatusServiceImpl = orderStatusServiceImpl;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setStuffId(int stuffId) {
		this.stuffId = stuffId;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}

	public void setWorkStatusServiceImpl(WorkStatusService workStatusServiceImpl) {
		this.workStatusServiceImpl = workStatusServiceImpl;
	}


	/**
	 * 用户接收订单 <br>
	 * 1.更新workRank表中信息 <br>
	 * 2.更新该订单状态 <br>
	 * 3.更新员工状态
	 * 
	 * @return
	 */
	public String receiveOrder() {
		ServerOrder so = serverOrderServiceImpl.findById(orderId);
		User u = so.getUser();
		
		switch (so.getClockCategory().getId()) {
		case ClockCategoryDAO.SPOT_CLOCK:  //如果是点钟
			workRankManage.addUserSpotNum(u);
			break;
		case ClockCategoryDAO.RANK_CLOCK:  //是排钟
			workRankManage.addUserRankNum(u);
			break;
		default:
			break;
		}
		so.setOrderStatus(orderStatusServiceImpl.findById(OrderStatusDAO.SERVICING));
		serverOrderServiceImpl.update(so);
		
		u.setWorkStatus(workStatusServiceImpl.findById(WorkStatusDAO.WORKING));
		userServiceImpl.update(u);

		return SUCCESS;
	}

	/**
	 * 用户拒绝订单
	 * <br>
	 * 1.更新订单表中指定用户
	 * 
	 * @return 
	 */
	public String refuseOrder(){
		
		ServerOrder so = serverOrderServiceImpl.findById(orderId);
		orderRefuseUsersManage.add(so.getId(), so.getUser());
		User u = workRankManage.nextOneNotIn(orderRefuseUsersManage.getByOrderId(so.getId()));
		so.setUser(u);
		
		return SUCCESS;
	}

	
	/**
	 * 更新订单内容
	 * 
	 * @return 成功返回success
	 */
	public String updateOrder(){
		ServerOrder so = serverOrderServiceImpl.findById(orderDataDto.getId());
		// 更新已经更改的字段
		orderDataDto.update(so);
		serverOrderServiceImpl.update(so);
		return SUCCESS;
	}

	/**
	 * 产看订单
	 * 通过id获取相应订单
	 * 
	 * @return 成功返回success
	 */
	public String viewOrder() {
		ServerOrder so = serverOrderServiceImpl.findById(orderId);
		// 数据映射
		orderDataDto.initByServerOrder(so);
		return SUCCESS;
	}
	
	/**
	 * 查看今日各种订单类型
	 * 
	 * @return 根据请求返回不同的界面
	 */
	public String viewStatusOrder() {
		OrderStatus os = orderStatusServiceImpl.findById(orderStatusId);
		// 找到今日该状态下的所有订单
		this.list = orderStatusServiceImpl.findTodayOrders(os);

		return os.getOrderstatus();
	}
	
	/**
	 * 查看待接收的订单
	 * 
	 * @return 根据请求返回不同的界面
	 */
	public String viewStatusUserOrders() {
		User u = new User.Builder().setId((int) session.get("id")).build();
		String orderStatus = (String) request.get("orderStatus");
		OrderStatus os = orderStatusServiceImpl.findByOrderStatus(orderStatus).get(0);
		// 找到今日该状态下的所有订单
		List<ServerOrder> listTemp = orderStatusServiceImpl.findTodayOrders(os);
		// 找对对应人物的订单
		for (Iterator<ServerOrder> iterator = listTemp.iterator(); iterator.hasNext();) {
			ServerOrder serverOrder = (ServerOrder) iterator.next();
			if (serverOrder.getUser().getId() == u.getId())
				this.list.add(serverOrder);
		}
		return orderStatus;
	}

	/**
	 * 当天的所有订单
	 * 
	 * @return 成功返回success
	 */
	public String viewTodayOrders() {
		this.list = serverOrderServiceImpl.findTodayOrder();
		return SUCCESS;
	}

	/**
	 * 当天的所有订单
	 * 
	 * @return 成功返回success
	 */
	public String viewTodayUserOrders() {
		User u = new User();
		u.setId((int) session.get("id"));
		this.list = userServiceImpl.findTodayOrders(u);
		return SUCCESS;
	}
	
	

}
