package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Room;
import com.lps.model.User;

/**
 * interfaceName:UserDAO
 * Description:继承自BasicDAO接口，包含查找用户的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface UserDAO extends BasicDAO<User>,BasicForServerOrderDAO<User, Integer>{
	/**
	 * 根据密码查找员工
	 * <p>
	 * @param password 员工密码
	 * @return 返回员工对象的数组
	 */
	List<User> findByPassword(Object password);

	/**
	 * 根据工号查找员工
	 * <p>
	 * @param workId 员工工号
	 * @return 返回员工对象的数组
	 */
	List<User> findByWorkId(Object workId);

	/**
	 * 根据电话号查找员工
	 * <p>
	 * @param telephonePhone 员工电话号
	 * @return 返回员工对象的数组
	 */
	List<User> findByTelephonePhone(Object telephonePhone);

	/**
	 * 根据email查找员工
	 * <p>
	 * @param email 员工邮箱
	 * @return 返回员工对象的数组
	 */
	List<User> findByEmail(Object email);

	/**
	 * 根据地址查找员工
	 * <p>
	 * @param address 员工地址
	 * @return 返回员工对象的数组
	 */
	List<User> findByAddress(Object address);

	/**
	 * 根据头像查找员工
	 * <p>
	 * @param avatar 员工头像
	 * @return 返回员工对象的数组
	 */
	List<User> findByAvatar(Object avatar);

	/**
	 * 根据密码找回问题查找员工
	 * <p>
	 * @param question 员工密码找回问题
	 * @return 返回员工对象的数组
	 */
	List<User> findByQuestion(Object question);

	/**
	 * 根据密码找回答案查找员工
	 * <p>
	 * @param answer 员工密码找回答案
	 * @return 返回员工对象的数组
	 */
	List<User> findByAnswer(Object answer);


	/**
	 * 根据该对象的id查找员工列表，员工的条数受限于begin limit
	 * @param begin 开始下标
	 * @param limit 从开始下标的limit个数
	 * @return 员工列表
	 */
	List<User> findListByLimit(long begin, long limit);
	/**
	 * 根据真实姓名查找User对象list
	 * @param realName 真实姓名
	 * @return 返回根据真实姓名查找User对象list 
	 */
	List<User> findByRealName(Object realName);
	
	/**
	 * 返回身份证号码为id的User对象
	 * @param IDCardNo 身份证的id
	 */
	List<User> findByIDCardNo(Object IDCardNo);

}