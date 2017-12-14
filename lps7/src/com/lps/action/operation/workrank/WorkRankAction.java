package com.lps.action.operation.workrank;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.WorkRankManage;
import com.lps.model.WorkRank;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.WorkJson;
import com.lps.web.workrank.dto.PageLinkTransformWorkRankDto;
import com.lps.web.workrank.dto.WorkRankTableDto;
import com.opensymphony.xwork2.ActionSupport;

public class WorkRankAction extends ActionSupport implements DataResult{

	private static final long serialVersionUID = 3231097688808974970L;
	
	private WorkRankManage workRankManage;
	
	private WorkRankTableDto workRankTableDto;
	
	public WorkRankTableDto getWorkRankTableDto() {
		return workRankTableDto;
	}

	public void setWorkRankTableDto(WorkRankTableDto workRankTableDto) {
		this.workRankTableDto = workRankTableDto;
	}

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}
	
	private int page;
	
	/**
	 * 分页系统辅助类
	 */
	private PageLinkTransformWorkRankDto pageLinkTransformWorkRankDto;
	
	public PageLinkTransformWorkRankDto getPageLinkTransformWorkRankDto() {
		return pageLinkTransformWorkRankDto;
	}

	public void setPageLinkTransformWorkRankDto(PageLinkTransformWorkRankDto pageLinkTransformWorkRankDto) {
		this.pageLinkTransformWorkRankDto = pageLinkTransformWorkRankDto;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 查看当前的工作排名表
	 * @return
	 * @throws PagePropertyNotInitException
	 */
	public String viewWorkRankTable() throws PagePropertyNotInitException{
		if(page <= 0){
			page = 1;
		}
		
		PageBean<WorkRank> workRankPage = workRankManage.getWorkRankTable(page, null);
		workRankTableDto.init(workRankPage, 
				new PageLinkTransformWorkRankDto(),
				pageLinkTransformWorkRankDto.getDomainName(),
				Thread.currentThread().getStackTrace()[1].getMethodName());
		
		writeInResult(workRankTableDto);
System.out.println(result);
		return SUCCESS;
	}
	
	public String workRankPage(){
		return SUCCESS;
	}

	
	@Override
	public void writeInResult(Object obj){
		result = WorkJson.toJsonDisableHtmlEscaping(obj);
	}
	
}
