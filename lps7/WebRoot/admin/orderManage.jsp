<%@ page language="java" pageEncoding="UTF-8"%>
<%
	StringBuffer basePath = request.getRequestURL();
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>订单管理</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="bower_components/Ionicons/css/ionicons.min.css">
<link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
<link rel="stylesheet" href="css/ordercss.css">
<link rel="stylesheet" href="css/styleradio.css">
  
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<script src="js/ajax_js.js"></script>
<script src="js/alert.js"></script>
<script src="js/order.js"></script>
<script src="js/initClass.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script type="text/javascript">

	window.onload = function() {
		//initActive();
		initBasicClass("orderManage");
		
		initTime();
		ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.timeType=1&pageLinkTransformOrderDto.statusId=1&pageLinkTransformOrderDto.page=1", waitingReceive);
	}

	//重新请求查询
	function reQueryBasic(){
		deleteLi();
        deleteTr();
		ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=" + $('.statusId:checked').val() + "&pageLinkTransformOrderDto.timeType=" + $('.dateType:checked').val(),
					 funcs[parseInt($('.statusId:checked').val()) - 1]);
	}

	function division() {
		var orderArray = document.getElementsByName("orderId");
		var i;
		for (i = 0; i < orderArray.length; i++) {
			if (orderArray[i].checked == true) {
				break;
			}
			if (i == orderArray.length - 1) {
				bootbox.alert("请选择订单", function() {});
				return;
			}
		}
		bootbox.confirm({
			message : "是否删除选中数据",
			callback : function(result) {
				if (result == true) {
					formSubmitWithEvent("deleteOrders", "formId", reQueryBasic);
				}
			}
		});
	}
	function revise() {
		var orderArray = document.getElementsByName("orderId");
		var i,
			count = 0,
			op;
		for (i = 0; i < orderArray.length; i++) {
			if (orderArray[i].checked == true) {
				count++;
				if (count == 2) {
					bootbox.alert("只能选择一个订单修改", function() {});
					return false;
				}
			}
			if (i == orderArray.length - 1 && count == 0) {
				bootbox.alert("至少一个订单", function() {});
				return false;
			}
		}
		
		//请求订单详细数据
		formSubmitWithEventData("queryOrder", "formId", initModifyBasicData);
		
	}
	//初始化修改信息
	function initModifyBasicData(orderData){
	
		var stuffId = document.getElementById("stuffId");
		stuffId.options.length = 0;
		var roomId = document.getElementById("roomId");
		roomId.options.length = 0;
		var statusId = document.getElementById("statusId");
		statusId.options.length = 0;
		var clockCategoryId = document.getElementById("clockCategoryId");
		clockCategoryId.options.length = 0;
		var payPathId = document.getElementById("payPathId");
		payPathId.options.length = 0;
		
		var pay = document.getElementById("pay");
		var realPay = document.getElementById("realPay");
		var orderRemark = document.getElementById("orderRemark");
		var orderId=document.getElementById("orderId");
		for (i in orderData.user) {
			op = document.createElement("option");
			op.setAttribute("value", orderData.user[i].stuffId);
			op.innerHTML = orderData.user[i].workId;
			stuffId.appendChild(op);
		}
		for (i in orderData.room) {
			op = document.createElement("option");
			op.setAttribute("value", orderData.room[i].roomId);
			op.innerHTML = orderData.room[i].roomName;
			roomId.appendChild(op);
		}
		for (i in orderData.status) {
			op = document.createElement("option");
			op.setAttribute("value", orderData.status[i].statusId);
			op.innerHTML = orderData.status[i].statusName;
			statusId.appendChild(op);
		}
		for (i in orderData.clockCategory) {
			op = document.createElement("option");
			op.setAttribute("value", orderData.clockCategory[i].clockCategoryId);
			op.innerHTML = orderData.clockCategory[i].clockCategoryName;
			clockCategoryId.appendChild(op);
		}
		for (i in orderData.payType) {
			op = document.createElement("option");
			op.setAttribute("value", orderData.payType[i].payId);
			op.innerHTML = orderData.payType[i].payPath;
			payPathId.appendChild(op);
		}
		pay.value = orderData.pay;
		realPay.value = orderData.realPay;
		orderRemark.value = orderData.orderRemark;
		orderId.value=orderData.orderId;
		$("#myModal").modal("show");
	
	}
	
	function sureRevise() {
		bootbox.confirm({
			message : "是否确认修改此订单信息？",
			callback : function(result) {
				if (result == true) {
					formSubmitWithEvent("updateOrder", "serverForm", reQueryBasic);
				}
			}
		});
	}
	function initTime() {
		var currentTime=document.getElementById("currentTime");
		var myDate=new Date();
		currentTime.innerHTML=myDate.toLocaleDateString()+"--"+myDate.toLocaleTimeString();
		setTimeout("initTime()",1000);
	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

	<header class="main-header" style="background-color: #333333">
		<jsp:include page="include/header.jsp"/>
	</header>
	<aside class="main-sidebar" style="background-color: #555555">
		<jsp:include page="include/left.jsp"/>
	</aside>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					管理模块 <small>订单情况</small>
				</h1>
				<ol class="breadcrumb">
				</ol>
			</section>
			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<form id="searshForm">
									<div>
										<label for="searsh1" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" id="searsh1" name="searsh" onclick="commonSearsh()" checked>
										普通搜索
										<span class="radio-on"></span>
										</label>
										<label for="searsh2" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" name="searsh" id="searsh2" onclick="superSearsh()">
										高级搜索
										<span class="radio-on"></span>
										</label>
										</br>
										</div>
										<div>
										<label for="date1" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="dateType" id="date1" value="1" name="date" checked>
										今日
										<span class="radio-on"></span>
										</label>
										<label for="date2" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="dateType" id="date2" value="2" name="date">
										本周
										<span class="radio-on"></span>
										</label>
										<label for="date3" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="dateType" id="date3" value="3" name="date">
										本月
										<span class="radio-on"></span>
										</label>
										<label for="date4" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="dateType" id="date4" value="4" name="date">
										今年
										<span class="radio-on"></span>
										</label>
										</br>
										</div>
										<div>
										<label for="status1" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="1" id="status1" key="waitingReceive" onclick="djsdd()" name="statusId" checked>
										待接收订单
										<span class="radio-on"></span>
										</label>
										<label for="status2" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="2" id="status2" key="servicing" onclick="gzzdd()" name="statusId">
										工作中订单
										<span class="radio-on"></span>
										</label>
										<label for="status3" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="5" id="status3" key="suspend" onclick="gqzdd()" name="statusId">
										挂起中订单
										<span class="radio-on"></span>
										</label>
										<label for="status4" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="3" id="status4" key="waitingPay" onclick="dzfdd()" name="statusId">
										待支付订单
										<span class="radio-on"></span>
										</label>
										<label for="status5" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="4" id="status5" key="finish" onclick="yzfdd()" name="statusId">
										已支付订单
										<span class="radio-on"></span>
										</label>
										<label for="status6" class="radio">
										<span class="radio-bg"></span>
										<input type="radio" class="statusId" value="6" id="status6" key="invalid" onclick="ysxdd()" name="statusId">
										失效订单
										<span class="radio-on"></span>
										</label>
										</br>
										</div>
										<div id="timeTr" style="display:none;">
										<label>
										起始日期：
										<input type="date" name="startTime">
										</label>
										<label>
										结束日期：
										<input type="date" name="endTime">
										</label>
										</br>
									</div>
								</form>
								<hr>
								<button class="btn btn-success" onclick="add()">
									<span class="glyphicon glyphicon-plus"></span>增加订单
								</button>
								<button class="btn btn-danger" id="divisonbutton"
									onclick="division()">
									<span class="glyphicon glyphicon-remove"></span>删除订单
								</button>
								<button class="btn btn-warning" id="editbutton" onclick="revise()">
									<span class="glyphicon glyphicon-wrench"></span>修改订单
								</button>
								<button class="btn btn-primary" id="allChecked"
									onclick="allChecked()">
									<span class="glyphicon glyphicon-ok"></span>全选
								</button>
								<button class="btn btn-primary" id="allUnChecked"
									onclick="allUnChecked()">
									<span class="glyphicon glyphicon-remove"></span></span>全不选
								</button>
								<button class="btn btn-primary" id="opposeChecked"
									onclick="opposeChecked()">
									<span class="glyphicon glyphicon-refresh"></span>反选
								</button>
								<button class="btn btn-info" id="exportChecked"
								onclick="exportChecked()">
								<span class="glyphicon glyphicon-download-alt"></span>导出Excel
								</button>
							</div>
							<div class="box-body table-responsive no-padding">
								<form id="formId">
									<table class="table table-hover" id="orderTable">
										<tr id="firsttr">
											<th>选择</th>
											<th>订单号</th>
											<th>房间号</th>
											<th>员工号</th>
											<th>员工姓名</th>
											<th>发布时间</th>
											<th>订单类型</th>
											<th>所做项目</th>
										</tr>
									</table>
								</form>
								<div class="box-footer clearfix">
									<lable style="font-family: 仿宋;color: #4cae4c;font-size: 20px">共<span
										id="allCount"></span>条数据-共<span id="allPage"></span>页-当前第<span
										id="currentPage"></span>页</lable>
									<ul id="hrefId"
										class="pagination pagination-sm no-margin pull-right">
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改订单</h4>
						</div>
						<form id="serverForm">
							<div class="modal-body">
								<div class="form-group">
									<label>员工编号</label> 
									<select name="orderUpdateDataDto.stuffId" id="stuffId"
										class="form-control"></select> <label>房间编号</label> 
									<select
										name="orderUpdateDataDto.roomId" id="roomId" class="form-control"></select> <label>订单状态</label>
									<select name="orderUpdateDataDto.statusId" id="statusId" class="form-control">
									</select> <label>钟点类型</label> 
									<select name="orderUpdateDataDto.clockCategoryId"
										id="clockCategoryId" class="form-control">
									</select> <label>支付方式</label> 
									<select name="orderUpdateDataDto.payPathId" id="payPathId"
										class="form-control"></select> <label>需付金额</label> 
										<input name="orderUpdateDataDto.pay" type="text" id="pay" class="form-control">
									<label>实付金额</label> <input name="orderUpdateDataDto.realPay" type="text"
										id="realPay" class="form-control"> <label>备注</label>
									<textarea name="orderUpdateDataDto.orderRemark" id="orderRemark" rows="3"
										class="form-control"></textarea>
										<input type="text" name="orderUpdateDataDto.orderId" id="orderId" style="display:none"">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<input type="button" onclick="sureRevise()" value="修改"
									class="btn btn-primary">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


	<aside class="control-sidebar control-sidebar-dark">
		<jsp:include page="include/right.jsp"/>
	</aside>
		<div class="control-sidebar-bg"></div>
	</div>

	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="dist/js/adminlte.min.js"></script>
	<script src="js/bootbox.min.js"></script>
</body>
</html>