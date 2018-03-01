package com.lps.control.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.model.Combo;
import com.lps.service.basic.BasicService;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;

@Component
public class ComboManage extends AbstractManage<Combo> implements BasicManage<Combo> {
	
	
	@Autowired
	public ComboManage(BasicService<Combo> service) {
		super(service);
	}

/*
	@Override
	public <DTO extends BasicRequestDto<Combo>> void create(DTO dto) throws ECreateFailedException {
		comboServiceImpl.save(dto.generate());
	}
*/
	/*@Override
	public <DTO extends BasicUpdateDto<Combo>> void update(DTO dto) throws FindByIdGetNullException {
		Combo medicine = dto.generate();

		medicine = comboServiceImpl.findById(medicine.getId());
		comboServiceImpl.update(dto.update(medicine));

	}*/

	/*@Override
	public void delete(java.io.Serializable... id) throws FindByIdGetNullException {
		Combo[] medicine = new Combo[id.length];
		int i = 0;
		for (java.io.Serializable seri : id) {
			medicine[i++] = comboServiceImpl.findById(seri);
		}
		comboServiceImpl.deleteAll(Arrays.asList(medicine));

	}*/

	/*@Override
	public <RDto extends BasicResponseDto<Combo>> Combo query(java.io.Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		Combo md = comboServiceImpl.findById(id);
		rdto.initDto(md);
		return md;
	}

	@Override
	public Combo query(java.io.Serializable id) throws FindByIdGetNullException {
		return comboServiceImpl.findById(id);
	}*/

	/*@Override
	public Combo query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException {

		return null;
	}*/

	/*@Override
	public PageBean<Combo> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {

		return comboServiceImpl.findByPage(page);

	}*/

	/*@Override
	public List<Combo> queryAll() {
		return comboServiceImpl.findAll();

	}*/

	/*@Override
	public List<Combo> queryByProperties(Map<String, Object> map) {

		return null;
	}
*/
	@Override
	public List<Combo> queryByPropertiesRange(List<PropertyRange<?>> listPro) {

		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		
	}

}
