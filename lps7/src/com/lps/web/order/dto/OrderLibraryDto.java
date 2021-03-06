package com.lps.web.order.dto;

public interface OrderLibraryDto {

	// 钟点类型
	String clockCategoryName = "clockCategoryName";
	// 完成时间
	String finishTime = "finishTime";

	// 订单发布时间
	String initTime = "initTime";

	// 订单编号
	String orderId = "orderId";

	// 备注
	String orderRemark = "orderRemark";

	// 订单状态
	String orderStatusName = "orderStatusName";

	// 所需支付
	String pay = "pay";

	// 支付方式
	String payPath = "payPath";

	// 支付时间
	String payTime = "payTime";
	
	String pledge = "pledge";
	// 所押物品名字
	String pledgeName = "pledgeName";

	String pledgeId = "pledgeId"; 
	
	// 实际支付
	String realPay = "realPay";
	// 员工接收时间
	String receiveTime = "receiveTime";
	// 房间名字
	String roomName = "roomName";
	// 服务类型
	
	String serverItem = "serverItem";
	
	String stuff = "stuff";
	
}
