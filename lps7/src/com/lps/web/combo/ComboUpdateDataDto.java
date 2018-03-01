package com.lps.web.combo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.lps.model.Combo;
import com.lps.model.ServerItem;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicUpdateDto;

public class ComboUpdateDataDto extends ComboRequestDto implements BasicUpdateDto<Combo> {

	@Override
	public Combo update(Combo t) {

		Combo combo = t;

		String[] scomboId = map.get(comboId);
		String[] scomboName = map.get(comboName);
		String[] scomboRemark = map.get(comboRemark);
		String[] scomboBeginTime = map.get(comboBeginTime);
		String[] scomboEndTime = map.get(comboEndTime);
		String[] scomboServerItemId = map.get(serverItem);
		
		if(scomboId != null){
			combo.setId(Integer.parseInt(scomboId[0]));
		}

		if (scomboName != null) {
			combo.setName(scomboName[0]);
		}

		if (scomboRemark != null) {
			combo.setRemark(scomboRemark[0]);
		}

		if (scomboBeginTime != null) {
			combo.setBeginTime(WorkDate.toDate(scomboBeginTime[0]));
		}

		if (scomboEndTime != null) {
			combo.setEndTime(WorkDate.toDate(scomboEndTime[0]));
		}

		if (scomboServerItemId != null) {
			Set<ServerItem> sis = new HashSet<>();
			combo.setComboServeritems(sis);
			for (String id : scomboServerItemId) {
				ServerItem si = new ServerItem();
				si.setId(Integer.parseInt(id));
				sis.add(si);
			}
		}

		return combo;
	}

	@Override
	public Serializable getId() {
		return map.get(comboId)[0];
	}

}
