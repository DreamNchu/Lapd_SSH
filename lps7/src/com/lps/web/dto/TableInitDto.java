package com.lps.web.dto;

import java.util.List;

import com.lps.model.basic.Entity;

public interface TableInitDto<T extends Entity> {

	public void init(List<T> lists) throws DtoInitException;
	
	public String getName();
	
}
