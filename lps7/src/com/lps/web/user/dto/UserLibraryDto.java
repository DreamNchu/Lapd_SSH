package com.lps.web.user.dto;

import com.lps.model.User;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface UserLibraryDto<K> extends BasicRequestDto<User>, BasicResponseDto<User>{
	
	String stuffId = "stuffId";
	String userName = "userName";
	String password = "password";
	String workId = "workId";
	String birthday = "birthday";
	String telephonePhone = "telephonePhone";
	String email = "email";
	String address = "address";
	String avatar = "avatar";
	String question = "question";
	String answer = "answer";
	String workStatusName = "workStatusName";
	String workStatusId = "workStatusId";
	String registerTime = "registerTime";
	String realName = "realName";
	String IDCardNo = "IDCardNo";
	
	/**
	 * 1)	`stuffId` INT NOT NULL, 员工主键
	2)	`userName` VARCHAR(45) NOT NULL COMMENT '员工用户名',
	3)	`password` VARCHAR(45) NOT NULL COMMENT '员工密码',
	4)	`workId` INT(11) NULL COMMENT '员工的工作id，没有关联其他主键',
	5)	`birthday` DATE NULL COMMENT '出生日期',
	6)	`telephonePhone` VARCHAR(15) NULL DEFAULT NULL COMMENT '电话号码',
	7)	`email` VARCHAR(20) NULL COMMENT '电子邮件',
	8)	`address` VARCHAR(200) NULL DEFAULT NULL COMMENT '地址',
	9)	`avatar` VARCHAR(255) NULL COMMENT '头像图片路径',
	10)	`question` VARCHAR(20) NOT NULL COMMENT '密保问题',
	11)	`answer` VARCHAR(100) NOT NULL COMMENT '密保答案',
	12)	`workStatus` INT NULL DEFAULT NULL,
	13)	`registerTime` TIMESTAMP NOT NULL,
	14)	`realName` VARCHAR(20) NULL COMMENT '真实姓名',
	15)	`IDCardNo` VARCHAR(30) NULL COMMENT '身份证号码',

	 */
	
	
}
