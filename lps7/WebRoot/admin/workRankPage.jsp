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
    <title>员工排名</title>
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
    <script src="js/rankJs.js"></script>
    <script type="text/javascript">
        window.onload=function () {
            initActive();
            initTime();
            ajaxRequest("viewWorkRankTable", receiveRank);
            //receiveRank();
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
                <small>员工今日排名</small>
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard"></i><label id="currentTime">2017-11-27-18-19</label></li>
            </ol>
        </section>

        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <table class="table table-hover" id="rankTable">
                            <tbody>
                                <tr>
                                    <td>序号</td>
                                    <td>员工号</td>
                                    <td>员工姓名</td>
                                    <td>点钟数</td>
                                    <td>排钟数</td>
                                </tr>
                            </tbody>
                        </table>
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
        </section>


    <aside class="control-sidebar control-sidebar-dark">
		<jsp:include page="right.jsp"></jsp:include>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>


</body>
</html>
