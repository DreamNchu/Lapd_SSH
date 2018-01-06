package com.lps.control.manage;

import java.util.Arrays;
import java.util.Map;

import com.lps.model.User;
import com.lps.model.basic.BasicModel;
import com.lps.service.UserService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.user.dto.UserDataDto;

public class UserManage {

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
	
	public void save(UserDataDto userDataDto){
		userServiceImpl.save(userDataDto.generateUser());
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
}
