package com.lps.control.manage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;

/**
 * 抽象的管理类，可以满足基本的业务需求。
 * @author 0001
 *
 */
public abstract class AbstractManage<T extends BasicModel> implements BasicManage<T> {
	
	protected BasicService<T> service;
	
	public AbstractManage(BasicService<T> service) {
		super();
		this.service = service;
	}

	public BasicService<T> getService() {
		return service;
	}

	public void setService(BasicService<T> service) {
		this.service = service;
	}

	@Override
	public <DTO extends BasicRequestDto<T>> void create(DTO dto) {
		service.save(dto.generate());
	}

	/**
	 * 更新实体数据
	 * refresh data
	 */
	@Override
	public <DTO extends BasicUpdateDto<T>> void update(DTO dto) throws FindByIdGetNullException {
		T T = dto.generate();
			
		 T = service.findById(T.getId());
		 
		 service.update(dto.update(T));
		
	}

	/**
	 * 批量删除实体
	 * delete a serial of models
	 */
	@Override
	public void delete(java.io.Serializable... id) throws FindByIdGetNullException {
		
		List<T> models = new ArrayList<>();
		for (java.io.Serializable seri : id) {
			models.add(service.findById(seri));
		}
		service.deleteAll(models);

	}

	@Override
	public <RDto extends BasicResponseDto<T>> T query(java.io.Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		
		T so = service.findById(id);
		rdto.initDto(so);
		return so;
	}

	@Override
	public T query(java.io.Serializable id) throws FindByIdGetNullException {
		return service.findById(id);
	}

	@Override
	public T query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<T> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		return service.findByPage(page);
	}

	@Override
	public List<T> queryAll() {
		return service.findAll();
	}

	@Override
	public List<T> queryByProperties(Map<String, Object> map) {
		return service.findByProperty(map);
	}

	@Override
	public List<T> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		return null;
	}

}
