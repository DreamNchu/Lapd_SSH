  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
  <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><s:property value="#session.userName"/></p>
          <a href="#"><i class="fa fa-circle text-success"></i>空闲</a>
        </div>
      </div>
      <ul class="sidebar-menu" name="hrefLink" data-widget="tree">
        <li value="1" name="activeLi">
          <a href="initOrder"><i class="glyphicon glyphicon-th-large"></i><span>发布订单</span></a>
        </li>
        <li value="2" name="activeLi">
          <a href="orderManage"><span class="glyphicon glyphicon-list-alt"></span><span>订单管理</span></a>
        </li>
        <li value="3" name="activeLi">
          <a href="userManage"><span class="glyphicon glyphicon-user"></span><span>员工管理</span></a>
        </li>
        <li value="4" name="activeLi">
          <a href="orderChart"> <span class="glyphicon glyphicon-signal"></span><span>图表分析</span></a>
        </li>
        <li value="5" class="active" name="activeLi">
          <a href="companyProfile"> <span class="glyphicon glyphicon-home"></span><span>公司简介</span></a>
        </li>
        <li value="6" >
          <a href="logout"><span class="glyphicon glyphicon-remove"></span><span>注销用户</span></a>
        </li>
      </ul>
    </section>