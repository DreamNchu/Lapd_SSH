package com.lps.action.operation.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.JsonResult;
import com.lps.control.manage.OrderManage;
import com.lps.model.ServerOrder;
import com.lps.service.ServerOrderService;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkJson;
import com.lps.web.order.dto.InitBasicUpdateDataDto;
import com.lps.web.order.dto.OrderTableDataDto;
import com.lps.web.order.dto.OrderUpdateDataDto;
import com.lps.web.order.dto.QueryOrderDto;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.orderchart.dto.OrderChartInitDto;
import com.lps.web.orderchart.dto.OrderChartRequestDto;
import com.opensymphony.xwork2.ActionSupport;

public class ManageOrdersAction extends ActionSupport implements JsonResult, SessionAware {

	private static final long serialVersionUID = -8763735445922466287L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private OrderTableDataDto orderTableDataDto;

	/**
	 * 查询所要的订单基本信息
	 */
	private QueryOrderDto queryOrderDto;

	private OrderManage orderManage;

	private Map<String, Object> session;

	private String result;

	private ServerOrderService serverOrderServiceImpl;

	private OrderUpdateDataDto orderUpdateDataDto;

	public OrderUpdateDataDto getOrderUpdateDataDto() {
		return orderUpdateDataDto;
	}

	public void setOrderUpdateDataDto(OrderUpdateDataDto orderUpdateDataDto) {
		this.orderUpdateDataDto = orderUpdateDataDto;
	}

	/**
	 * 订单的编号
	 */
//	private String orderId;
	/**
	 * 订单编号的id集合
	 */
	private List<String> orderId;

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String deleteOrders() {
		Map<String, Object> map = new HashMap<>();
		boolean isError = false;
		try {
			for (String orderId : orderId) {
				ServerOrder so = serverOrderServiceImpl.findById(orderId);
				serverOrderServiceImpl.delete(so);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "删除订单失败");
			isError = true;
		}
		if(!isError)
			map.put(MSG, "删除订单成功");
		result = WorkJson.toJsonDisableHtmlEscaping(map);
		return SUCCESS;
	}

	public OrderUpdateDataDto getOrderDataDto() {
		return orderUpdateDataDto;
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public OrderTableDataDto getOrderTableDataDto() {
		return orderTableDataDto;
	}

	public QueryOrderDto getQueryOrderDto() {
		return queryOrderDto;
	}

	@Override
	public String getResult() {
		return this.result;
	}

	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	/**
	 * 根据时间查看各种订单类型
	 * 
	 * @return 根据请求返回不同的界面
	 * @throws PagePropertyNotInitException
	 */
	public String queryBasicOrders() throws PagePropertyNotInitException {
		// 找到今日该状态下的所有订单

		if (queryOrderDto != null) {
			if (queryOrderDto.getStatusId() != 0)
				session.put("statusId", queryOrderDto.getStatusId());
			if (queryOrderDto.getTimeType() != 0) {
				session.put("timeType", queryOrderDto.getTimeType());
			}
			if (queryOrderDto.getPage() != 0)
				session.put("orderPage", queryOrderDto.getPage());
		}
		
		queryOrderDto.setPage(Integer.parseInt( session.get("orderPage") + ""));
		queryOrderDto.setStatusId(Integer.parseInt( session.get("statusId") + ""));
		queryOrderDto.setTimeType(Integer.parseInt( session.get("timeType")+""));

		orderTableDataDto.init(orderManage.basicQuery(queryOrderDto, queryOrderDto.getPage()), queryOrderDto, "queryOrderDto",
				"queryBasicOrders");
		result = WorkJson.toJsonDisableHtmlEscaping(orderTableDataDto);
System.out.println(result);
		return SUCCESS;

	}
	
	private OrderChartDto orderChartDto = new OrderChartDto();
	
	private OrderChartRequestDto orderChartRequestDto;
	
	/**
	 * 图图表分析数据
	 * @return
	 */
	public String chartDataOrders(){
		orderManage.chartAnalyze(orderChartDto, orderChartRequestDto);
		result = WorkJson.toJsonDisableHtmlEscaping(orderChartDto);
System.out.println(result);
		return SUCCESS;
	}
	
	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	public OrderChartRequestDto getOrderChartRequestDto() {
		return orderChartRequestDto;
	}

	public void setOrderChartRequestDto(OrderChartRequestDto orderChartRequestDto) {
		this.orderChartRequestDto = orderChartRequestDto;
	}

	public void setOrderDataDto(OrderUpdateDataDto orderUpdateDataDto) {
		this.orderUpdateDataDto = orderUpdateDataDto;
	}


	public List<String> getOrderId() {
		return orderId;
	}

	public void setOrderId(List<String> orderId) {
		this.orderId = orderId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	public void setOrderTableDataDto(OrderTableDataDto orderTableDataDto) {
		this.orderTableDataDto = orderTableDataDto;
	}

	public void setQueryOrderDto(QueryOrderDto queryOrderDto) {
		this.queryOrderDto = queryOrderDto;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	//
	private InitBasicUpdateDataDto initBasicUpdateDataDto ;
	
	/**
	 * 更新订单内容
	 * 
	 * @return 成功返回success
	 */
	public String updateOrder() {
		// 更新已经更改的字段
		Map<String, Object> map = new HashMap<>();
		boolean isError = false;
		try {
			orderManage.update(orderUpdateDataDto);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(MSG, "更新订单失败");
			isError = true;
		}
		if(! isError)
			map.put(MSG, "更新订单成功");
		result = WorkJson.toJsonDisableHtmlEscaping(map);
		return SUCCESS;
	}
	
	/**
	 * 查询单个订单
	 * @return
	 */
	public String queryOrder(){
		String id = orderId.get(0);
		serverOrderServiceImpl.findById(id);
		orderManage.basicQuery(initBasicUpdateDataDto,id);
		result = WorkJson.toJsonDisableHtmlEscaping(initBasicUpdateDataDto);
System.out.println(result);
		return SUCCESS;
	}
	
	private OrderChartInitDto orderChartInitDto = new OrderChartInitDto();
	
	public String initChartOrders(){

		
		orderChartInitDto.init(orderManage.findAllUser());
		result = WorkJson.toJsonDisableHtmlEscaping(orderChartInitDto);
System.out.println(result);
		return SUCCESS;
	}
	

	public OrderChartInitDto getOrderChartInitDto() {
		return orderChartInitDto;
	}

	public void setOrderChartInitDto(OrderChartInitDto orderChartInitDto) {
		this.orderChartInitDto = orderChartInitDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public InitBasicUpdateDataDto getInitBasicUpdateDataDto() {
		return initBasicUpdateDataDto;
	}

	public void setInitBasicUpdateDataDto(InitBasicUpdateDataDto initBasicUpdateDataDto) {
		this.initBasicUpdateDataDto = initBasicUpdateDataDto;
	}

}
