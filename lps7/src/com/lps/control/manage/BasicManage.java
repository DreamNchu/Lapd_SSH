package com.lps.control.manage;

import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;

public interface BasicManage<T extends BasicModel>{

	/**
	 * 创建一个实体对象
	 * 
	 * @param dto
	 * @throws ECreateFailedException 
	 */
	
	<DTO extends BasicRequestDto<T>> void create(DTO dto) throws ECreateFailedException;

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
	void delete(java.io.Serializable... id) throws FindByIdGetNullException;

	/**
	 * 通过主键id查找实体
	 * You can find the entity by the id.
	 * @param id
	 * @return
	 * @throws FindByIdGetNullException
	 * @throws DtoInitException 
	 */
	/**
	 * You get a model, but cann't resolve it.So you need to give me a DTO which can resolve this data.  
	 * @param id identity for model
	 * @param rdto DTO for resolve data.
	 * @return model, not DTO
	 * @throws FindByIdGetNullException
	 * @throws DtoInitException
	 */
	<RDto extends BasicResponseDto<T>> T query(java.io.Serializable id, RDto rdto) throws FindByIdGetNullException, DtoInitException;
	
	T query(java.io.Serializable id)throws FindByIdGetNullException;
	
	/**
	 * 通过主键id查找 model , model 的字段属性为 listName 中
	 * @param id
	 * @param listName
	 * @return
	 * @throws FindByIdGetNullException
	 */
	T query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException;
	
	/**
	 * query models by page
	 * @param page
	 * @return
	 * @throws FindByIdGetNullException
	 * @throws PagePropertyNotInitException
	 */
	PageBean<T> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException;
	
	
	/**
	 * 查询所有的实体
	 * query all entities.
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
	
	
	/**
	 * This method is used to initialize model data.
	 * 
	 * @param dto put initialized data into it
	 * @throws DtoInitException
	 * @throws MapNotInitForClassPathException
	 */
	<DTO extends BasicRespondMsgDto> void initOperationData(DTO dto) throws DtoInitException, MapNotInitForClassPathException;
	
	
}