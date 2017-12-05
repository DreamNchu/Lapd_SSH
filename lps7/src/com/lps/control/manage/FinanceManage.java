package com.lps.control.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lps.model.ServerOrder;
import com.lps.service.ServerOrderService;
import com.lps.web.dto.FinanceLineChartDataBasicDto;

public class FinanceManage {

	private FinanceLineChartDataBasicDto financeDayLineChartDataDto;
	private FinanceLineChartDataBasicDto financeBefore7DaysLineChartDataDto;
	private FinanceLineChartDataBasicDto financeThisMonthLineChartDataDto;
	private FinanceLineChartDataBasicDto financeThisYearChartDataDto;
	

	public FinanceLineChartDataBasicDto getFinanceDayLineChartDataDto() {
		return financeDayLineChartDataDto;
	}

	public void setFinanceDayLineChartDataDto(FinanceLineChartDataBasicDto financeDayLineChartDataDto) {
		this.financeDayLineChartDataDto = financeDayLineChartDataDto;
	}

	public FinanceLineChartDataBasicDto getFinanceBefore7DaysLineChartDataDto() {
		return financeBefore7DaysLineChartDataDto;
	}

	public void setFinanceBefore7DaysLineChartDataDto(FinanceLineChartDataBasicDto financeBefore7DaysLineChartDataDto) {
		this.financeBefore7DaysLineChartDataDto = financeBefore7DaysLineChartDataDto;
	}

	public FinanceLineChartDataBasicDto getFinanceThisMonthLineChartDataDto() {
		return financeThisMonthLineChartDataDto;
	}

	public void setFinanceThisMonthLineChartDataDto(FinanceLineChartDataBasicDto financeThisMonthLineChartDataDto) {
		this.financeThisMonthLineChartDataDto = financeThisMonthLineChartDataDto;
	}

	public FinanceLineChartDataBasicDto getFinanceThisYearChartDataDto() {
		return financeThisYearChartDataDto;
	}

	public void setFinanceThisYearChartDataDto(FinanceLineChartDataBasicDto financeThisYearChartDataDto) {
		this.financeThisYearChartDataDto = financeThisYearChartDataDto;
	}

	private ServerOrderService serverOrderServiceImpl;

	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	/**
	 * 将list中的数据按照mapUtil中的类型整合分析
	 * @param mapUtil
	 * @param list
	 * @return
	 */
	private List<Double> analizeLineChartData(FinanceLineChartDataBasicDto fa, List<ServerOrder> list){
		fa.init();
		
		Map<String, Double> mapUtil = new LinkedHashMap<>();
		
		for(int i = 0; i < fa.getLabels().size(); i ++){
			mapUtil.put(fa.getLabels().get(i)+"", 0.0);
		}
		
		for (Iterator<ServerOrder> iterator = list.iterator(); iterator.hasNext();) {
			ServerOrder serverOrder = (ServerOrder) iterator.next();
			Date payTime = serverOrder.getPayTime();  //得到支付时间
			if(payTime != null){
				String time = fa.refrences(payTime);
				Double obj = mapUtil.get(time);
				Integer realPay = serverOrder.getRealPay();
				if(realPay != null)
					mapUtil.replace(time, obj + realPay);
			}
		}
		List<Double> listUtil = new ArrayList<>();
		for (String str : mapUtil.keySet()) {
			listUtil.add(mapUtil.get(str));
		}
		
		return listUtil;
	}
	
	/**
	 * 返回数据分析dto
	 * <br>
	 * 1.单位时间点营业额
	 * <br>
	 * 2.工作时间点
	 * @return
	 */
	public FinanceLineChartDataBasicDto getDayLineChartDataAnalizy(){
		Map<String , Object> map = financeDayLineChartDataDto.getDataSet();
		List<ServerOrder> list = serverOrderServiceImpl.findTodayOrder();
		
		List<Double> listUtil =  analizeLineChartData(financeDayLineChartDataDto,list);
		
		map.replace(financeDayLineChartDataDto.getData(), listUtil);
		
		return financeDayLineChartDataDto;
	}
	/**
	 * 最近七天的折线图报表
	 * @return
	 */
	public FinanceLineChartDataBasicDto getBefore7DaysLineChartDataAnalizy(){
		Map<String , Object> map = financeBefore7DaysLineChartDataDto.getDataSet();
		List<ServerOrder> list = serverOrderServiceImpl.findBefore7DayOrders();
		
		//分析数据
		List<Double> listUtil =  analizeLineChartData(financeBefore7DaysLineChartDataDto,list);
		
		map.replace(financeBefore7DaysLineChartDataDto.getData(), listUtil);
		
		return financeBefore7DaysLineChartDataDto;
	}
	
//	financeThisMonthLineChartDataDto
	/**
	 * 本月的工作折线统计分析
	 * @return
	 */
	public FinanceLineChartDataBasicDto getThisMonthLineChartDataAnalizy(){
		
		Map<String , Object> map = financeThisMonthLineChartDataDto.getDataSet();
		List<ServerOrder> list = serverOrderServiceImpl.findThisMonthOrders();
		
		//分析数据
		List<Double> listUtil =  analizeLineChartData(financeThisMonthLineChartDataDto,list);
		
		map.replace(financeThisMonthLineChartDataDto.getData(), listUtil);
		
		return financeThisMonthLineChartDataDto;
		
	}
//	financeThisYearChartDataDto
	
	/**
	 * 今年的工作折线图报表信息
	 * @return
	 */
	public FinanceLineChartDataBasicDto getThisYearLineChartDataAnalizy(){
		Map<String , Object> map = financeThisYearChartDataDto.getDataSet();
		List<ServerOrder> list = serverOrderServiceImpl.findThisYearOrders();
		
		//分析数据
		List<Double> listUtil =  analizeLineChartData(financeThisYearChartDataDto,list);
		
		map.replace(financeThisYearChartDataDto.getData(), listUtil);
		
		return financeThisYearChartDataDto;
	}
	
}
