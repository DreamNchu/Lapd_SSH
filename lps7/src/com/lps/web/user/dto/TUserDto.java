package com.lps.web.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.User;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@DtoName("users")
public class TUserDto extends ArrayList<UserResponseDto> implements TableInitDto<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9057825122505773284L;
	
//	public static final String name = "users";
	
//	public static final String partName = ""

	@Override
	public void init(List<User> lists) throws DtoInitException {
		for (User user : lists) {
			UserResponseDto ud = new UserResponseDto();
			ud.initDto(user);
			add(ud);
		}
	}
	
/*	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}*/
}
