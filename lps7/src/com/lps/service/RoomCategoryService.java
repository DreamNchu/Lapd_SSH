package com.lps.service;
import java.util.List;

import com.lps.model.RoomCategory;
import com.lps.service.basic.BasicForServerOrderService;

public interface RoomCategoryService extends BasicForServerOrderService<RoomCategory>{


	List<RoomCategory> findByRoomCategory(Object roomCategory);

}