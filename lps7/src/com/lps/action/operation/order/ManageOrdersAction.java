package com.lps.action.operation.order;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.lps.action.jsonresult.DataResult;
import com.lps.control.manage.BasicManage;
import com.lps.control.manage.OrderManage;
import com.lps.dao.OrderStatusDAO;
import com.lps.model.ServerOrder;
import com.lps.permission.Permission;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PagePropertyNotInitException;
import com.lps.web.order.dto.AdvancedSearchDto;
import com.lps.web.order.dto.InitBasicUpdateDataDto;
import com.lps.web.order.dto.OrderDto;
import com.lps.web.order.dto.OrderTableDataDto;
import com.lps.web.order.dto.OrderUpdateDataDto;
import com.lps.web.order.dto.PageLinkTransformOrderDto;
import com.lps.web.order.dto.UpdateOrderNormalOperationDto;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.orderchart.dto.OrderChartInitDto;
import com.lps.web.orderchart.dto.OrderChartRequestDto;
import com.opensymphony.xwork2.ActionSupport;

public class ManageOrdersAction extends ActionSupport implements DataResult, SessionAware {

	private final static Logger logger = LogManager.getLogger(new Object() {
		// 静态方法中获取当前类名
		public String getClassName() {
			String className = this.getClass().getName();
			return className.substring(0, className.lastIndexOf('$'));
		}
	}.getClassName());

	private static final long serialVersionUID = -8763735445922466287L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 高级查询辅助类
	 */
	private AdvancedSearchDto advancedSearchDto;

	//
	private InitBasicUpdateDataDto initBasicUpdateDataDto;

	private OrderChartDto orderChartDto;

	private OrderChartInitDto orderChartInitDto;

	private OrderChartRequestDto orderChartRequestDto;

	/**
	 * 订单编号的id集合
	 */
	private List<String> orderId;

	private OrderManage orderManage;

	private OrderDto orderSingleDataDto;

	private OrderTableDataDto orderTableDataDto;

	private OrderUpdateDataDto orderUpdateDataDto;

	/**
	 * 查询所要的订单基本信息
	 */
	private PageLinkTransformOrderDto pageLinkTransformOrderDto;

	private Map<String, Object> session;

	private UpdateOrderNormalOperationDto updateOrderNormalOperationDto;

	/**
	 * 图图表分析数据
	 * 
	 * @return
	 */
	public String chartDataOrders() {

		basicMsg.setMsgDto(orderChartDto);

		try {
			orderManage.chartAnalyze(orderChartDto, orderChartRequestDto);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			orderChartDto.setErrorMsg(e.getMessage());
		}

		return SUCCESS;
	}

	/**
	 * 删除订单
	 * @return
	 */
	public String deleteOrders() {
		try {
			orderManage.delete(orderId.toArray(new String[0]));
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			basicMsg.setErrorMsg("id = " + orderId + " --> " + e.getMessage() + "\n" + "删除订单失败");
		}
		basicMsg.setDefaultSuccessMsg();
		return SUCCESS;

	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public AdvancedSearchDto getAdvancedSearchDto() {
		return advancedSearchDto;
	}

	public InitBasicUpdateDataDto getInitBasicUpdateDataDto() {
		return initBasicUpdateDataDto;
	}

	public OrderChartDto getOrderChartDto() {
		return orderChartDto;
	}

	public OrderChartInitDto getOrderChartInitDto() {
		return orderChartInitDto;
	}

	public OrderChartRequestDto getOrderChartRequestDto() {
		return orderChartRequestDto;
	}

	public OrderUpdateDataDto getOrderDataDto() {
		return orderUpdateDataDto;
	}

	public List<String> getOrderId() {
		return orderId;
	}

	public BasicManage getOrderManage() {
		return orderManage;
	}

	public OrderDto getOrderSingleDataDto() {
		return orderSingleDataDto;
	}

	public OrderTableDataDto getOrderTableDataDto() {
		return orderTableDataDto;
	}

	public OrderUpdateDataDto getOrderUpdateDataDto() {
		return orderUpdateDataDto;
	}

	public PageLinkTransformOrderDto getPageLinkTransformOrderDto() {
		return pageLinkTransformOrderDto;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public UpdateOrderNormalOperationDto getUpdateOrderNormalOperationDto() {
		return updateOrderNormalOperationDto;
	}

	public String initChartOrders() {

		basicMsg.setMsgDto(orderChartDto);
		orderChartInitDto.init(orderManage.findAllUser());

		return SUCCESS;
	}

	public String outputOrdersExcel() throws PagePropertyNotInitException {
		// queryBasicOrderUtil(); //

		// orderTableDataDto
		return SUCCESS;
	}

	public String payOrderPage() {
		return SUCCESS;
	}

	/**
	 * 高级查询
	 * 
	 * @return
	 * @throws PagePropertyNotInitException
	 */
	public String queryAdvancedOrder() throws PagePropertyNotInitException {

		basicMsg.setMsgDto(orderTableDataDto);
		orderManage.advancedQuery(advancedSearchDto);

		orderTableDataDto.init(orderManage.advancedQuery(advancedSearchDto), advancedSearchDto,
				advancedSearchDto.getDomainName(), Thread.currentThread().getStackTrace()[1].getMethodName());

		return SUCCESS;
	}

	/**
	 * 根据时间查看各种订单类型
	 * 
	 * @return 根据请求返回不同的界面
	 * @throws PagePropertyNotInitException
	 */
	public String queryBasicOrders() throws PagePropertyNotInitException {
		// 找到今日该状态下的所有订单
		basicMsg.setMsgDto(orderTableDataDto);

		if (pageLinkTransformOrderDto != null) {
			if (pageLinkTransformOrderDto.getStatusId() != 0)
				session.put("statusId", pageLinkTransformOrderDto.getStatusId());
			if (pageLinkTransformOrderDto.getTimeType() != 0) {
				session.put("timeType", pageLinkTransformOrderDto.getTimeType());
			}
			if (pageLinkTransformOrderDto.getPage() != 0)
				session.put("orderPage", pageLinkTransformOrderDto.getPage());
		}

		pageLinkTransformOrderDto.setPage(Integer.parseInt(session.get("orderPage") + ""));
		pageLinkTransformOrderDto.setStatusId(Integer.parseInt(session.get("statusId") + ""));
		pageLinkTransformOrderDto.setTimeType(Integer.parseInt(session.get("timeType") + ""));

		try {
			orderTableDataDto.init(
					orderManage.basicQuery(pageLinkTransformOrderDto),
					pageLinkTransformOrderDto, pageLinkTransformOrderDto.getDomainName(),
					Thread.currentThread().getStackTrace()[1].getMethodName());

		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			orderTableDataDto.setErrorMsg(e.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * 查询单个订单
	 * 
	 * @return
	 */
	public String queryOrder() {
		String id = orderId.get(0);
		basicMsg.setMsgDto(orderSingleDataDto);

		ServerOrder so = null;

		try {
			so = orderManage.queryOrder(id);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
		}

		orderSingleDataDto.init(so);
		return SUCCESS;
	}

	public void setAdvancedSearchDto(AdvancedSearchDto advancedSearchDto) {
		this.advancedSearchDto = advancedSearchDto;
	}

	public void setInitBasicUpdateDataDto(InitBasicUpdateDataDto initBasicUpdateDataDto) {
		this.initBasicUpdateDataDto = initBasicUpdateDataDto;
	}

	public void setOrderChartDto(OrderChartDto orderChartDto) {
		this.orderChartDto = orderChartDto;
	}

	public void setOrderChartInitDto(OrderChartInitDto orderChartInitDto) {
		this.orderChartInitDto = orderChartInitDto;
	}

	public void setOrderChartRequestDto(OrderChartRequestDto orderChartRequestDto) {
		this.orderChartRequestDto = orderChartRequestDto;
	}

	public void setOrderDataDto(OrderUpdateDataDto orderUpdateDataDto) {
		this.orderUpdateDataDto = orderUpdateDataDto;
	}

	public void setOrderId(List<String> orderId) {
		this.orderId = orderId;
	}

	public void setOrderManage(OrderManage orderManage) {
		this.orderManage = orderManage;
	}

	public void setOrderSingleDataDto(OrderDto orderSingleDataDto) {
		this.orderSingleDataDto = orderSingleDataDto;
	}

	public void setOrderTableDataDto(OrderTableDataDto orderTableDataDto) {
		this.orderTableDataDto = orderTableDataDto;
	}

	public void setOrderUpdateDataDto(OrderUpdateDataDto orderUpdateDataDto) {
		this.orderUpdateDataDto = orderUpdateDataDto;
	}

	public void setPageLinkTransformOrderDto(PageLinkTransformOrderDto pageLinkTransformOrderDto) {
		this.pageLinkTransformOrderDto = pageLinkTransformOrderDto;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public void setUpdateOrderNormalOperationDto(UpdateOrderNormalOperationDto updateOrderNormalOperationDto) {
		this.updateOrderNormalOperationDto = updateOrderNormalOperationDto;
	}

	public String toPayOrders() {

		try {
			updateOrderNormalOperationDto.setPermission(new Permission(Permission.ADMIN));

			updateOrderNormalOperationDto.setOrderStatusId(OrderStatusDAO.FINISH);

			orderManage.updateOrderNormal(updateOrderNormalOperationDto);

		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage() + "\n" + "支付失败");
		}
		basicMsg.setSuccessMsg("支付成功");

		return SUCCESS;
	}

	/**
	 * 更新订单内容
	 * 
	 * @return 成功返回success
	 */
	public String updateOrder() {
		// 更新已经更改的字段

		try {

			orderManage.update(orderUpdateDataDto);

		} catch (Exception e) {
			e.printStackTrace();
			basicMsg.setErrorMsg(e.getMessage() + "\n" + "更新失败");
		}
		basicMsg.setSuccessMsg("更新成功");
		return SUCCESS;

	}

}
