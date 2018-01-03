package com.lps.web.order.dto;

import com.lps.web.room.dto.NotRoomObjectException;

/**
 * 
 * @author 0001
 *
 * @param <K> init之后返回数据类型
 */
public interface DtoBasicInit<K> {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws NotRoomObjectException 
	 */
	 K init(Object obj) throws Exception;
	
}
