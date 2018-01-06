package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.DtoInitException;

public class UserDto extends BasicRespondMsgDto implements UserLibraryDto{

	@Override
	public UserDto init(User obj) throws DtoInitException {
		// TODO Auto-generated method stub
		return null;
	}

}
