package com.lps.control.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.Entity;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;

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
	<DTO extends BasicUpdateDto<T>> void update(DTO dto) throws FindByIdGetNullException;

	/**
	 * 删除实体对象
	 * @param id
	 * @throws FindByIdGetNullException
	 */
	void delete(Serializable... id) throws FindByIdGetNullException;

	/**
	 * 通过主键id查找实体
	 * @param id
	 * @return
	 * @throws FindByIdGetNullException
	 * @throws DtoInitException 
	 */
	<RDto extends BasicResponseDto<T>> T query(Serializable id, RDto rdto) throws FindByIdGetNullException, DtoInitException;
	
	T query(Serializable id)throws FindByIdGetNullException;
	
	/**
	 * 通过主键id查找 listName 中的主键
	 * @param id
	 * @param listName
	 * @return
	 * @throws FindByIdGetNullException
	 */
	T query(Serializable id, List<String> listName) throws FindByIdGetNullException;
	
	/**
	 * 
	 * @param page
	 * @return
	 * @throws FindByIdGetNullException
	 * @throws PagePropertyNotInitException
	 */
	PageBean<T> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException;
	
	
	/**
	 * 查询所有的实体
	 * @return
	 */
	List<T> queryAll();
	
	/**
	 * 精确查找，根据相应字段的值查找对象集合
	 * @param map
	 * @return
	 */
	List<T> queryByProperties(Map<String, Object> map);
	
	
	List<T> queryByPropertiesRange(List<PropertyRange<?>> listPro);
	
	
	<DTO extends BasicRespondMsgDto> void initOperationData(DTO dto) throws DtoInitException, MapNotInitForClassPathException;
	
	
}