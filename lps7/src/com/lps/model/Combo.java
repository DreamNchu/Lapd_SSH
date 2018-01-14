package com.lps.model;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;

@Entity
@Table(name="t_combo")
@TableGenerator(
		name = "pk_generate",
		table = "tb_generator",
		pkColumnName = "gen_name",
		valueColumnName = "gen_value",
		pkColumnValue = "combo_PK",
		allocationSize = 1)
public class Combo implements BasicModel<Integer>,java.io.Serializable, ModelLinkServerOrder<Integer> {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String remark;
	private Date beginTime;
	private Date endTime;
	
	
	private Set<ServerOrder> serverOrders = new HashSet<>();
	// Constructors

	@ManyToMany(mappedBy="serverorderCombos")
/*	@JoinTable(name = "t_serverorder_combo",
			joinColumns = {	@JoinColumn(name = "t_combo_id") },
			inverseJoinColumns = {@JoinColumn(name = "t_serverorder_id") })*/
	public Set<ServerOrder> getServerOrders() {
		return serverOrders;
	}

	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}
	
	private Set<ServerItem> comboServeritems = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "t_combo_serveritem",
			joinColumns = {	@JoinColumn(name = "t_combo_id") },
			inverseJoinColumns = { @JoinColumn(name = "t_serverItem_id") })
	public Set<ServerItem> getComboServeritems() {
		return comboServeritems;
	}

	public void setComboServeritems(Set<ServerItem> comboServeritems) {
		this.comboServeritems = comboServeritems;
	}

	public Combo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remark")

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "beginTime", length = 19)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "endTime", length = 19)

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
