package com.lps.web.orderchart.dto;

import java.util.List;

import com.lps.model.User;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.user.dto.TUserDto;
import com.lps.web.user.dto.UserTableDataDto;

public class OrderChartInitDto extends BasicRespondMsgDto{

	/**
	 * 
	 */
	private static  long serialVersionUID = -7461073611505904523L;
	private TUserDto users ;
	
	public void init(List<User> us) throws DtoInitException, MapNotInitForClassPathException{
		
		users.init(us);
//		super.initTable(us);
//		for (User u : us) {
//			UserDataDto ud = new UserDataDto();
//			ud.init(u);
//			user.add(ud);
//		}
	}

	public TUserDto getUsers() {
		return users;
	}

	public void setUsers(TUserDto users) {
		this.users = users;
	}
	
/*	public TUserResponseDto getUser() {
		return user;
	}

	public void setUser(TUserResponseDto user) {
		this.user = user;
	}*/

/*	public List<UserDataDto> getUser() {
		return user;
	}


	public void setUser(List<UserDataDto> user) {
		this.user = user;
	}
*/	
	
}
