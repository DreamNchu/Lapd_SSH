package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.model.Medicine;
import com.lps.service.MedicineService;
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

@Component
public class MedicineManage extends AbstractManage<Medicine> {
	
	@Autowired
	public MedicineManage(BasicService<Medicine> service) {
		super(service);
	}


	@Override
	public List<Medicine> queryByProperties(Map<String, Object> map) {
		return null;
	}

	@Override
	public List<Medicine> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		
	}


	@Override
	public Medicine query(Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}


}
