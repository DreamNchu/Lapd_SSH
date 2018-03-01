
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
<title>套餐管理</title>
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
<link rel="shortcut icon" href="image/center.ico" type="image/x-icon" />
<script src="js/combo_Js.js"></script>
<script src="../js/ajax_js.js"></script>
<script src="js/initClass.js"></script>
<script type="text/javascript">
	window.onload = function() {

		initBasicClass("comboManage");
		initTime();
		ajaxRequest("queryComboByPage?pageUtil.page=1", showdata);

	}


	function sureRevise() {
		if (document.getElementById("myModalLabel").innerHTML == "修改套餐信息") {
			sureReviseEdit();
		} else {
			sureReviseAdd();
		}
	}
	function sureReviseAdd() {
		bootbox.confirm({
			message : "确认执行此操作？",
			callback : function(result) {
				if (result == true) {
					formSubmitWithEventData("addMedicine", "comboForm", reQueryBasic);
				// ajaxRequest('queryBasicUser',showdata);
				}
			}
		});
	}

	function sureReviseEdit() {
		bootbox.confirm({
			message : "确认执行此操作？",
			callback : function(result) {
				if (result == true) {
					formSubmitWithEventData("updateMedicine", "comboForm", reQueryBasic);
				// ajaxRequest('queryBasicUser',showdata);
				}
			}
		});
	}

	function deleteUser() {
		var userArray = document.getElementsByName("comboIds");
		var i;
		for (i = 0; i < userArray.length; i++) {
			if (userArray[i].checked == true) {
				break;
			}
			if (i == userArray.length - 1) {
				bootbox.alert("请选择套餐", function() {});
				return;
			}
		}
		bootbox.confirm({
			message : "是否删除选中套餐数据",
			callback : function(result) {
				if (result == true) {
					formSubmitWithEventData("deleteCombo", "comboShow", reQueryBasic);
				//ajaxRequest('queryBasicUser',reQueryBasic);
				}
			}
		});
	}
	function reQueryBasic() {
		deleteLi();
		deleteTr();
		ajaxRequest("queryComboByPage", showdata);
	}

	function editUser() {
		var userArray = document.getElementsByName("comboIds");
		var i,
			count = 0,
			op;
		// alert(userArray.length);
		for (i = 0; i < userArray.length; i++) {
			if (userArray[i].checked == true) {
				count++;
				if (count == 2) {
					bootbox.alert("只能选择一个套餐修改", function() {});
					return false;
				}
			}
			if (i == userArray.length - 1 && count == 0) {
				bootbox.alert("至少选择一个套餐", function() {});
				return false;
			}
		}

		document.getElementById("myModalLabel").innerHTML = "修改套餐信息";
		formSubmitWithEventData("queryMedicine", "comboShow", queryMedicine);
	}

	function queryMedicine(comboData) {
		var comboId = document.getElementById("comboId");
		var comboNum = document.getElementById("comboNum");
		var comboName = document.getElementById("comboName");
		var comboVender = document.getElementById("comboVender");
		var comboShelfLife = document.getElementById("comboShelfLife");
		var comboPrice = document.getElementById("comboPrice");
		var comboInventory = document.getElementById("comboInventory");
		var comboSales = document.getElementById("comboSales");

		comboId.value = comboData.comboId;
		comboNum.value = comboData.comboNum;
		comboName.value = comboData.comboName;
		comboVender.value = comboData.comboVender;
		comboShelfLife.value = comboData.comboShelfLife;
		comboPrice.value = comboData.comboPrice;
		comboInventory.value = comboData.comboInventory;
		comboSales.value = comboData.comboSales;

		$("#myModal").modal("show");
	}

	function reviseLable() {
		document.getElementById("myModalLabel").innerHTML = "增加套餐";
		
		
	}
	function initTime() {
		var currentTime = document.getElementById("currentTime");
		var myDate = new Date();
		currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
		setTimeout("initTime()", 1000);
	}
</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header" style="background-color: #333333">
			<jsp:include page="include/header.jsp" />
		</header>
		<aside class="main-sidebar" style="background-color: #555555">
			<jsp:include page="include/left.jsp" />
		</aside>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>套餐管理</h1>
			</section>
			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<hr>
								<button class="btn btn-success" onclick="reviseLable()"
									data-toggle="modal" data-target="#myModal">
									<span class="glyphicon glyphicon-plus"></span>增加套餐
								</button>
								<button class="btn btn-danger" id="divisonbutton"
									onclick="deleteUser()">
									<span class="glyphicon glyphicon-remove"></span>删除套餐
								</button>
								<button class="btn btn-warning" id="editbutton"
									onclick="editUser()">
									<span class="glyphicon glyphicon-wrench"></span>修改套餐
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
								<hr>
							</div>
							<div class="box-body table-responsive no-padding">
								<form id="comboShow">
									<table class="table table-hover" id="dataTable">
										<thead>
											<tr>
												<th></th>
												<th>套餐名称</th>
												<th>套餐价格</th>
												<th>服务项目</th>
												<th>开始时间</th>
												<th>结束时间</th>
											</tr>
										</thead>
									</table>
								</form>
								<div class="box-footer clearfix">
									<label style="font-family: 仿宋;color: #4cae4c;font-size: 20px">共<span
										id="allCount"></span>条数据-共<span id="allPage"></span>页-当前第<span
										id="currentPage"></span>页
									</label>
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
						<form id="comboForm">
							<div class="modal-body">
								<div class="form-group">
									<label>套餐名称</label> 
										<input type="text" name="data.comboName" id="comboName" class="form-control"> 
									<label id="addServerItem" >服务项目</label>
										<!-- <input type="text" name="data.comboServerItem" id="comboServerItem" class="form-control"> --> 
									<label>套餐价格</label> 
										<input type="text" name="data.comboPrice" id="comboPrice" class="form-control"> 
									<label>套餐活动开始时间</label>
										<input type="date" name="data.comboBeginTime" id="comboBeginTime" class="form-control">
									 <label>套餐活动结束时间</label> 
										<input type="date" name="data.comboEndTime" id="comboEndTime" class="form-control">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<input type="button" onclick="sureRevise()" value="确定"
									class="btn btn-primary">
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>


	<aside class="control-sidebar control-sidebar-dark">
		<jsp:include page="include/right.jsp" />
	</aside>
	<div class="control-sidebar-bg"></div>
	</div>


	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="dist/js/adminlte.min.js"></script>
	<script src="js/bootbox.min.js"></script>
</body>
</html>