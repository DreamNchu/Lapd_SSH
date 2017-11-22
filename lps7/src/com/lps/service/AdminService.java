package com.lps.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.lps.model.Admin;
import com.lps.service.basic.BasicService;
/**
 * ��û��ֱ��˵���������еĲ�ѯ���ǰ���id���ж�����
 * @author 0001
 *
 */
public interface AdminService extends BasicService<Admin>{
	
	public Admin getByUserName(String name);
	
	public Date getRegisterTime(Admin admin);
	
	public String getAvatar(Admin admin);

//	List<Admin> findByRegisterTime( Timestamp value);
	
}
