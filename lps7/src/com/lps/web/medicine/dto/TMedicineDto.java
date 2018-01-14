package com.lps.web.medicine.dto;

import java.util.ArrayList;
import java.util.List;

import com.lps.model.Medicine;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.web.annotation.dto.DtoName;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.TableInitDto;
import com.lps.web.user.dto.UserResponseDto;

@DtoName("medicines")
public class TMedicineDto extends ArrayList<MedicineResponseDto> implements TableInitDto<Medicine> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -935412308080036067L;

	@Override
	public void init(List<Medicine> lists) throws DtoInitException {
		for (Medicine user : lists) {
			MedicineResponseDto ud = new MedicineResponseDto();
			ud.initDto(user);
			add(ud);
		}		
	}

}
