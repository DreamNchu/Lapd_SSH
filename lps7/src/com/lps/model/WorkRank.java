package com.lps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.lps.model.basic.BasicModel;

/**
 * ClassName:WorkRank 
 * Description:WorkRank类继承自java.io.Serializable接口，工作排班类，包含员工名，排班数之类的属性，包含这些属性的get set方法
 * <p>
 * @author cyl
 * @version 1.0
 *
 */
@Entity
@Table(name="t_workrank")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "workrank_PK",
		allocationSize = 1)
public class WorkRank implements java.io.Serializable,BasicModel<Integer> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2023033530916611426L;
	private Integer id;
	private User user;
	private Integer rankNum;
	private Integer spotNum;

	// Constructors

	/** default constructor */
	/**
	 * 这是WorkRank类的无参构造函数
	 */
	public WorkRank() {
	}

	/** minimal constructor */
	/**
	 * 这是WorkRank类的构造函数
	 * <p>
	 * @param user 员工名
	 */
	public WorkRank(User user) {
		this.user = user;
	}

	/** full constructor */
	/**
	 * 这是WorkRank类的构造函数
	 * <p>
	 * @param user 员工名
	 * @param rank 排名序号
	 * @param rankNum 排钟数
	 * @param spotNum 点钟数
	 */
	public WorkRank(User user, Integer rankNum, Integer spotNum) {
		this.user = user;
		this.rankNum = rankNum;
		this.spotNum = spotNum;
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
    @Override
	public Integer getId() {
		return this.id;
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
	 * 获取员工名
	 * <p>
	 * @return 返回员工名,String类型
	 *///++++++++++++++++++++++++++++++++++++
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stuffId", nullable = false, unique=true)

	public User getUser(){
		return this.user;
	}

	/**
	 * 设置员工名
	 * <p>
	 * @param User 设置员工名
	 */
	public void setUser(User User) {
		this.user = User;
	}


	/**
	 * 获取排钟号
	 * <p>
	 * @return 返回排钟号,Interger类型
	 */
	@Column(name = "rankNum",nullable=false, columnDefinition="int default 0")

	public Integer getRankNum() {
		return this.rankNum;
	}

	/**
	 * 设置排钟号
	 * <p>
	 * @param rankNum 设置排钟号
	 */
	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
	}

	/**
	 * 获取点钟数
	 * <p>
	 * @return 返回点钟数,Interger类型
	 */
	@Column(name = "spotNum", nullable=false, columnDefinition="int default 0")
	public Integer getSpotNum() {
		return this.spotNum;
	}

	/**
	 * 设置点钟数
	 * <p>
	 * @param spotNum 设置点钟数
	 */
	public void setSpotNum(Integer spotNum) {
		this.spotNum = spotNum;
	}
	
	/**
	 * ClassName:Builder
     * Description:内部类，可以访问外部类里的属性，也可以访问属性的set方法
     * <p>
     * @see WorkRank
	 * @author cyl
	 * @version 1.0
	 *
	 */
	public static class Builder{
    private User user;
	private int rank;
	private Integer rankNum;
	private Integer spotNum;

	 /**
     * 这个方法用于设置员工名
     * <p>
     * @param User 员工名
     * @return 员工名
     */
        public Builder setUser(User User){
        	this.user = User;
        	return this;
        }
        
        /**
         * 这个方法用于设置排名序号
         * <p>
         * @param rank 排名序号
         * @return 排名序号
         */
        public Builder setRank(int rank) {
    		this.rank = rank;
    		return this;
    	}
        
        /**
         * 这个方法用于设置排钟数
         * <p>
         * @param rankNum 排钟数
         * @return 排钟数
         */
        public Builder setRankNum(Integer rankNum) {
		    this.rankNum = rankNum;
            return this;
	    }
        
        /**
         * 这个方法用于设置点钟数
         * <p>
         * @param spotNum 点钟数
         * @return 点钟数
         */
        public Builder setSpotNum(Integer spotNum) {
		    this.spotNum = spotNum;
            return this;
	    }
        
        /**
         * build方法，返回工作排班信息
         * <p>
         * @return WorkRank实例
         */
        public WorkRank build(){
        	return new WorkRank(user,rankNum,spotNum);
        }
    }




}