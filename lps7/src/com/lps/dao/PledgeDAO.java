package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.WorkStatus;

public interface PledgeDAO extends BasicDAO<Pledge>, BasicForServerOrderDAO<Pledge, Integer>{

	List<Pledge> findByName(Object pledge);

}