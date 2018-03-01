package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.UserService;
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

public class UserManage implements BasicManage<User>{

	private UserService userServiceImpl;
	
	public UserManage() {
	}
	
	public void addUser(){
		
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 * @throws PagePropertyNotInitException
	 */
	public PageBean<User> basicQuery(int page) throws PagePropertyNotInitException{
		return userServiceImpl.findByPage(page);
	}
	
	/**
	 * 查询指定字段
	 * @param t
	 * @param fields
	 * @return
	 */
	public User querySamePropety(BasicModel<Integer> t, Map<String, Class<?>> fields){
		return userServiceImpl.findFieldsByModel(t, fields);
	}
	
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public <DTO extends BasicRequestDto<User>> void create(DTO dto) throws ECreateFailedException {
		userServiceImpl.save(dto.generate());
	}

	@Override
	public void delete(Serializable... id) throws FindByIdGetNullException {
		User[] users = new User[id.length]; 
		int i = 0;
		for (Serializable serializable : id) {
			users[i ++] = userServiceImpl.findById(serializable);
		}
		userServiceImpl.deleteAll(Arrays.asList(users));
	}

/*	@Override
	public User query(Serializable id) throws FindByIdGetNullException {
		return userServiceImpl.findById(id);
	}*/
	
	@Override
	public <RDto extends BasicResponseDto<User>> User query(Serializable id, RDto rdto)
			throws FindByIdGetNullException, DtoInitException {
		User user = userServiceImpl.findById(id);
		rdto.initDto(user);
		return user;
	}

	@Override
	public PageBean<User> queryByPage(int page) throws FindByIdGetNullException, PagePropertyNotInitException {
		// TODO Auto-generated method stub
		return userServiceImpl.findByPage(page);
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userServiceImpl.findAll();
	}

	@Override
	public <DTO extends BasicUpdateDto<User>> void update(DTO dto) throws FindByIdGetNullException {
		User user = dto.generate();
		
		user = userServiceImpl.findById(user.getId());
//		dto.update(user);
		userServiceImpl.update(dto.update(user));
	}

	@Override
	public List<User> queryByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User query(Serializable id, List<String> listName) throws FindByIdGetNullException {
//		userServiceImpl
		return null;
	}

	@Override
	public List<User> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User query(Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return userServiceImpl.findById(id);
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}


}
