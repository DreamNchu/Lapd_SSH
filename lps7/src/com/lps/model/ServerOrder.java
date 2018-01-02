package com.lps.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lps.model.basic.BasicModel;

/**
 * AbstractTServerorder entity provides the base persistence definition of the
 * TServerorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_serverorder")

public class ServerOrder implements java.io.Serializable, BasicModel<String> {

	private static final long serialVersionUID = 6038267699363948636L;
	private String id;

	/**
	 * 外键关联
	 */
	private PayPath payPath;
	private Room room;
	private User user;
	private Pledge pledge;
	private ClockCategory clockCategory;
	private OrderStatus orderStatus;

	/**
	 * 订单的服务项目
	 */
	private Set<ServerItem> serverorderServeritems = new HashSet<>(0);

	@ManyToMany
	@JoinTable(name = "t_serverorder_serveritem",
			joinColumns = {	@JoinColumn(name = "t_serverorder_id") },
			inverseJoinColumns = { @JoinColumn(name = "t_serverItem_id") })
	
	public Set<ServerItem> getServerorderServeritems() {
		return serverorderServeritems;
	}

	public void setServerorderServeritems(Set<ServerItem> serverorderServeritems) {
		this.serverorderServeritems = serverorderServeritems;
	}
	
	private Set<Combo> serverorderCombos = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "t_serverorder_combo",
			joinColumns = {	@JoinColumn(name = "t_serverorder_id") },
			inverseJoinColumns = { @JoinColumn(name = "t_combo_id") })
	
	public Set<Combo> getServerorderCombos() {
		return serverorderCombos;
	}

	public void setServerorderCombos(Set<Combo> serverorderCombos) {
		this.serverorderCombos = serverorderCombos;
	}

	private Set<Medicine> serverorderMedicines = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "t_serverorder_medicine",
			joinColumns = {	@JoinColumn(name = "t_serverorder_id") },
			inverseJoinColumns = { @JoinColumn(name = "t_medicine_id") })
	public Set<Medicine> getServerorderMedicines() {
		return serverorderMedicines;
	}

	public void setServerorderMedicines(Set<Medicine> serverorderMedicines) {
		this.serverorderMedicines = serverorderMedicines;
	}

	/**
	 * 基本属性
	 */
	private Date initTime;
	private Date receiveTime;
	private Date finishTime;
	private Date payTime;
	private Integer pay;
	private Integer realPay;
	private String orderRemark;

	/** default constructor */
	/**
	 * ServerOrder无参构造方法
	 */
	public ServerOrder() {
	}

	/** minimal constructor */
	/**
	 * ServerOrder 构造函数
	 * 
	 * @param id
	 *            主键
	 * @param room
	 *            房间
	 * @param user
	 *            员工
	 * @param clockCategory
	 *            钟点类型
	 * @param orderStatus
	 *            订单状态
	 * @param initTime
	 *            初始时间
	 */
	public ServerOrder(String id, Room room, User user, ClockCategory clockCategory, OrderStatus orderStatus,
			Date initTime) {
		this.id = id;
		this.room = room;
		this.user = user;
		this.clockCategory = clockCategory;
		this.orderStatus = orderStatus;
		this.initTime = initTime;
	}

	/** full constructor */
	/**
	 * ServerOrder 构造函数
	 * 
	 * @param id
	 *            主键
	 * @param payPath
	 *            付费方式
	 * @param room
	 *            房间
	 * @param user
	 *            员工
	 * @param pledge
	 *            抵押物品
	 * @param clockCategory
	 *            钟点类型
	 * @param orderStatus
	 *            订单状态
	 * @param initTime
	 *            初始时间
	 * @param receiveTime
	 *            订单接收时间
	 * @param finishTime
	 *            订单完成时间
	 * @param pay
	 *            订单金额
	 * @param realPay
	 *            实际付费金额
	 * @param payTime
	 *            付费时间
	 * @param orderRemark
	 *            订单备注
	 */
	public ServerOrder(String id, PayPath payPath, Room room, User user, Pledge pledge, ClockCategory clockCategory,
			OrderStatus orderStatus, Date initTime, Date receiveTime, Date finishTime, Integer pay, Integer realPay,
			Date payTime, String orderRemark) {
		this.id = id;
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

	/**
	 * 获取订单id
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 45)

	public String getId() {
		return this.id;
	}

	/**
	 * 设置id
	 * 
	 * @param orderId
	 *            订单id
	 */
	public void setId(String orderId) {
		this.id = orderId;
	}

	/**
	 * 获取订单付费方式
	 * 
	 * @return 付费方式
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payPathId")

	public PayPath getPayPath() {
		return this.payPath;
	}

	/**
	 * 设置订单付费方式
	 * 
	 * @param payPath
	 *            付费方式
	 */
	public void setPayPath(PayPath payPath) {
		this.payPath = payPath;
	}

	/**
	 * 获取订单房间
	 * 
	 * @return 房间
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId", nullable = false)

	public Room getRoom() {
		return this.room;
	}

	/**
	 * 设置订单房间
	 * 
	 * @param Room
	 *            房间
	 */
	public void setRoom(Room Room) {
		this.room = Room;
	}

	/**
	 * 获取订单服务员工
	 * 
	 * @return 员工
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stuffId", nullable = false)

	public User getUser() {
		return this.user;
	}

	/**
	 * 设置订单员工
	 * 
	 * @param user
	 *            员工
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取订单抵押物品
	 * 
	 * @return 抵押物品
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pledgeNameId")

	public Pledge getPledge() {
		return this.pledge;
	}

	/**
	 * 设置订单抵押物品
	 * 
	 * @param pledge
	 *            抵押物
	 */
	public void setPledge(Pledge pledge) {
		this.pledge = pledge;
	}

	/**
	 * 获取订单钟点类型
	 * 
	 * @return 钟点类型
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clockcategoryId", nullable = false)

	public ClockCategory getClockCategory() {
		return this.clockCategory;
	}

	/**
	 * 设置订单钟点类型
	 * 
	 * @param clockCategory
	 *            钟点类型
	 */
	public void setClockCategory(ClockCategory clockCategory) {
		this.clockCategory = clockCategory;
	}

	/**
	 * 获取订单状态
	 * 
	 * @return 订单状态
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statusId", nullable = false)

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * 设置订单状态
	 * 
	 * @param orderStatus
	 *            订单状态
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 获取订单初始时间
	 * 
	 * @return 初始时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "initTime", nullable = false, length = 19)

	public Date getInitTime() {
		return this.initTime;
	}

	/**
	 * 设置订单初始时间
	 * 
	 * @param initTime
	 *            初始时间
	 */
	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

	/**
	 * 获取订单接收时间
	 * 
	 * @return 接收时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receiveTime", length = 19)

	public Date getReceiveTime() {
		return this.receiveTime;
	}

	/**
	 * 设置订单接收时间
	 * 
	 * @param receiveTime
	 *            接收时间
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * 获取订单完成时间
	 * 
	 * @return 完成时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finishTime", length = 19)

	public Date getFinishTime() {
		return this.finishTime;
	}

	/**
	 * 设置订单完成时间
	 * 
	 * @param finishTime
	 *            完成时间
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * 获取订单费用
	 * 
	 * @return 费用
	 */
	@Column(name = "pay")

	public Integer getPay() {
		return this.pay;
	}

	/**
	 * 设置订单费用
	 * 
	 * @param pay
	 *            订单费用
	 */
	public void setPay(Integer pay) {
		this.pay = pay;
	}

	/**
	 * 获取订单实际付费
	 * 
	 * @return 实际付费
	 */
	@Column(name = "realPay")

	public Integer getRealPay() {
		return this.realPay;
	}

	/**
	 * 设置订单实际付费
	 * 
	 * @param realPay
	 *            实际付费
	 */
	public void setRealPay(Integer realPay) {
		this.realPay = realPay;
	}

	/**
	 * 获取订单付费时间
	 * 
	 * @return 付费时间
	 */
	@Column(name = "payTime", length = 19)

	public Date getPayTime() {
		return this.payTime;
	}

	/**
	 * 设置订单付费时间
	 * 
	 * @param payTime
	 *            付费时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * 获取订单备注
	 * 
	 * @return 备注
	 */
	@Column(name = "orderRemark")

	public String getOrderRemark() {
		return this.orderRemark;
	}

	/**
	 * 设置订单备注
	 * 
	 * @param orderRemark
	 *            备注
	 */
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	@Override
	public String toString() {
		return "ServerOrder [id=" + id + ", payPath=" + payPath + ", room=" + room + ", user=" + user + ", pledge="
				+ pledge + ", clockCategory=" + clockCategory + ", orderStatus=" + orderStatus + ", initTime="
				+ initTime + ", receiveTime=" + receiveTime + ", finishTime=" + finishTime + ", payTime=" + payTime
				+ ", pay=" + pay + ", realPay=" + realPay + ", orderRemark=" + orderRemark + "]";
	}

	/**
	 * ClassName:Builder Description:内部类，可以访问外部类里订单的属性等，也可以访问每个属性的set方法
	 * <p>
	 * 
	 * @author cyl
	 * @version 1.0
	 *
	 */
	public static class Builder {

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
		private Date payTime;
		private Integer pay;
		private Integer realPay;
		private String orderRemark;

		/**
		 * 设置订单id
		 * 
		 * @param orderId
		 *            订单id String类型
		 * @return 订单id
		 */
		public Builder setId(String orderId) {
			this.id = orderId;
			return this;
		}

		/**
		 * 设置订单付费方式
		 * 
		 * @param payPath
		 *            付费方式对象
		 * @return 付费方式
		 */
		public Builder setPayPath(PayPath payPath) {
			this.payPath = payPath;
			return this;
		}

		/**
		 * 设置订单房间
		 * 
		 * @param Room
		 *            房间对象
		 * @return 房间对象
		 */
		public Builder setRoom(Room Room) {
			this.room = Room;
			return this;
		}

		/**
		 * 设置订单员工
		 * 
		 * @param user
		 *            员工对象
		 * @return 员工对象
		 */
		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		/**
		 * 设置订单抵押物品
		 * 
		 * @param pledge
		 *            抵押物对象
		 * @return 抵押物对象
		 */
		public Builder setPledge(Pledge pledge) {
			this.pledge = pledge;
			return this;
		}

		/**
		 * 设置订单钟点类型
		 * 
		 * @param clockCategory
		 *            钟点类型对象
		 * @return 钟点类型对象
		 */
		public Builder setClockCategory(ClockCategory clockCategory) {
			this.clockCategory = clockCategory;
			return this;
		}

		/**
		 * 设置订单状态
		 * 
		 * @param orderStatus
		 *            订单状态对象
		 * @return 订单状态对象
		 */
		public Builder setOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
			return this;
		}

		/**
		 * 设置订单初始时间
		 * 
		 * @param initTime
		 *            初始时间
		 * @return 初始时间
		 */
		public Builder setInitTime(Date initTime) {
			this.initTime = initTime;
			return this;
		}

		/**
		 * 设置订单接收时间
		 * 
		 * @param receiveTime
		 *            接收时间
		 * @return
		 */
		public Builder setReceiveTime(Date receiveTime) {
			this.receiveTime = receiveTime;
			return this;
		}

		/**
		 * 设置订单完成时间
		 * 
		 * @param finishTime
		 *            完成时间
		 * @return 完成时间
		 */
		public Builder setFinishTime(Date finishTime) {
			this.finishTime = finishTime;
			return this;
		}

		/**
		 * 设置订单费用
		 * 
		 * @param pay
		 *            订单费用
		 * @return 订单费用
		 */
		public Builder setPay(Integer pay) {
			this.pay = pay;
			return this;
		}

		/**
		 * 设置订单实际付费
		 * 
		 * @param realPay
		 *            实际付费
		 * @return 实际付费
		 */
		public Builder setRealPay(Integer realPay) {
			this.realPay = realPay;
			return this;
		}

		/**
		 * 设置订单付费时间
		 * 
		 * @param payTime
		 *            付费时间
		 * @return 付费时间
		 */
		public Builder setPayTime(Date payTime) {
			this.payTime = payTime;
			return this;
		}

		/**
		 * 设置订单备注
		 * 
		 * @param orderRemark
		 *            备注
		 * @return 备注
		 */
		public Builder setOrderRemark(String orderRemark) {
			this.orderRemark = orderRemark;
			return this;
		}

		/**
		 * build方法，返回订单的各项属性
		 * 
		 * @return 返回ServerOrder实例
		 */
		public ServerOrder build() {
			return new ServerOrder(id, payPath, room, user, pledge, clockCategory, orderStatus, initTime, receiveTime,
					finishTime, pay, realPay, payTime, orderRemark);
		}
	}
}