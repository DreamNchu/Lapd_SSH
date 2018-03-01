package com.lps.web.combo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.model.Combo;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.page.dto.PageAble;
import com.lps.web.page.dto.TablePage;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ComboTableDataDto extends TablePage<Combo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -888635444453809942L;
	
	@Autowired
	private TComboDto combos;

	public TComboDto getCombos() {
		return combos;
	}

	public void setCombos(TComboDto combos) {
		this.combos = combos;
	}

	public ComboTableDataDto() {

	}

	/**
	 * 初始化值
	 * @param lOrders
	 * @param pageLinkTransformOrderDto
	 * @param domainName
	 * @param actionName
	 * @throws DtoInitException 
	 */
	public void init(PageBean<Combo> combosPage, PageAble pageLinkTransformOrderDto, String actionName) throws DtoInitException {
		
		super.init(combosPage, pageLinkTransformOrderDto, actionName);
		
		combos.init(combosPage.getList());
		
	}

}
