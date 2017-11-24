package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.Pledge;
import com.lps.model.WorkStatus;

public interface PledgeDAO extends BasicDAO<Pledge>{

	List<Pledge> findByName(Object pledge);

}