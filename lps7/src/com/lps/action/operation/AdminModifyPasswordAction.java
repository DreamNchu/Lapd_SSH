package com.lps.action.operation;

import com.lps.model.Admin;
import com.lps.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminModifyPasswordAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5154888213081248125L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	private AdminService adminServiceImpl;
	
	private String oldPassword;
	private String newPassword;
	private int id;
	
	/**
	 * 成功返回success，失败返回error
	 * @return
	 */
	public String modifyPassword(){
		Admin admin = adminServiceImpl.findById(id);
		if(admin.getPassword().equals(oldPassword)){
			admin.setPassword(newPassword);
			adminServiceImpl.update(admin);
			return SUCCESS;
		}
		return ERROR;
	}
	

	public AdminService getAdminServiceImpl() {
		return adminServiceImpl;
	}


	public void setAdminServiceImpl(AdminService adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}
	
	
	
	
	
}
