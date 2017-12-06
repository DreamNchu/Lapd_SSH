package com.lps.dao;

import java.util.List;

import com.lps.dao.basic.BasicDAO;
import com.lps.dao.basic.BasicForServerOrderDAO;
import com.lps.model.Room;
import com.lps.model.ServerItem;
/**
 * interfaceName:RoomDAO
 * Description:继承自BasicDAO接口，包含查找房间的方法
 * <p>
 * @see BasicDAO
 * @author cyl
 *
 */
public interface RoomDAO extends BasicDAO<Room>,BasicForServerOrderDAO<Room, Integer>{

	/**
	 * 根据房间名字查找,返回房间
	 * <p>
	 * @param name 房间名字
	 * @return 返回房间对象的数组
	 */
	public List<Room> findByName(Object name);
	/**
	 * 根据房间楼层查找,返回房间
	 * <p>
	 * @param floor 房间楼层
	 * @return 返回房间对象的数组
	 */
	public List<Room> findByFloor(Object floor) ;

	/**
	 * 根据房间大小查找,返回房间
	 * <p>
	 * @param size 房间大小
	 * @return 返回房间对象的数组
	 */
	public List<Room> findBySize(Object size) ;
	
		/**
		 * 查找空闲房间对象的数组
		 * <p>
		 * @return 返回空闲房间
		 */
	public List<Room> findFreeRoom();

}