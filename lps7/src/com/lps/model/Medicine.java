package com.lps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.BasicModel;

@Entity
@Table(name="t_medicine")
@TableGenerator(
		name = "pk_generate",
		table = "tb_generator",
		pkColumnName = "gen_name",
		valueColumnName = "gen_value",
		pkColumnValue = "medicine_PK",
		allocationSize = 1)
public class Medicine implements BasicModel<Integer>, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String medicineId;
	private String name;
	private String vender;
	private String shelfLife;
	private Integer price;
	private Integer inventory;
	private Integer sales;
//	private Set<TServerorderMedicine> TServerorderMedicines = new HashSet<TServerorderMedicine>(0);

	public Medicine() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="pk_generate")
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "medicineId", nullable = false, length = 45)

	public String getMedicineId() {
		return this.medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	@Column(name = "name", nullable = false, length = 15)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "vender", nullable = false, length = 30)

	public String getVender() {
		return this.vender;
	}

	public void setVender(String vender) {
		this.vender = vender;
	}

	@Column(name = "shelfLife", nullable = false, length = 15)

	public String getShelfLife() {
		return this.shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Column(name = "price", nullable = false)

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "inventory", nullable = false)

	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Column(name = "sales", nullable = false)

	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TMedicine")

/*	public Set<TServerorderMedicine> getTServerorderMedicines() {
		return this.TServerorderMedicines;
	}

	public void setTServerorderMedicines(Set<TServerorderMedicine> TServerorderMedicines) {
		this.TServerorderMedicines = TServerorderMedicines;
	}*/

}