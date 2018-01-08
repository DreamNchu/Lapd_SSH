package com.lps.web.order.dto;

import java.sql.Date;

import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ServerOrder;
import com.lps.util.PropertyRange;
import com.lps.web.basicmsg.dto.BasicRequestMsgDto;
import com.lps.web.page.dto.PageAble;

public class AdvancedSearchDto extends BasicRequestMsgDto<ServerOrder> implements PageAble {
	/**
	 * 
	 * A.时间段搜索， B.价格段搜索， C.订单类型搜索， D.项目类型搜索， E.工号进行搜索 F.房间号进行搜索。 I.员工姓名。
	 * K.支付方式进行搜索。
	 */
	// private PropertyRange<Date> initTimeRange;
	// private PropertyRange<Integer> realPayRange;

	private Date minDate;
	private Date maxDate;

	private float minRealPay;
	private float maxRealPay;

	private int statusId;
	private int workId;
	private int roomId;
	private String realName;
	private int payPathId;
	
	private int page;

	@Override
	public String getDomainName() {
		String str = this.getClass().getSimpleName();
		str = str.substring(0, 1).toLowerCase() + str.substring(1);
		return str;
	}

	public PropertyRange<Date> getInitTimeRange() {

		if (minDate != null && maxDate != null) {
			return new PropertyRange<Date>(ServerOrderDAOImpl.INIT_TIME, minDate, maxDate);
		}

		return null;
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

	public String getRealName() {
		return realName;
	}

	public PropertyRange<Float> getRealPayRange() {
		if (minRealPay != 0 && maxRealPay != 0)
			return new PropertyRange<Float>(ServerOrderDAOImpl.REAL_PAY, minRealPay, maxRealPay);
		return null;
	}

	public int getRoomId() {
		return roomId;
	}

	public int getStatusId() {
		return statusId;
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

	public void setRealName(String realName) {
		this.realName = realName;
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
	public ServerOrder generate() {
		// TODO Auto-generated method stub
		return null;
	}

}
