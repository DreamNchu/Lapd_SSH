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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>图表分析</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, users-scalable=no"
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
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="js/highcharts.js"></script>
<script src="../js/ajax_js.js"></script>
<script src="js/initClass.js"></script>
<script>

	var serrie = [ 55954, 52503, 57177, 69658, 97031, 119931, 137133 ];
	var categories1 = [ '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00', '24:00' ];
	var categories2 = [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ];
	var categories3 = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21',
		'22', '23', '24', '25', '26', '27', '28', '29', '30', '31' ];
	var categories4 = [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ];
	var array = new Array(categories1, categories2, categories3, categories4);
	//条形图
	function chart(serrie) {
		//, categories
		contain1(serrie, array[serrie.timeType - 1]);
		contain2(serrie, array[serrie.timeType - 1]);
	}

	function contain1(serrie, categories) {
		var chart = Highcharts.chart('contain1', {
			title : {
				text : '公司员工收益报表图',
				style : {
					color : 'blue',
					fontFamily : '楷体',
				}
			},
			xAxis : {
				categories : categories
			},
			yAxis : {
				title : {
					text : ' 收益/元',
				},
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle'
			},
			plotOptions : {
				line : {
					dataLabels : {
						enabled : true,
						style : {
							color : 'blue',
						}
					},
					enableMouseTracking : true
				}
			},
			series : [ {
				name : '收益',
				data : serrie.income,
			} ],
			credits : {
				text : '',
			},
			responsive : {
				rules : [ {
					condition : {
						maxWidth : 500
					},
					chartOptions : {
						legend : {
							layout : 'horizontal',
							align : 'center',
							verticalAlign : 'bottom'
						}
					}
				} ]
			}
		});
	}
	function contain2(serrie, categories) {
		var chart = Highcharts.chart('contain2', {
			chart : {
				type : 'column'
			},
			title : {
				text : '公司员工订单数报表图',
				style : {
					color : 'blue',
					fontFamily : '楷体',
				}
			},
			xAxis : {
				categories : categories
			},
			yAxis : {
				title : {
					text : ' 订单数/个'
				}
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle'
			},
			plotOptions : {
				series : {
					dataLabels : {
						enabled : true,
						style : {
							color : 'blue',
						},
					},
					label : {
						connectorAllowed : false
					}
				}
			},
			series : [ {
				name : '订单数',
				data : serrie.orderCount
			} ],
			credits : {
				text : '',
			},
			responsive : {
				rules : [ {
					condition : {
						maxWidth : 500
					},
					chartOptions : {
						legend : {
							layout : 'horizontal',
							align : 'center',
							verticalAlign : 'bottom'
						}
					}
				} ]
			}
		});
	}
	function receviveUser(userData) {
		/*   var userData={
		      "users":[{"wordId":"workId1","userName":"userName1"},{"wordId":"workId2","userName":"userName2"},{"wordId":"workId3","userName":"userName3"}]
		  }; */
		var userSelect = document.getElementById("users");
		var i;
		for (i in userData.users) {
			var op = document.createElement("option");
			op.value = userData.users[i].id;
			op.innerHTML = "工号: " + userData.users[i].workId + "---姓名: " + userData.users[i].realName;
			userSelect.appendChild(op);
		}
	}
	;
	$(document).ready(function() {
		initBasicClass("orderChart");
		initTime();
		ajaxRequest("initChartOrders", receviveUser);

		$('#contain2').hide();
		//图表类型
		$('#chart').change(function() {
			$(this).val() == 1 ? $('#contain1').show() : $('#contain1').hide();
			$(this).val() == 2 ? $('#contain2').show() : $('#contain2').hide();
		})
		//日期范围
		$('#date').change(function() {

			ajaxRequest("chartDataOrders?orderChartRequestDto.timeType="
			+ $('#date option:selected').val() + "&orderChartRequestDto.population=" + $("#type option:selected").val()
			+ "&orderChartRequestDto.stuffId=" + $('#users option:selected').val(),
				chart);
		// chart()
		// contain1(serrie,array[parseInt($(this).val())-1]);
		// contain2(serrie,array[parseInt($(this).val())-1]);
		})
		//总体或者个人s
		$('#type').change(function() {
			$(this).val() == 2 ? $("#users").attr("disabled", "disabled") : $("#users").attr("disabled", false);
			ajaxRequest("chartDataOrders?orderChartRequestDto.timeType="
			+ $('#date option:selected').val() + "&orderChartRequestDto.population=" + $("#type option:selected").val()
			+ "&orderChartRequestDto.stuffId=" + $('#users option:selected').val(),
				chart);
		})
		//员工选择
		$('#users').change(function() {
			ajaxRequest("chartDataOrders?orderChartRequestDto.timeType="
			+ $('#date option:selected').val() + "&orderChartRequestDto.population=" + $("#type option:selected").val()
			+ "&orderChartRequestDto.stuffId=" + $('#users option:selected').val(),
				chart);
		})
	})
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
					图表分析 <small>员工业绩</small>
				</h1>
				<ol class="breadcrumb">
				</ol>
			</section>

			<section class="content container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header with-border">
								<from id="chartform ">
								<div class="form-group">
									<label>选择时间</label> <select class="form-control" name="date"
										id="date">
										<option value="1">当日</option>
										<option value="2">本周</option>
										<option value="3">当月</option>
										<option value="4">今年</option>
									</select>
									<div class="form-group">
										<label>选择个人或是总体</label> <select class="form-control"
											name="type" id="type">
											<option value="1">个人</option>
											<option value="2">总体</option>
										</select>
									</div>
									<div class="form-group">
										<label>选择员工</label> <select class="form-control" name="users"
											id="users">
										</select>
									</div>
									<div class="form-group">
										<label>选择图表类型</label> <select class="form-control" id="chart">
											<option value="1">折线图</option>
											<option value="2">柱状图</option>
										</select>
									</div>
								</div>
								</from>
							</div>
							<div class="box-body">
								<div id="contain1">
									<script>
										contain1(serrie, categories1);
									</script>
								</div>
								<div id="contain2">
									<script>
										contain2(serrie, categories1);
									</script>
								</div>
							</div>
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