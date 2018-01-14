package com.lps.web.dto;

import com.lps.model.basic.Entity;

/**
 * 
 * @author 0001
 *
 * @param <K> init之后返回数据类型
 */
public interface BasicRequestDto<T extends Entity> {
	
	/**
	 * 根据当前的dto生成对应的实体对象的entity
	 * @return
	 */
	T generate();
	
}
