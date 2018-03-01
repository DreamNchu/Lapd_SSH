package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.model.Combo;
import com.lps.service.ComboService;
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

@Component
public class ComboManage implements BasicManage<Combo> {

	@Autowired
	private ComboService comboServiceImpl;

	public ComboService getComboServiceImpl() {
		return comboServiceImpl;
	}

	public void setComboServiceImpl(ComboService medicineServiceImpl) {
		this.comboServiceImpl = medicineServiceImpl;
	}

	@Override
	public <DTO extends BasicRequestDto<Combo>> void create(DTO dto) throws ECreateFailedException {
		comboServiceImpl.save(dto.generate());
	}

	@Override
	public <DTO extends BasicUpdateDto<Combo>> void update(DTO dto) throws FindByIdGetNullException {
		Combo medicine = dto.generate();

		medicine = comboServiceImpl.findById(medicine.getId());
		comboServiceImpl.update(dto.update(medicine));

	}

	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		Combo[] medicine = new Combo[id.length];
		int i = 0;
		for (Serializable serializable : id) {
			medicine[i++] = comboServiceImpl.findById(serializable);
		}
		comboServiceImpl.deleteAll(Arrays.asList(medicine));

	}

	@Override
	public <RDto extends BasicResponseDto<Combo>> Combo query(Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		Combo md = comboServiceImpl.findById(id);
		rdto.initDto(md);
		return md;
	}

	@Override
	public Combo query(Serializable id) throws FindByIdGetNullException {
		return comboServiceImpl.findById(id);
	}

	@Override
	public Combo query(Serializable id, List<String> listName) throws FindByIdGetNullException {

		return null;
	}

	@Override
	public PageBean<Combo> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {

		return comboServiceImpl.findByPage(page);

	}

	@Override
	public List<Combo> queryAll() {
		return comboServiceImpl.findAll();

	}

	@Override
	public List<Combo> queryByProperties(Map<String, Object> map) {

		return null;
	}

	@Override
	public List<Combo> queryByPropertiesRange(List<PropertyRange<?>> listPro) {

		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {

	}

}
