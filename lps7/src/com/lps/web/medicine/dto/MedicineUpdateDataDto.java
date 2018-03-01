package com.lps.web.medicine.dto;

import java.io.Serializable;

import com.lps.model.Medicine;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicUpdateDto;

public class MedicineUpdateDataDto extends MedicineRequestDto implements BasicUpdateDto<Medicine>{

	@Override
	public Medicine update(Medicine medicine) {

		String[] id = map.get(medicineId);
		String[] name = map.get(medicineName);
		String[] vender = map.get(medicineVender);
		String[] shelflife = map.get(medicineShelfLife);
		String[] price = map.get(medicinePrice);
		String[] inventory = map.get(medicineInventory);
		String[] sales =map.get(medicineSales);
		
		if(id != null) {
			medicine.setId(Integer.parseInt(id[0]));
		}
		
		if(name != null) {
			medicine.setName(name[0]);
		}
		
		
		if(vender != null) {
			medicine.setVender(vender[0]);
		}
		
		if(shelflife != null) {
			medicine.setShelfLife(WorkDate.toDate(shelflife[0]));
		}
		
		if(price != null) {
			medicine.setPrice(Integer.parseInt(price[0]));
		}
		
		if(inventory != null) {
			medicine.setInventory(Integer.parseInt(inventory[0]));
		}
		
		if(sales != null) {
			medicine.setSales(Integer.parseInt(sales[0]));
		}
			
		return medicine;
	}

	@Override
	public Serializable getId() {
		return map.get(medicineId)[0];
	}

}
