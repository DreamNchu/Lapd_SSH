package com.lps.web.workrank.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.WorkRank;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@DtoName("workRanks")
public class TWorkRankDto extends ArrayList<WorkRankDto> implements TableInitDto<WorkRank>{

	private static final long serialVersionUID = -5652757594637313740L;

	@Override
	public void init(List<WorkRank> lists) throws DtoInitException {
		for (WorkRank workRank : lists) {
			WorkRankDto wrd = new WorkRankDto();
			wrd.init(workRank);
			add(wrd);
		}
	}

}
