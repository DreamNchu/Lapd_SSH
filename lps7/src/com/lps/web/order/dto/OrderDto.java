package com.lps.web.order.dto;

import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class OrderDto extends BasicRespondMsgDto implements OrderLibraryDto{
	
	public OrderDto(){
	}

	@SuppressWarnings("unchecked")
	public OrderDto init(ServerOrder so) {
		setOrderId(so.getId());
		
		if (so.getPayPath() != null)
			setPayPath(so.getPayPath().getPayPath());
		if (so.getRoom() != null){
			setRoomName(so.getRoom().getName());
		}
		
		String temp = "";
		for ( ServerItem si : so.getServerorderServeritems()) {
			temp += si.getServerItem();
		}
		setServerItem(temp);
		
		if(so.getUser() != null){
			setWorkId(so.getUser().getWorkId() == null ? "" : so.getUser().getWorkId()+"");
			setRealName(so.getUser().getRealName());			
		}
		if (so.getPledge() != null)
			setPledgeName(so.getPledge().getName());
		if (so.getClockCategory() != null)
			setClockCategoryName(so.getClockCategory().getClockCategory());
		if (so.getOrderStatus() != null)
			setOrderStatusName(so.getOrderStatus().getOrderstatus());
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
		
		return this;
	}
	
	private void setClockCategoryName(String clockCategory) {
		put(clockCategoryName ,clockCategory);
	}

	private void setFinishTime(String finishTime) {
		put(OrderDto.finishTime ,finishTime);
	}

	private void setInitTime(String initTime) {
		put(OrderDto.initTime ,initTime);
	}

	private void setOrderId(String orderId) {
		put(OrderDto.orderId ,orderId);
	}

	private void setOrderRemark(String orderRemark) {
		put(OrderDto.orderRemark ,orderRemark);
	}

	private void setOrderStatusName(String orderStatusName) {
		put(OrderDto.orderStatusName ,orderStatusName);
	}

	private void setPay(String pay) {
		put(OrderDto.pay ,pay);
	}

	private void setPayPath(String payPath) {
		put(OrderDto.payPath ,payPath);
	}

	private void setPayTime(String payTime) {
		put(OrderDto.payTime ,payTime);
	}

	private void setPledgeName(String pledgeName) {
		put(OrderDto.pledgeName ,pledgeName);
	}

	private void setRealName(String realName) {
		put(OrderDto.realName ,realName);
	}

	private void setRealPay(String realPay) {
		put(OrderDto.realPay ,realPay);
	}

	private void setReceiveTime(String receiveTime) {
		put(OrderDto.receiveTime ,receiveTime);
	}

	private void setRoomName(String roomName) {
		put(OrderDto.roomName ,roomName);
	}

	private void setServerItem(String serverItem) {
		put(OrderDto.serverItemName ,serverItem);
	}

	private void setWorkId(String workId) {
		put(OrderDto.workId ,workId);
	}
/*
	private String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}*/

	@Override
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
