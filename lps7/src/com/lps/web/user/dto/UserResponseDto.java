package com.lps.web.user.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicResponseDto;

@Component
@Scope("prototype")
public class UserResponseDto extends BasicRespondMsgDto implements UserLibraryDto, BasicResponseDto<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6317635082695983319L;

	@SuppressWarnings("unchecked")
	@Override
	public UserResponseDto initDto(User obj) throws DtoInitException {
		// TODO Auto-generated method stub
		if(obj == null) {
			throw new DtoInitException("用户数据转换对象初始化异常");
		}
		User user = (User)obj;
		if(user.getId() != null) {
			put(stuffId, user.getId());
		}
		
		if(user.getUserName() != null) {
			put(userName, user.getUserName());
		}
		
		if(user.getPassword() != null) {
			put(password, user.getPassword());
		}
		
		if(user.getWorkId() != null) {
			put(workId, user.getWorkId());
		}
		
		if(user.getAnswer() != null) {
			put(answer, user.getAnswer());
		}
		
		if(user.getBirthday() != null) {
			put(birthday, WorkDate.dateToString(user.getBirthday()));
		}
		
		if(user.getTelephone() != null) {
			put(telephone, user.getTelephone());
		}
		
		if(user.getEmail() != null) {
			put(email, user.getEmail());
		}
		
		if(user.getAddress() != null) {
			put(address, user.getAddress());
		}
		
		if(user.getAvatar() != null) {
			put(avatar, user.getAvatar());
		}
		
		if(user.getQuestion() != null) {
			put(question, user.getQuestion());
		}
		
		if(user.getRegisterTime() != null) {
			put(registerTime,WorkDate.dateToString(user.getRegisterTime()));
		}
		
		if(user.getWorkStatus() != null) {
			put(workStatusName, user.getWorkStatus().getWorkStatus());
			put(workStatusId, user.getWorkStatus().getId());
		}
		
		if(user.getIDCardNo() != null) {
			put(IDCardNo, user.getIDCardNo());
		}
		
		if(user.getRealName() != null){
			put(realName, user.getRealName());
		}
		return this;
	}
	
}
