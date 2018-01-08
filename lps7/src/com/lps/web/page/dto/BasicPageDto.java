package com.lps.web.page.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.Entity;
import com.lps.util.PageLinkParamCreater;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public abstract class BasicPageDto<T extends Entity> extends BasicRespondMsgDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5075706924643222212L;

	protected  List<Map<String, Object>> page = new ArrayList<>();;

	protected  List<Map<String, Object>> transform = new ArrayList<>();;

	protected  List<Map<String, Object>> number = new ArrayList<>();

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

	public void init(PageBean<T> pageBean, PageAble pageAble, String actionName) throws DtoInitException {
		if(pageBean == null)
			return ;
		Map<String, Object> mapPage = new HashMap<>();
		mapPage.put("currentPage", pageBean.getPage());
		mapPage.put("allCount", pageBean.getAllCount());
		mapPage.put("allPage", pageBean.getAllPage());
		page.add(mapPage);

		if(pageAble == null) //如果不需要分页
			return ;
		// 前一页
		Map<String, Object> mapdir = new HashMap<>();
		pageAble.setPage((int) (pageBean.getPage() - 1 <= 0 ? 1 : pageBean.getPage() - 1));
		String qlBack = PageLinkParamCreater.createLinkParam(pageAble);
		mapdir.put("back", removeLast(actionName + "?" + qlBack));

		// 后一页
		pageAble.setPage(
				(int) (pageBean.getPage() + 1 > pageBean.getAllPage() ? pageBean.getAllPage() : pageBean.getPage() + 1));
		String qlFront = PageLinkParamCreater.createLinkParam(pageAble);
		mapdir.put("front", removeLast(actionName + "?" + qlFront));
		transform.add(mapdir);

		// 页码
		for (int i : pageBean.getViewPageNum()) {
			pageAble.setPage(i);
			Map<String, Object> map = new HashMap<>();

			map.put("value", i);
			String temp = PageLinkParamCreater.createLinkParam(pageAble);
			map.put("link", removeLast(actionName + "?" + temp));
			number.add(map);
		}
	}
	
	private String removeLast(String str){
		return str.substring(0, str.length() - 1);
	}

}
