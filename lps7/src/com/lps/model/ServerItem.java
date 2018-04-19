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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.ModelLinkServerOrder;

/**
 * ClassName:ServerItem
 * Description:ServerItem类继承自java.io.Serializable接口，房间类型类，包含属性的get set方法
 * <p>
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name="t_serveritem")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "serverItem_PK",
		allocationSize = 1)
public class ServerItem implements java.io.Serializable ,ModelLinkServerOrder<Integer>,  Comparable<ServerItem> {

	// Fields

	/**
	 * 
	 */
	private static  long serialVersionUID = 3529111347160958534L;
	private Integer id;
	private String serverItem;
	private Float price;
	private Set<Room> rooms = new HashSet<Room>(0);
	

	/**
	 * 获取房间列表
	 * <p>
	 * @return 返回房间列表
	 */
	@OneToMany(/*cascade = CascadeType.ALL, fetch = FetchType.EAGER, */ mappedBy = "roomCategory")
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

	private Set<ServerOrder> serverOrders = new HashSet<>();
	// Constructors

	@ManyToMany(mappedBy="serverorderServeritems")
//	@JoinTable(map)
	public Set<ServerOrder> getServerOrders() {
		return serverOrders;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

	/** default constructor */
	/**
	 * 这是ServerItem类的无参构造函数
	 */
	public ServerItem() {
	}
	
	/**
	 * 这是ServerItem类的构造函数
	 * <p>
	 * @param roomcategory 房间类型 String类型
	 */
	public ServerItem(String roomcategory) {
		this.serverItem = roomcategory;
	}

	/** full constructor */
	/**
	 * 这是ServerItem类的构造函数
	 * <p>
	 * @param serverItem 房间类型 String类型
	 * @param rooms
	 */
	public ServerItem(String serverItem, Set<Room> rooms) {
		this.serverItem = serverItem;
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
	public void setId(java.io.Serializable id) {
		this.id = (int)id;
	}
	@Column(name = "price")
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * 获取房间类型
	 * <p>
	 * @return 返回房间类型,String类型
	 */
	@Column(name = "serverItem", unique = true, length = 20,  nullable=false)

	public String getServerItem() {
		return this.serverItem;
	}

	/**
	 * 设置房间类型
	 * <p>
	 * @param serverItem 设置房间类型
	 */
	public void setServerItem(String serverItem) {
		this.serverItem = serverItem;
	}

	
	/**
	 * ClassName:Builder
     * Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
     * <p>
     * @see ServerItem
	 * @author cyl
	 * @version 1.0
	 *
	 */
	  public static class Builder{
	    	private String serverItem;
	        private Set<Room> rooms = new HashSet<Room>(0);
	        
	        /**
	         * 这个方法用于设置房间类型
	         * <p>
	         * @param servetItem 房间类型
	         * @return 房间类型
	         */
	        public Builder setServerItem(String servetItem) {
			this.serverItem = servetItem;
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
	        public ServerItem build(){
	        	return new ServerItem(serverItem, rooms);
	        }
	       
	    }
	  
	@Override
	public int compareTo(ServerItem o){
		return this.getServerItem().compareTo((o.getServerItem()));
	}


}