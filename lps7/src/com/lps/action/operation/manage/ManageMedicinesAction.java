package com.lps.action.operation.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.basic.ActionSupportLps;
import com.lps.control.manage.ECreateFailedException;
import com.lps.control.manage.MedicineManage;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.medicine.dto.MedicineRequestDto;
import com.lps.web.medicine.dto.MedicineResponseDto;
import com.lps.web.medicine.dto.MedicineTableDataDto;
import com.lps.web.medicine.dto.MedicineUpdateDataDto;
import com.lps.web.page.dto.PageUtil;

public class ManageMedicinesAction extends ActionSupportLps implements SessionAware{

	/**
	 * 
	 */
	private static  long serialVersionUID = 6496410441337869225L;
	
	private PageUtil pageUtil;

	private List<Integer> medicineIds;

	/**
	 * 1.增加： add*(); 2.删除： delete*s(); 3.查询单个：query*(); 4.分页查询：query*sByPage();
	 * 5.更新：update*();
	 * 
	 */
	private MedicineManage medicineManage;

	private MedicineRequestDto medicineRequestDto;

	private MedicineResponseDto medicineResponseDto;

	private MedicineTableDataDto medicineTableDataDto;

	private MedicineUpdateDataDto medicineUpdateDataDto;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	private Map<String, Object> session ;

	public String addMedicine() {
		
		medicineRequestDto.setMap(data);

		try {
			medicineManage.create(medicineRequestDto);
		} catch (ECreateFailedException e) {
			e.printStackTrace();
			basicMsg.setDefaultErrorMsg();
			return SUCCESS;
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public String deleteMedicines() {

		try {
			medicineManage.delete(medicineIds.toArray(new java.io.Serializable[0]));
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

	public List<Integer> getMedicineIds() {
		return medicineIds;
	}

	public MedicineManage getMedicineManage() {
		return medicineManage;
	}

	public MedicineRequestDto getMedicineRequestDto() {
		return medicineRequestDto;
	}

	public MedicineResponseDto getMedicineResponseDto() {
		return medicineResponseDto;
	}

	public MedicineTableDataDto getMedicineTableDataDto() {
		return medicineTableDataDto;
	}

	public MedicineUpdateDataDto getMedicineUpdateDataDto() {
		return medicineUpdateDataDto;
	}

	public String queryMedicine() {

		basicMsg.setMsgDto(medicineResponseDto);

		try {
			medicineManage.query(medicineIds.get(0), medicineResponseDto);
		} catch (FindByIdGetNullException | DtoInitException e) {
			e.printStackTrace();
			medicineResponseDto.setDefaultErrorMsg();
		}
		medicineResponseDto.setDefaultSuccessMsg();
		return SUCCESS;
	}

	public String queryMedicinesByPage() {

		basicMsg.setMsgDto(medicineTableDataDto);

		if (pageUtil != null) {
			if (pageUtil.getPage() != 0) {
				session.put("medicinePage", pageUtil.getPage());
			}
		} else {
			pageUtil = new PageUtil();
		}
		pageUtil.setPage(Integer.parseInt(session.get("medicinePage") + ""));

		try {
			medicineTableDataDto.init(medicineManage.queryByPage(pageUtil.getPage()), pageUtil,
					Thread.currentThread().getStackTrace()[1].getMethodName());
		} catch (DtoInitException | FindByIdGetNullException | PagePropertyNotInitException e) {
			medicineTableDataDto.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public void setMedicineIds(List<Integer> medicineIds) {
		this.medicineIds = medicineIds;
	}

	public void setMedicineManage(MedicineManage medicineManage) {
		this.medicineManage = medicineManage;
	}

	public void setMedicineRequestDto(MedicineRequestDto medicineRequestDto) {
		this.medicineRequestDto = medicineRequestDto;
	}
	
	public void setMedicineResponseDto(MedicineResponseDto medicineResponseDto) {
		this.medicineResponseDto = medicineResponseDto;
	}

	public void setMedicineTableDataDto(MedicineTableDataDto medicineTableDataDto) {
		this.medicineTableDataDto = medicineTableDataDto;
	}

	public void setMedicineUpdateDataDto(MedicineUpdateDataDto medicineUpdateDataDto) {
		this.medicineUpdateDataDto = medicineUpdateDataDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public String updateMedicine() {
		medicineUpdateDataDto.setMap(data);
		try {
			medicineManage.update(medicineUpdateDataDto);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("数据更新失败");
		}
		basicMsg.setSuccessMsg("数据更新成功");
		return SUCCESS;
	}
}
