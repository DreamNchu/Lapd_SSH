package com.lps.web.user.dto;

import java.util.Map;

import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicRequestDto;

public class UserRequestDto implements UserLibraryDto, BasicRequestDto<User>{
	
	public UserRequestDto() {
	}
	
	public UserRequestDto( Map<String, String[]> map) {
		this.map = map;
	}

	protected Map<String, String[]> map ;
	
	public Map<String, String[]> getMap() {
		return map;
	}

	public void setMap(Map<String, String[]> map) {
		this.map = map;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1727879901472191276L;

	@Override
	public User generate() {
		// TODO Auto-generated method stub
		User user = new User();
//		System.out.println(this.map.get(stuffId));
		String[] id = map.get(stuffId); 
		String[] sUserName = map.get(userName);
		String[] sWorkId = map.get(workId);
		String[] sPassWord  = map.get(password);
		String[] sBirthday = map.get(birthday);
		String[] stelephonePhone = map.get(telephone);
		String[] sEmail = map.get(email); 
		String[] sAddress = map.get(address);
		String[] sQuestion = map.get(question); 
		String[] sAnswer = map.get(answer);
		String[] sAvatar = map.get(avatar);
		String[] sRegisterTime = map.get(registerTime);
		String[] sWorkStatus = map.get(workStatusName);
		String[] sWorkStatusId = map.get(workStatusId);
		String[] idCard = map.get(IDCardNo);
		String[] sRealName = map.get(realName);
		
		if(id != null) {
			user.setId(Integer.parseInt(id[0]));
		}
		
		if(sUserName != null) {
			user.setUserName(sUserName[0]);
		}
		
		if(sWorkId != null) {
			user.setWorkId(Integer.parseInt(sWorkId[0]));
		}
		
		if(sPassWord != null) {
			user.setPassword(sPassWord[0]);
		}
		
		if(sBirthday != null) {
			user.setBirthday(WorkDate.toDate(sBirthday[0]));
		}
		
		if(stelephonePhone != null) {
			user.setTelephone(stelephonePhone[0]);
		}
		
		if(sEmail != null) {
			user.setEmail(sEmail[0]);
		}
		
		if(sAddress != null) {
			user.setAddress(sAddress[0]);
		}
		
		if(sQuestion != null) {
			user.setQuestion(sQuestion[0]);
		}
		
		if(sAnswer != null) {
			user.setAnswer(sAnswer[0]);
		}
		
		if(sAvatar != null) {
			user.setAvatar(sAvatar[0]);
		}
		
		if(sRegisterTime != null) {
			user.setRegisterTime(WorkDate.toDate(sRegisterTime[0]));
		}
		
		if(sWorkStatus != null) {
			WorkStatus ws = new WorkStatus();
			ws.setId(Integer.parseInt(sWorkStatusId[0]));
			ws.setWorkStatus(sWorkStatus[0]);
			user.setWorkStatus(ws);
		}
		
		if(idCard != null) {
			user.setIDCardNo(idCard[0]);
		}
		
		if(sRealName != null) {
			user.setRealName(sRealName[0]);
		}
		
		return user;
	}

}
