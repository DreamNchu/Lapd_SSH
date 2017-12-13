package com.lps.web.user.dto;

import com.lps.web.page.dto.PageAble;

public class PageLinkTransformUserDto implements PageAble{

	private int page;

	public int getPage() {
		return page;
	}

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
