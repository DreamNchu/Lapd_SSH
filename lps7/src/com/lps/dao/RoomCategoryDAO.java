package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Pledge;
import com.lps.model.RoomCategory;
import com.lps.model.WorkStatus;

public interface RoomCategoryDAO extends BasicDAO<RoomCategory>,
BasicForServerOrderDAO<RoomCategory, Integer>{

	List<RoomCategory> findByRoomCategory(Object roomCategory);

}