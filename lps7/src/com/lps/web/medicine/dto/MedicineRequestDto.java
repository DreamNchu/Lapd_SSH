package com.lps.web.medicine.dto;

import java.util.Map;

import com.lps.model.Medicine;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicRequestDto;

public class MedicineRequestDto implements MedicineLibraryDto , BasicRequestDto<Medicine>{
	
	public Map<String, String[]> map;
	
	public MedicineRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	MedicineRequestDto( Map<String, String[]> map){
		this.map = map;
	}

	public Map<String, String[]> getMap() {
		return map;
	}

	public void setMap(Map<String, String[]> map) {
		this.map = map;
	}
	
	@Override
	public Medicine generate() {
		
		Medicine medicine = new Medicine();
		String[] id = map.get(medicineId);
		String[] smedicineNum = map.get(medicineNum);
		String[] name = map.get(medicineName);
		String[] vender = map.get(medicineVender);
		String[] shelflife = map.get(medicineShelfLife);
		String[] price = map.get(medicinePrice);
		String[] inventory = map.get(medicineInventory);
		String[] sales =map.get(medicineSales);
		
		if(id != null && !id[0].equals("")) {
			medicine.setId(Integer.parseInt(id[0]));
		}
		
		if(name != null) {
			medicine.setName(name[0]);
		}
		
		if(smedicineNum != null){
			medicine.setMedicineId((smedicineNum[0]));
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


}
