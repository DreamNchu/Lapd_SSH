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
	/**
	 * 获取页数
	 * @return 返回当前的页面数
	 */
	public long getPage() {
		return page;
	}

	/**
	 * 设置页面数
	 * @param page 设置页面
	 */
	public void setPage(long page) {
		this.page = page;
	}
/**
 * 返回所有记录
 * @return
 */
	public long getAllCount() {
		return allCount;
	}
/**
 * 设置当前的记录总数
 * @param allCount 记录总数
 */
	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}
/**
 * 返回页面总数
 * @return 放回页面总数
 */
	public long getAllPage() {
		return allPage;
	}
/**
 * 设置页面总数
 * @param allPage 页面总数
 */
	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}
/**
 * 每个页面的限制条数
 * @return 返回每个页面的限制条数
 */
	public long getLimit() {
		return limit;
	}
/**
 * 设置页面的记录显示条数
 * @param limit 页面的记录显示条数
 */
	public void setLimit(long limit) {
		this.limit = limit;
	}
/**
 * 返回当前页面的list
 * @return
 */
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
