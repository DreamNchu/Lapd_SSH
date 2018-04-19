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


/**
 * ClassName:WorkStatus 
 * Description:WorkStatus类继承自java.io.Serializable接口，工作状态类，包含工作状态及一系列员工，包含这些属性的get set方法
 * <p>
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name="t_workstatus")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "workstatus_PK",
		allocationSize = 1)
public class WorkStatus implements java.io.Serializable, BasicModel {


    // Fields    

     /**
	 * 
	 */
	private static  long serialVersionUID = 683152915918217364L;
	private Integer id;
     private String workStatus;
     private Set<User> users = new HashSet<User>(0);

    // Constructors

    /** default constructor */
     /**
 	 * 这是WorkStatus类的无参构造函数
 	 */
    public WorkStatus() {
    }

	/** minimal constructor */
    /**
     * 这是WorkStatus类的构造函数
     * <p>
     * @param workStatus 工作状态
     */
    public WorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    
    /** full constructor */
    /**
     * 这是WorkStatus类的构造函数
     * <p>
     * @param workStatus 工作状态
     * @param users 员工名
     */
    public WorkStatus(String workStatus, Set<User> users) {
        this.workStatus = workStatus;
        this.users = users;
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
    
    /**
	 * 获取工作状态
	 * <p>
	 * @return 返回工作状态,String类型
	 */
    @Column(name="workStatus", unique=true, nullable=false, length=20)

    public String getWorkStatus() {
        return this.workStatus;
    }
    
   
    /**
     * 
     * @param workStatus 工作状态
     */
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    
    /**
	 * 获取员工表
	 * <p>
	 * @return 返回员工表
	 */
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="workStatus")
    public Set<User> getUsers() {
        return this.users;
    }
    
    /**
	 * 设置员工表
	 * <p>
	 * @param users 设置员工表
	 */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
   
    
    /**
	 * ClassName:Builder
     * Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
     * <p>
     * @see WorkStatus
	 * @author cyl
	 * @version 1.0
	 *
	 */
    public static class Builder{
    	private String workStatus;
        private Set<User> users = new HashSet<User>(0);
        
        /**
         * 这个方法用于设置工作状态
         * <p>
         * @param workStatus 工作状态
         * @return 工作状态
         */
        public Builder setWorkStatus(String workStatus){
        	this.workStatus = workStatus;
        	return this;
        }
        
        /**
         * 这个方法用于设置员工列表
         * <p>
         * @param users 员工列表
         * @return 员工列表
         */
        public Builder setUsers(Set<User> users){
        	this.users = users;
        	return this;
        }
        
        /**
         * build方法，返回工作状态
         * <p>
         * @return WorkStatus实例
         */
        public WorkStatus build(){
        	return new WorkStatus(workStatus, users);
        }
       
    }





}