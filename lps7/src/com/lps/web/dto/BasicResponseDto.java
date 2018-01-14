package com.lps.web.dto;

import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.DtoInitException;

/**
 * 
 * @author 0001
 *
 * @param <K> init之后返回数据类型
 */
public interface BasicResponseDto<E extends Entity> {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws DtoInitException 
	 */
	 <K extends BasicResponseDto<E>> K initDto(E obj) throws DtoInitException;
	
	 
}
