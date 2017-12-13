package com.lps.web.order.dto;

import com.lps.web.page.dto.PageAble;

public class PageLinkTransformOrderDto implements PageAble{
	
	private int statusId = 1;
	
	private int timeType = 1;
	
	private int page = 1;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public PageLinkTransformOrderDto() {
	}
	
	public PageLinkTransformOrderDto(int statusId, int timeType) {
		super();
		this.statusId = statusId;
		this.timeType = timeType;
	}
	
	@Override
	public String getDomainName() {
		String str = this.getClass().getSimpleName();
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}
	
	/*public static void main(String[] args) {
		QueryOrderDto q = new QueryOrderDto(1, 2);
		System.out.println(Thread.currentThread().getStackTrace()[0].getMethodName());
		System.out.println(LinkParamCreater.createLinkParam(q));
	}*/

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTimeType() {
		return timeType;
	}

	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}

}
