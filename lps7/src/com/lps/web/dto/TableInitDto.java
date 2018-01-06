package com.lps.web.dto;

import java.util.List;

import com.lps.model.basic.Entity;

public interface TableInitDto {

	public <T extends Entity> void init(List<T> lists) throws DtoInitException;
	
}
