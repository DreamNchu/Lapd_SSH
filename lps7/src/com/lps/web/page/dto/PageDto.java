package com.lps.web.page.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.util.LinkParamCreater;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.BasicMsgDto;

public abstract class PageDto extends BasicMsgDto{

	protected List<Map<String, Object>> page = new ArrayList<>();;

	protected List<Map<String, Object>> transform = new ArrayList<>();;

	protected List<Map<String, Object>> number = new ArrayList<>();

	public List<Map<String, Object>> getPage() {
		return page;
	}

	public void setPage(List<Map<String, Object>> page) {
		this.page = page;
	}

	public List<Map<String, Object>> getTransform() {
		return transform;
	}

	public void setTransform(List<Map<String, Object>> transform) {
		this.transform = transform;
	}

	public List<Map<String, Object>> getNumber() {
		return number;
	}

	public void setNumber(List<Map<String, Object>> number) {
		this.number = number;
	}

	public <T> void init(PageBean<T> lOrders, PageAble pageLinkDto, String domainName, String actionName) {
		if(lOrders == null)
			return ;
		Map<String, Object> mapPage = new HashMap<>();
		mapPage.put("currentPage", lOrders.getPage());
		mapPage.put("allCount", lOrders.getAllCount());
		mapPage.put("allPage", lOrders.getAllPage());
		page.add(mapPage);

		if(pageLinkDto == null) //如果不需要分页
			return ;
		// 前一页
		Map<String, Object> mapdir = new HashMap<>();
		pageLinkDto.setPage((int) (lOrders.getPage() - 1 <= 0 ? 1 : lOrders.getPage() - 1));
		String qlBack = LinkParamCreater.createLinkParam(pageLinkDto, domainName);
		mapdir.put("back", removeLast(actionName + "?" + qlBack));

		// 后一页
		pageLinkDto.setPage(
				(int) (lOrders.getPage() + 1 > lOrders.getAllPage() ? lOrders.getAllPage() : lOrders.getPage() + 1));
		String qlFront = LinkParamCreater.createLinkParam(pageLinkDto, domainName);
		mapdir.put("front", removeLast(actionName + "?" + qlFront));
		transform.add(mapdir);

		// 页码
		for (int i : lOrders.getViewPageNum()) {
			pageLinkDto.setPage(i);
			Map<String, Object> map = new HashMap<>();

			map.put("value", i);
			String temp = LinkParamCreater.createLinkParam(pageLinkDto, domainName);
			map.put("link", removeLast(actionName + "?" + temp));
			number.add(map);
		}
	}
	
	private String removeLast(String str){
		return str.substring(0, str.length() - 1);
	}

}
