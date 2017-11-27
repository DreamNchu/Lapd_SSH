package com.lps.dao;
import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Pledge;
import com.lps.model.RoomCategory;
import com.lps.model.WorkStatus;

/**
 * interfaceName:RoomCategoryDAO
 * Description:继承自BasicDAO接口，包含查找房间类型的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface RoomCategoryDAO extends BasicDAO<RoomCategory>{

	/**
	 * 根据房间状态查找,返回房间状态
	 * <p>
	 * @param roomCategory 房间状态对象
	 * @return 返回房间状态对象的数组
	 */
	List<RoomCategory> findByRoomCategory(Object roomCategory);

}