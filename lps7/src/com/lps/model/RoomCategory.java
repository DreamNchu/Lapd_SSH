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

@Entity
@Table(name="t_roomcategory")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "roomcategory_PK",
		allocationSize = 1)
public class RoomCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roomcategory;
	private Set<Room> rooms = new HashSet<Room>(0);

	// Constructors

	/** default constructor */
	public RoomCategory() {
	}

	/** full constructor */
	public RoomCategory(String roomcategory, Set<Room> TRooms) {
		this.roomcategory = roomcategory;
		this.rooms = TRooms;
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

	@Column(name = "roomcategory", unique = true, length = 20,  nullable=false)

	public String getRoomcategory() {
		return this.roomcategory;
	}

	public void setRoomcategory(String roomcategory) {
		this.roomcategory = roomcategory;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomCategory")

	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> TRooms) {
		this.rooms = TRooms;
	}

}