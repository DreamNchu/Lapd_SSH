<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	StringBuffer basePath = request.getRequestURL();
%>
<%-- <s:debug></s:debug> --%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>发布订单</title>
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
<link rel="stylesheet" href="css/all.css">
<link rel="stylesheet" href="css/styleradio.css">
<link rel="shortcut icon" href="image/center.ico" type="image/x-icon" />
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="js/icheck.min.js"></script>
<script src="js/ajax_js.js"></script>
<script src="js/initClass.js"></script>

<script type="text/javascript">

	window.onload = function() {

		initBasicClass("initOrder");
		initTime();
		
		
		var currentTime = document.getElementById("currentTime");
		var myDate = new Date();
		currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
		ajaxRequest("initOrderData", create);

	}
	function create(createOrder) {
		var stuffId = document.getElementById("stuffId");
		var roomId = document.getElementById("roomId");
		var roomCategory = document.getElementById("roomCategory");
		var i,
			userDatab,
			op,
			createOrder;

		document.getElementById("rad1").value = createOrder.createWays[0];
		document.getElementById("rad2").value = createOrder.createWays[1];
		document.getElementById("rad3").value = createOrder.createWays[2];
		for (i in createOrder.user) {
			op = document.createElement("option");
			op.setAttribute("value", createOrder.user[i].stuffId);
			op.innerHTML = createOrder.user[i].workId;
			stuffId.appendChild(op);
		}
		for (i in createOrder.room) {
			op = document.createElement("option");
			op.setAttribute("value", createOrder.room[i].roomId);
			op.innerHTML = createOrder.room[i].roomName;
			roomId.appendChild(op);
		}
		for (i in createOrder.roomCategory) {
			op = document.createElement("option");
			op.setAttribute("value", createOrder.roomCategory[i].catetgoryId);
			op.innerHTML = createOrder.roomCategory[i].catetgoryName;
			roomCategory.appendChild(op);
		}
	}

	function hideOf() {
		document.getElementById("stuffId").disabled = "disabled";
	}
	function showOf() {
		document.getElementById("stuffId").disabled = "";
	}
	function initTime() {
		var currentTime = document.getElementById("currentTime");
		var myDate = new Date();
		currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
		setTimeout("initTime()", 1000);
	}
</script>
</head>
<body class="hold-transition skin-blue  sidebar-mini">
	<div class="wrapper">
		<header class="main-header" style="background-color: #333333">
			<jsp:include page="include/header.jsp" />
		</header>
		<aside class="main-sidebar" style="background-color: #555555">
			<jsp:include page="include/left.jsp" />
		</aside>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					工作模块 <small>订单发布</small>
				</h1>
				<ol class="breadcrumb">
				</ol>
			</section>

			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<form role="form" method="get" action="" id="orderForm">
								<div class="box box-warning">
									<div class="box-header with-border">
										<label for="rad1" class="radio"> <span
											class="radio-bg"></span> <input type="radio"
											name="createOrderDto.createWays" id="rad1" checked
											onclick="showOf()"> 点钟手发 <span class="radio-on"></span>
										</label> <label for="rad2" class="radio"> <span
											class="radio-bg"></span> <input type="radio"
											name="createOrderDto.createWays" id="rad2" onclick="showOf()">
											排钟手发 <span class="radio-on"></span>
										</label> <label for="rad3" class="radio"> <span
											class="radio-bg"></span> <input type="radio"
											name="createOrderDto.createWays" id="rad3" onclick="hideOf()">
											排钟自发 <span class="radio-on"></span>
										</label>
									</div>
									<div class="box-body">
										<div class="form-group">
											<label>选择员工</label> <select class="form-control"
												name="createOrderDto.stuffId" id="stuffId">

											</select>
										</div>
										<div class="form-group">
											<label>选择房间</label> <select class="form-control"
												name="createOrderDto.roomId" id="roomId">
											</select>
										</div>
										<div class="form-group">
											<label>选择项目</label> <select class="form-control"
												name="createOrderDto.serverItemId" id="roomCategory">
											</select>
										</div>
										<div class="form-group">
											<label>备注</label>
											<textarea class="form-control" rows="3"
												placeholder="备注信息......" name="createOrderDto.orderRemark"></textarea>
										</div>
										<div class="form-group">
											<input type="button"
												onclick="formSubmit('createOrder','orderForm')"
												class="btn btn-info pull-left" value="发布">
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
		</div>


		<aside class="control-sidebar control-sidebar-dark">
			<jsp:include page="include/right.jsp" />
		</aside>
		<div class="control-sidebar-bg"></div>
	</div>


</body>
</html>