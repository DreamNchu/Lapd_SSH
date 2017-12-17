<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
StringBuffer basePath = request.getRequestURL();
%>
<%-- <s:debug></s:debug> --%>
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
    <script src="js/headCSS.js"></script>
    
    <script type="text/javascript">
    	
    	$(document).ready(function(){
    		setHeadCSS("userDataModel")
    	})
    	
    </script>
</head>
<body>
<header class="am-topbar header">
   <jsp:include page="include/head.jsp"></jsp:include>
</header>
<div class="toppic" style="background-image: url('img/wdxx.jpg')">
    <div class="am-container-1">
        <div class="toppic-title left">
            <span class="toppic-title-span" ></span>
        </div>
    </div>
</div>

<div class=" am-container-1">
    <div class="container">
        <div class="row">
            <div class="col-xs-9 col-xs-offset-3 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <h2 style="font-family: 仿宋;color: #1b6d85">我的信息</h2>
            </div>
            <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table">
                    <tbody >
                    <tr>
                        <td rowspan="3"><img src="img/zhaoping2.png" style="width:100px;height: 100px;"></td>
                        <td>姓名：</td>
                        <td><s:property value="userDataDto.realName"/></td>
                    </tr>
                    <tr>
                        <td>工号：</td>
                        <td><s:property value="userDataDto.workId"/></td>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td><s:property value="userDataDto.userName"/></td>
                    </tr>
                    <tr>
                        <td >身份证号码</td>
                        <td colspan="2"><s:property value="userDataDto.IDCardNo"/></td>
                    </tr>
                    <tr>
                        <td >注册时间</td>
                        <td colspan="2"><s:property value="userDataDto.registerTime"/></td>
                    </tr>
                    <tr>
                        <td >出生年月：</td>
                        <td colspan="2"><s:property value="userDataDto.birthday"/></td>
                    </tr>
                    <tr>
                        <td >家庭地址：</td>
                        <td colspan="2"><s:property value="userDataDto.address"/></td>
                    </tr>
                    <tr>
                        <td >电话号码：</td>
                        <td colspan="2"><s:property value="userDataDto.telephonePhone"/></td>
                    </tr>
                    <tr>
                        <td >电子邮箱：</td>
                        <td colspan="2"><s:property value="userDataDto.email"/></td>
                    </tr>
                    </tbody>
                </table>
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
