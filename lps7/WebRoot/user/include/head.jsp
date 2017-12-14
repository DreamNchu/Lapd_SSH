<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="am-container-1">
        <div class="left hw-logo">
            <lable  style="margin-left: 15px;font-size: 250%">★</lable>
            <lable  style="margin-left: 5px;font-size: 250%;font-family: 仿宋">小店helper</lable>
        </div>
        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
                data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
                class="am-icon-bars"></span></button>
        <div class="am-collapse am-topbar-collapse right" id="doc-topbar-collapse">
            <div class=" am-topbar-left am-form-inline am-topbar-right" role="search">
                <ul class="am-nav am-nav-pills am-topbar-nav hw-menu">
                	<li id="mainModel" >
                		<a href="main">个人中心</a></li>
                    <li id="workManageModel" >
                    	<a href="manageOrdersPage">工作模板</a></li>
                    <li id="workTableModel">
                    	<a href="workTableAnalyze">工作报表</a></li>
                    <li id="workRankModel">
                    	<a href="workRankPage">上钟排名 </a></li>
                    <li id="userDataModel">
                    	<a href="userData">我的资料</a></li>
                    <li id="userModifyDataModel">
                    	<a href="modifyUserDataPage">修改资料</a></li>
                    <li ><a href="logout">退出</a></li>
                </ul>
            </div>
        </div>
    </div>