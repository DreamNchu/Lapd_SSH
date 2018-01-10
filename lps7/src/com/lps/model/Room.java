package com.lps.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;

/**
 * AbstractTRoom entity provides the base persistence definition of the TRoom
 * entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_room")
@TableGenerator(name = "pk_generate", table = "tb_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "room_PK", allocationSize = 1)
public class Room implements java.io.Serializable ,ModelLinkServerOrder<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192142277776627069L;
	private Integer id;
	private ServerItem serverItem;// 房间类型
	private String name;
	private Integer floor;// 楼层
	private Integer size;// 房间大小
	private Integer customerNum; //改房间当前客人数
	private boolean isFree;
	private boolean isClean;

	private String remark;
	private Date addTime;
	
	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "room")
	public Set<ServerOrder> getServerOrders() {
		return this.serverOrders;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	/**
	 * 这是Room类的构造函数
	 * <p>
	 * 
	 * @param floor
	 *            房间楼层 Integer类型
	 * @param size
	 *            房间大小 Integer类型
	 * @param addTime
	 *            加时 Date类型
	 */
	public Room(String name, Integer floor, Integer size, Date addTime, ServerItem serverItem, boolean isFree) {
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.addTime = addTime;
		this.serverItem = serverItem;
		this.isFree = isFree;
	}

	/** full constructor */
	/**
	 * 这是Room类的构造函数
	 * <p>
	 * 
	 * @param serverItem
	 *            房间类型
	 * @param name
	 *            房间名字 String类型
	 * @param floor
	 *            楼层 Integer类型
	 * @param size
	 *            房间大小 Integer类型
	 * @param remark
	 *            备注 String类型
	 * @param addTime
	 *            加时 Date类型
	 */
	public Room(ServerItem serverItem, String name, Integer floor, Integer size, String remark, Date addTime) {
		this.serverItem = serverItem;
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.remark = remark;
		this.addTime = addTime;
	}

	// Property accessors
	/**
	 * 获取id值
	 * <p>
	 * 
	 * @return 返回id,Interger类型
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置id值
	 * <p>
	 * 
	 * @param id
	 *            设置id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取房间类型值
	 * <p>
	 * 
	 * @return 返回房间类型
	 * @see ServerItem
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "roomCategory", nullable = false)

	public ServerItem getRoomCategory() {
		return this.serverItem;
	}

	/**
	 * 设置房间状态
	 * <p>
	 * 
	 * @param serverItem
	 *            设置roomCategory
	 * @see ServerItem
	 */
	public void setRoomCategory(ServerItem serverItem) {
		this.serverItem = serverItem;
	}

	/**
	 * 获取员工名
	 * <p>
	 * 
	 * @return 返回员工名,String类型
	 */
	@Column(name = "name", unique = true, length = 10, nullable = false)

	public String getName() {
		return this.name;
	}

	/**
	 * 设置员工名
	 * <p>
	 * 
	 * @param name
	 *            设置员工名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取楼层
	 * <p>
	 * 
	 * @return 返回楼层,Interger类型
	 */
	@Column(name = "floor", nullable = false)

	public Integer getFloor() {
		return this.floor;
	}

	/**
	 * 设置楼层
	 * <p>
	 * 
	 * @param floor
	 *            设置楼层
	 */
	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	/**
	 * 获取房间大小
	 * <p>
	 * 
	 * @return 返回房间大小,Interger类型
	 */
	@Column(name = "size", nullable = false)

	public Integer getSize() {
		return this.size;
	}

	@Column(name = "customerNum", nullable = false)
	public Integer getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}

	/**
	 * 设置房间大小
	 * <p>
	 * 
	 * @param size
	 *            设置房间大小
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * 获取备注
	 * <p>
	 * 
	 * @return 返回备注 ,String类型
	 */
	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置备注
	 * <p>
	 * 
	 * @param remark
	 *            设置备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取加时
	 * <p>
	 * 
	 * @return 返回加时,Date类型
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "addTime", nullable = false, length = 19)
	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Column(name = "isFree", nullable = false)

	public boolean getIsFree() {
		return this.isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	@Column(name = "isClean")
	public boolean getIsClean() {
		return isClean;
	}

	public void setIsClean(boolean isClean) {
		this.isClean = isClean;
	}

	/**
	 * ClassName:Builder Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
	 * <p>
	 * 
	 * @see Room
	 * @author cyl
	 * @version 1.0
	 *
	 */
	public static class Builder {
		private ServerItem serverItem;
		private String name;
		private Integer floor;
		private Integer size;
		private String remark;
		private Date addTime;

		/**
		 * 这个方法用于设置房间类型
		 * <p>
		 * 
		 * @param roomcategory
		 *            房间类型
		 * @see ServerItem
		 * @return 房间类型
		 */
		public Builder setRoomCategory(ServerItem roomcategory) {
			this.serverItem = roomcategory;
			return this;
		}

		/**
		 * 这个方法用于设置房间名字
		 * <p>
		 * 
		 * @param name
		 *            房间名字
		 * @return 房间名字
		 */
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		/**
		 * 这个方法用于设置房间楼层
		 * <p>
		 * 
		 * @param floor
		 *            房间楼层
		 * @return 房间楼层
		 */
		public Builder setFloor(Integer floor) {
			this.floor = floor;
			return this;
		}

		/**
		 * 这个方法用于设置房间大小
		 * <p>
		 * 
		 * @param size
		 *            房间大小
		 * @return 房间大小
		 */
		public Builder setSize(Integer size) {
			this.size = size;
			return this;
		}

		/**
		 * 这个方法用于设置房间备注
		 * <p>
		 * 
		 * @param remark
		 *            房间备注
		 * @return 房间备注
		 */
		public Builder setRemark(String remark) {
			this.remark = remark;
			return this;
		}

		/**
		 * 这个方法用于设置房间加时
		 * <p>
		 * 
		 * @param addTime
		 *            房间加时
		 * @return 房间加时
		 */
		public Builder setAddTime(Date addTime) {
			this.addTime = addTime;
			return this;
		}

		/**
		 * build方法，返回房间
		 * <p>
		 * 
		 * @return Room实例
		 */
		public Room build() {
			return new Room(serverItem, name, floor, size, remark, addTime);
		}
	}

}