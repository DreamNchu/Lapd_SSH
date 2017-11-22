package com.lps.service;
import java.util.List;

import com.lps.model.RoomCategory;
import com.lps.service.basic.BasicService;

public interface RoomCategoryService extends BasicService<RoomCategory>{


	List<RoomCategory> findByRoomCategory(Object roomCategory);

}