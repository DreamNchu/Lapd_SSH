package com.lps.web.medicine.dto;

import com.lps.model.Medicine;
import com.lps.model.ServerOrder;
import com.lps.util.PageBean;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.order.dto.TOrderDto;
import com.lps.web.page.dto.TablePage;
import com.lps.web.page.dto.PageAble;

public class MedicineTableDataDto extends TablePage<Medicine> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698020908629318584L;
	
	private TMedicineDto medicines;

	public TMedicineDto getMedicines() {
		return medicines;
	}

	public void setMedicines(TMedicineDto medicines) {
		this.medicines = medicines;
	}

	public MedicineTableDataDto() {

	}

	/**
	 * 初始化值
	 * @param lOrders
	 * @param pageLinkTransformOrderDto
	 * @param domainName
	 * @param actionName
	 * @throws DtoInitException 
	 */
	@SuppressWarnings("unchecked")
	public void init(PageBean<Medicine> medicinesPage, PageAble pageLinkTransformOrderDto, String actionName) throws DtoInitException {
		
		super.init(medicinesPage, pageLinkTransformOrderDto, actionName);
		
		medicines.init(medicinesPage.getList());
		
	}

}
