package com.lps.model;
// default package

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
 * AbstractPayPath entity provides the base persistence definition of the PayPath entity. @author MyEclipse Persistence Tools
 */

/**
 * ClassName:PayPath
 * Description:PayPath类继承自java.io.Serializable接口，用于描述一个订单的付费方式，包含付费方式的get set方法
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name = "t_paypath")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "paypath_PK",
		allocationSize = 1)

public  class PayPath  implements java.io.Serializable ,ModelLinkServerOrder<Integer>{


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -4804160261476295801L;
	private Integer id;
     private String payPath;

 	private Set<ServerOrder> serverOrders = new TreeSet<ServerOrder>();
	
 	@OneToMany(
 			cascade = CascadeType.ALL,
 			fetch = FetchType.EAGER,
 			mappedBy = "payPath")
 	public Set<ServerOrder> getServerOrders() {
 		return this.serverOrders;
 	}

 	public void setServerOrders(Set<ServerOrder> serverOrders) {
 		this.serverOrders = serverOrders;
 	}

    // Constructors

    /** default constructor */
     /**
      * PayPath无参构造方法
      */
    public PayPath() {
    }

    
    /** full constructor */
    /**
     * PayPath构造方法
     * <p>
     * @param payPath 付费方式，String类型
     */
    public PayPath(String payPath) {
        this.payPath = payPath;
    }

   
    // Property accessors
   
    
    /**
     * 获取id值
     * <p>
     * @return 返回id,Interger类型
     *  
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
	 * @param id id值
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * 获取付费方式
     * <p>
     * @return 返回payPath,String类型
     *  
     */
    @Column(name="payPath", unique=true, length=20)

    public String getPayPath() {
        return this.payPath;
    }
    /**
   	 * 设置付费方式
   	 * <p>
   	 * @param payPath 付费方式 String类型
   	 */
    public void setPayPath(String payPath) {
        this.payPath = payPath;
    }
   
    /**
	 * ClassName:Builder
     * Description:内部类，可以访问PayPath类里的PayPath属性，也可以访问payPath属性的set方法
     * <p>
	 * @author cyl
	 * @version 1.0
	 * @see PayPath
	 */
    public static class Builder{
    	private String payPath;
      

        /**
         * 这个方法用于设置付费方式
         * <p>
         * @param payPath 付费方式
         * @return 付费方式
         */
        public Builder setPayPath(String payPath) {
        this.payPath = payPath;
        return this;
        }
        
        /**
         * build方法，返回付费方式
         * <p>
         * @return PayPath实例
         */
        public PayPath build(){
        	return new PayPath(payPath);
        }
       
    }
}