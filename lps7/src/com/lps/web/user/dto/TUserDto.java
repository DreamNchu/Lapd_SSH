package com.lps.web.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.User;
import com.lps.web.dto.DtoInitException;
import com.lps.web.dto.TableInitDto;

public class TUserDto extends ArrayList<UserDto> implements TableInitDto<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9057825122505773284L;
	
	public static final String name = "users";
	
//	public static final String partName = ""

	@Override
	public void init(List<User> lists) throws DtoInitException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
