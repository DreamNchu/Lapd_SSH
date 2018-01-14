package com.lps.web.dto;

import com.lps.model.basic.Entity;

public interface BasicUpdateDto<T extends Entity> extends BasicRequestDto<T>{
	
	/**
	 * 根据订单
	 * @param t
	 * @return
	 */
	T update(T t);

}
