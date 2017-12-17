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
    <script src="js/jquery.placeholder.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/ajax_js.js"></script>
    <script src="js/headCSS.js"></script>
    <script type="text/javascript">
    	
    	$(document).ready(function(){
    		setHeadCSS("mainModel");
    	})
    	
    
        function SignUp() {
        	ajaxRequest("checkIn", resolveCheckMsg);
        }
        
        function resolveCheckMsg(msg){
        	alert(msg.msg);
        }
        
        function  SignOut() {
        		ajaxRequest("checkOut", resolveCheckMsg);
        }
    </script>
</head>
<body>
<header class="am-topbar header">
	<jsp:include page="include/head.jsp"></jsp:include>
</header>
<div class="toppic" style="background-image: url('img/sbqd.jpg')">
    <div class="am-container-1">
        <div class="toppic-title left">
            <span class="toppic-title-span" ></span>
        </div>
    </div>
</div>

<div class=" am-container-1">

</div>

<div class=" am-container-1">
    <div class="part-title part-title-mar">
            <i class=" am-icon-home part-title-i"></i>
            <lable id="signup" style="color: blue" onclick="SignUp()"><span class="part-title-span">上班签到</span></lable>--
            <lable id="signout" style="color: blue" onclick="SignOut()"><span class="part-title-span">下班签退</span></lable>
    </div>
    <div class="office-space">
        <a href="manageOrdersPage" id="gzmk" >
            <div class="cam-u-lg-6 am-u-md-6 am-u-sm-12">
                <img src="img/gzmk.jpg"/>
            </div>
        </a>
        <a href="workRankPage" id="gzpm" >
            <div class="cam-u-lg-3 am-u-md-3 am-u-sm-6">
                <img src="img/gzpm.jpg"/>
            </div>
        </a>
        <a href="chartAnalyzePage" id="gzbb" >
            <div class="cam-u-lg-3 am-u-md-3 am-u-sm-6">
                <img src="img/gzbb.jpg"/>
            </div>
        </a>
        <a href="userData" id="wdxx" >
            <div class="cam-u-lg-3 am-u-md-3 am-u-sm-6">
                <img src="img/wdxx.jpg"/>
            </div>
        </a>
        <a href="modifyUserDataPage" id="xgxx">
            <div class="cam-u-lg-3 am-u-md-3 am-u-sm-6">
                <img src="img/xgxx.jpg"/>
            </div>
        </a>
        <div class="clear"></div>
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
