package com.lps.web.combo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lps.model.Combo;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;

@Component
@DtoName("combos")
public class TComboDto extends ArrayList<ComboResponseDto> implements TableInitDto<Combo> {

	private static final long serialVersionUID = 365798462793553144L;

	@Override
	public void init(List<Combo> lists) throws DtoInitException {
		for (Combo item : lists) {
			ComboResponseDto ud = new ComboResponseDto();
			ud.initDto(item);
			add(ud);
		}
	}

}
