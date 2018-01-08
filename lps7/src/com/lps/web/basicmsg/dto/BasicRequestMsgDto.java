package com.lps.web.basicmsg.dto;

import com.lps.model.basic.Entity;
import com.lps.web.dto.BasicRequestDto;

public abstract class BasicRequestMsgDto<T extends Entity> implements BasicRequestDto<T>{

	@SuppressWarnings("unchecked")
	public<K> K getNativeObject(){
		return (K)this;
	}
	
}
