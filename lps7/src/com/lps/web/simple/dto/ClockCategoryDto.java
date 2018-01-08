package com.lps.web.simple.dto;

import com.lps.model.ClockCategory;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class ClockCategoryDto extends BasicRespondMsgDto implements ClockCategoryLibrary{
	
	@SuppressWarnings("unchecked")
	@Override
	public ClockCategoryDto init(ClockCategory obj) throws DtoInitException {
		
		if (obj == null){
			throw new DtoInitException("钟点类型数据转换对象初始化异常");
		}
		ClockCategory cc = obj;
		if(cc.getId() != null)
			put(clockCategoryId , cc.getId());
		if(cc.getClockCategory() != null)
			put(clockCategoryName , cc.getClockCategory());
		return this;
	}

	@Override
	public ClockCategory generate() {
		// TODO Auto-generated method stub
		ClockCategory cc = new ClockCategory();
		String id = (String)get(clockCategoryId);
		String name = (String)get(clockCategoryName);
		
		if(id != null) {
			cc.setId(Integer.parseInt(id));
		}
		
		if(name != null) {
			cc.setClockCategory(name);
		}
		return cc;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public static void main(String[] args) throws DtoInitException {
		ClockCategoryDto ccd = new ClockCategoryDto();
		
		ClockCategory cc1 = new ClockCategory();
		cc1.setId(1);
		cc1.setClockCategory("点钟");
		ClockCategoryDto ccd1 = ccd.init(cc1);
		System.out.println(ccd1.get(clockCategoryId));
		System.out.println(ccd1.get(clockCategoryName));
	
		ClockCategoryDto ccd2 = new ClockCategoryDto();
		ccd2.put("clockCategoryId", "3");
		ccd2.put("clockCategoryName", "排钟");
		ClockCategory cc2 = ccd2.generate();
		System.out.println(cc2.getId());
		System.out.println(cc2.getClockCategory());
	} */
	
}

