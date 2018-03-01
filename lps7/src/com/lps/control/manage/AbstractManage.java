package com.lps.control.manage;

import java.util.List;
import java.util.Map;

import com.lps.model.basic.BasicModel;
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
public class AbstractManage implements BasicManage<BasicModel> {
	
	protected BasicService<BasicModel> service;

	public BasicService<BasicModel> getService() {
		return service;
	}

	public void setService(BasicService<BasicModel> service) {
		this.service = service;
	}

	@Override
	public <DTO extends BasicRequestDto<BasicModel>> void create(DTO dto) {
		service.save(dto.generate());
	}

	@Override
	public <DTO extends BasicUpdateDto<BasicModel>> void update(DTO dto) throws FindByIdGetNullException {
		BasicModel BasicModel = dto.generate();
			
		 BasicModel = service.findById(BasicModel.getId());
		 
		 service.update(dto.update(BasicModel));
		
	}

	@Override
	public void delete(java.io.Serializable... id) throws FindByIdGetNullException {
		
	}

	@Override
	public <RDto extends BasicResponseDto<BasicModel>> BasicModel query(java.io.Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicModel query(java.io.Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicModel query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<BasicModel> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasicModel> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasicModel> queryByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BasicModel> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}

}
