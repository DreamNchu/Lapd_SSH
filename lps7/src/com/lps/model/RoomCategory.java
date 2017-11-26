package com.lps.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;

/**
 * ClassName:RoomCategory
 * Description:RoomCategory类继承自java.io.Serializable接口，房间类型类，包含属性的get set方法
 * <p>
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name="t_roomcategory")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "roomcategory_PK",
		allocationSize = 1)
public class RoomCategory implements java.io.Serializable ,ModelLinkServerOrder<Integer>{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3529111347160958534L;
	private Integer id;
	private String roomCategory;
	private Set<Room> rooms = new HashSet<Room>(0);

	// Constructors

	/** default constructor */
	/**
	 * 这是RoomCategory类的无参构造函数
	 */
	public RoomCategory() {
	}
	
	/**
	 * 这是RoomCategory类的构造函数
	 * <p>
	 * @param roomcategory 房间类型 String类型
	 */
	public RoomCategory(String roomcategory) {
		this.roomCategory = roomcategory;
	}

	/** full constructor */
	/**
	 * 这是RoomCategory类的构造函数
	 * <p>
	 * @param roomcategory 房间类型 String类型
	 * @param TRooms
	 */
	public RoomCategory(String roomcategory, Set<Room> rooms) {
		this.roomCategory = roomcategory;
		this.rooms = rooms;
	}

	// Property accessors
	/**
	 * 获取id值
	 * <p>
	 * @return 返回id,Interger类型
	 */
	    @Id 
	    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	    @Column(name="id", unique=true, nullable=false)

	public Integer getId() {
		return this.id;
	}

	    /**
		 * 设置id值
		 * <p>
		 * @param id 设置id
		 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取房间类型
	 * <p>
	 * @return 返回房间类型,String类型
	 */
	@Column(name = "roomCategory", unique = true, length = 20,  nullable=false)

	public String getRoomCategory() {
		return this.roomCategory;
	}

	/**
	 * 设置房间类型
	 * <p>
	 * @param roomcategory 设置房间类型
	 */
	public void setRoomCategory(String roomcategory) {
		this.roomCategory = roomcategory;
	}

	/**
	 * 获取房间列表
	 * <p>
	 * @return 返回房间列表
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomCategory")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	/**
	 * 设置房间列表
	 * <p>
	 * @param rooms 设置房间列表
	 */
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	/**
	 * ClassName:Builder
     * Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
     * <p>
     * @see RoomCategory
	 * @author cyl
	 * @version 1.0
	 *
	 */
	  public static class Builder{
	    	private String roomcategory;
	        private Set<Room> rooms = new HashSet<Room>(0);
	        
	        /**
	         * 这个方法用于设置房间类型
	         * <p>
	         * @param roomcategory 房间类型
	         * @return 房间类型
	         */
	        public Builder setRoomcategory(String roomcategory) {
			this.roomcategory = roomcategory;
	        	return this;
	        }
	        /**
	         * 这个方法用于设置房间列表
	         * <p>
	         * @param rooms 房间列表
	         * @return 房间列表
	         */
	        public Builder setRooms(Set<Room> rooms) {
			this.rooms = rooms;
	        	return this;
	        }
	        
	        /**
	         * build方法，返回房间状态
	         * <p>
	         * @return RoomCatagory实例
	         */
	        public RoomCategory build(){
	        	return new RoomCategory(roomcategory, rooms);
	        }
	       
	    }


}