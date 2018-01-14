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
        <li value="1" id="initOrder">
          <a href="initOrder"><i class="glyphicon glyphicon-th-large"></i><span>发布订单</span></a>
        </li>
        <li value="2"  id="payOrderPage">
          <a href="payOrderPage"><i class="glyphicon glyphicon-usd"></i><span>支付收银</span></a>
        </li>
        <li value="3" id="workRankPage">
          <a href="workRankPage"><i class="glyphicon glyphicon-align-left"></i><span>员工排名</span></a>
        </li>
        <li value="4"  id="orderManage">
          <a href="orderManage"><i class="glyphicon glyphicon-list-alt"></i><span>订单管理</span></a>
        </li>
        <li value="5" id="userManage">
          <a href="userManage"><i class="glyphicon glyphicon-user"></i><span>员工管理</span></a>
        </li>
        <li value="6" id="roomManage">
        	<a href="roomManage"><i class="fa fa-university"></i><span>房间管理</span></a>
        </li>
        <li value="7" id="medicineManage">
        	<a href="medicineManage"><i class="fa fa-medkit"></i><span>药品管理</span></a>
        </li>
        <li value="8" id="orderChart">
          <a href="orderChart"><i class="glyphicon glyphicon-signal"></i><span>图表分析</span></a>
        </li>
        <li value="9" id="companyProfile">
          <a href="companyProfile"><i class="glyphicon glyphicon-home"></i><span>公司简介</span></a>
        </li>
        <li value="10" >
          <a href="logout"><i class="glyphicon glyphicon-remove"></i><span>注销用户</span></a>
        </li>
      </ul>
    </section>