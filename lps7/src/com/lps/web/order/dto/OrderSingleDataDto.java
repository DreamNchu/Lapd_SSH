package com.lps.web.order.dto;

import com.lps.model.ServerOrder;
import com.lps.util.WorkDate;

public class OrderSingleDataDto{
	
	// 订单编号
	private String idOrder;
	// 房间名字
	private String room;
	// 工号
	private String stuff;
	//真实姓名
	private String realName;
	// 员工姓名
	private String userName;
	// 订单发布时间
	private String initTime;
	// 钟点类型
	private String clockCategory;
	// 订单状态
	private String orderStatus;
	// 房间类型对应服务类型
	private String roomCategory;
	// 所押物品名字
	private String pledgeName;
	// 所需支付
	private String pay;
	// 实际支付
	private String realPay;
	// 支付方式
	private String payPath;
	// 员工接收时间
	private String receiveTime;
	// 完成时间
	private String finishTime;
	// 支付时间
	private String payTime;
	// 备注
	private String orderRemark;
	

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public OrderSingleDataDto() {

	}

	public OrderSingleDataDto(String idOrder, String room, String stuff, String userName, String initTime,
			String clockCategory, String orderStatus, String roomCategory, String pledgeName, String pay,
			String realPay, String payPath, String receiveTime, String finishTime, String payTime, String orderRemark) {
		super();
		this.idOrder = idOrder;
		this.room = room;
		this.stuff = stuff;
		this.userName = userName;
		this.initTime = initTime;
		this.clockCategory = clockCategory;
		this.orderStatus = orderStatus;
		this.roomCategory = roomCategory;
		this.pledgeName = pledgeName;
		this.pay = pay;
		this.realPay = realPay;
		this.payPath = payPath;
		this.receiveTime = receiveTime;
		this.finishTime = finishTime;
		this.payTime = payTime;
		this.orderRemark = orderRemark;
	}

	public void init(ServerOrder so) {
		setIdOrder(so.getId());
		if (so.getPayPath() != null)
			setPayPath(so.getPayPath().getPayPath());
		if (so.getRoom() != null){
			setRoom(so.getRoom().getName());
			setRoomCategory(so.getRoom().getRoomCategory().getServerItem());
		}
		if(so.getUser() != null){
			setStuff(so.getUser().getWorkId() == null ? "" : so.getUser().getWorkId()+"");
			setRealName(so.getUser().getRealName());			
		}
		if (so.getPledge() != null)
			setPledgeName(so.getPledge().getName());
		if (so.getClockCategory() != null)
			setClockCategory(so.getClockCategory().getClockCategory());
		if (so.getOrderStatus() != null)
			setOrderStatus(so.getOrderStatus().getOrderstatus());
		if (so.getInitTime() != null)
			setInitTime(WorkDate.dateTimeToString(so.getInitTime()));
		if (so.getReceiveTime() != null)
			setReceiveTime(WorkDate.dateTimeToString(so.getReceiveTime()));
		if (so.getFinishTime() != null)
			setFinishTime(WorkDate.dateTimeToString(so.getFinishTime()));
		setPay(so.getPay() == null ? "" : so.getPay() + "");
		setRealPay(so.getRealPay() == null ? "" : so.getRealPay() + "");
		if (so.getPayTime() != null)
			setPayTime(WorkDate.dateTimeToString(so.getPayTime()));
		setOrderRemark(so.getOrderRemark());
	}
	

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getStuff() {
		return stuff;
	}

	public void setStuff(String stuff) {
		this.stuff = stuff;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInitTime() {
		return initTime;
	}

	public void setInitTime(String initTime) {
		this.initTime = initTime;
	}

	public String getClockCategory() {
		return clockCategory;
	}

	public void setClockCategory(String clockCategory) {
		this.clockCategory = clockCategory;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getPledgeName() {
		return pledgeName;
	}

	public void setPledgeName(String pledgeName) {
		this.pledgeName = pledgeName;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getRealPay() {
		return realPay;
	}

	public void setRealPay(String realPay) {
		this.realPay = realPay;
	}

	public String getPayPath() {
		return payPath;
	}

	public void setPayPath(String payPath) {
		this.payPath = payPath;
	}

}
