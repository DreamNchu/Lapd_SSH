<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="alternate icon" type="img/hengwang-1.png"
	href="img/hengwang-1.png">
<link rel="stylesheet" href="css/amazeui.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/headCSS.js"></script>
<script src="js_cyl/userData.js"></script>
<script src="../js/ajax_js.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		setHeadCSS("userDataModel");

		ajaxRequest("viewUserData", resolveUserData);

	})
	
	/* $().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#userData").validate({
    rules: {
      IDCardNo: "required",
      realName:{
          required: true,
          minlength: 2,
      },
      address:{
          required: true,
          minlength: 5,
      },
      telephone:{
          required: true,
          length: 11,
      },
      email: {
          required: true,
          email: true
        },
    },
    
    messages: {
      realName: {
        required: "请输入您的真实姓名",
        minlength: "用户名至少由两个字母组成"
      },
      
      address:{
    	  required: "请输入您的居住地址",
          minlength: "居住地址至少由五个字母组成"
      },
      
      telephone:{
    	  required:"请输入您的手机号码",
    	  length:"手机号码由11位组成"
      },
      
      email: "请输入一个正确的邮箱",
      
     }
    })
}); */
</script>
</head>
<body>
	<header class="am-topbar header">
		<jsp:include page="include/head.jsp"></jsp:include>
	</header>
	<div class="toppic" style="background-image: url('img/wdxx.jpg')">
		<div class="am-container-1">
			<div class="toppic-title left">
				<span class="toppic-title-span"></span>
			</div>
		</div>
	</div>

	<div class=" am-container-1">
		<div class="container">
			<div class="row">
				<div
					class="col-xs-9 col-xs-offset-3 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
					<h2 style="font-family: 仿宋;color: #1b6d85">我的信息</h2>
				</div>
				<div
					class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
					<form id="userData" method="post">
						<table class="table">
							<tbody>
								<tr>
									<td rowspan="3"><img src="img/zhaoping2.png"
										style="width:100px;height: 100px;"></td>
									<td>姓名：</td>
									<td id="realName" class="modifiable"></td>
								</tr>
								<tr>
									<td>工号：</td>
									<td id="workId"></td>
								</tr>
								<tr>
									<td>用户名</td>
									<td id="userName"><s:property value="userDataDto.userName" /></td>
								</tr>
								<tr>
									<td>身份证号码</td>
									<td colspan="2" id="IDCardNo" class="modifiable"></td>
								</tr>
								<tr>
									<td>注册时间</td>
									<td colspan="2" id="registerTime"></td>
								</tr>
								<tr>
									<td>出生年月：</td>
									<td colspan="2" id="birthday" class="modifiable"></td>
								</tr>
								<tr>
									<td>家庭地址：</td>
									<td colspan="2" id="address" class="modifiable"></td>
								</tr>
								<tr>
									<td>电话号码：</td>
									<td colspan="2" id="telephone" class="modifiable"></td>
								</tr>
								<tr>
									<td>电子邮箱：</td>
									<td colspan="2" id="email" class="modifiable"></td>
								</tr>
							</tbody>
						</table>
					</form>
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
