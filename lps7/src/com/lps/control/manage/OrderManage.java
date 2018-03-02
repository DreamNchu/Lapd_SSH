package com.lps.control.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lps.dao.ClockCategoryDAO;
import com.lps.dao.OrderStatusDAO;
import com.lps.dao.impl.ServerOrderDAOImpl;
import com.lps.model.ClockCategory;
import com.lps.model.OrderStatus;
import com.lps.model.Room;
import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.model.User;
import com.lps.service.ClockCategoryService;
import com.lps.service.OrderStatusService;
import com.lps.service.PayPathService;
import com.lps.service.RoomService;
import com.lps.service.ServerItemService;
import com.lps.service.ServerOrderService;
import com.lps.service.UserService;
import com.lps.service.basic.BasicForServerOrderService;
import com.lps.service.basic.BasicService;
import com.lps.service.impl.FindByIdGetNullException;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;
import com.lps.util.PropertyRange;
import com.lps.util.WorkDate;
import com.lps.web.basicmsg.dto.BasicRespondMsgDto;
import com.lps.web.basicmsg.dto.DtoInitException;
import com.lps.web.dto.BasicRequestDto;
import com.lps.web.dto.BasicResponseDto;
import com.lps.web.dto.BasicUpdateDto;
import com.lps.web.order.dto.AdvancedSearchDto;
import com.lps.web.order.dto.CreateOrderDto;
import com.lps.web.order.dto.InitBasicUpdateDataDto;
import com.lps.web.order.dto.MapNotInitForClassPathException;
import com.lps.web.order.dto.OrderUpdateDataDto;
import com.lps.web.order.dto.PageLinkTransformOrderDto;
import com.lps.web.order.dto.UpdateOrderNormalOperationDto;
import com.lps.web.order.dto.constant.CreateOrderWay;
import com.lps.web.order.dto.constant.TimeType;
import com.lps.web.orderchart.dto.OrderChartDto;
import com.lps.web.orderchart.dto.OrderChartRequestDto;
import com.lps.web.orderchart.dto.Population;

@Component
public class OrderManage extends AbstractManage<ServerOrder> implements TimeType, Population, BasicManage<ServerOrder> {

	@Autowired
	public OrderManage(BasicService<ServerOrder> service, UserService userServiceImpl, RoomService roomServiceImpl,
			ClockCategoryService clockCategoryServiceImpl, OrderStatusService orderStatusServiceImpl,
			ServerOrderService serverOrderServiceImpl, ServerItemService serverItemServiceImpl,
			WorkRankManage workRankManage, PayPathService payPathServiceImpl) {
		super(service);
		this.userServiceImpl = userServiceImpl;
		this.roomServiceImpl = roomServiceImpl;
		this.clockCategoryServiceImpl = clockCategoryServiceImpl;
		this.orderStatusServiceImpl = orderStatusServiceImpl;
		this.serverOrderServiceImpl = serverOrderServiceImpl;
		this.serverItemServiceImpl = serverItemServiceImpl;
		this.workRankManage = workRankManage;
		this.payPathServiceImpl = payPathServiceImpl;
	}



	private UserService userServiceImpl;

	private RoomService roomServiceImpl;

	private ClockCategoryService clockCategoryServiceImpl;

	private OrderStatusService orderStatusServiceImpl;

	private ServerOrderService serverOrderServiceImpl;

	private ServerItemService serverItemServiceImpl;

	public ServerItemService getServerItemServiceImpl() {
		return serverItemServiceImpl;
	}

	public void setServerItemServiceImpl(ServerItemService serverItemServiceImpl) {
		this.serverItemServiceImpl = serverItemServiceImpl;
	}

	private WorkRankManage workRankManage;

	private PayPathService payPathServiceImpl;

	public PayPathService getPayPathServiceImpl() {
		return payPathServiceImpl;
	}

	public void setPayPathServiceImpl(PayPathService payPathServiceImpl) {
		this.payPathServiceImpl = payPathServiceImpl;
	}

	private int userWorkIdLength;

	private int roomNameLength;

	private int indexLength;

	public ServerOrderService getServerOrderServiceImpl() {
		return serverOrderServiceImpl;
	}

	public void setServerOrderServiceImpl(ServerOrderService serverOrderServiceImpl) {
		this.serverOrderServiceImpl = serverOrderServiceImpl;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		OrderManage.i = i;
	}

	public WorkRankManage getWorkRankManage() {
		return workRankManage;
	}

	public void setWorkRankManage(WorkRankManage workRankManage) {
		this.workRankManage = workRankManage;
	}

	public int getUserWorkIdLength() {
		return userWorkIdLength;
	}

	public void setUserWorkIdLength(int userWorkIdLength) {
		this.userWorkIdLength = userWorkIdLength;
	}

	public int getRoomNameLength() {
		return roomNameLength;
	}

	public void setRoomNameLength(int roomNameLength) {
		this.roomNameLength = roomNameLength;
	}

	public int getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(int indexLength) {
		this.indexLength = indexLength;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	public OrderStatusService getOrderStatusServiceImpl() {
		return orderStatusServiceImpl;
	}

	public void setOrderStatusServiceImpl(OrderStatusService orderStatusServiceImpl) {
		this.orderStatusServiceImpl = orderStatusServiceImpl;
	}

	public ClockCategoryService getClockCategoryServiceImpl() {
		return clockCategoryServiceImpl;
	}

	public void setClockCategoryServiceImpl(ClockCategoryService clockCategoryServiceImpl) {
		this.clockCategoryServiceImpl = clockCategoryServiceImpl;
	}

	public static int i = 1;

	/**
	 * 订单id的生成
	 * 
	 * @param wordId
	 * @param roomName1
	 * @param clockCategoryId
	 * @return
	 */
	private String orderIdCreater(int wordId, String roomName1, int clockCategoryId) {
		String userWorkId = format(wordId, userWorkIdLength);
		String roomName = format(roomName1, roomNameLength);
		String date = WorkDate.getNowDateTime();
		String index = format(i++, indexLength);
		String orderId = userWorkId + roomName + clockCategoryId + date + index;
		return orderId;
	}

	/**
	 * 订单格式化
	 * 
	 * @param value
	 * @param length
	 * @return
	 */
	private String format(int value, int length) {
		return format(String.valueOf(value), length);
	}

	/**
	 * 订单格式化
	 * 
	 * @param value
	 * @param length
	 * @return
	 */
	private String format(String value, int length) {
		int strLen = value.length();
		if (strLen < length) {
			while (strLen < length) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(value);// 左补0
				value = sb.toString();
				strLen = value.length();
			}
		}
		return value;
	}

	/**
	 * 创建一个订单
	 * 
	 * @param stuffId
	 * @param roomId
	 * @param clockCategory
	 * @return
	 * @throws ECreateOrderFailedException
	 */
	public ServerOrder createOrder(int stuffId, int roomId, int clockCategory, Set<Integer> serverItemIds,
			String orderRemark) throws ECreateOrderFailedException {

		User u = null;
		Room r = null;
		ClockCategory cc = null;

		try {
			u = userServiceImpl.findById(stuffId);
			r = roomServiceImpl.findById(roomId);
			cc = clockCategoryServiceImpl.findById(clockCategory);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			throw new ECreateOrderFailedException("创建订单失败");
		}
		Set<ServerItem> items = getServerItems(serverItemIds);

		return createNormalOrder(u, r, cc, items, orderRemark);
	}

	/**
	 * 正常情况创建订单
	 * 
	 * @param user
	 * @param room
	 * @param clockCategory
	 * @return
	 * @throws ECreateOrderFailedException 
	 */
	private ServerOrder createNormalOrder(User user, Room room, ClockCategory clockCategory, Set<ServerItem> serverItems,
			String orderRemark) throws ECreateOrderFailedException {
		ServerOrder so = new ServerOrder();
		so.setId(orderIdCreater(user.getWorkId(), room.getName(), clockCategory.getId()));
		so.setUser(user); // 初始化员工
		so.setRoom(room); // 初始化房间
		so.setClockCategory(clockCategory); // 初始化钟点类型
		OrderStatus os = null;
		try {
			os = orderStatusServiceImpl.findById(OrderStatusDAO.WAITING_RECEIVE);
		} catch (FindByIdGetNullException e) {
			e.printStackTrace();
			throw new ECreateOrderFailedException("创建订单失败");
		}
		so.setOrderStatus(os); // 初始化订单状态
		so.setInitTime(new Date());
		so.setOrderRemark(orderRemark);
		so.setServerorderServeritems(serverItems);
		return so;
	}

	/* (non-Javadoc)
	 * @see com.lps.control.manage.BasicManage2#createOrder(com.lps.web.order.dto.CreateOrderDto)
	 */
	@Override
	public <DTO extends BasicRequestDto<ServerOrder>> void create(DTO dto) throws ECreateFailedException {
		
		CreateOrderDto createOrderDto = (CreateOrderDto)dto;
		
		ServerOrder so = null;
		switch (createOrderDto.getCreateWays()) {
		case CreateOrderWay.rank_order_auto:
			so = createOrder(createOrderDto.getRoomId(), createOrderDto.getOrderRemark(),
					createOrderDto.getServerItemIds());
			break;
		case CreateOrderWay.rank_order_handle:
			so = createOrder(createOrderDto.getStuffId(), createOrderDto.getRoomId(), ClockCategoryDAO.RANK_CLOCK,
					createOrderDto.getServerItemIds(), createOrderDto.getOrderRemark());
			break;
		case CreateOrderWay.spot_order_handle:
			so = createOrder(createOrderDto.getStuffId(), createOrderDto.getRoomId(), ClockCategoryDAO.SPOT_CLOCK,
					createOrderDto.getServerItemIds(), createOrderDto.getOrderRemark());
			break;
		}
		serverOrderServiceImpl.save(so); // 保存订单
	}

	/**
	 * 自动创建订单 创建排钟
	 * 
	 * @param roomId
	 * @return
	 * @throws ECreateOrderFailedException 
	 */
	private ServerOrder createOrder(int roomId, String orderRemark, Set<Integer> serverItemIds) throws ECreateOrderFailedException {

		ServerOrder so = null;
		User u = workRankManage.nextOne();

		if (u != null) {
			// 判断是否有空闲员工，如果有那么执行下面语句
			Room r = null;
			ClockCategory cc = null;
			try {
				r = roomServiceImpl.findById(roomId);
				cc = clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK);
			} catch (FindByIdGetNullException e) {
				e.printStackTrace();
				throw new ECreateOrderFailedException("订单创建失败");
			}
			Set<ServerItem> items = getServerItems(serverItemIds);

			return createNormalOrder(u, r, cc, items, orderRemark);
		} else { // 所有员工都没有空
			// 订单挂起
			// Room r = roomServiceImpl.findById(roomId);
			// ClockCategory cc =
			// clockCategoryServiceImpl.findById(ClockCategoryDAO.RANK_CLOCK);

		}
		return so;
	}

	/**
	 * 获取服务项目集合
	 * 
	 * @param sets
	 * @return
	 */
	private Set<ServerItem> getServerItems(Set<Integer> sets) {
		Set<ServerItem> sis = new HashSet<>();
		ServerItem  si = null;
		for (Integer id : sets) {
			try {
				si = serverItemServiceImpl.findById(id);
				sis.add(si);
			} catch (FindByIdGetNullException e) {
				e.printStackTrace();
				sis.remove(si);
			}
		}
		return sis;
	}

	/**
	 * 基本查询
	 * 
	 * @param qod
	 * @return
	 * @throws PagePropertyNotInitException
	 * @throws FindByIdGetNullException 
	 */
	public PageBean<ServerOrder> basicQuery(PageLinkTransformOrderDto qod)
			throws PagePropertyNotInitException, FindByIdGetNullException {
		PageBean<ServerOrder> listSo = null;

		// 订单类型范围
		PropertyRange<OrderStatus> pr = orderStatusServiceImpl.createProRangeForOrder(qod.getStatusId());
		List<PropertyRange<?>> listPro = new ArrayList<>();
		listPro.add(pr);

		// 时间范围解析
		List<Date> ld = TimeTypeResolve.resolveTimeType(qod.getTimeType());
		listPro.add(
				serverOrderServiceImpl.createPropertyRangeByName(ServerOrderDAOImpl.INIT_TIME, ld.get(0), ld.get(1)));

		listSo = serverOrderServiceImpl.findOrdersByPropertyLimit(listPro, qod.getPage());

		return listSo;
	}

	/**
	 * 辅助更新数据添加
	 * 
	 * @param t
	 * @param lts
	 * @return
	 */
	private <T> List<T> addUtil(T t, List<T> lts) {
		List<T> listTs = new ArrayList<>();
		listTs.add(t);
		listTs.addAll(lts);
		return listTs;
	}

	/**
	 * 往 initBasicUpdateDataDto 填信息
	 * 
	 * @param initBasicUpdateDataDto
	 * @throws FindByIdGetNullException 
	 * @throws MapNotInitForClassPathException 
	 * @throws DtoInitException 
	 */
	@SuppressWarnings("unchecked")
	public void basicQuery(InitBasicUpdateDataDto initBasicUpdateDataDto, String orderId) throws FindByIdGetNullException, DtoInitException, MapNotInitForClassPathException {
		ServerOrder so = serverOrderServiceImpl.findById(orderId);

		List<User> users = addUtil(so.getUser(), userServiceImpl.findAll());
		List<Room> rooms = addUtil(so.getRoom(), roomServiceImpl.findAll());
		List<OrderStatus> oss = addUtil(so.getOrderStatus(), orderStatusServiceImpl.findAll());
		List<ClockCategory> cc = addUtil(so.getClockCategory(), clockCategoryServiceImpl.findAll());
//		List<PayPath> pp = addUtil(so.getPayPath(), payPathServiceImpl.findAll());

		initBasicUpdateDataDto.init(so, users, rooms, oss, cc/*, pp*/);

	}

	/* (non-Javadoc)
	 * @see com.lps.control.manage.BasicManage2#update(com.lps.web.order.dto.OrderUpdateDataDto)
	 */
	
//	public <DTO extends BasicRequestDto<ServerOrder>> void update(DTO dto) throws FindByIdGetNullException 
	@Override
	public <DTO extends BasicUpdateDto<ServerOrder>> void update(DTO dto) throws FindByIdGetNullException {
		
		OrderUpdateDataDto ou = (OrderUpdateDataDto)dto;
		
		ServerOrder so = serverOrderServiceImpl.findById(ou.getOrderId());
		if (ou.getStuffId() != 0)
			so.setUser(userServiceImpl.findById(ou.getStuffId()));
		if (ou.getRoomId() != 0)
			so.setRoom(roomServiceImpl.findById(ou.getRoomId()));
		if (ou.getStatusId() != 0)
			so.setOrderStatus(orderStatusServiceImpl.findById(ou.getStatusId()));
		if (ou.getClockCategoryId() != 0)
			so.setClockCategory(clockCategoryServiceImpl.findById(ou.getClockCategoryId()));

		so.setPay(ou.getPay());
		so.setRealPay(ou.getRealPay());
		so.setOrderRemark(ou.getOrderRemark());
		serverOrderServiceImpl.update(so);
	}
	
	/**
	 * 完全更新 1.订单在服务中，那么判定员工接受该订单 需要在工作排名中加一
	 * 
	 * @param so
	 */
	public void updateToReciveFromUser(ServerOrder so) {

		switch (so.getClockCategory().getId()) {
		case ClockCategoryDAO.RANK_CLOCK:
			if (so.getOrderStatus().getId() == OrderStatusDAO.SERVICING)
				workRankManage.addUserRankNum(so.getUser());
			break;
		case ClockCategoryDAO.SPOT_CLOCK:
			if (so.getOrderStatus().getId() == OrderStatusDAO.SERVICING)
				workRankManage.addUserSpotNum(so.getUser());
			break;
		}
	}

	/**
	 * 图表数据分析
	 * 
	 * @param orderChartDto
	 * @param orderChartRequestDto
	 * @throws FindByIdGetNullException 
	 */
	public void chartAnalyze(OrderChartDto orderChartDto, OrderChartRequestDto orderChartRequestDto) throws FindByIdGetNullException {
		// 时间类型
		orderChartDto.setTimeType(orderChartRequestDto.getTimeType());

		List<PropertyRange<Date>> listProDate = TimeTypeResolve.resolveTimeToProRange(ServerOrderDAOImpl.INIT_TIME,
				orderChartRequestDto.getTimeType());

		PropertyRange<User> userPro = null;
		switch (orderChartRequestDto.getPopulation()) {
		case ONE:
			User u = userServiceImpl.findById(orderChartRequestDto.getStuffId());
			userPro = new PropertyRange<User>(ServerOrderDAOImpl.USER, u, u);
			break;
		case ALL:
			break;
		}
		// 根据属性限制获取分析数据
		getData(userPro, listProDate, orderChartDto);

	}

	private void getData(PropertyRange<User> user, List<PropertyRange<Date>> date, OrderChartDto orderChartDto) {
		List<ServerOrder> sos = null;
		if (user == null) {
			for (PropertyRange<Date> propertyRange : date) {
				// 拿到所有该时间段的订单
				List<PropertyRange<?>> lt = new ArrayList<PropertyRange<?>>();
				lt.add(propertyRange);
				sos = serverOrderServiceImpl.findOrdersByProperyLimit(lt, 0,
						(int) serverOrderServiceImpl.findAllCount());
				basicCalcu(sos, orderChartDto);
			}
		} else {
			for (PropertyRange<Date> propertyRange : date) {
				List<PropertyRange<?>> lt = new ArrayList<PropertyRange<?>>();
				lt.add(user);
				lt.add(propertyRange);
				sos = serverOrderServiceImpl.findOrdersByProperyLimit(lt, 0,
						(int) serverOrderServiceImpl.findAllCount());
				basicCalcu(sos, orderChartDto);
			}
		}
	}

	private void basicCalcu(List<ServerOrder> sos, OrderChartDto orderChartDto) {
		long income = 0;
		long count = 0;
		long spotNum = 0;
		long rankNum = 0;
		for (ServerOrder serverOrder : sos) {
			if (serverOrder.getRealPay() != null) {
				income += serverOrder.getRealPay();

				if (serverOrder.getClockCategory().getId() == ClockCategoryDAO.RANK_CLOCK) {
					rankNum++;
				} else if (serverOrder.getClockCategory().getId() == ClockCategoryDAO.SPOT_CLOCK) {
					spotNum++;
				}

				count++;
			}
		}
		// 总收入
		orderChartDto.getIncome().add(income);
		// 总订单个数
		orderChartDto.getOrderCount().add(count);

		orderChartDto.getOrderRankCount().add(rankNum);

		orderChartDto.getOrderSpotCount().add(spotNum);
	}

	/**
	 * 通过id 查找订单
	 * 
	 * @param orderId
	 * @return
	 * @throws FindByIdGetNullException 
	 */
	public ServerOrder queryOrder(String orderId) throws FindByIdGetNullException {
		return serverOrderServiceImpl.findById(orderId);
	}

	/**
	 * 根据条件拿到订单 1.主要是针对员工的订单数据数据
	 * 
	 * @param userId
	 * @param orderStatus
	 * @param timeType
	 * @return
	 * @throws FindByIdGetNullException 
	 */
	public List<ServerOrder> queryOrder(int userId, int orderStatus, int timeType) throws FindByIdGetNullException {
		List<PropertyRange<?>> listPro = new ArrayList<>();

		User user = userServiceImpl.findById(userId);
		listPro.add(serverOrderServiceImpl.createPropertyRangeByName(ServerOrderDAOImpl.USER, user, user));

		OrderStatus os = orderStatusServiceImpl.findById(orderStatus);

		listPro.add(serverOrderServiceImpl.createPropertyRangeByName(ServerOrderDAOImpl.ORDER_STATUS, os, os));
		// 时间范围解析
		List<Date> ld = TimeTypeResolve.resolveTimeType(timeType);
		listPro.add(
				serverOrderServiceImpl.createPropertyRangeByName(ServerOrderDAOImpl.INIT_TIME, ld.get(0), ld.get(1)));

		return serverOrderServiceImpl.findOrdersByProperyLimit(listPro, 0, (int) serverOrderServiceImpl.findAllCount());
	}

	public List<User> findAllUser() {
		return userServiceImpl.findAll();
	}

	public Map<String, Set<User>> orderRefuseUserMap = new HashMap<>();

	/**
	 * 来自员工的拒绝订单
	 * 
	 * @param so
	 */
	public void refuseOrderFromUser(ServerOrder so) {
		if (orderRefuseUserMap.get(so.getId()) == null) {
			orderRefuseUserMap.put(so.getId(), new HashSet<User>());
		}
		orderRefuseUserMap.get(so.getId()).add(so.getUser());
		User user = workRankManage.nextOneNotIn( // 找到下一个符合条件的员工
				orderRefuseUserMap.get(so.getId()));
		if (user != null)
			so.setUser(user);
		else {
			// 订单将为挂起状态
		}
		serverOrderServiceImpl.update(so);
	}

	/**
	 * 管理员和员工都可以更新订单 在正常情况下更新订单
	 * 
	 * @param uo
	 * @throws FindByIdGetNullException 
	 */
	public void updateOrderNormal(UpdateOrderNormalOperationDto uo) throws FindByIdGetNullException {
		ServerOrder so = serverOrderServiceImpl.findById(uo.getOrderId());

		// 权限检查
		if (uo.getPermission().getPerssion() != com.lps.permission.Permission.ADMIN) {
			// 不是管理员的话，那么
			if (uo.getStuffId() != so.getUser().getId()) // 检查不同步问题
				// 订单上的员工的主键id和用户主键id不匹配
				throw new EUserUpdateOrderNotTheSameUserIdException();
			// return;
		}

		// 更改状态
		so.setOrderStatus(orderStatusServiceImpl.findById(uo.getOrderStatusId()));

		switch (uo.getOrderStatusId()) {
		case OrderStatusDAO.SERVICING:

			so.setReceiveTime(new Date()); // 接受时间
			updateToReciveFromUser(so); // 更新workrank表中的数据
			break;
		case OrderStatusDAO.WAITING_PAY:

			so.setPay(uo.getPay());
			so.setFinishTime(new Date());
			break;
		case OrderStatusDAO.FINISH:

			so.setRealPay(uo.getRealPay());
			so.setFinishTime(new Date());
			so.setPayPath(payPathServiceImpl.findById(uo.getPayPath()));
			break;
		}

		serverOrderServiceImpl.update(so);
	}

	/**
	 * 订单高级查询
	 * 
	 * @param advancedSearchDto
	 * @return
	 * @throws PagePropertyNotInitException
	 */
	public PageBean<ServerOrder> advancedQuery(AdvancedSearchDto advancedSearchDto)
			throws PagePropertyNotInitException {

		AdvancedSearchDto as = advancedSearchDto;
		List<PropertyRange<?>> listPro = new ArrayList<>();
		
		listPro.addAll(as.getRangeList());

		return serverOrderServiceImpl.findOrdersByPropertyLimit(listPro, as.getPage());
	}

	@Override
	public ServerOrder query(java.io.Serializable id, List<String> listName) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServerOrder> queryByPropertiesRange(List<PropertyRange<?>> listPro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerOrder query(java.io.Serializable id) throws FindByIdGetNullException {
		// TODO Auto-generated method stub
		return serverOrderServiceImpl.findById(id);
	}

	@Override
	public <DTO extends BasicRespondMsgDto> void initOperationData(DTO dto)
			throws DtoInitException, MapNotInitForClassPathException {
		// TODO Auto-generated method stub
		
	}


	
}
