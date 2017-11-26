package com.lps.util;

import java.util.List;

/**
 * @author 0001
 *
 * @param <T>
 */
public class PageBean<T> {

	private long page = -1;// 当前页数

	private long allCount = -1;// 总记录数

	private long allPage = -1;// 总页数(总记录数/每页记录数)

	private long limit = -1;// 每页记录数

	private List<T> list;// 包含的集合

	/**
	 * 该方法完成了对{@link PageBean#getAllCount()}初始化
	 * <p>
	 * 返回该页面下的起始下标
	 * @param allCount 所有的记录
	 * @param page 当前页面数
	 * @return 返回该页面下的起始下标
	 * @throws PagePropertyNotInitException 
	 */
	public long init(long allCount, long page) throws PagePropertyNotInitException {
		
		if(limit < 0){
			throw new PagePropertyNotInitException("PageBeanLimitNotInitException ");
		}
		
		this.page = page;
		
		this.allCount = allCount;

		long totalpage = (long) Math.ceil(allCount / limit);

		this.allPage = totalpage;

		long begin = (page - 1) * limit;
		
		return begin;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getAllCount() {
		return allCount;
	}

	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
