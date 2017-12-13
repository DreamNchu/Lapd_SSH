package com.lps.web.workrank.dto;

import com.lps.web.page.dto.PageAble;

public class PageLinkTransformWorkRankDto implements PageAble{
	
	private int page;

	public int getPage() {
		return page;
	}

	@Override
	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String getDomainName() {
		String str = this.getClass().getSimpleName();
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}
}
