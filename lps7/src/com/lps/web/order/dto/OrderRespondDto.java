package com.lps.web.order.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.simple.dto.ServerItemDto;
import com.lps.web.user.dto.UserResponseDto;

@Component("orderDto")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderRespondDto extends BasicRespondMsgDto implements OrderLibraryDto ,BasicResponseDto<ServerOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1438588682488989075L;

	public OrderRespondDto() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderRespondDto initDto(ServerOrder obj) throws DtoInitException {

		if (obj == null) {
			throw new DtoInitException("订单数据转换对象初始化异常");
		}

		ServerOrder so = obj;

		if (so.getServerorderServeritems() != null) {
			Set<ServerItemDto> sidtos = new HashSet<>();
			put(serverItem, sidtos);
			for (ServerItem si : so.getServerorderServeritems()) {
				ServerItemDto sidto = new ServerItemDto();
				sidto.initDto(si);
				sidtos.add(sidto);
			}
		}

		if (so.getId() != null) {
			put(orderId, so.getId());
		}

		if (so.getOrderStatus() != null) {
			put(orderStatusName, so.getOrderStatus().getOrderstatus());
		}

		if (so.getClockCategory() != null) {
			put(clockCategoryName, so.getClockCategory().getClockCategory());
		}

		if (so.getRoom() != null) {
			put(roomName, so.getRoom().getName());
		}

		if (so.getInitTime() != null) {
			put(initTime, WorkDate.dateTimeToString(so.getInitTime()));
		}

		if (so.getFinishTime() != null) {
			put(finishTime, WorkDate.dateTimeToString(so.getFinishTime()));
		}

		if (so.getOrderRemark() != null) {
			put(orderRemark, so.getOrderRemark());
		}

		if (so.getPayPath() != null) {
			put(payPath, so.getPayPath().getPayPath());
		}

		if (so.getPay() != null) {
			put(pay, so.getPay());
		}

		if (so.getPayTime() != null) {
			put(payTime, WorkDate.dateTimeToString(so.getPayTime()));
		}

		if (so.getRealPay() != null) {
			put(realPay, so.getRealPay());
		}

		if (so.getPayTime() != null) {
			put(payTime, WorkDate.dateTimeToString((so.getPayTime())));
		}

		if (so.getPledge() != null) {
			put(pledgeName, so.getPledge().getName());
		}

		if (so.getReceiveTime() != null) {
			put(receiveTime, WorkDate.dateTimeToString(so.getReceiveTime()));
		}

		if (so.getRoom() != null) {
			put(roomName, so.getRoom().getName());
		}
		
		UserResponseDto ud = new UserResponseDto();
		ud.initDto(so.getUser());
		put(stuff, ud);

		return this;
	}

	

}
