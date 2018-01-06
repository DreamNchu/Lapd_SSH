package com.lps.web.order.dto;

import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class OrderDto extends BasicRespondMsgDto implements OrderLibraryDto{
	
	public OrderDto(){
	}

	public void init(ServerOrder so) {
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
	}
	
	private void setClockCategoryName(String clockCategory) {
		map.put(clockCategoryName ,clockCategory);
	}

	private void setFinishTime(String finishTime) {
		map.put(OrderDto.finishTime ,finishTime);
	}

	private void setInitTime(String initTime) {
		map.put(OrderDto.initTime ,initTime);
	}

	private void setOrderId(String orderId) {
		map.put(OrderDto.orderId ,orderId);
	}

	private void setOrderRemark(String orderRemark) {
		map.put(OrderDto.orderRemark ,orderRemark);
	}

	private void setOrderStatusName(String orderStatusName) {
		map.put(OrderDto.orderStatusName ,orderStatusName);
	}

	private void setPay(String pay) {
		map.put(OrderDto.pay ,pay);
	}

	private void setPayPath(String payPath) {
		map.put(OrderDto.payPath ,payPath);
	}

	private void setPayTime(String payTime) {
		map.put(OrderDto.payTime ,payTime);
	}

	private void setPledgeName(String pledgeName) {
		map.put(OrderDto.pledgeName ,pledgeName);
	}

	private void setRealName(String realName) {
		map.put(OrderDto.realName ,realName);
	}

	private void setRealPay(String realPay) {
		map.put(OrderDto.realPay ,realPay);
	}

	private void setReceiveTime(String receiveTime) {
		map.put(OrderDto.receiveTime ,receiveTime);
	}

	private void setRoomName(String roomName) {
		map.put(OrderDto.roomName ,roomName);
	}

	private void setServerItem(String serverItem) {
		map.put(OrderDto.serverItemName ,serverItem);
	}

	private void setWorkId(String workId) {
		map.put(OrderDto.workId ,workId);
	}
/*
	private String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}*/

}
