package com.lps.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "t_clockcategory")
@TableGenerator(name = "pk_generate", table = "tb_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "clockcategory_PK", allocationSize = 1)
public class ClockCategory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7563728190772989668L;
	private Integer id;
	private String clockcategory;
	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();

	// Constructors

	/** default constructor */
	public ClockCategory() {
	}

	/** minimal constructor */
	public ClockCategory(String clockcategory) {
		this.clockcategory = clockcategory;
	}

	/** full constructor */
	public ClockCategory(String clockcategory, Set<ServerOrder> serverOrders) {
		this.clockcategory = clockcategory;
		this.serverOrders = serverOrders;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "clockcategory", unique = true, nullable = false, length = 20)

	public String getClockcategory() {
		return this.clockcategory;
	}

	public void setClockcategory(String clockcategory) {
		this.clockcategory = clockcategory;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TClockcategory")
	public Set<ServerOrder> getServerOrders() {
		return this.serverOrders;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

}