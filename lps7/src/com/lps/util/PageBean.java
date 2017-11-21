package com.lps.util;

import java.util.List;

/**
 * @author 0001
 *
 * @param <T>
 */
public class PageBean<T> {

	private long page;// ��ǰҳ��
	
	private long allCount;// �ܼ�¼��
	
	private long allPage;// ��ҳ��(�ܼ�¼��/ÿҳ��¼��)
	
	private long limit;// ÿҳ��¼��
	
	private List<T> list ;// �����ļ���

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
