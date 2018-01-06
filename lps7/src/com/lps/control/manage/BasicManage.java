package com.lps.control.manage;

import java.io.Serializable;

import com.lps.model.basic.Entity;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;
import com.lps.web.page.dto.PageDto;

public interface BasicManage {

	/**
	 * 创建一个实体对象
	 * 
	 * @param dto
	 * @throws CreateFailedException 
	 */
	
	<DTO extends BasicRequestMsgDto> void create(DTO dto) throws CreateFailedException;

	/**
	 * 根据dto 更新相应的model
	 * 
	 * @param orderUpdateDataDto
	 * @throws FindByIdGetNullException 
	 */
	<DTO extends BasicRequestMsgDto> void update(DTO dto) throws FindByIdGetNullException;

	void delete(Serializable... id) throws FindByIdGetNullException;

	Entity query(Serializable id) throws FindByIdGetNullException;
	
	<DTO extends PageDto> PageBean<Entity> query(DTO dto) throws FindByIdGetNullException;
}