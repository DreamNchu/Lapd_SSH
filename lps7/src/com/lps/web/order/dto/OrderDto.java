package com.lps.web.order.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.lps.web.user.dto.UserDto;

public class OrderDto extends BasicRespondMsgDto implements OrderLibraryDto ,BasicResponseDto<ServerOrder>, BasicRequestDto<ServerOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1438588682488989075L;

	public OrderDto() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public OrderDto init(ServerOrder obj) throws DtoInitException {

		if (obj == null) {
			throw new DtoInitException("订单数据转换对象初始化异常");
		}

		ServerOrder so = obj;

		if (so.getServerorderServeritems() != null) {
			Set<ServerItemDto> sidtos = new HashSet<>();
			put(serverItem, sidtos);
			for (ServerItem si : so.getServerorderServeritems()) {
				ServerItemDto sidto = new ServerItemDto();
				sidto.init(si);
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
		
		UserDto ud = new UserDto();
		ud.init(so.getUser());
		put(stuff, ud);

		return this;
	}

	@Override
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		ServerOrder so = new ServerOrder();
		String sClockCategoryName = (String) get(clockCategoryName);
		String sFinishTime = (String) get(finishTime);
		String sInitTime = (String) get(initTime);
		String sOrderId = (String) get(orderId);
		String sOrderRemark = (String) get(orderRemark);
		String sOrderStatusName = (String) get(orderStatusName);
		String sPay = (String) get(pay);
		String sPayPath = (String) get(payPath);
		String sRealPay = (String) get(realPay);
		String sPayTime = (String) get(payTime);
		String sPledgeName = (String) get(pledgeName);
//		String sRealName = (String) get(realName);
		String sReceiveTime = (String) get(receiveTime);
		String sRoomName = (String) get(roomName);
		@SuppressWarnings("unchecked")
		List<String> sServerItemId = (List<String>) get(serverItem);
		String sStuff = (String) get(stuff);

		for (String string : sServerItemId) {
			ServerItem si = new ServerItem();
			si.setId(Integer.parseInt(string));
			so.getServerorderServeritems().add(si);
		}

		if (sClockCategoryName != null) {
			ClockCategory cc = new ClockCategory();
			cc.setClockCategory(sClockCategoryName);
			so.setClockCategory(cc);
		}

		if (sFinishTime != null) {
			so.setFinishTime(WorkDate.toDate(sFinishTime));
		}

		if (sInitTime != null) {
			so.setInitTime(WorkDate.toDate(sInitTime));
		}

		if (sReceiveTime != null) {
			so.setReceiveTime(WorkDate.toDate(sReceiveTime));
		}

		if (sOrderId != null) {
			so.setId(sOrderId);
		}

		if (sOrderRemark != null) {
			so.setOrderRemark(sOrderRemark);
		}

		if (sOrderStatusName != null) {
			OrderStatus os = new OrderStatus();
			os.setOrderstatus(sOrderStatusName);
			so.setOrderStatus(os);
		}

		if (sPay != null) {
			so.setPay(Float.parseFloat(sPay));
		}

		if (sPayPath != null) {
			PayPath pp = new PayPath();
			pp.setPayPath(sPayPath);
			so.setPayPath(pp);
		}

		if (sRealPay != null) {
			so.setRealPay(Float.parseFloat(sRealPay));
		}

		if (sPledgeName != null) {
			Pledge pl = new Pledge();
			pl.setName(sPledgeName);
			so.setPledge(pl);
		}

		if (sRoomName != null) {
			Room room = new Room();
			room.setName(sRoomName);
			so.setRoom(room);
		}

		if (sPayTime != null) {
			so.setPayTime(WorkDate.toDate(sPayTime));
		}

		User u = new User();
		if (sStuff != null) {
			u.setId(Integer.parseInt(sStuff));
			so.setUser(u);
		}


		// if(sServerItemName != null) {
		// ServerItem si = new ServerItem();
		// si.setServerItem(sServerItemName);
		// so.setServerorderServeritems(si);
		// }

		return so;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public static void main(String[] args) throws DtoInitException { // Test
	 * init OrderDto od = new OrderDto(); ServerOrder so1 = new ServerOrder();
	 * so1.setClockCategory(new ClockCategory("点钟"));
	 * so1.setFinishTime(WorkDate.toDate("1265-12-5"));
	 * so1.setInitTime(WorkDate.toDate("1265-12-5")); so1.setOrderRemark("VIP");
	 * so1.setOrderStatus(new OrderStatus("待支付订单")); so1.setPay((float)15.3);
	 * so1.setPayPath(new PayPath("支付宝"));
	 * so1.setPayTime(WorkDate.toDate("1265-12-5")); so1.setPledge(new
	 * Pledge("idCard", 5)); so1.setRealPay((float)152.6);
	 * so1.setReceiveTime(WorkDate.toDate("1265-12-5")); Room room = new Room();
	 * room.setName("101"); so1.setRoom(room); OrderDto od1 = od.init(so1); //
	 * for(String key:od1.keySet()) // { //
	 * System.out.println("Key: "+key+" Value: "+od1.get(key)); // }
	 * 
	 * // Test generate OrderDto od2 = new OrderDto();
	 * od2.put(clockCategoryName, "排钟"); od2.put(finishTime, "1996-2-3");
	 * od2.put(initTime, "1635-6-5"); od2.put(orderId, "1");
	 * od2.put(orderRemark, "该订单"); od2.put(orderStatusName, "今日订单");
	 * od2.put(pay, "12"); od2.put(payPath, "支付宝0"); od2.put(realPay, "2.0");
	 * od2.put(payTime, "2005-9-6"); od2.put(pledgeName, "钱包");
	 * od2.put(receiveTime, "2306-9-5"); od2.put(roomName, "206");
	 * od2.put(realName, "啊站"); od2.put(workId, "222"); ServerOrder so2 =
	 * od2.generate(); System.out.println(so2.getId());
	 * System.out.println(so2.getOrderRemark());
	 * System.out.println(so2.getClockCategory().getClockCategory());
	 * System.out.println(so2.getFinishTime());
	 * System.out.println(so2.getInitTime());
	 * System.out.println(so2.getOrderStatus().getOrderstatus());
	 * System.out.println(so2.getPay());
	 * System.out.println(so2.getPayPath().getPayPath());
	 * System.out.println(so2.getPayTime());
	 * System.out.println(so2.getPledge().getName());
	 * System.out.println(so2.getRealPay());
	 * System.out.println(so2.getReceiveTime());
	 * System.out.println(so2.getUser().getWorkId());
	 * System.out.println(so2.getUser().getRealName()); }
	 */

	/*
	 * @SuppressWarnings("unchecked") public OrderDto init(ServerOrder so) {
	 * setOrderId(so.getId());
	 * 
	 * if (so.getPayPath() != null) setPayPath(so.getPayPath().getPayPath()); if
	 * (so.getRoom() != null){ setRoomName(so.getRoom().getName()); }
	 * 
	 * String temp = ""; for ( ServerItem si : so.getServerorderServeritems()) {
	 * temp += si.getServerItem(); } setServerItem(temp);
	 * 
	 * if(so.getUser() != null){ setWorkId(so.getUser().getWorkId() == null ? ""
	 * : so.getUser().getWorkId()+""); setRealName(so.getUser().getRealName());
	 * } if (so.getPledge() != null) setPledgeName(so.getPledge().getName()); if
	 * (so.getClockCategory() != null)
	 * setClockCategoryName(so.getClockCategory().getClockCategory()); if
	 * (so.getOrderStatus() != null)
	 * setOrderStatusName(so.getOrderStatus().getOrderstatus()); if
	 * (so.getInitTime() != null)
	 * setInitTime(WorkDate.dateTimeToString(so.getInitTime())); if
	 * (so.getReceiveTime() != null)
	 * setReceiveTime(WorkDate.dateTimeToString(so.getReceiveTime())); if
	 * (so.getFinishTime() != null)
	 * setFinishTime(WorkDate.dateTimeToString(so.getFinishTime()));
	 * setPay(so.getPay() == null ? "" : so.getPay() + "");
	 * setRealPay(so.getRealPay() == null ? "" : so.getRealPay() + ""); if
	 * (so.getPayTime() != null)
	 * setPayTime(WorkDate.dateTimeToString(so.getPayTime()));
	 * setOrderRemark(so.getOrderRemark());
	 * 
	 * return this; }
	 * 
	 * private void setClockCategoryName(String clockCategory) {
	 * put(clockCategoryName ,clockCategory); }
	 * 
	 * private void setFinishTime(String finishTime) { put(OrderDto.finishTime
	 * ,finishTime); }
	 * 
	 * private void setInitTime(String initTime) { put(OrderDto.initTime
	 * ,initTime); }
	 * 
	 * private void setOrderId(String orderId) { put(OrderDto.orderId ,orderId);
	 * }
	 * 
	 * private void setOrderRemark(String orderRemark) {
	 * put(OrderDto.orderRemark ,orderRemark); }
	 * 
	 * private void setOrderStatusName(String orderStatusName) {
	 * put(OrderDto.orderStatusName ,orderStatusName); }
	 * 
	 * private void setPay(String pay) { put(OrderDto.pay ,pay); }
	 * 
	 * private void setPayPath(String payPath) { put(OrderDto.payPath ,payPath);
	 * }
	 * 
	 * private void setPayTime(String payTime) { put(OrderDto.payTime ,payTime);
	 * }
	 * 
	 * private void setPledgeName(String pledgeName) { put(OrderDto.pledgeName
	 * ,pledgeName); }
	 * 
	 * private void setRealName(String realName) { put(OrderDto.realName
	 * ,realName); }
	 * 
	 * private void setRealPay(String realPay) { put(OrderDto.realPay ,realPay);
	 * }
	 * 
	 * private void setReceiveTime(String receiveTime) {
	 * put(OrderDto.receiveTime ,receiveTime); }
	 * 
	 * private void setRoomName(String roomName) { put(OrderDto.roomName
	 * ,roomName); }
	 * 
	 * private void setServerItem(String serverItem) {
	 * put(OrderDto.serverItemName ,serverItem); }
	 * 
	 * private void setWorkId(String workId) { put(OrderDto.workId ,workId); }
	 * /* private String getUserName() { return userName; }
	 * 
	 * private void setUserName(String userName) { this.userName = userName; }
	 */

}
