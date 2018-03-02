package com.lps.action.operation.manage;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.action.basic.ActionSupportLps;
import com.lps.control.manage.ComboManage;
import com.lps.control.manage.ECreateFailedException;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.combo.ComboRequestDto;
import com.lps.web.combo.ComboResponseDto;
import com.lps.web.combo.ComboTableDataDto;
import com.lps.web.combo.ComboUpdateDataDto;
import com.lps.web.page.dto.PageUtil;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ManageComboAction extends ActionSupportLps implements SessionAware{

	private static final long serialVersionUID = 6496410441337869225L;
	
	private PageUtil pageUtil;

	private List<Integer> comboIds;

	/**
	 * 1.增加： add*(); 2.删除： delete*s(); 3.查询单个：query*(); 4.分页查询：query*sByPage();
	 * 5.更新：update*();
	 * 
	 */
	@Autowired
	private ComboManage comboManage;

	private ComboRequestDto comboRequestDto;

	@Autowired
	private ComboResponseDto comboResponseDto;

	@Autowired
	private ComboTableDataDto comboTableDataDto;

	private ComboUpdateDataDto comboUpdateDataDto;
	
	private Map<String, Object> session;

	public String addCombo() {
		
		comboRequestDto.setMap(data);

		try {
			comboManage.create(comboRequestDto);
		} catch (ECreateFailedException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public String deleteCombos() {

		try {
			comboManage.delete(comboIds.toArray(new java.io.Serializable[0]));
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public List<Integer> getComboIds() {
		return comboIds;
	}

	public ComboManage getComboManage() {
		return comboManage;
	}

	public ComboRequestDto getComboRequestDto() {
		return comboRequestDto;
	}

	public ComboResponseDto getComboResponseDto() {
		return comboResponseDto;
	}

	public ComboTableDataDto getComboTableDataDto() {
		return comboTableDataDto;
	}

	public ComboUpdateDataDto getComboUpdateDataDto() {
		return comboUpdateDataDto;
	}

	public String queryCombo() {

		basicMsg.setMsgDto(comboResponseDto);

		try {
			comboManage.query(comboIds.get(0), comboResponseDto);
		} catch (FindByIdGetNullException | DtoInitException e) {
			e.printStackTrace();
			comboResponseDto.setDefaultErrorMsg();
		}
		comboResponseDto.setDefaultSuccessMsg();
		return SUCCESS;
		
	}
	
	public String queryCombosByPage() {

		basicMsg.setMsgDto(comboTableDataDto);

		if (pageUtil != null) {
			if (pageUtil.getPage() != 0) {
				session.put("comboPage", pageUtil.getPage());
			}
		} else {
			pageUtil = new PageUtil();
		}
		
		pageUtil.setPage(Integer.parseInt(session.get("comboPage") + ""));

		try {
			comboTableDataDto.init(comboManage.queryByPage(pageUtil.getPage()), pageUtil,
					Thread.currentThread().getStackTrace()[1].getMethodName());
		} catch (DtoInitException | FindByIdGetNullException | PagePropertyNotInitException e) {
			comboTableDataDto.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public void setComboIds(List<Integer> comboIds) {
		this.comboIds = comboIds;
	}

	public void setComboManage(ComboManage comboManage) {
		this.comboManage = comboManage;
	}

	public void setComboRequestDto(ComboRequestDto comboRequestDto) {
		this.comboRequestDto = comboRequestDto;
	}
	
	public void setComboResponseDto(ComboResponseDto comboResponseDto) {
		this.comboResponseDto = comboResponseDto;
	}

	public void setComboTableDataDto(ComboTableDataDto comboTableDataDto) {
		this.comboTableDataDto = comboTableDataDto;
	}

	public void setComboUpdateDataDto(ComboUpdateDataDto comboUpdateDataDto) {
		this.comboUpdateDataDto = comboUpdateDataDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public String updateCombo(){
		comboUpdateDataDto.setMap(data);
		try {
			comboManage.update(comboUpdateDataDto);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("数据更新失败");
		}
		basicMsg.setSuccessMsg("数据更新成功");
		return SUCCESS;
	}
}
