<%@ page language="java" pageEncoding="UTF-8"%><%
	StringBuffer basePath = request.getRequestURL();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>公司简介</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="js/initClass.js"></script>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
    <script type="text/javascript">
    
 		 window.onload=function () {
            initActive();
        }
        $(document).ready(function () {
        	initActive();
            $('#hrefLink li a').ready(function () {
                $('#hrefLink li').removeClass('active');
            })
            $('#hrefLink li').each(function () {
                alert(str[parseInt($(this).val())-1]);
                alert( window.location.pathname);
                if(str[parseInt($(this).val())-1]==window.location.pathname){
                    $(this).addClass("active");
                }
            })
        })
    </script>
<body class="hold-transition skin-blue  sidebar-mini">
<div class="wrapper">
    <header class="main-header" style="background-color: #333333">
        <jsp:include page="header.jsp"/>
    </header>
    <aside class="main-sidebar" style="background-color: #555555">
      <jsp:include page="left.jsp"/>
    </aside>

    <div class="content-wrapper" >
    <div  align="center">
    	<img style="margin:20px auto" alt="" src="image/companyProfile.jpg">
    </div>
       <!-- 	<p style="font-family: 仿宋;font-size: 20px" style="margin:100px">
        
        </p> -->
    </div>


    <aside class="control-sidebar control-sidebar-dark">
        <jsp:include page="right.jsp"/>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
</body>
</html>