package com.lps.web.order.dto;

import com.lps.web.page.dto.PageAble;

public class PageLinkTransformOrderDto implements PageAble{
	
	private int statusId = 1;
	/**
	 * 时间段类型
	 */
	private int timeType = 1;
	
	private int page = 1;

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
	
	public int getPage() {
		return page;
	}
	
	public int getStatusId() {
		return statusId;
	}
	

	public int getTimeType() {
		return timeType;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}

}
