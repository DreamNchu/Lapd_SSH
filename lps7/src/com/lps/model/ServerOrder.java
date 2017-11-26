package com.lps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lps.model.basic.BasicModel;


/**
 * AbstractTServerorder entity provides the base persistence definition of the
 * TServerorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_serverorder")

public class ServerOrder implements java.io.Serializable ,BasicModel<String>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6038267699363948636L;
	private String id;
	
	private PayPath payPath;
	private Room room;
	private User user;
	private Pledge pledge;
	private ClockCategory clockCategory;
	private OrderStatus orderStatus;
	
	private Date initTime;
	private Date receiveTime;
	private Date finishTime;
	private Integer pay;
	private Integer realPay;
	private Date payTime;
	private String orderRemark;

	// Constructors

	/** default constructor */
	public ServerOrder() {
	}

	/** minimal constructor */
	public ServerOrder(Room room, User user, ClockCategory clockCategory, OrderStatus orderStatus,
			Date initTime) {
		this.room = room;
		this.user = user;
		this.clockCategory = clockCategory;
		this.orderStatus = orderStatus;
		this.initTime = initTime;
	}

	/** full constructor */
	public ServerOrder(PayPath payPath, Room room, User user, Pledge pledge,
			ClockCategory clockCategory, OrderStatus orderStatus, Date initTime, Date receiveTime, Date finishTime,
			Integer pay, Integer realPay, Date payTime, String orderRemark) {
		this.payPath = payPath;
		this.room = room;
		this.user = user;
		this.pledge = pledge;
		this.clockCategory = clockCategory;
		this.orderStatus = orderStatus;
		this.initTime = initTime;
		this.receiveTime = receiveTime;
		this.finishTime = finishTime;
		this.pay = pay;
		this.realPay = realPay;
		this.payTime = payTime;
		this.orderRemark = orderRemark;
	}

	// Property accessors
	@Id
//	@GeneratedValue

	@Column(
			name = "idOrder", 
			unique = true, 
			nullable = false, 
			length = 45)

	public String getId() {
		return this.id;
	}

	public void setId(String idOrder) {
		this.id = idOrder;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payPathId")

	public PayPath getPayPath() {
		return this.payPath;
	}

	public void setPayPath(PayPath payPath) {
		this.payPath = payPath;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId", nullable = false)

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room Room) {
		this.room = Room;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stuffId", nullable = false)

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pledgeNameId")

	public Pledge getPledge() {
		return this.pledge;
	}

	public void setPledge(Pledge pledge) {
		this.pledge = pledge;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clockcategoryId", nullable = false)

	public ClockCategory getClockCategory() {
		return this.clockCategory;
	}

	public void setClockCategory(ClockCategory clockCategory) {
		this.clockCategory = clockCategory;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statusId", nullable = false)

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "initTime", nullable = false, length = 19)

	public Date getInitTime() {
		return this.initTime;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receiveTime", length = 19)

	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finishTime", length = 19)

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Column(name = "pay")

	public Integer getPay() {
		return this.pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	@Column(name = "realPay")

	public Integer getRealPay() {
		return this.realPay;
	}

	public void setRealPay(Integer realPay) {
		this.realPay = realPay;
	}

	@Column(name = "payTime", length = 19)

	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Column(name = "orderRemark")

	public String getOrderRemark() {
		return this.orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

}