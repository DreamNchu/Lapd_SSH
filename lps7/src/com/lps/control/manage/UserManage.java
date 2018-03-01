package com.lps.control.manage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;

@Component
public class UserManage extends AbstractManage<User> {

	@Autowired
	public UserManage(BasicService<User> service) {
		super(service);
	}

	/**
	 * 查询指定字段
	 * @param t
	 * @param fields
	 * @return
	 */
	public User querySamePropety(BasicModel t, Map<String, Class<?>> fields){
		return service.findFieldsByModel(t, fields);
	}
	
	@Override
	public User query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException {
		return null;
	}

	@Override
	public List<User> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}


}
