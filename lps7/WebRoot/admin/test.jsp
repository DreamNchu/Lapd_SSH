<%@ page language="java" 
	pageEncoding="utf-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<a href="#">Error</a>
<s:debug></s:debug>