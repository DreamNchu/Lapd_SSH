package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.page.dto.BasicPageDto;
import com.lps.web.page.dto.PageAble;

public class UserTableDataDto extends BasicPageDto<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -176652993513460323L;
	
	private TUserDto users ;

	public TUserDto getUsers() {
		return users;
	}


	public void setUsers(TUserDto users) {
		this.users = users;
	}


	@Override
	public void init(PageBean<User> usersP, PageAble page, String actionName) throws DtoInitException {
		super.init(usersP, page,  actionName);
		if(usersP.getList() == null){
			return ;
		}
		users.init(usersP.getList());
		
	}
	
	
}
