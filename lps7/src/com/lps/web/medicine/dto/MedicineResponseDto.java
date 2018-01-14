package com.lps.web.medicine.dto;

import com.lps.model.Medicine;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.dto.BasicResponseDto;

public class MedicineResponseDto extends BasicRespondMsgDto implements MedicineLibraryDto ,BasicResponseDto<Medicine>{

	private static final long serialVersionUID = 5223165740117546947L;

	@SuppressWarnings("unchecked")
	@Override
	public MedicineResponseDto initDto(Medicine obj) throws DtoInitException {
		
		if (obj == null) {
			throw new DtoInitException("药品数据转换对象初始化异常");
		}
		
		Medicine m = obj;
		//  药品主键
		if(m.getId() != null) {
			put(medicineId, m.getId());
		}
		
		//  药品编号
		if(m.getMedicineId() != null) {
			put(medicineNum, m.getMedicineId());
		}
		
		if(m.getName() != null) {
			put(medicineName, m.getName());
		}
		
		if(m.getVender() != null) {
			put(medicineVender, m.getVender());
		}
		
		if(m.getShelfLife() != null) {
			put(medicineShelfLife, m.getShelfLife());
		}
		
		if(m.getPrice() != null) {
			put(medicinePrice, m.getPrice());
		}
		
		if(m.getInventory() != null) {
			put(medicineInventory, m.getInventory());
		}
		
		if(m.getSales() != null) {
			put(medicineSales, m.getSales());
		}
		return this;
	}

}
