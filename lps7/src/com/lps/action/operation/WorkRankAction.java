package com.lps.action.operation;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.lps.model.WorkRank;
import com.lps.service.WorkRankService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.opensymphony.xwork2.ActionSupport;

public class WorkRankAction extends ActionSupport 
implements SessionAware, RequestAware{

	private static final long serialVersionUID = 8749680586112424941L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private Map<String, Object> session ;
	
	private Map<String, Object> request ;
	
	
	public List<WorkRank> getList() {
		return list;
	}

	public void setList(List<WorkRank> list) {
		this.list = list;
	}

	private WorkRankService workRankServiceImpl;

	public WorkRankService getWorkRankServiceImpl() {
		return workRankServiceImpl;
	}

	public void setWorkRankServiceImpl(WorkRankService workRankServiceImpl) {
		this.workRankServiceImpl = workRankServiceImpl;
	}

	/**
	 * 存储表信息
	 */
	private List<WorkRank> list;
	
	public String viewTodayWorkRank(){
		this.list = workRankServiceImpl.findAll();
		
		return SUCCESS;
	}
	
	private PageBean<WorkRank> workRankPageBean;
	
	public PageBean<WorkRank> getWorkRankPageBean() {
		return workRankPageBean;
	}

	public void setWorkRankPageBean(PageBean<WorkRank> workRankPageBean) {
		this.workRankPageBean = workRankPageBean;
	}
	
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 根据页面查看上钟排名信息
	 * @return
	 * @throws PagePropertyNotInitException
	 */
	public String viewTodayWorkRankByPage() throws PagePropertyNotInitException{
		
		this.workRankPageBean = workRankServiceImpl.findByPage(page);
		
		
		return SUCCESS;
	}
	

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	

}
