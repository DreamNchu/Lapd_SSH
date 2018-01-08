package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.model.WorkStatus;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class UserDto extends BasicRespondMsgDto implements UserLibraryDto<UserDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6317635082695983319L;

	@SuppressWarnings("unchecked")
	@Override
	public UserDto init(User obj) throws DtoInitException {
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
		
		if(user.getTelephonePhone() != null) {
			put(telephonePhone, user.getTelephonePhone());
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
		
		if(user.getRealName() != null) {
			put(realName, user.getRealName());
		}
		return this;
	}

	@Override
	public User generate() {
		// TODO Auto-generated method stub
		User user = new User();
		String id = (String)get(stuffId); 
		String sUserName = (String)get(userName);
		String sWorkId = (String)get(workId);
		String sPassWord  = (String)get(password);
		String sBirthday = (String)get(birthday);
		String stelephonePhone = (String)get(telephonePhone);
		String sEmail = (String)get(email); 
		String sAddress = (String)get(address);
		String sQuestion = (String)get(question); 
		String sAnswer = (String)get(answer);
		String sAvatar = (String)get(avatar);
		String sRegisterTime = (String)get(registerTime);
		String sWorkStatus = (String)get(workStatusName);
		String sWorkStatusId = (String)get(workStatusId);
		String idCard = (String)get(IDCardNo);
		String sRealName = (String)get(realName);
		
		if(id != null) {
			user.setId(Integer.parseInt(id));
		}
		
		if(sUserName != null) {
			user.setUserName(sUserName);
		}
		
		if(sWorkId != null) {
			user.setWorkId(Integer.parseInt(sWorkId));
		}
		
		if(sPassWord != null) {
			user.setPassword(sPassWord);
		}
		
		if(sBirthday != null) {
			user.setBirthday(WorkDate.toDate(sBirthday));
		}
		
		if(stelephonePhone != null) {
			user.setTelephonePhone(stelephonePhone);
		}
		
		if(sEmail != null) {
			user.setEmail(sEmail);
		}
		
		if(sAddress != null) {
			user.setAddress(sAddress);
		}
		
		if(sQuestion != null) {
			user.setQuestion(sQuestion);
		}
		
		if(sAnswer != null) {
			user.setAnswer(sAnswer);
		}
		
		if(sAvatar != null) {
			user.setAvatar(sAvatar);
		}
		
		if(sRegisterTime != null) {
			user.setRegisterTime(WorkDate.toDate(sRegisterTime));
		}
		
		if(sWorkStatus != null) {
			WorkStatus ws = new WorkStatus();
			ws.setId(Integer.parseInt(sWorkStatusId));
			ws.setWorkStatus(sWorkStatus);
			user.setWorkStatus(ws);
		}
		
		if(idCard != null) {
			user.setIDCardNo(idCard);
		}
		
		if(sRealName != null) {
			user.setRealName(sRealName);
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K> K getNativeObject() {
		return (K)this;
	}
	
	
/*	public static void main(String[] args) throws DtoInitException {
		User u1 = new User();
		UserDto ud = new UserDto();
		ud.init(u1);
		ud.put("stuffId", "23");
		ud.put("userName", "电视上");
		ud.put("password", "we12344aa");
		ud.put("birthday", "2017-10-5");
		ud.put("telephonePhone", "15579869546");
		ud.put("email", "1352436378@qq.com");
		ud.put("address", "的方式放松放松放松");
		ud.put("question", "飒飒");
		ud.put("answer", "阿斯达");
		ud.put("avatar", "dsk/sdfsdd/dd.nnp");
		ud.put("registerTime", "20161223");
		ud.put("workStatus", "1");
		ud.put("IDCardNo", "43434343434");
//		Map map;
		
		User u2 = ud.generate();
//		System.out.println(u2.getIDCardNo());
		System.out.println(u2.getBirthday());
		System.out.println(u2.getAddress());
		System.out.println(u2.getAnswer());
		System.out.println(u2.getAvatar());
		System.out.println(u2.getIDCardNo());
		System.out.println(u2.getId());
		System.out.println(u2.getEmail());
		System.out.println(u2.getRealName());
		System.out.println(u2.getQuestion());
		System.out.println(u2.getUserName());
		System.out.println();
		
		u1.setAddress("skfj");
		u1.setAnswer("康教授弗兰克");
		u1.setId(2);
		u1.setBirthday(WorkDate.toDate("1996-6-6"));
		u1.setEmail("是富士康");
		u1.setIDCardNo("12345134554545445454545");
		u1.setPassword("1234654654");
		u1.setRealName("凯盛家纺");
		u1.setUserName("看手机");
		u1.setWorkStatus(new WorkStatus());
		u1.setWorkId(1);
		u1.setQuestion("sdkj");
		u1.setAvatar("jslkdjfl");
		
		UserDto ud2 = ud.init(u1);
		System.out.println(ud2.get(stuffId));
		System.out.println(ud2.get(IDCardNo));
		System.out.println(ud2.get(address));
		System.out.println(ud2.get(answer));
		System.out.println(ud2.get(avatar));
		System.out.println(ud2.get(birthday));
		System.out.println(ud2.get(workStatus));
		System.out.println(ud2.get(workId));
		System.out.println(ud2.get(userName));
		System.out.println(ud2.get(email));
		System.out.println(ud2.get(password));
		System.out.println(ud2.get(question));
		System.out.println(ud2.get(registerTime));
		System.out.println();
		System.out.println();
	} */
}
