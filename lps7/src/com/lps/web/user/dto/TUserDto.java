package com.lps.web.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.basic.Entity;
import com.lps.web.dto.DtoInitException;
import com.lps.web.dto.TableInitDto;

public class TUserDto extends ArrayList<UserDto> implements TableInitDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9057825122505773284L;

	@Override
	public <T extends Entity> void init(List<T> lists) throws DtoInitException {
		// TODO Auto-generated method stub
		
	}

}
