package com.lps.web.workrank.dto;

import com.lps.model.User;
import com.lps.model.WorkRank;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class WorkRankDto extends BasicRespondMsgDto implements WorkRankLibrary{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7285373361923506019L;

	/**
	 * 	String index = "index";
	
	String stuffId = "stuffId";
	
	String workId = "workId";

	String realName = "realName";

	String rankNum = "rankNum";
	
	String spotNum = "spotNum";
	 */
	
	@Override
	public WorkRank generate() {
//		WorkRank wr = new WorkRank();
//		if(get()
		return null;
	}

	@Override
	public WorkRankDto getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkRankDto init(WorkRank obj) throws DtoInitException {
		WorkRank wr = obj;
		
		if(wr.getId() != null){
			put(workRankId, wr.getId());
		}
		if(wr.getRankNum() != null){
			put(rankNum, wr.getRankNum());
		}
		if(wr.getSpotNum() != null){
			put(spotNum, wr.getSpotNum());
		}
		if(wr.getUser() != null){
			User u = wr.getUser();
			put(realName, u.getRealName());
			put(workId, u.getWorkId());
		}
		return this;
	}
	

}
