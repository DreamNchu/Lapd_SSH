package com.lps.web.dto;

import com.lps.model.basic.Entity;
import com.lps.web.room.dto.NotRoomObjectException;

/**
 * 
 * @author 0001
 *
 * @param <K> init之后返回数据类型
 */
public interface BasicInitDto<K, E extends Entity> {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws DtoInitException 
	 */
	 K init(E obj) throws DtoInitException;
	
}
