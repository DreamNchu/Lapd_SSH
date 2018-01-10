package com.lps.web.order.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.OrderStatus;
import com.lps.model.PayPath;
import com.lps.model.Room;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.util.PropertyRange;
import com.lps.util.PropertyRangeNullException;
import com.lps.web.basicmsg.dto.BasicProRangeDto;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;
import com.lps.web.page.dto.PageAble;

public class AdvancedSearchDto extends BasicRequestMsgDto<ServerOrder> implements OrderLibraryDto, BasicProRangeDto,PageAble {
	
	private Date maxDate;
	private float maxRealPay;
	
	/**
	 * 
	 * A.时间段搜索， B.价格段搜索， C.订单类型搜索， D.项目类型搜索， E.工号进行搜索 F.房间号进行搜索。
	 * K.支付方式进行搜索。
	 */

	private Date minDate;
	private float minRealPay;

	private int page;
	private int payPathId;
	private int roomId;
	private int statusId;
	
	private int workId;
	
	@Override
	public ServerOrder generate() {
		return null;
	}
	
	public PropertyRange<Date> getInitTimeRange() throws PropertyRangeNullException {

		if (minDate != null && maxDate != null) {
			return new PropertyRange<Date>(ServerOrderDAOImpl.INIT_TIME, minDate, maxDate);
		}
		throw new PropertyRangeNullException();
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public float getMaxRealPay() {
		return maxRealPay;
	}

	public Date getMinDate() {
		return minDate;
	}

	public float getMinRealPay() {
		return minRealPay;
	}

	public int getPage() {
		return page;
	}

	public int getPayPathId() {
		return payPathId;
	}

	public PropertyRange<PayPath> getPayPathRange() throws PropertyRangeNullException {
		if (roomId > 0) {
			PropertyRange<PayPath> pro = new PropertyRange<PayPath>();
			PayPath item = new PayPath();
			item.setId(payPathId);
			pro.setMinValue(item);
			pro.setMaxValue(item);
			return pro;
		}
		throw new PropertyRangeNullException();
	}

	@Override
	public List<PropertyRange<?>> getRangeList() {
		List<PropertyRange<?>> list = new ArrayList<>();

		try {
			list.add(getRealPayRange());
			list.add(getInitTimeRange());
			list.add(getRealPayRange());
			list.add(getPayPathRange());
			
			list.add(getRoomRange());
			list.add(getStatusRange());
			list.add(getUserRange());
		} catch (PropertyRangeNullException e) {
			e.printStackTrace();
		}

		return list;
	}

	public PropertyRange<Float> getRealPayRange() throws PropertyRangeNullException {
		if (minRealPay != 0 && maxRealPay != 0)
			return new PropertyRange<Float>(ServerOrderDAOImpl.REAL_PAY, minRealPay, maxRealPay);
		throw new PropertyRangeNullException();
	}

	public int getRoomId() {
		return roomId;
	}

	public PropertyRange<Room> getRoomRange() throws PropertyRangeNullException {
		if (roomId > 0) {
			PropertyRange<Room> pro = new PropertyRange<Room>();
			Room item = new Room();
			item.setId(roomId);
			pro.setMinValue(item);
			pro.setMaxValue(item);
			return pro;
		}
		throw new PropertyRangeNullException();
	}

	public int getStatusId() {
		return statusId;
	}

	public PropertyRange<OrderStatus> getStatusRange() throws PropertyRangeNullException {
		if (statusId > 0) {
			PropertyRange<OrderStatus> proOrder = new PropertyRange<OrderStatus>();
			OrderStatus item = new OrderStatus();
			item.setId(statusId);
			proOrder.setMinValue(item);
			proOrder.setMaxValue(item);
			return proOrder;
		}
		throw new PropertyRangeNullException();
	}

	public PropertyRange<User> getUserRange() throws PropertyRangeNullException {
		if (workId > 0) {
			PropertyRange<User> pro = new PropertyRange<User>();
			User item = new User();
			item.setWorkId(workId);
			pro.setMinValue(item);
			pro.setMaxValue(item);
			return pro;
		}
		throw new PropertyRangeNullException();
	}

	public int getWorkId() {
		return workId;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public void setMaxRealPay(float maxRealPay) {
		this.maxRealPay = maxRealPay;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public void setMinRealPay(float minRealPay) {
		this.minRealPay = minRealPay;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPayPathId(int payPathId) {
		this.payPathId = payPathId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	@Override
	public String getDomainName() {
		String str = this.getClass().getSimpleName();
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}

}
