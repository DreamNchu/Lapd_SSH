package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.model.RoomCategory;
import com.lps.model.WorkStatus;

public interface RoomCategoryDAO extends BasicDAO<RoomCategory>{

	List<RoomCategory> findByRoomCategory(Object roomCategory);

}