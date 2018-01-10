package com.lps.service;

import java.util.List;

import com.lps.model.Combo;
import com.lps.service.basic.BasicForServerOrderService;

public interface ComboService extends BasicForServerOrderService<Combo>{
	/**
	 * 根据套餐查找
	 * 
	 * @param combo
	 *            套餐
	 * @return 套餐的集合
	 */
	List<Combo> findByCombo(Object combo);

	/**
	 * 根据其对应的ID找到Combo字段
	 * 
	 * @param combo
	 *            必须包含主键id
	 * @return 返回Combo的名字
	 */
	String findCombo(Combo combo);

	/**
	 * 存在返回id，不存在返回-1
	 * 
	 * @param combo
	 * @return
	 */
	int findIdByCombo(String combo);


}
