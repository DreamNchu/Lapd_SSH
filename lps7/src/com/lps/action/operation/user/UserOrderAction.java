package com.lps.action.operation.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.BasicManage;
import com.lps.control.manage.OrderManage;
import com.lps.dao.impl.OrderStatusDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.permission.Permission;
import com.lps.service.OrderStatusService;
import com.lps.util.PageBean;
import com.lps.util.WorkJson;
import com.lps.web.order.dto.OrderSingleDataDto;
import com.lps.web.order.dto.OrderTableDataDto;
import com.lps.web.order.dto.UpdateOrderNormalOperationDto;
import com.lps.web.order.dto.constant.TimeType;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.user.dto.UserOrderRequestDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserOrderAction extends ActionSupport implements DataResult, SessionAware {

	private static final long serialVersionUID = -7901998643050021799L;

	private Map<String, Object> session;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private UserOrderRequestDto userOrderRequestDto;

	public UserOrderRequestDto getUserOrderRequestDto() {
		return userOrderRequestDto;
	}

	public void setUserOrderRequestDto(UserOrderRequestDto userOrderRequestDto) {
		this.userOrderRequestDto = userOrderRequestDto;
	}

	private OrderManage orderManage;

	public BasicManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	private OrderTableDataDto orderTableDataDto;

	public OrderTableDataDto getOrderTableDataDto() {
		return orderTableDataDto;
	}

	public void setOrderTableDataDto(OrderTableDataDto orderTableDataDto) {
		this.orderTableDataDto = orderTableDataDto;
	}

	/**
	 * 查询用户订单
	 * 
	 * @return
	 */
	public String queryOrders() {
		int userId = Integer.parseInt(session.get("id") + "");

		int timeType = 0;
		if (userOrderRequestDto.getTimeType() == 0){
			timeType = TimeType.DAY;
		}

		List<ServerOrder> listOrders = orderManage.queryOrder(userId, userOrderRequestDto.getStatusId(), timeType);

		PageBean<ServerOrder> pageBean = new PageBean<ServerOrder>();

		pageBean.setList(listOrders);

		orderTableDataDto.init(pageBean, null, null, null);

		result = WorkJson.toJsonDisableHtmlEscaping(orderTableDataDto);
System.out.println(result);
		return SUCCESS;
	}

	private OrderChartDto orderChartDto;

	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	public String todayOrderIncome() {
		// OrderChartRequestDto orderChartRequestDto = new
		// OrderChartRequestDto();
		// orderChartRequestDto.setUserId(Integer.parseInt(session.get("id") +
		// ""));
		//
		// orderChartRequestDto.setTimeType(TimeType.DAY);
		//
		// orderChartRequestDto.setPopulation(Population.ONE);
		// orderManage.chartAnalyze(orderChartDto, orderChartRequestDto);
		// result = WorkJson.toJsonDisableHtmlEscaping(orderChartDto);
		//
		// LogAspect.logger.info(result);
		return SUCCESS;
	}

	/**
	 * 管理订单页面
	 * 
	 * @return
	 */
	public String manageOrdersPage() {
		return SUCCESS;
	}

	private OrderSingleDataDto orderSingleDataDto;

	public OrderSingleDataDto getOrderSingleDataDto() {
		return orderSingleDataDto;
	}

	public void setOrderSingleDataDto(OrderSingleDataDto orderSingleDataDto) {
		this.orderSingleDataDto = orderSingleDataDto;
	}

	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取订单的详细信息
	 * 
	 * @return
	 */
	public String detailOrderInfo() {
		orderSingleDataDto.init(orderManage.queryOrder(orderId));
		return SUCCESS;
	}

	/**
	 * 拒绝订单
	 * 
	 * @return
	 */
	public String refuseOrder() {
		ServerOrder so = orderManage.queryOrder(orderId);
		// 拒绝订单
		orderManage.refuseOrderFromUser(so);
		return SUCCESS;
	}

	private OrderStatusService orderStatusServiceImpl;

	public OrderStatusService getOrderStatusServiceImpl() {
		return orderStatusServiceImpl;
	}

	public void setOrderStatusServiceImpl(OrderStatusService orderStatusServiceImpl) {
		this.orderStatusServiceImpl = orderStatusServiceImpl;
	}

	/**
	 * 接受订单
	 * 
	 * @return
	 */
	public String receiveOrder() {

		try {

			int userId = Integer.parseInt(session.get("id") + "");

			UpdateOrderNormalOperationDto uo = new UpdateOrderNormalOperationDto(orderId, new Permission(Permission.USER), 0f, 0f,
					OrderStatusDAOImpl.SERVICING, userId);
			orderManage.updateOrderNormal(uo);

		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "接收订单失败！");
			writeInResult(map);
			return SUCCESS;
		}
		map.put(MSG, "接收订单成功！");
		writeInResult(map);
		return SUCCESS;
	}

	/**
	 * 完成订单
	 * 
	 * @return
	 */
	public String finishOrder() {
		try {
			if (pay <= 0) {
				throw new Exception();
			}
			int userId = Integer.parseInt(session.get("id") + "");

			UpdateOrderNormalOperationDto uo = new UpdateOrderNormalOperationDto(orderId, new Permission(Permission.USER), pay, 0f,
					OrderStatusDAOImpl.WAITING_PAY, userId);
			
			orderManage.updateOrderNormal(uo);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "提交订单失败！,检查输入金额或其他系统错误");
			writeInResult(map);
			return SUCCESS;
		}
		map.put(MSG, "恭喜您，订单完成！");
		writeInResult(map);
		return SUCCESS;
	}

	private float pay;

	public float getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void writeInResult(Object obj) {
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

}
