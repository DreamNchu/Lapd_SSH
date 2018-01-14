package com.lps.web.medicine.dto;

public interface MedicineLibraryDto {

	
	/**
	 *  `medicineId` INT NOT NULL COMMENT '主键',
  `medicineNum` VARCHAR(45) NOT NULL COMMENT '药品编号',
  `medicineName` VARCHAR(45) NULL COMMENT '药品名称',
  `medicineVender` VARCHAR(45) NULL COMMENT '厂家',
  `medicineShelfLife` DATE NULL COMMENT '保质期',
  `medicinePrice` FLOAT NULL COMMENT '药品价格',
  `medicineInventory` INT NULL COMMENT '库存',

	 */
	String medicineId = "medicineId";	
	String medicineNum = "medicineNum" ;
	String medicineName = "medicineName" ;
	String medicineVender =  "medicineVender";
	
	String medicineShelfLife =  "medicineShelfLife";
	String medicinePrice = "medicinePrice" ;
	String medicineInventory = "medicineInventory" ;
	String medicineSales = "medicineSales" ;
}
