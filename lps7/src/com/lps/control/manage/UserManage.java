package com.lps.control.manage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.model.basic.Entity;
import com.lps.service.UserService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.page.dto.BasicPageDto;
import com.lps.web.user.dto.UserDto;

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
		return userServiceImpl.findFields(t, fields);
	}
	
	public void delete(Integer...ids) throws FindByIdGetNullException{
		User[] users = new User[ids.length];
		for (int i : ids) {
			users[i] = userServiceImpl.findById(i);
		}
		userServiceImpl.deleteAll(Arrays.asList(users));
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public <DTO extends BasicRequestDto<User>> void create(DTO dto) throws CreateFailedException {
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

	@Override
	public User query(Serializable id) throws FindByIdGetNullException {
		return userServiceImpl.findById(id);
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
	public <DTO extends BasicRequestDto<User>> void update(DTO dto) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> queryIdByProperties(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
}
