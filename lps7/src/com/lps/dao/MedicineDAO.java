package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Medicine;

public interface MedicineDAO extends BasicDAO<Medicine> , BasicForServerOrderDAO<Medicine, Integer>{
	
	List<Medicine> findByMedicine(Object medicine);
	
}