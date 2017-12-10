    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
   <%--          <%
StringBuffer basePath = request.getRequestURL();
%> --%>
    <a href="" class="logo" style="background-color: #333333">
        <span class="logo-mini"><b>☆</b></span>
        <span class="logo-lg"><b> 小店助手</b></span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation" style="background-color: #555555">
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button"></a>
        <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
        <li class="dropdown messages-menu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-envelope-o" ></i>
        <span class="label label-success"></span>
        </a>
        <ul class="dropdown-menu">

        </ul>
        </li>
        <li class="dropdown notifications-menu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-bell-o"></i>
        <span class="label label-warning"></span>
        </a>
        <ul class="dropdown-menu">

        </ul>
        </li>
        <li class="dropdown tasks-menu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <i class="fa fa-flag-o"></i>
        <span class="label label-danger"></span>
        </a>
        <ul class="dropdown-menu">
        <li>
        <ul class="menu">

        </ul>
        </li>
        </ul>
        </li>
        <li class="dropdown user user-menu">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
        <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
        <span class="hidden-xs"><s:property value="#session.userName"/></span>
        </a>
        <ul class="dropdown-menu" >
        <li class="user-header">
        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </br>
        <lable style="font-family: 楷体"></lable>
        </br>注册时间2017-12-11
        </li>
        </ul>
        </li>
        <li>
        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
        </li>
        </ul>
        </div>
        </nav>