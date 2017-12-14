package com.lps.action.operation.user;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.OrderManage;
import com.lps.util.WorkJson;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.orderchart.dto.OrderChartRequestDto;
import com.lps.web.orderchart.dto.Population;
import com.opensymphony.xwork2.ActionSupport;

public class UserOrdersCountAction extends ActionSupport 
		implements DataResult{
	
	private static final long serialVersionUID = -7904719214614886119L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public void writeInResult(Object obj){
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}
	private OrderManage orderManage;
	
	private OrderChartDto orderChartDto;
	
	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	/**
	 * 员工个人分析图表页面
	 * @return
	 */
	public String chartAnalyzePage(){
		return SUCCESS;
	}
	
	private OrderChartRequestDto orderChartRequestDto;
	
	/**
	 * 员工图表数据
	 * @return
	 */
	public String chartDataOrders(){
		
		//权限限制
		orderChartRequestDto.setPopulation(Population.ONE);
		
		orderManage.chartAnalyze(orderChartDto, orderChartRequestDto);
		result = WorkJson.toJsonDisableHtmlEscaping(orderChartDto);
	//System.out.println(result);
		return SUCCESS;	
		
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
}
