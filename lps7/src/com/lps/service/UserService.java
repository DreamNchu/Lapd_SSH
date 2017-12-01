package com.lps.service;

import java.util.List;

import com.lps.model.User;
import com.lps.service.basic.BasicForServerOrderService;
import com.lps.service.webuser.WebAccessUtil;
import com.lps.util.PageBean;

public interface UserService extends BasicForServerOrderService<User>, WebAccessUtil{
	
	/**
	 * 根据密码查找员工
	 * @param password 密码
	 * @return 员工的集合
	 */	
	List<User> findByPassword(Object password);

    /**
	 * 根据工号查找员工
	 * @param workId 工号
	 * @return 员工的集合
	 */
	List<User> findByWorkId(Object workId);

	/**
	 * 根据电话号查找员工
	 * @param telephonePhone 电话号
	 * @return 员工的集合
	 */
	List<User> findByTelephonePhone(Object telephonePhone);
	
	/**
	 * 根据email查找员工
	 * @param email 员工邮箱
	 * @return 员工的集合
	 */
	List<User> findByEmail(Object email);

	/**
	 * 根据email查找员工
	 * @param email 员工邮箱
	 * @return 员工的集合
	 */
	List<User> findByAddress(Object address);

	/**
	 * 根据头像查找员工
	 * @param avatar 员工头像
	 * @return 员工的集合
	 */
	List<User> findByAvatar(Object avatar);

	/**
	 * 根据密码找回问题查找员工
	 * @param question 问题
	 * @return 员工的集合
	 */
	List<User> findByQuestion(Object question);

	/**
	 * 根据密码找回答案查找员工
	 * @param answer 答案
	 * @return 员工的集合
	 */
	List<User> findByAnswer(Object answer);

	/**
	 * 根据页数查找员工
	 * @param page 页数
	 * @return 员工的PageBean对象
	 */
	PageBean<User> findByPage(int page);
	
	/**
	 * 根据员工真是姓名查找员工
	 * @param realName 真实姓名
	 * @return 员工的集合
	 */
	List<User> findByRealName(Object realName);
	
	/**
	 * 根据ID卡号查找员工
	 * @param IDCardNo ID卡号
	 * @return 员工的集合
	 */
	List<User> findByIDCardNo(Object IDCardNo);
	
	
}