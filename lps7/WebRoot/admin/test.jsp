<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	StringBuffer basePath = request.getRequestURL();
%>
<s:debug></s:debug>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>点钟手发</title>
</head>

<body class="hold-transition skin-red  sidebar-mini">

	<form id="createOrder" method="post">
			<input name="userName" />
			<input name="password" />
		    <input type="button" onclick="submitOrder()" value="发布">
	</form>

	<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script type="text/javascript">

	function submitOrder() {
		var AjaxURL = "test";
		alert($('#createOrder').serialize());
		$.ajax({
			type : "POST",
			dataType : "json",
			url : AjaxURL,
			data : $('#createOrder').serialize(),
			success : function(data) {
				var strresult = data;
				alert(strresult);
			},
			error : function(data) {
				alert("error:" + data.responseText);
			}
		});


	/*   //下面这个是我们上传时候用到的对象，这里一定要注意的是，我们后台用的是类对象去接受这些上传的数据
	  //所以里面的属性名要写成Action里的'对象名.属性名'，千万别直接写成'属性名'，不然后台那个对象接收不到
	  var mytest={
	      'mytest.username':$('#username').val(),
	      'mytest.password':$('#pass').val()
	  }; */
	/*  $.ajax({
	     url:'usertest.action',
	     type:'post',
	     data:mytest,
	     dataType:"json",
	     success:function(data){
	         //有时候感觉接受的数据总是显示各种乱七八糟的错误，你可以先alert看下，传回的是什么东西
	         alert(data);
	         //随便的显示一下传回的数据喽
	         var backdata=JSON.parse(data); //传回的是json字符串，要先把它转换成js中的类对象，对于json字符串和json对象自己去百度
	         $('#backusername').html(backdata.backusername);//将json字符串转换成json对象后，就可以这样获取其中的值。
	         $('#backpassword').html(backdata.backpassword);
	     }
	 }); */
	}
	/* 
	 $('#createOrder').submit(function() {
	            var AjaxURL= "createOrder";       
	            alert($('#createOrder').serialize());
	                $.ajax({
	                    type: "POST",
	                    dataType: "json",
	                    url: AjaxURL,
	                    data: $('#createOrder').serialize(),
	                    success: function (data) {
	                        var strresult=data;
	                        alert(strresult);
	                    },
	                    error: function(data) {
	                        alert("error:"+data.responseText);
	                     }
	                });
	        }
	    ); */
</script>
</body>
</html>