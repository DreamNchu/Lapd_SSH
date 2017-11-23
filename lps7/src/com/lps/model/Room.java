package com.lps.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AbstractTRoom entity provides the base persistence definition of the TRoom
 * entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_room")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "room_PK",
		allocationSize = 1)
public class Room implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192142277776627069L;
	private Integer id;
	private RoomCategory roomCategory;
	private String name;
	private Integer floor;
	private Integer size;
	private String remark;
	private Date addTime;

	// Constructors

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(String name,Integer floor, Integer size, Date addTime,RoomCategory roomCategory) {
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.addTime = addTime;
		this.roomCategory = roomCategory;
	}

	/** full constructor */
	public Room(RoomCategory TRoomcategory, String name, Integer floor, Integer size, String remark,
			Date addTime) {
		this.roomCategory = TRoomcategory;
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.remark = remark;
		this.addTime = addTime;
	}

	// Property accessors
	 @Id 
	    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	    @Column(name="id", unique=true, nullable=false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name = "roomCategory", nullable=false)

	public RoomCategory getRoomCategory() {
		return this.roomCategory;
	}

	public void setRoomCategory(RoomCategory TRoomcategory) {
		this.roomCategory = TRoomcategory;
	}

	@Column(name = "name", unique = true, length = 10,nullable=false)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "floor", nullable = false)

	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "size", nullable = false)

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "addTime", nullable = false, length = 19)

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}