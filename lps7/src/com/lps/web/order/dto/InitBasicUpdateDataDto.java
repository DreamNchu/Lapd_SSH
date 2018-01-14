package com.lps.web.order.dto;

import java.util.List;

import com.lps.model.ServerOrder;
import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.room.dto.TRoomDto;
import com.lps.web.simple.dto.TClockCategoryDto;
import com.lps.web.simple.dto.TOrderStatusDto;
import com.lps.web.simple.dto.TPayPathDto;
import com.lps.web.user.dto.TUserDto;

public class InitBasicUpdateDataDto extends BasicRespondMsgDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6522735277854018127L;
	/**
	 * 所有用户基本信息
	 */
	private TUserDto users;
	/**
	 * 所有房间基本信息
	 */
	private TRoomDto rooms;
	
	
	/**
	 * 所有订单状态基本信息
	 */
	private TOrderStatusDto statuses;
	
	/**
	 * 所有钟点类型基本信息
	 */
	private TClockCategoryDto clockCategorys;
	
	/**
	 * 所有支付方式基本信息
	 */
	private TPayPathDto payPaths;
	
	private OrderDto orderDto;
	
/*	private Float pay;
	
	private Float realPay;
	
	private String orderRemark;
	
	private String orderId;*/
	
//	private TPayPathDto payPaths2;
	
/*	public static void main(String[] args) {
		for(Field f: InitBasicUpdateDataDto.class.getDeclaredFields()){
if(Modifier.isTransient(f.getModifiers()))			
			System.out.println(f.getName());
		}
	}*/
	
	/*public String getOrderId() {
		return orderId;
	}
*/
	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}
	
/*	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private void initSurplus(ServerOrder so){
		pay = so.getPay();
		realPay = so.getRealPay();
		orderRemark = so.getOrderRemark();
		orderId = so.getId();
	}*/
	
	public InitBasicUpdateDataDto() {
		
	}
	
	public InitBasicUpdateDataDto init(ServerOrder so, List<? extends Entity> ...listEntities /*, List<User> users, List<Room> rooms, List<OrderStatus> orderStatuses
			,List<ClockCategory> clockCategorys, List<PayPath> payPaths,*/ /*ServerOrder so*/) throws DtoInitException, MapNotInitForClassPathException{
		
//		initSurplus(so);
		
		initTable(listEntities);
		
		orderDto.initDto(so);
		
		return this;
	}
	
	

	public TUserDto getUsers() {
		return users;
	}

	public void setUsers(TUserDto users) {
		this.users = users;
	}

	public TRoomDto getRooms() {
		return rooms;
	}

	public void setRooms(TRoomDto rooms) {
		this.rooms = rooms;
	}

	public TOrderStatusDto getStatuses() {
		return statuses;
	}

	public void setStatuses(TOrderStatusDto statuses) {
		this.statuses = statuses;
	}

	public TClockCategoryDto getClockCategorys() {
		return clockCategorys;
	}

	public void setClockCategorys(TClockCategoryDto clockCategorys) {
		this.clockCategorys = clockCategorys;
	}

	public TPayPathDto getPayPaths() {
		return payPaths;
	}

	public void setPayPaths(TPayPathDto payPaths) {
		this.payPaths = payPaths;
	}

	/*public Float getPay() {
		return pay;
	}

	public void setPay(Float pay) {
		this.pay = pay;
	}

	public Float getRealPay() {
		return realPay;
	}

	public void setRealPay(Float realPay) {
		this.realPay = realPay;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	*/
}
