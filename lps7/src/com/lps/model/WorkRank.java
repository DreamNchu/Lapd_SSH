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

@Entity
@Table(name="t_workrank")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "workrank_PK",
		allocationSize = 1)
public class WorkRank implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2023033530916611426L;
	private Integer id;
	private User user;
	private int rank;
	private Integer rankNum;
	private Integer spotNum;

	// Constructors

	/** default constructor */
	public WorkRank() {
	}

	/** minimal constructor */
	public WorkRank(User user) {
		this.user = user;
	}

	/** full constructor */
	public WorkRank(User user, Integer rankNum, Integer spotNum) {
		this.user = user;
		this.rankNum = rankNum;
		this.spotNum = spotNum;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stuffId", nullable = false)

	public User getUser() {
		return this.user;
	}

	public void setUser(User User) {
		this.user = User;
	}
	
	@Column(name = "rank", unique=true, nullable=false)
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


	@Column(name = "rankNum")

	public Integer getRankNum() {
		return this.rankNum;
	}

	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
	}

	@Column(name = "spotNum")
	public Integer getSpotNum() {
		return this.spotNum;
	}

	public void setSpotNum(Integer spotNum) {
		this.spotNum = spotNum;
	}

}