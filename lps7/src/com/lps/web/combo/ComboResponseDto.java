package com.lps.web.combo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.model.Combo;
import com.lps.model.ServerItem;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.simple.dto.ServerItemDto;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ComboResponseDto extends BasicRespondMsgDto implements ComboLibraryDto ,BasicResponseDto<Combo>{
	/**
	 * 
	 */
	private static  long serialVersionUID = -3856325605627463704L;

	@SuppressWarnings("unchecked")
	@Override
	public ComboResponseDto initDto(Combo obj) throws DtoInitException {
		
		if (obj == null) {
			throw new DtoInitException("套餐数据转换对象初始化异常");
		}
		
		Combo c = obj;
		
		if(c.getId() != null){
			put(comboId, c.getId());
		}
		
		if(c.getName() != null){
			put(comboName, c.getName());
		}
		
		if(c.getRemark() != null){
			put(comboRemark, c.getRemark());
		}
		
		if(c.getBeginTime() != null){
			put(comboBeginTime, c.getBeginTime());
		}
		
		if(c.getEndTime() != null){
			put(comboEndTime, c.getEndTime());
		}
		
		if(c.getComboServeritems() != null){
			
			Set<ServerItemDto> sis = new HashSet<ServerItemDto>();
			put(serverItem, sis);
			
			for(ServerItem si : c.getComboServeritems()){
				
				ServerItemDto sidto = new ServerItemDto();
				sidto.initDto(si);
				sis.add(sidto);
				
			}
			
		}
		
		return this;
	}
	
}
