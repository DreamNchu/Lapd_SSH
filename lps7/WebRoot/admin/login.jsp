<%@ page language="java"  pageEncoding="UTF-8"%>
<%
StringBuffer basePath = request.getRequestURL();

%>
<!DOCTYPE html>
<html>
<head lang="en">
  	<base href="<%=basePath%>">
  <meta charset="UTF-8">
  <title>登录</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="image/title.jpg">
  <link rel="stylesheet" href="css/amazeui.min.css"/>
  <link rel="stylesheet" href="css/style.css"/>
  <script src="js/login.js"></script>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>小店助手</h1>
    <p>工作非娱乐，乐趣在工作<br/>----简单工作--快乐生活--欢迎使用-----</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登录</h3>
    <hr>
    <div class="am-btn-group">
     <!--  <a href="javascript:void(0)" onclick="emailclick()" id="emaillogin" class="am-btn am-btn-secondary am-btn-sm">邮箱登录</a>
      <a href="javascript:void(0)" onclick="phoneclick()" class="am-btn am-btn-success am-btn-sm">手机号登录</a>
       -->
       <a href="javascript:void(0)" onclick="userNameclick()" class="am-btn am-btn-primary am-btn-sm">普通登录</a>
      <a href="sign_up.html"  class="am-btn am-btn-primary am-btn-sm" style="background-color:mediumpurple;border-color:mediumpurple">我要注册 </a>
    </div>
    <br>
    <br>

    <form method="post" class="am-form" action="admin/access" >
<!--       <label id="lableemail" for="email">邮箱:</label>
      <input type="email" name="email" id="email" value="" >
      <label id="labletelephonePhone" for="telephonePhone" style="display: none">手机号:</label>
      <input type="tel" name="telephonePhone" id="telephonePhone" style="display: none" value=""> -->
      
      <label id="lableuserName" for="userName" style="display: none">账号:</label>
      <input type="text" name="userName" id="userName" value="" style="display: block;">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" value="">
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
        记住密码
      </label>
      <br />
      <div class="am-cf">
        <input type="submit"  value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="button"  value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>

    <hr>
    <p>© 2017--专属你的工作助手</p>
  </div>
</div>
</body>
</html>
