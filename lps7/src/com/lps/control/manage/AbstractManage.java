package com.lps.control.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.Entity;
import com.lps.service.basic.BasicService;
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

/**
 * 抽象的管理类，可以满足基本的业务需求。
 * @author 0001
 *
 */
public class AbstractManage implements BasicManage<Entity> {
	
	protected BasicService<Entity> service;

	public BasicService<Entity> getService() {
		return service;
	}

	public void setService(BasicService<Entity> service) {
		this.service = service;
	}

	@Override
	public <DTO extends BasicRequestDto<Entity>> void create(DTO dto) {
		service.save(dto.generate());
	}

	@Override
	public <DTO extends BasicUpdateDto<BasicModel<Serializable>>> void update(DTO dto) throws FindByIdGetNullException {
		BasicModel<Serializable> entity = dto.generate();
			
		 entity = service.findById(entity.getId());
		 
		 service.update(dto.update(entity));
		
	}

	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		
	}

	@Override
	public <RDto extends BasicResponseDto<Entity>> Entity query(Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity query(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity query(Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<Entity> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> queryByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}

}
