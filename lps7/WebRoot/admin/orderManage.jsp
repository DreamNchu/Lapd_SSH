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
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
<link rel="stylesheet" href="css/ordercss.css">
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<script src="js/ajax_js.js"></script>
<script src="js/alert.js"></script>
<script src="js/order.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script type="text/javascript">

	window.onload = function() {
		ajaxRequest("queryBasicOrders?queryOrderDto.timeType=1&queryOrderDto.statusId=1&queryOrderDto.page=1", waitingReceive);
	}

	//待接收订单
	function djsdd() {
		deleteTr();
		var reciveOrder = {
			//                    "order":[{"idOrder":"idOrder1","room":"room1","stuff":"stuff1","userName":"userName1","initTime":"initTtime1","clockCategory":"clockCategory1","roomCategory":"roomCategory1,"}
			//                        ,{"idOrder":"idOrder2","room":"room2","stuff":"stuff2","userName":"userName2","initTime":"initTtime2","clockCategory":"clockCategory2","roomCategory":"roomCategory2,"}]
			//                  , "page":[{"currentPage":"1","allCount":"10","allPage":"10"}],
			//                   "transform":[{"back":"TestHref","front":"TestHref"}],
			//                   "number":[{"value":"1","link":"TestHref"},{"value":"2","link":"TestHref"},{"value":"3","link":"TestHref"},{"value":"4","link":"TestHrefestHref"}]

		}
		var reciveOrder1 ;
		waitingReceive(reciveOrder1)
	}
	//工作中订单
	function gzzdd() {
		deleteTr();
		var reciveOrder = {
			"order" : [ {
				"idOrder" : "idOrder2",
				"room" : "room1",
				"stuff" : "stuff1",
				"userName" : "userName1",
				"initTime" : "initTtime1",
				"clockCategory" : "clockCategory1",
				"roomCategory" : "roomCategory1,"
			}
				, {
					"idOrder" : "idOrder2",
					"room" : "room2",
					"stuff" : "stuff2",
					"userName" : "userName2",
					"initTime" : "initTtime2",
					"clockCategory" : "clockCategory2",
					"roomCategory" : "roomCategory2,"
				} ],
			"page" : [ {
				"currentPage" : "1",
				"allCount" : "10",
				"allPage" : "10"
			} ],
			"transform" : [ {
				"back" : "TestHref",
				"front" : "TestHref"
			} ],
			"number" : [ {
				"value" : "1",
				"link" : "TestHref"
			}, {
				"value" : "2",
				"link" : "TestHref"
			}, {
				"value" : "3",
				"link" : "TestHref"
			} ]
		}
		servicing(reciveOrder)
	}
	//挂起中订单
	function gqzdd() {
		deleteTr();
		var reciveOrder = {
			"order" : [ {
				"idOrder" : "idOrder3",
				"room" : "room1",
				"stuff" : "stuff1",
				"userName" : "userName1",
				"initTime" : "initTtime1",
				"clockCategory" : "clockCategory1",
				"roomCategory" : "roomCategory1,"
			}
				, {
					"idOrder" : "idOrder2",
					"room" : "room2",
					"stuff" : "stuff2",
					"userName" : "userName2",
					"initTime" : "initTtime2",
					"clockCategory" : "clockCategory2",
					"roomCategory" : "roomCategory2,"
				} ],
			"page" : [ {
				"currentPage" : "1",
				"allCount" : "10",
				"allPage" : "10"
			} ],
			"transform" : [ {
				"back" : "TestHref",
				"front" : "TestHref"
			} ],
			"number" : [ {
				"value" : "1",
				"link" : "TestHref"
			}, {
				"value" : "2",
				"link" : "TestHref"
			}, {
				"value" : "3",
				"link" : "TestHref"
			}, {
				"value" : "4",
				"link" : "TestHref"
			} ]
		}
		suspend(reciveOrder);
	}
	//待支付订单
	function dzfdd() {
		deleteTr();
		var reciveOrder = {
			"order" : [ {
				"idOrder" : "idOrder1",
				"room" : "room1",
				"stuff" : "stuff1",
				"userName" : "userName1",
				"initTime" : "initTtime1",
				"clockCategory" : "clockCategory1",
				"roomCategory" : "roomCategory1,",
				"pledgeName" : "pledgeName1",
				"pay" : "pay1"
			}
				, {
					"idOrder" : "idOrder2",
					"room" : "room2",
					"stuff" : "stuff2",
					"userName" : "userName2",
					"initTime" : "initTtime2",
					"clockCategory" : "clockCategory2",
					"roomCategory" : "roomCategory2,",
					"pledgeName" : "pledgeName2",
					"pay" : "pay2"
				} ],
			"page" : [ {
				"currentPage" : "1",
				"allCount" : "10",
				"allPage" : "10"
			} ],
			"transform" : [ {
				"back" : "TestHref",
				"front" : "TestHref"
			} ],
			"number" : [ {
				"value" : "1",
				"link" : "TestHref"
			}, {
				"value" : "2",
				"link" : "TestHref"
			}, {
				"value" : "3",
				"link" : "TestHref"
			}, {
				"value" : "4",
				"link" : "TestHref"
			} ]
		}
		waitingPay(reciveOrder);
	}
	//已支付订单
	function yzfdd() {
		deleteTr();
		var reciveOrder = {
			"order" : [ {
				"idOrder" : "idOrder1",
				"room" : "room1",
				"stuff" : "stuff1",
				"userName" : "userName1",
				"initTime" : "initTtime1",
				"clockCategory" : "clockCategory1",
				"roomCategory" : "roomCategory1,",
				"pledgeName" : "pledgeName1",
				"pay" : "pay1",
				"realPay" : "realPay1",
				"payPath" : "payPath1"
			}
				, {
					"idOrder" : "idOrder2",
					"room" : "room2",
					"stuff" : "stuff2",
					"userName" : "userName2",
					"initTime" : "initTtime2",
					"clockCategory" : "clockCategory2",
					"roomCategory" : "roomCategory2,",
					"pledgeName" : "pledgeName2",
					"pay" : "pay2",
					"realPay" : "realPay1",
					"payPath" : "payPath1"
				} ],
			"page" : [ {
				"currentPage" : "1",
				"allCount" : "10",
				"allPage" : "10"
			} ],
			"transform" : [ {
				"back" : "TestHref",
				"front" : "TestHref"
			} ],
			"number" : [ {
				"value" : "1",
				"link" : "TestHref"
			}, {
				"value" : "2",
				"link" : "TestHref"
			}, {
				"value" : "3",
				"link" : "TestHref"
			}, {
				"value" : "4",
				"link" : "TestHref"
			} ]
		}
		finish(reciveOrder)
	}
	//已失效订单
	function ysxdd() {
		deleteTr();
		var reciveOrder = {
			"order" : [ {
				"idOrder" : "idOrder6",
				"room" : "room1",
				"stuff" : "stuff1",
				"userName" : "userName1",
				"initTime" : "initTtime1",
				"clockCategory" : "clockCategory1",
				"roomCategory" : "roomCategory1,"
			}
				, {
					"idOrder" : "idOrder2",
					"room" : "room2",
					"stuff" : "stuff2",
					"userName" : "userName2",
					"initTime" : "initTtime2",
					"clockCategory" : "clockCategory2",
					"roomCategory" : "roomCategory2,"
				} ],
			"page" : [ {
				"currentPage" : "1",
				"allCount" : "10",
				"allPage" : "10"
			} ],
			"transform" : [ {
				"back" : "TestHref",
				"front" : "TestHref"
			} ],
			"number" : [ {
				"value" : "1",
				"link" : "TestHref"
			}, {
				"value" : "2",
				"link" : "TestHref"
			}, {
				"value" : "3",
				"link" : "TestHref"
			}, {
				"value" : "4",
				"link" : "TestHref"
			} ]
		}
		invalid(reciveOrder)
	}
	
	//重新请求查询
	function reQueryBasic(){
		deleteLi();
        deleteTr();
		ajaxRequest("queryBasicOrders?queryOrderDto.statusId=" + $('.statusId:checked').val() + "&queryOrderDto.timeType=" + $('.dateType:checked').val(),
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
					
					//ajaxRequest("queryBasicOrders", 
					//funcs[parseInt($('.statusId:checked').val()) - 1]);
//alert(12);
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
alert("formSubmitWithEventForData");
		formSubmitWithEventData("queryOrder", "formId", initModifyBasicData);
		
	}
	//初始化修改信息
	function initModifyBasicData(orderData){
	
	
	 /*orderData =  {
			user : [ {
				"stuffId" : "stuffId1",
				"stuffworkId" : "stuffworkId1"
			}, {
				"stuffId" : "stuffId1",
				"stuffworkId" : "stuffworkId1"
			} ],
			room : [ {
				"roomId" : "roomId1",
				"roomName" : "roomName1"
			}, {
				"roomId" : "roomId2",
				"roomName" : "roomName2"
			} ],
			status : [ {
				"statusId" : "statusId1",
				"statusName" : "statusName1"
			}, {
				"statusId" : "statusId2",
				"statusName" : "statusName2"
			} ],
			clockCategory : [ {
				"clockId" : "clockId1",
				"clockName" : "clockName1"
			}, {
				"clockId" : "clockId2",
				"clockName" : "clockName2"
			} ],
			payType : [ {
				"payId" : "payId1",
				"payPath" : "payPath1"
			}, {
				"payId" : "payId2",
				"payPath" : "payPath2"
			} ],
			pay :  "100" ,
			relPay : "100" ,
			orderRemark :  "哈哈哈" ,
			orderId:"66565465466"
		} */
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
			op.innerHTML = orderData.user[i].stuffWorkId;
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
			op.setAttribute("value", orderData.clockCategory[i].clockId);
			op.innerHTML = orderData.clockCategory[i].clockName;
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
					//ajaxRequest("queryBasicOrders?queryOrderDto.statusId=" + $('.statusId:checked').val() + "&queryOrderDto.timeType=" + $('.dateType:checked').val(),
					 //funcs[parseInt($('.statusId:checked').val()) - 1]);
				}
			}
		});
	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header" style="background-color: #333333">

		</header>
		<aside class="main-sidebar" style="background-color: #555555">

		</aside>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					管理模块 <small>订单情况</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i>2017-11-27-18-19</a></li>
				</ol>
			</section>
			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<form id="searshForm">
									<div>
										<input type="radio" id="searsh1" name="searsh"
											onclick="commonSearsh()" checked>
										<h3 class="box-title">普通搜索</h3>
										<input type="radio" name="searsh" onclick="superSearsh()">
										<h3 class="box-title">高级搜索</h3>
										</br>
										</br>
									</div>
									<div>
										<input type="radio" class="dateType" value="1" name="date"
											checked>
										<h3 class="box-title">今日</h3>
										<input type="radio" class="dateType" value="2" name="date">
										<h3 class="box-title">本周</h3>
										<input type="radio" class="dateType" value="3" name="date">
										<h3 class="box-title">本月</h3>
										<input type="radio" class="dateType" value="4" name="date">
										<h3 class="box-title">今年</h3>
										</br>
										</br>
									</div>
									<div>
										<input type="radio" class="statusId" value="1"
											key="waitingReceive" onclick="djsdd()" name="statusId"
											checked>
										<h3 class="box-title">待接收订单</h3>
										<input type="radio" class="statusId" value="2" key="servicing"
											onclick="gzzdd()" name="statusId">
										<h3 class="box-title">工作中订单</h3>
										<input type="radio" class="statusId" value="5" key="suspend"
											onclick="gqzdd()" name="statusId">
										<h3 class="box-title">挂起中订单</h3>
										<input type="radio" class="statusId" value="3"
											key="waitingPay" onclick="dzfdd()" name="statusId">
										<h3 class="box-title">待支付订单</h3>
										<input type="radio" class="statusId" value="4" key="finish"
											onclick="yzfdd()" name="statusId">
										<h3 class="box-title">已支付订单</h3>
										<input type="radio" class="statusId" value="6" key="invalid"
											onclick="ysxdd()" name="statusId">
										<h3 class="box-title">失效订单</h3>
										</br>
										</br>
									</div>
									<div id="timeTr" style="display:none;">
										<h3 class="box-title">起始日期：</h3>
										<input type="date" name="startTime">
										<h3 class="box-title">结束日期：</h3>
										<input type="date" name="endTime"> </br>
										</br>
									</div>
								</form>
								<hr>
								<button class="btn btn-info" onclick="add()">
									<span class="glyphicon glyphicon-plus"></span>增加订单
								</button>
								<button class="btn btn-info" id="divisonbutton"
									onclick="division()">
									<span class="glyphicon glyphicon-remove"></span>删除订单
								</button>
								<button class="btn btn-info" id="editbutton" onclick="revise()">
									<span class="glyphicon glyphicon-wrench"></span>修改订单
								</button>
								<button class="btn btn-info" id="allChecked"
									onclick="allChecked()">
									<span class="glyphicon glyphicon-ok"></span>全选
								</button>
								<button class="btn btn-info" id="allUnChecked"
									onclick="allUnChecked()">
									<span class="glyphicon glyphicon-remove"></span></span>全不选
								</button>
								<button class="btn btn-info" id="opposeChecked"
									onclick="opposeChecked()">
									<span class="glyphicon glyphicon-refresh"></span>反选
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


		<aside class="control-sidebar control-sidebar-dark"></aside>
		<div class="control-sidebar-bg"></div>
	</div>

	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="dist/js/adminlte.min.js"></script>
	<script src="js/bootbox.min.js"></script>
</body>
</html>