package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lps.model.Medicine;
import com.lps.model.Room;
import com.lps.service.MedicineService;
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

public class MedicineManage implements BasicManage<Medicine>{
	
	private MedicineService medicineServiceImpl;

	public MedicineService getMedicineServiceImpl() {
		return medicineServiceImpl;
	}

	public void setMedicineServiceImpl(MedicineService medicineServiceImpl) {
		this.medicineServiceImpl = medicineServiceImpl;
	}

	@Override
	public <DTO extends BasicRequestDto<Medicine>> void create(DTO dto) throws CreateFailedException {
		medicineServiceImpl.save(dto.generate());
		// TODO Auto-generated method stub
		
	}

	@Override
	public <DTO extends BasicUpdateDto<Medicine>> void update(DTO dto) throws FindByIdGetNullException {
		 Medicine medicine = dto.generate();
			
			medicine = medicineServiceImpl.findById(medicine.getId());
			medicineServiceImpl.update(dto.update(medicine));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		Medicine[] medicine = new Medicine[id.length]; 
		int i = 0;
		for (Serializable serializable : id) {
			medicine[i ++] = medicineServiceImpl.findById(serializable);
		}
		medicineServiceImpl.deleteAll(Arrays.asList(medicine));
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public Medicine query(Serializable id) throws FindByIdGetNullException {
		return medicineServiceImpl.findById(id);
		
	}*/
	
	@Override
	public <RDto extends BasicResponseDto<Medicine>> Medicine query(Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		Medicine md = medicineServiceImpl.findById(id);
		rdto.initDto(md);
		return md;
	}
	
	@Override
	public Medicine query(Serializable id) throws FindByIdGetNullException {
		return medicineServiceImpl.findById(id);
	}


	@Override
	public Medicine query(Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<Medicine> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		return medicineServiceImpl.findByPage(page);
	
	}

	@Override
	public List<Medicine> queryAll() {
		return medicineServiceImpl.findAll();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medicine> queryByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}


}
