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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;

/**
 * AbstractTPledge entity provides the base persistence definition of the
 * TPledge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_pledge")
@TableGenerator(name = "pk_generate", table = "tb_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "pledge_PK", allocationSize = 1)

public class Pledge implements java.io.Serializable,ModelLinkServerOrder<Integer> {

	// Fields

	/**
	 * 
	 */
	private static  long serialVersionUID = 4797803268008785860L;
	private Integer id;
	private String name;
	private Integer price;
	
	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();
	
	@OneToMany(
/*			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,*/
			mappedBy = "pledge")
	public Set<ServerOrder> getServerOrders() {
		return this.serverOrders;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

	// Constructors

	/** default constructor */
	public Pledge() {
	}

	/** full constructor */
	public Pledge(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(java.io.Serializable id) {
		this.id = (int)id;
	}

	@Column(name = "name", unique = true, length = 20)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}