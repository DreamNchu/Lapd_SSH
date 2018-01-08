package com.lps.web.order.dto;

import com.lps.model.ServerOrder;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;

public interface OrderLibraryDto extends BasicResponseDto<ServerOrder>, BasicRequestDto<ServerOrder>{

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
	// 所押物品名字
	String pledgeName = "pledgeName";
	// 真实姓名
	String realName = "realName";
	// // 员工姓名
	// String userName;
	// 实际支付
	String realPay = "realPay";
	// 员工接收时间
	String receiveTime = "receiveTime";
	// 房间名字
	String roomName = "roomName";
	// 房间类型对应服务类型
	String serverItemName = "serverItemName";
	// 工号
	String workId = "workId";
	
}
