package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Combo;

public interface ComboDAO extends BasicDAO<Combo>, BasicForServerOrderDAO<Combo , Integer>{

	List<Combo> findByCombo(Object combo);

}
