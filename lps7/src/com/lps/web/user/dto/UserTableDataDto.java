package com.lps.web.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.User;
import com.lps.util.PageBean;
import com.lps.web.order.dto.PageLinkTransformOrderDto;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.PageDto;

public class UserTableDataDto extends PageDto{
	
/*    "user":[{"workId":"workId1","realName":"realName1","userName":"userName1","birthday":"birthday1","telephonePhone":"telephonePhone1","email":"email1","address":"address1","question":"question1","answer":"answer1","registerTime":"registerTime1","IDCardNo":"IDCardNo1"}
    ,{"workId":"workId2","realName":"realName1","userName":"userName1","birthday":"birthday1","telephonePhone":"telephonePhone1","email":"email1","address":"address1","question":"question1","answer":"answer1","`registerTime":"`registerTime1","IDCardNo":"IDCardNo1"}]
    , "page":[{"currentPage":"1","allCount":"10","allPage":"10"}],
    "transform":[{"back":"TestHref","front":"TestHref"}],
    "number":[{"value":"1","link":"TestHref"},{"value":"2","link":"TestHref"},{"value":"3","link":"TestHref"},{"value":"4","link":"TestHref"}]
*/
	
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
