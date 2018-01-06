package com.lps.web.simple.dto;

import com.lps.model.PayPath;
import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.BasicInitDto;

public class PayPathDto extends BasicRespondMsgDto implements PayPathLibrary{


	@Override
	public PayPathDto init(PayPath obj) {
		if (obj == null) {
			return this;
		}
		PayPath pp = (PayPath) obj;
		map.put(payId , pp.getId());
		map.put(payPath , pp.getPayPath());
		return this;
	}

}
