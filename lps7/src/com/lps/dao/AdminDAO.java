package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Admin;

/**
 * ��û��ֱ��������������ѯ���Ǹ���id����ѯ
 * @author 0001
 *
 */
public interface AdminDAO extends BasicDAO<Admin>{
	
	public Admin getByUserName(String name);
	/**
	 * ���ݶ����id�ж��Ƿ����
	 * @param admin
	 * @return
	 */
	
}
