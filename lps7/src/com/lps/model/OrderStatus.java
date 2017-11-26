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

import com.lps.model.basic.BasicModel;
import com.lps.model.basic.ModelLinkServerOrder;

/**
 * ClassName:OrderStatus
 * Description:OrderStatus继承自java.io.Serializable接口，用于描述一个订单的状态，包含订单状态的get set方法
 * <p>
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name = "t_orderstatus")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "orderstatus_PK",
		allocationSize = 1)

public class OrderStatus implements java.io.Serializable,ModelLinkServerOrder<Integer> {

	// Fields

	/**
	 * ClassName:Builder
     * Description:内部类，可以访问外部类里的orderstatus属性等，也可以访问orderstatus属性的set方法
     * <p>
     * @see OrderStatus
	 * @author cyl
	 * @version 1.0
	 *
	 */
	 public static class Builder{
	    	private String orderstatus;
	      
	        /**
	         * build方法，返回订单状态
	         * <p>
	         * @return OrderStatus实例
	         */
	        public OrderStatus build(){
	        	return new OrderStatus(orderstatus);
	        }
	        
	        /**
	         * 这个方法用于设置订单状态
	         * <p>
	         * @param orderstatus 订单状态
	         * @return 订单状态
	         * @see OrderStatus#setOrderstatus(String)
	         */
	        public Builder setOrderstatus(String orderstatus) {
			    this.orderstatus = orderstatus;
	        	return this;
	        }
	       
	    }
	/**
	 * 
	 */
	private static final long serialVersionUID = 4509505398828451606L;
	private Integer id;
	
	private String orderstatus;
	
	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();

	/**
	 * 这是OrderStatus类的无参构造函数
	 */
	public OrderStatus() {
	}

	// Constructors

	/** default constructor */
	
	/**
	 * OrderStatus类的构造函数
	 * @param orderstatus 订单状态，String类型
	 */
	public OrderStatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	/** full constructor */
	
	/**
	 * 获取id值
	 * <p>
	 * @return 返回id,Interger类型
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	/**
	 * 获取订单状态
	 * <p>
	 * @return 返回订单状态,String类型
	 */
	@Column(name = "orderstatus", unique = true, length = 20)

	public String getOrderstatus() {
		return this.orderstatus;
	}

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "orderStatus")
	public Set<ServerOrder> getServerOrders() {
		return this.serverOrders;
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
	 * 设置订单状态
	 * <p>
	 * @param  orderstatus 订单状态
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	public void setServerOrders(Set<ServerOrder> serverOrders) {
		this.serverOrders = serverOrders;
	}

}