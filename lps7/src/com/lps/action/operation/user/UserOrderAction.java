package com.lps.action.operation.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.BasicManage;
import com.lps.control.manage.OrderManage;
import com.lps.control.manage.UserManage;
import com.lps.dao.impl.OrderStatusDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.permission.Permission;
import com.lps.service.OrderStatusService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.WorkJson;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.OrderDto;
import com.lps.web.order.dto.OrderTableDto;
import com.lps.web.order.dto.UpdateOrderNormalOperationDto;
import com.lps.web.order.dto.constant.TimeType;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.user.dto.UserOrderRequestDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserOrderAction extends ActionSupport implements DataResult, SessionAware {

	private static final long serialVersionUID = -7901998643050021799L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private OrderChartDto orderChartDto;

	private String orderId;

	private OrderManage orderManage;

	private OrderDto orderSingleDataDto;

	private OrderStatusService orderStatusServiceImpl;

	private OrderTableDto orderTableDataDto;

	private float pay;

	private Map<String, Object> session;

	private UserManage userManage;

	private UserOrderRequestDto userOrderRequestDto;

	/**
	 * 获取订单的详细信息
	 * 
	 * @return
	 */
	public String detailOrderInfo() {
		basicMsg.setMsgDto(orderSingleDataDto);
		try {
			orderSingleDataDto.init(orderManage.query(orderId));
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			orderSingleDataDto.setErrorMsg(e.getMessage());
		} catch (DtoInitException e) {
			e.printStackTrace();
			orderSingleDataDto.setErrorMsg(e.getMessage());
		}
		orderSingleDataDto.setDefaultSuccessMsg();
		return SUCCESS;
	}

	/**
	 * 完成订单
	 * 
	 * @return
	 */
	public String finishOrder() {
		UpdateOrderNormalOperationDto uo = null;
		try {
			if (pay <= 0) {
				throw new Exception();
			}
			int userId = Integer.parseInt(session.get("id") + "");
			
			uo = new UpdateOrderNormalOperationDto(orderId,
					new Permission(Permission.USER), pay, 0f, OrderStatusDAOImpl.WAITING_PAY, userId);

			orderManage.updateOrderNormal(uo);
		} catch (Exception e) {
			e.printStackTrace();
			uo.setErrorMsg("提交订单失败！,检查输入金额或其他系统错误");
//			map.put(MSG, "提交订单失败！,检查输入金额或其他系统错误");
//			writeInResult(map);
//			return SUCCESS;
		}
		uo.setSuccessMsg("恭喜您，订单完成！");
//		map.put(MSG, "恭喜您，订单完成！");
//		writeInResult(map);
		return SUCCESS;
	}

	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public String getOrderId() {
		return orderId;
	}

	public BasicManage<ServerOrder> getOrderManage() {
		return orderManage;
	}

	public OrderDto getOrderSingleDataDto() {
		return orderSingleDataDto;
	}

	public OrderStatusService getOrderStatusServiceImpl() {
		return orderStatusServiceImpl;
	}

	public OrderTableDto getOrderTableDataDto() {
		return orderTableDataDto;
	}

	public float getPay() {
		return pay;
	}

	public String getResult() {
		return result.toString();
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public UserManage getUserManage() {
		return userManage;
	}

	public UserOrderRequestDto getUserOrderRequestDto() {
		return userOrderRequestDto;
	}

	/**
	 * 管理订单页面
	 * 
	 * @return
	 */
	public String manageOrdersPage() {
		return SUCCESS;
	}

	/**
	 * 查询用户订单
	 * 
	 * @return
	 */
	public String queryOrders() {
		basicMsg.setMsgDto(orderTableDataDto);

		int userId = Integer.parseInt(session.get("id") + "");

		int timeType = 0;
		if (userOrderRequestDto.getTimeType() == 0) {
			timeType = TimeType.DAY;
		}

		List<ServerOrder> listOrders;
		try {
			listOrders = orderManage.queryOrder(userId, userOrderRequestDto.getStatusId(), timeType);

			PageBean<ServerOrder> pageBean = new PageBean<ServerOrder>();

			pageBean.setList(listOrders);

			orderTableDataDto.init(pageBean, null, null);
		} catch (FindByIdGetNullException | DtoInitException e1) {
			e1.printStackTrace();
			orderTableDataDto.setErrorMsg(e1.getMessage());
		}

		// result = WorkJson.toJsonDisableHtmlEscaping(orderTableDataDto);
		// System.out.println(result);
		return SUCCESS;
	}

	/**
	 * 接受订单
	 * 
	 * @return
	 */
	public String receiveOrder() {
		UpdateOrderNormalOperationDto uo = null;
		try {

			int userId = Integer.parseInt(session.get("id") + "");
			uo = new UpdateOrderNormalOperationDto(orderId, new Permission(Permission.USER), 0f, 0f,
					OrderStatusDAOImpl.SERVICING, userId);
			basicMsg.setMsgDto(uo);
			orderManage.updateOrderNormal(uo);

		} catch (Exception e) {
			e.printStackTrace();
			uo.setErrorMsg("接收订单失败");
			// map.put(MSG, "接收订单失败！");
			// writeInResult(map);

			return SUCCESS;
		}
		uo.setSuccessMsg("接收订单成功");
		// map.put(MSG, "接收订单成功！");
		// writeInResult(map);
		return SUCCESS;
	}

	/**
	 * 拒绝订单
	 * 
	 * @return
	 */
	public String refuseOrder() {
		ServerOrder so;
		try {
			so = orderManage.queryOrder(orderId);
			orderManage.refuseOrderFromUser(so);
		} catch (FindByIdGetNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage());
		}
		// 拒绝订单
		basicMsg.setSuccessMsg("拒绝成功");
		return SUCCESS;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	public void setOrderSingleDataDto(OrderDto orderSingleDataDto) {
		this.orderSingleDataDto = orderSingleDataDto;
	}

	public void setOrderStatusServiceImpl(OrderStatusService orderStatusServiceImpl) {
		this.orderStatusServiceImpl = orderStatusServiceImpl;
	}

	public void setOrderTableDataDto(OrderTableDto orderTableDataDto) {
		this.orderTableDataDto = orderTableDataDto;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setUserManage(UserManage userManage) {
		this.userManage = userManage;
	}

	public void setUserOrderRequestDto(UserOrderRequestDto userOrderRequestDto) {
		this.userOrderRequestDto = userOrderRequestDto;
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

}
