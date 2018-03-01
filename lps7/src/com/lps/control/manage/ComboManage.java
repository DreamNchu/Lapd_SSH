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
public class ComboManage extends AbstractManage<Combo>  {
	
	
	@Autowired
	public ComboManage(BasicService<Combo> service) {
		super(service);
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
