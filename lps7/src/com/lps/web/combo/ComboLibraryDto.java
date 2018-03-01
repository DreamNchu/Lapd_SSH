package com.lps.web.combo;

public interface ComboLibraryDto {
	
	String comboId = "comboId"; 

	/**
	 * 套餐的名字
	 */
	 String comboName = "comboName";
	 
	 /**
	  * 套餐的备注
	  */
	 String comboRemark = "comboRemark";
	 
	 /**
	  * 套餐服务的开始时间
	  */
	 String comboBeginTime = "beginTime";
	 
	 /**
	  * 套餐服务的结束时间
	  */
	 String comboEndTime = "comboEndTime";
	 
	 /**
	  * 套餐服务项目
	  */
	 String serverItem = "serverItem";
	 String serverItemId = "serverItemId";
}
