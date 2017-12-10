package com.lps.web.order.dto;

import com.lps.model.PayPath;

public class PayPathOrderDto implements DtoBasicInit<PayPathOrderDto> {

	public Integer payId;

	public String payPath;

	public PayPathOrderDto(Integer payId, String payPath) {
		super();
		this.payId = payId;
		this.payPath = payPath;
	}

	public PayPathOrderDto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PayPathOrderDto init(Object obj) {
		if (obj == null) {
			return this;
		}
		PayPath pp = (PayPath) obj;
		payId = pp.getId();
		payPath = pp.getPayPath();
		return this;
	}

}
