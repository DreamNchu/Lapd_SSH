package com.lps.web.workrank.dto;

import java.util.List;

import com.lps.model.WorkRank;
import com.lps.util.PageBean;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.PageDto;

public class WorkRankTableDto extends PageDto{
	
	private List<WorkRankSingleDataDto> workRankData ;

	
	@SuppressWarnings("unchecked")
	@Override
	public <T> void init(PageBean<T> lOrders, PageAble queryOrderDto, String domainName, String actionName) {
		super.init(lOrders, queryOrderDto, domainName, actionName);
		
		int i = 0;
		for (WorkRank wr: (List<WorkRank>)lOrders.getList()) {
			i ++;
			WorkRankSingleDataDto ws = new WorkRankSingleDataDto();
			try {
				ws.init(i, wr);
			} catch (WorkRankSingleDataInitException e) {
				e.printStackTrace();
				continue;
			}
			this.workRankData.add(ws);
		}
	}

	
	
	public List<WorkRankSingleDataDto> getWorkRankData() {
		return workRankData;
	}

	public void setWorkRankData(List<WorkRankSingleDataDto> workRankData) {
		this.workRankData = workRankData;
	}
	
}
