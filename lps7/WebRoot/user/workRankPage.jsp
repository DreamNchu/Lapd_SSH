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
    <meta charset="UTF-8">
    <title>小店助手</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,maximum-scale=1.0, user-scalable=0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="alternate icon" type="img/hengwang-1.png" href="img/hengwang-1.png">
    <link rel="stylesheet" href="css/amazeui.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/ajax_js.js"></script>
    <script src="js/headCSS.js"></script>
    <script src="js/rankJs.js"></script>
    <script type="text/javascript">
    
    $(document).ready(function(){
    	setHeadCSS("workRankModel");
    })
    
    window.onload=function () {
        //先请求待接收订单
         ajaxRequest("viewWorkRankTable", resolveData);
   }
   </script>
</head>
<body>
<header class="am-topbar header">
   <jsp:include page="include/head.jsp"></jsp:include>
</header>
<div class="toppic" style="background-image: url('img/gzpm.jpg')">
    <div class="am-container-1">
        <div class="toppic-title left">
            <span class="toppic-title-span" ></span>
        </div>
    </div>
</div>

<div class=" am-container-1">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <h2 style="font-family: 仿宋;color: #1b6d85">今日员工工作排名表</h2>
            </div>
            <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" id="workRank">
                    <tbody id="workRank">
                        <tr align="center">
                            <th>序号</th>
                            <th>工号</th>
                            <th>姓名 </th>
                            <th>排钟</th>
                            <th>点钟</th>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="box-footer clearfix col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <lable style="font-family: 仿宋;color: #4cae4c;font-size: 20px">共<span id="allCount"></span>条数据-共<span id="allPage"></span>页-当前第<span
                id="currentPage"></span>页</lable>
                </br>
            <ul id="hrefId" class="pagination pagination-sm no-margin pull-right">

            </ul>
            </div>
        </div>
    </div>
</div>

</body>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<!--[if (gte IE 9)|!(IE)]><!-->

</html>
