<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'All.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="admin/bower_components/jquery/dist/jquery.min.js"></script>
</head>

	<style type="text/css">
	
	body{
	width:100%;
	}
	
	.save{
		width:500px;
	}
	</style>
	
	<script type="text/javascript">
	
		$(".delete").click(function(){
			
		})
	
	</script>

<body>
	<form action="save" method="get">
		<table class="save">
			<tr>
				<th>住房编号</th>
				<th>登录密码</th>
				<th>业主姓名</th>
				<th>性别</th>
				<th>职业</th>
				<th>入住时间</th>
				<th>住房面积</th>
				<th>常住人口数</th>
				<th>联系电话</th>
			</tr>
			<tr>
				<td><input type="text" name="test.num" /></td>
				<td><input type="password" name="test.password" /></td>
				<td><input type="text" name="test.name" /></td>
				<td><input type="text" name="test.sex" /></td>
				<td><input type="text" name="test.profession" /></td>
				<td><input type="date" name="test.liveTime" /></td>
				<td><input type="number" step="0.01" name="test.area" /></td>
				<td><input type="number" name="test.livePeople" /></td>
				<td><input type="text" name="test.phoneNum" /></td>
			</tr>
		</table>
		<input type="reset" value="重置"> 
		<input type="submit" value="存储">
	</form>
	<table>
		<tr>
			<th>住房编号</th>
			<th>登录密码</th>
			<th>业主姓名</th>
			<th>性别</th>
			<th>职业</th>
			<th>入住时间</th>
			<th>住房面积</th>
			<th>常住人口数</th>
			<th>联系电话</th>
		</tr>
		<!-- 	private int id;
	
	private String num;
	
	private String password;
	
	private String name;
	
	private String sex;
	
	private String profession;
	
	private Date liveTime;
	
	private Float area;
	
	private int livePeople;
	
	private String phoneNum; -->
		<s:iterator value="tests">
			<tr>
				<input type="hidden" name="id"
					value="<s:property value="id"/>">
				<td><s:property value="num" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="profession" /></td>
				<td><s:property value="liveTime" /></td>
				<td><s:property value="area" /></td>
				<td><s:property value="livePeople" /></td>
				<td><input type="button" key="<s:property value="id"/>" class="delete" value="删除"></td>
				<td><input type="button" key="<s:property value="id"/>" class="update" value="更新"></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
