package com.lps.web.order.dto;

import java.util.List;
import java.util.Map;

import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Pledge;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.util.WorkDate;
import com.lps.web.dto.BasicRequestDto;

public class OrderRequestDto implements OrderLibraryDto , BasicRequestDto<ServerOrder>{
	
	protected Map<String, String[]> map ;

	public Map<String, String[]> getMap() {
		return map;
	}

	public void setMap(Map<String, String[]> map) {
		this.map = map;
	}
	
	@Override
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		ServerOrder so = new ServerOrder();
		String[] sClockCategoryName = (String[]) map.get(clockCategoryName);
		String[] sFinishTime = (String[]) map.get(finishTime);
		String[] sInitTime = (String[]) map.get(initTime);
		String[] sOrderId = (String[]) map.get(orderId);
		String[] sOrderRemark = (String[]) map.get(orderRemark);
		String[] sOrderStatusName = (String[]) map.get(orderStatusName);
		String[] sPay = (String[]) map.get(pay);
		String[] sPayPath = (String[]) map.get(payPath);
		String[] sRealPay = (String[]) map.get(realPay);
		String[] sPayTime = (String[]) map.get(payTime);
		String[] sPledgeName = (String[]) map.get(pledgeName);
//		String[] sRealName = (String[]) map.get(realName);
		String[] sReceiveTime = (String[]) map.get(receiveTime);
		String[] sRoomName = (String[]) map.get(roomName);
		String[] sServerItemId =   map.get(serverItem);
		String[] sStuff =  map.get(stuff);

		for (String string : sServerItemId) {
			ServerItem si = new ServerItem();
			si.setId(Integer.parseInt(string));
			so.getServerorderServeritems().add(si);
		}

		if (sClockCategoryName != null) {
			ClockCategory cc = new ClockCategory();
			cc.setClockCategory(sClockCategoryName[0]);
			so.setClockCategory(cc);
		}

		if (sFinishTime != null) {
			so.setFinishTime(WorkDate.toDate(sFinishTime[0]));
		}

		if (sInitTime != null) {
			so.setInitTime(WorkDate.toDate(sInitTime[0]));
		}

		if (sReceiveTime != null) {
			so.setReceiveTime(WorkDate.toDate(sReceiveTime[0]));
		}

		if (sOrderId != null) {
			so.setId(sOrderId[0]);
		}

		if (sOrderRemark != null) {
			so.setOrderRemark(sOrderRemark[0]);
		}

		if (sOrderStatusName != null) {
			OrderStatus os = new OrderStatus();
			os.setOrderstatus(sOrderStatusName[0]);
			so.setOrderStatus(os);
		}

		if (sPay != null) {
			so.setPay(Float.parseFloat(sPay[0]));
		}

		if (sPayPath != null) {
			PayPath pp = new PayPath();
			pp.setPayPath(sPayPath[0]);
			so.setPayPath(pp);
		}

		if (sRealPay != null) {
			so.setRealPay(Float.parseFloat(sRealPay[0]));
		}

		if (sPledgeName != null) {
			Pledge pl = new Pledge();
			pl.setName(sPledgeName[0]);
			so.setPledge(pl);
		}

		if (sRoomName != null) {
			Room room = new Room();
			room.setName(sRoomName[0]);
			so.setRoom(room);
		}

		if (sPayTime != null) {
			so.setPayTime(WorkDate.toDate(sPayTime[0]));
		}

		User u = new User();
		if (sStuff != null) {
			u.setId(Integer.parseInt(sStuff[0]));
			so.setUser(u);
		}


		return so;
	}

	/*@Override
	public ServerOrder generate() {
		
		String[] _clockCategoryName = map.get(clockCategoryName);
		String[] _orderId = map.get(orderId);
		String[] _orderRemark = map.get(orderRemark);
		String[] _pay = map.get(pay);
		String[] _payPath = map.get(payPath);
		String[] _pledgeName = map.get(pledge);
		String[] _ = map.get();
		String[] _ = map.get();
		String[] _ = map.get();
		String[] _ = map.get();
		
		
		
		return null;
	}*/

}
