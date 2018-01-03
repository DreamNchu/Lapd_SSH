package com.lps.web.user.dto;

import java.util.List;

import com.lps.model.User;
import com.lps.util.PageBean;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.PageDto;

public class UserTableDataDto extends PageDto{
	
	private List<UserDataDto> user ;
	
	public List<UserDataDto> getUser() {
		return user;
	}

	public void setUser(List<UserDataDto> user) {
		this.user = user;
	}
	
	@Override
	public <T> void init(PageBean<T> lOrders, PageAble queryOrderDto, String domainName, String actionName) {
		super.init(lOrders, queryOrderDto, domainName, actionName);
		if(lOrders.getList() == null){
			return ;
		}
		for (User user : (List<User>)lOrders.getList()) {
			UserDataDto osd = new UserDataDto();
			osd.init(user);
			this.user.add(osd);
		}
		
	}
	
	
}
