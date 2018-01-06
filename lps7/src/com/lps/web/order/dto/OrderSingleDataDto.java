package com.lps.web.order.dto;

import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;

public class OrderSingleDataDto extends BasicRespondMsgDto implements OrderLibraryDto{
	
	public OrderSingleDataDto(){
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
		map.put(OrderSingleDataDto.finishTime ,finishTime);
	}

	private void setInitTime(String initTime) {
		map.put(OrderSingleDataDto.initTime ,initTime);
	}

	private void setOrderId(String orderId) {
		map.put(OrderSingleDataDto.orderId ,orderId);
	}

	private void setOrderRemark(String orderRemark) {
		map.put(OrderSingleDataDto.orderRemark ,orderRemark);
	}

	private void setOrderStatusName(String orderStatusName) {
		map.put(OrderSingleDataDto.orderStatusName ,orderStatusName);
	}

	private void setPay(String pay) {
		map.put(OrderSingleDataDto.pay ,pay);
	}

	private void setPayPath(String payPath) {
		map.put(OrderSingleDataDto.payPath ,payPath);
	}

	private void setPayTime(String payTime) {
		map.put(OrderSingleDataDto.payTime ,payTime);
	}

	private void setPledgeName(String pledgeName) {
		map.put(OrderSingleDataDto.pledgeName ,pledgeName);
	}

	private void setRealName(String realName) {
		map.put(OrderSingleDataDto.realName ,realName);
	}

	private void setRealPay(String realPay) {
		map.put(OrderSingleDataDto.realPay ,realPay);
	}

	private void setReceiveTime(String receiveTime) {
		map.put(OrderSingleDataDto.receiveTime ,receiveTime);
	}

	private void setRoomName(String roomName) {
		map.put(OrderSingleDataDto.roomName ,roomName);
	}

	private void setServerItem(String serverItem) {
		map.put(OrderSingleDataDto.serverItemName ,serverItem);
	}

	private void setWorkId(String workId) {
		map.put(OrderSingleDataDto.workId ,workId);
	}
/*
	private String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}*/

}
