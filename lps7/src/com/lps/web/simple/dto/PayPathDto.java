package com.lps.web.simple.dto;

import com.lps.model.PayPath;
import com.lps.model.basic.Entity;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;

public class PayPathDto extends BasicRespondMsgDto implements PayPathLibrary{


	@SuppressWarnings("unchecked")
	@Override
	public PayPathDto init(PayPath obj) throws DtoInitException {
		if (obj == null) {
			throw new DtoInitException("支付方式数据转换对象初始化异常");
		}
		PayPath pp = (PayPath)obj;
		if(pp.getId() != null)
			put(payPathId , pp.getId());
		if(pp.getPayPath() != null)
			put(payPathName , pp.getPayPath());
		return this;
	}

	@Override
	public PayPath generate() {
		// TODO Auto-generated method stub
//		PayPath pp = new PayPath.Builder().setPayPath((String)get(payPath)).build();
		PayPath pp = new PayPath();
		String id = (String)get(payPathId);
		String name = (String)get(payPathName);
		if(id != null){
			pp.setId(Integer.parseInt(id));
		}
	
		if(name != null){
			pp.setPayPath(name);
		}
		
		return pp;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public static void main(String[] args) throws DtoInitException {
		PayPathDto ppd = new PayPathDto();
		PayPath pp1 = new PayPath();
		pp1.setId(4);
		pp1.setPayPath("支付宝");
		PayPathDto ppd1 = ppd.init(pp1);
		System.out.println(ppd1.get(payPathId));
		System.out.println(ppd1.get(payPathName));
		
		PayPathDto ppd2 = new PayPathDto();
		ppd2.put("payPathId", "1");
		ppd2.put("payPathName", "value");
		PayPath pp2 = ppd2.generate();
		System.out.print(pp2.getId());
		System.out.println(pp2.getPayPath());
	}	*/

}
