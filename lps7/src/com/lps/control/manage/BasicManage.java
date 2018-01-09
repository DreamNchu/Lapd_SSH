package com.lps.control.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lps.model.User;
import com.lps.model.basic.Entity;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.page.dto.BasicPageDto;

public interface BasicManage<T extends Entity>{

	/**
	 * 创建一个实体对象
	 * 
	 * @param dto
	 * @throws CreateFailedException 
	 */
	
	<DTO extends BasicRequestDto<T>> void create(DTO dto) throws CreateFailedException;

	/**
	 * 根据dto 更新相应的model
	 * 
	 * @param orderUpdateDataDto
	 * @throws FindByIdGetNullException 
	 */
	<DTO extends BasicRequestDto<T>> void update(DTO dto) throws FindByIdGetNullException;

	/**
	 * 删除实体对象
	 * @param id
	 * @throws FindByIdGetNullException
	 */
	void delete(Serializable... id) throws FindByIdGetNullException;

	T query(Serializable id) throws FindByIdGetNullException;
	
	PageBean<T> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException;
	
	List<T> queryAll();
	
	/**
	 * 精确查找，根据相应字段的值查找对象集合
	 * @param map
	 * @return
	 */
	List<T> queryByProperties(Map<String, Object> map);
	
}