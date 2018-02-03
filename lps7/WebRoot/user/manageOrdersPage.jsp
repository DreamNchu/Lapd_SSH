<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
StringBuffer basePath = request.getRequestURL();
%>

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
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="alternate icon" type="img/hengwang-1.png" href="img/hengwang-1.png">
    <link rel="stylesheet" href="css/amazeui.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/orderManage.js"></script>
    <script src="../js/ajax_js.js"></script>
    <script src="js/headCSS.js"></script>
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		
    		setHeadCSS("workManageModel");
    		
    	})
    
        window.onload=function () {
        	//先请求待接收订单
        	 ajaxRequest("queryOrders?userOrderRequestDto.statusId=1", singleOrder);
        
        	var accept=document.getElementById("accept");
            var working=document.getElementById("working");
            var notpay=document.getElementById("notpay");
            var paying=document.getElementById("paying");
            var income=document.getElementById("income");
            var lis=document.getElementById("lis").getElementsByTagName("li");
            
			working.style.display="none";
            notpay.style.display="none";
            paying.style.display="none";
            income.style.display="none";
            lis[0].onclick = function () {
                lis[0].className="active";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="";
                accept.style.display="block";
                working.style.display="none";
                notpay.style.display="none";
                paying.style.display="none";
                income.style.display="none";
              
               ajaxRequest("queryOrders?userOrderRequestDto.statusId=1", singleOrder);
               
            }
            lis[1].onclick=function () {
                lis[0].className="";
                lis[1].className="active";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="";
                accept.style.display="none";
                working.style.display="block";
                notpay.style.display="none";
                paying.style.display="none";
                income.style.display="none";
                ajaxRequest("queryOrders?userOrderRequestDto.statusId=2", singleOrder);
            }
            lis[2].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="active";
                lis[3].className="";
                lis[4].className="";
                accept.style.display="none";
                working.style.display="none";
                notpay.style.display="block";
                paying.style.display="none";
                income.style.display="none";
                ajaxRequest("queryOrders?userOrderRequestDto.statusId=3",waitingPayUser);
                
            }
            lis[3].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="active";
                lis[4].className="";
                accept.style.display="none";
                working.style.display="none";
                notpay.style.display="none";
                paying.style.display="block";
                income.style.display="none";
                ajaxRequest("queryOrders?userOrderRequestDto.statusId=4", finish);
            }
             lis[4].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="active";
                accept.style.display="none";
                working.style.display="none";
                notpay.style.display="none";
                paying.style.display="none";
                income.style.display="block";
            } 
        }
        
        
        
    </script>
</head>
<body>
<header class="am-topbar header">
    <jsp:include page="include/head.jsp"></jsp:include>
</header>
<div class="toppic" style="background-image: url('img/gzmk.jpg')">
    <div class="am-container-1" >
        <div class="toppic-title left">
            <span class="toppic-title-span"></span>
        </div>
    </div>
</div>

<div class=" am-container-1">
    <div class="container">
        <div class="row">
            <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <ul id="lis" class="nav nav-tabs" style="font-size: 5px;width: 104%">
                    <li class="active"><a href="javascript:void(0)" style="font-size: 15px">待接收</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">工作中</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">待付款</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">已支付</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px"><!-- 日收益 --></a></li>
                </ul>
            </div>
            <div id="accept" class="col-xs-12 col-xs-offset-0 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" >
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>内容</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>订单编号：</td>
                        <td id="waitingOrderId" class="orderId"></td>
                    </tr>
                    <tr>
                        <td>房间号：</td>
                        <td class="room"></td>
                    </tr>
                    <tr>
                        <td>下单时间：</td>
                        <td class="initTime"></td>
                    </tr>
                    <tr>
                        <td>所需项目：</td>
                        <td class="serverItem"></td>
                    </tr>
                    <tr>
                        <td>钟点类型：</td>
                        <td class="clockCategory"></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-primary" type="button" value="接受" onclick="acceptOrder()"></td>
                        <td><input class="btn btn-warning" type="button" value="拒绝" onclick="refuseform()"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="working" class="col-xs-12  col-xs-offset-0 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" >
                    <tbody>
                     <tr>
                         <td><b>名称</b></td>
                         <td colspan="4" ><b>内容</b></td>
                    <tr>
                        <td>订单编号：</td>
                        <td class="orderId" colspan="4" id="servicingOrderId"></td>
                    </tr>
                    <tr>
                        <td>房间号：</td>
                        <td class="room" colspan="4" ></td>
                    </tr>
                    <tr>
                        <td>开始时间：</td>
                        <td class="initTime" colspan="4" ></td>
                    </tr>
                    <tr>
                        <td>所选项目：</td>
                        <td class="serverItem" colspan="4" ></td>
                    </tr>
                    <tr>
                        <td>工作类型</td>
                        <td class="clockCategory" colspan="4" ></td>
                    </tr>
                    <tr>
                    	<td>服务金额</td>
                    	<td class="pay" colspan="4"  ><input type="text" name="pay" id="pay"></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-primary" type="button" value="完成工作" onclick="completeWork()"></td>
                        <td colspan="4" ><input class="btn btn-warning" type="button" value="终止工作" onclick="stopWork()"></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div id="notpay" class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" >
                    <thead >
                    <tr>
                        <th>房间</th>
                        <th>项目</th>
                        <th>完成时间</th>
                        <th>类型</th>
                        <th>需付 </th>
                    </tr>
                    </thead>
                    <tbody id="waitingPay">
                    </tbody>
                </table>
            </div>
            <div id="paying" class="col-xs-12 col-xs-offset-0 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" >
                    <thead >
                    <tr >
                        <th>房间</th>
                        <th>项目</th>
                        <th>类型</th>
                        <th>需付 </th>
                        <th>实付</th>
                    </tr>
                    </thead>
                    <tbody id="finish">
                    </tbody>
                </table>
            </div>
            <div id="income" class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <table class="table" >
                    <thead >
                    <tr>
                        <th>点钟数</th>
                        <th>排钟数</th>
                        <th>服务收益 </th>
                        <th>实际收益 </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td id="spotNum">5</td>
                        <td id="rankNum">12</td>
                        <td id="companyIncome">500元</td>
                        <td id="mineIncome">480元</td>
                    </tr>
                    </tbody>
                </table>
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
