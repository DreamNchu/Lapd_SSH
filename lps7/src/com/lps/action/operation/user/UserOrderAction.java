package com.lps.action.operation.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.OrderManage;
import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.util.WorkJson;
import com.lps.web.order.dto.OrderSingleDataDto;
import com.lps.web.order.dto.OrderTableDataDto;
import com.lps.web.order.dto.constant.TimeType;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.orderchart.dto.OrderChartRequestDto;
import com.lps.web.orderchart.dto.Population;
import com.lps.web.user.dto.UserOrderRequestDto;
import com.opensymphony.xwork2.ActionSupport;

public class UserOrderAction extends ActionSupport 
		implements DataResult, SessionAware{

	private static final long serialVersionUID = -7901998643050021799L;
	
	private Map<String, Object> session ;
	
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

	public OrderManage getOrderManage() {
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

	public String queryOrders(){
		int userId = Integer.parseInt(session.get("id")+"");
		
		int timeType = 0;
		if(userOrderRequestDto.getTimeType() == 0){
			timeType = TimeType.DAY;
		}
		
		List<ServerOrder> listOrders = orderManage.queryOrder(userId, 
				userOrderRequestDto.getStatusId(), 
				timeType);
		
		PageBean<ServerOrder> pageBean = new PageBean<ServerOrder>();
		pageBean.setList(listOrders);
		
		orderTableDataDto.init(pageBean, null, null, null);
		result = WorkJson.toJsonDisableHtmlEscaping(orderTableDataDto);
//System.out.println(result);
		return SUCCESS;
	}
	
	private OrderChartDto orderChartDto;
	
	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	public String todayOrderIncome(){
		OrderChartRequestDto orderChartRequestDto = new OrderChartRequestDto();
		orderChartRequestDto.setUserId(Integer.parseInt(session.get("id")+""));
		if(userOrderRequestDto.getTimeType() == 0){
			orderChartRequestDto.setTimeType(TimeType.DAY);
		}
		orderChartRequestDto.setPopulation(Population.ONE);
		orderManage.chartAnalyze(orderChartDto,orderChartRequestDto);
		result = WorkJson.toJsonDisableHtmlEscaping(orderChartDto);
		return SUCCESS;
	}
	
	/**
	 * 管理订单页面
	 * @return
	 */
	public String manageOrdersPage(){
		return SUCCESS;
	}
	
	private OrderSingleDataDto orderSingleDataDto;
	
	public OrderSingleDataDto getOrderSingleDataDto() {
		return orderSingleDataDto;
	}

	public void setOrderSingleDataDto(OrderSingleDataDto orderSingleDataDto) {
		this.orderSingleDataDto = orderSingleDataDto;
	}
	
	private String idOrder;

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	/**
	 * 获取订单的详细信息
	 * @return
	 */
	public String detailOrderInfo(){
		orderSingleDataDto.init(orderManage.queryOrder(idOrder));
		return SUCCESS;
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
