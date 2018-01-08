package com.lps.web.simple.dto;

import com.lps.model.ServerItem;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;

public class ServerItemDto extends BasicRespondMsgDto implements ServerItemLibrary {

	@SuppressWarnings("unchecked")
	@Override
	public ServerItemDto init(ServerItem obj) throws DtoInitException {
		if (obj == null) {
			throw new DtoInitException("服务项目数据转换对象初始化异常");
		}
		ServerItem si = (ServerItem)obj;
		if (si.getId() != null)
			put(serverItemId, si.getId());
		if (si.getServerItem() != null)
			put(serverItemName, si.getServerItem());
		if (si.getPrice() != null)
			put(price, si.getPrice());
		return this;
	}

	@Override
	public ServerItem generate() {
		// TODO Auto-generated method stub
		ServerItem si = new ServerItem();
		String id = (String)get(serverItemId);
		String name = (String)get(serverItemName);
		String p = (String)get(price);
		if(id != null) {
			si.setId(Integer.parseInt(id));
		}
		
		if(name != null) {
			si.setServerItem(name);
		}
		
		if(p != null) {
			si.setPrice(Float.parseFloat(price));
		}
		return si;
	}

	@Override
	public <K> K getNativeObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
