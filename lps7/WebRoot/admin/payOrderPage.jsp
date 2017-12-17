<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
    <title>支付收银</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="css/tdStyle.css">
    <link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="dist/js/adminlte.min.js"></script>
    <script src="js/bootbox.min.js"></script>
    <script src="js/icheck.min.js"></script>
    <script src="js/ajax_js.js"></script>
    <script src="js/initClass.js"></script>
    <script src="js/receiveMoneyJs.js"></script>
    <script type="text/javascript">
        window.onload=function () {
            var linkHref="";
            initActive();
            initTime();
           // receivePayOrder();
           // receiveServingOrder();
            
             ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=3"+"&pageLinkTransformOrderDto.timeType=1",
             receivePayOrder);
             
               ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=2"+"&pageLinkTransformOrderDto.timeType=1",
             receiveServingOrder);
        }
    </script>
</head>
<body class="hold-transition skin-blue  sidebar-mini">
<div class="wrapper">
    <header class="main-header" style="background-color: #333333">
		<jsp:include page="header.jsp"></jsp:include>
    </header>
    <aside class="main-sidebar" style="background-color: #555555">
<jsp:include page="left.jsp"></jsp:include>
    </aside>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                工作模块
                <small>支付收银</small>
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard"></i><label id="currentTime">2017-11-27-18-19</label></li>
            </ol>
        </section>

        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">待支付订单</h3>
                            <div class="box-tools">
                                <form id="payForm">
                                    <div class="input-group input-group-sm" style="width: 150px;">
                                        <input type="text" name="roomId" class="form-control pull-right" placeholder="房间号">
                                        <div class="input-group-btn">
                                            <button onclick="searshOrder()" class="btn btn-default"><i class="fa fa-search"></i></button>
                                        </div>
                                     </div>
                                </form>
                            </div>
                        </div>
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="payTable">
                                <tr >
                                    <th >订单号</th>
                                    <th>房间号</th>
                                    <th>员工号</th>
                                    <th>员工姓名</th>
                                    <th>发布时间</th>
                                    <th>订单类型</th>
                                    <th>所做项目</th>
                                    <th></th>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">服务中订单</h3>
                        </div>
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover" id="serveTable">
                                <tr>
                                    <th>订单号</th>
                                    <th>房间号</th>
                                    <th>员工号</th>
                                    <th>员工姓名</th>
                                    <th>服务开始时间</th>
                                   <!--  <th>已经服务时间</th> -->
                                </tr>
                            </table>
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
                            <table align="center" border="1" cellspacing="0" cellpadding="5px">
                                <tbody align="center">
                                    <tr>
                                        <td >订单号：</td>
                                        <td id="idOrder">1</td>
                                        <td >房间号：</td>
                                        <td id="roomId">1</td>
                                    </tr>
                                    <tr>
                                        <td>员工号：</td>
                                        <td id="stuffId">1</td>
                                        <td>员工姓名：</td>
                                        <td  id="realName">1</td>
                                    </tr>
                                    <tr>
                                        <td>发布时间：</td>
                                        <td  id="initTime">1</td>
                                        <td>所做项目：</td>
                                        <td  id="roomCategory">1</td>
                                    </tr>
                                    <tr>
                                        <td>服务开始时间：</td>
                                        <td id="receiveTime">1</td>
                                        <td>完成时间：</td>
                                        <td  id="finishTime">1</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="right">待支付金额：</td>
                                        <td colspan="2"  id="pay">1</td>
                                    </tr>
                                    <tr id="payTr">
                                        <td>支付方式</td>
                                        <td colspan="3" id="payTd"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="right">实际支付：</td>
                                        <td colspan="2"><input name="realPay" id="realpay" type="text" placeholder="请输入支付金额"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <input type="hidden" name="idOrder" id="id">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭</button>
                            <input type="button" onclick="surePay()" value="确认支付"
                                   class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <aside class="control-sidebar control-sidebar-dark">
<jsp:include page="right.jsp"></jsp:include>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>


</body>
</html>
