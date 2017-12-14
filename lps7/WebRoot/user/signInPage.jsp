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
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/main.js"></script>
<script src="js/sign-up.js"></script>
<script src="js/ajax_js.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#signbutton").click(function() {
			formSubmitWithEventData("signIn", "signInData", inherf);
		})
	})

	function inherf(data) {
		if (data.msg == true) {
			alert("注册成功，即将转向登录界面");
			$(location).attr("href", "login");
		} else {
			alert("注册失败");
		}

	}
</script>
</head>
<body>
	<header class="am-topbar header">
		<div class="am-container-1">
			<div class="left hw-logo">
				<lable style="margin-left: 15px;font-size: 250%">★</lable>
				<lable style="margin-left: 5px;font-size: 250%;font-family: 仿宋">小店helper</lable>
			</div>
			<button
				class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
				data-am-collapse="{target: '#doc-topbar-collapse'}">
				<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
			</button>
			<div class="am-collapse am-topbar-collapse right"
				id="doc-topbar-collapse">
				<div class=" am-topbar-left am-form-inline am-topbar-right"
					role="search">
					<ul class="am-nav am-nav-pills am-topbar-nav hw-menu">
						<li><a href="login.html">登录</a></li>
						<li class="hw-menu-active"><a href="login.html">注册</a></li>
						<li><a href="forgetpassword.html">忘记密码</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	<div class="toppic" style="background-image: url('img/sign_yp.jpg')">
		<div class="am-container-1">
			<div class="toppic-title left">
				<span class="toppic-title-span">工作非娱乐-乐趣在工作</span>
			</div>
		</div>
	</div>

	<div class=" am-container-1">
		<div class="container">
			<div class="row">
				<div
					class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2">
					<form class="fh5co-form animate-box" data-animate-effect="fadeIn"
						id="signInData">
						<a href="javascript:void(0)" style="font-size: 30px"> <i
							class="am-icon-hand-o-right"></i>
						</a>
						<div class="form-group">
							<div class="alert alert-success" role="alert">
								<p style="color: #3c763d;font-weight: bolder" id="title">请填写以下全部信息</p>
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="userSignInDto.userName" id="name"
								placeholder="用户名" autocomplete="off" onblur="blue()"
								onfocus="focus1()">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="telephonePhone"
								id="phonenumber" placeholder="手机号" autocomplete="off"
								onblur="blue()" onfocus="focus1()">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="userSignInDto.password"
								id="password" placeholder="密码" autocomplete="off"
								onblur="blue()" onfocus="focus1()">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="userSignInDto.password2"
								id="re-password" placeholder="重复密码" autocomplete="off"
								onblur="blue()" onfocus="focus1()">
						</div>
						<!--      <div class="form-group">
                        <input type="date" class="form-control" name="birthday" id="date" placeholder="所在公司" autocomplete="off" onblur="blue()" onfocus="focus1()">
                    </div> -->
						<!--         <div class="form-group">
                        <input type="password" class="form-control" name="company" id="company" placeholder="所在公司" autocomplete="off" onblur="blue()" onfocus="focus1()">
                    </div> -->
						<div class="form-group">
							<select id="select" name="userSignInDto.question" class="form-control"
								style="opacity: 0.4;color: black">
								<option>选择一个密码问题</option>
								<option value="1">你的初恋的一个爱好</option>
								<option value="2">你最讨厌的东西</option>
								<option value="3">你最难忘的一个人</option>
							</select>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="userSignInDto.answer"
								id="answer" placeholder="问题答案" autocomplete="off"
								onblur="blue()" onfocus="focus1()">
						</div>
						<div class="form-group">
							<input type="button" value="注册" id="signbutton"
								class="btn btn-primary">
						</div>
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
