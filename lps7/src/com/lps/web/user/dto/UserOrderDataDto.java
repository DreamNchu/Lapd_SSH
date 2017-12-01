package com.lps.web.user.dto;

import java.util.Date;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;

public class UserOrderDataDto {

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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PayPath getPayPath() {
		return payPath;
	}
	public void setPayPath(PayPath payPath) {
		this.payPath = payPath;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Pledge getPledge() {
		return pledge;
	}
	public void setPledge(Pledge pledge) {
		this.pledge = pledge;
	}
	public ClockCategory getClockCategory() {
		return clockCategory;
	}
	public void setClockCategory(ClockCategory clockCategory) {
		this.clockCategory = clockCategory;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getInitTime() {
		return initTime;
	}
	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay = pay;
	}
	public Integer getRealPay() {
		return realPay;
	}
	public void setRealPay(Integer realPay) {
		this.realPay = realPay;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public UserOrderDataDto(String id,PayPath payPath, Room room, User user, Pledge pledge,
			ClockCategory clockCategory, OrderStatus orderStatus, Date initTime, Date receiveTime, Date finishTime,
			Integer pay, Integer realPay, Date payTime, String orderRemark) {
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
	
	public UserOrderDataDto initByServerOrder(ServerOrder so){
		setId(so.getId());
		setPayPath(so.getPayPath());
		setRoom(so.getRoom());
		setUser(so.getUser());
		setPledge(so.getPledge());
		setClockCategory(so.getClockCategory());
		setOrderStatus(so.getOrderStatus());
		setInitTime(so.getInitTime());
		setReceiveTime(so.getReceiveTime());
		setFinishTime(so.getFinishTime());
		setPay(so.getPay());
		setRealPay(so.getRealPay());
		setPayTime(so.getPayTime());
		setOrderRemark(so.getOrderRemark());
		return this;
	}
	
	public ServerOrder update(ServerOrder so){
		so.setId(id);
		so.setPayPath(payPath);
		so.setRoom(room);
		so.setUser(user);
		so.setPledge(pledge);
		so.setClockCategory(clockCategory);
		so.setOrderStatus(orderStatus);
		so.setInitTime(initTime);
		so.setReceiveTime(receiveTime);
		so.setFinishTime(finishTime);
		so.setPay(pay);
		so.setRealPay(realPay);
		so.setPayTime(payTime);
		so.setOrderRemark(orderRemark);
		
		return so;
	}
	
}
