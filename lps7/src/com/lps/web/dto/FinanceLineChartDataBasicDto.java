package com.lps.web.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 财政今日数据分析数据转换
 * @author 0001
 *
 */
public abstract class FinanceLineChartDataBasicDto {
	
	private transient String data; 
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private List<String> labels;
	
	private Map<String , Object> dataSet;

	public Map<String, Object> getDataSet() {
		return dataSet;
	}

	public void setDataSet(Map<String, Object> dataSet) {
		this.dataSet = dataSet;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
	public abstract void init();
	
	public abstract String refrences(Date date);
	
	/*var yearChartData = {
			labels  : ['9.00', '10.00', '11.00', '12.00', '13.00', '14.00', '15.00','16.00', '17.00', '18.00', '19.00', '20.00','21.00','22.00','23.00','24.00'],
			    datasets: [
			        {
			            label               : ' 时间',
			            fillColor           : '#3c8dbc',
			            strokeColor         : '#f56954',
			            pointColor          : '#3c8dbc',
			            pointStrokeColor    : '#f56954',
			            pointHighlightFill  : '#3c8dbc',
			            pointHighlightStroke: 'rgba(220,220,220,1)',
			            data                : [60, 50, 80, 80, 60, 90,20 ,100, 70, 30, 80, 102, 50,40,50,70]
			        }
			    ]
			}
*/	
	
	
}
