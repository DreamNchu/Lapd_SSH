package com.lps.service;

import java.util.List;

import com.lps.model.ClockCategory;
import com.lps.model.Combo;
import com.lps.model.Medicine;
import com.lps.service.basic.BasicForServerOrderService;

public interface MedicineService  extends BasicForServerOrderService<Medicine>{
	/**
	 * 根据药物查找
	 * 
	 * @param medicine
	 *            药物
	 * @return 药物的集合
	 */
	List<Medicine> findByMedicine(Object medicine);

	/**
	 * 根据其对应的ID找到Medicine字段
	 * 
	 * @param medicine
	 *            必须包含主键id
	 * @return 返回Medicine的名字
	 */
	String findMedicine(Medicine medicine);

	/**
	 * 存在返回id，不存在返回-1
	 * 
	 * @param medicine
	 * @return
	 */
	int findIdByMedicine(String medicine);

}
