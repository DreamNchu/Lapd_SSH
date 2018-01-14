package com.lps.web.basicmsg.dto;

import java.util.List;

import com.lps.model.basic.Entity;

public interface TableInitDto<T extends Entity> {

	public void init(List<T> lists) throws DtoInitException;
	
}
