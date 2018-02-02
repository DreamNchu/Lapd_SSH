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
    <link rel="stylesheet"href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/headCSS.js"></script>
    <script src="../js/ajax_js.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		setHeadCSS("chartAnalyzeModel");
    	})
        window.onload=function () {
            var lis=document.getElementById("lis").getElementsByTagName("li");
            var today=document.getElementById("today");
            var week=document.getElementById("week");
            var month=document.getElementById("month");
            var year=document.getElementById("year");
            var query=document.getElementById("equry");
            today.style.display="block";
            week.style.display="none";
            month.style.display="none";
            year.style.display="none";
            query.style.display="none";
            ajaxRequest("chartDataOrders?orderChartRequestDto.timeType=1",todayChart);
            lis[0].onclick=function () {
                lis[0].className="active";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="";
                today.style.display="block";
                week.style.display="none";
                month.style.display="none";
                year.style.display="none";
                query.style.display="none";
                ajaxRequest("chartDataOrders?orderChartRequestDto.timeType=1",todayChart);
            }
            lis[1].onclick=function () {
                lis[0].className="";
                lis[1].className="active";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="";
                today.style.display="none";
                week.style.display="block";
                month.style.display="none";
                year.style.display="none";
                query.style.display="none";
                ajaxRequest("chartDataOrders?orderChartRequestDto.timeType=2",weekChart);
            }
            lis[2].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="active";
                lis[3].className="";
                lis[4].className="";
                today.style.display="none";
                week.style.display="none";
                month.style.display="block";
                year.style.display="none";
                query.style.display="none";
                ajaxRequest("chartDataOrders?orderChartRequestDto.timeType=3",monthChart);
            }
            lis[3].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="active";
                lis[4].className="";
                today.style.display="none";
                week.style.display="none";
                month.style.display="none";
                year.style.display="block";
                query.style.display="none";
                 ajaxRequest("chartDataOrders?orderChartRequestDto.timeType=4",yearChart);
            }
            lis[4].onclick=function () {
                lis[0].className="";
                lis[1].className="";
                lis[2].className="";
                lis[3].className="";
                lis[4].className="active";
                today.style.display="none";
                week.style.display="none";
                month.style.display="none";
                year.style.display="none";
                query.style.display="block";
            }
        }

    </script>
    <script>
    /*     var serrie={
            "income":[50,20,30,60,70]
        }; */
       /*   var categories3=['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15', '16', '17', '18', '19', '20', '21',
                             '22', '23', '24', '25', '26', '27', '28','29', '30', '31'];
        */
        
        var todayCategories=['12', '13', '14', '15', '16', '17', '18', '19', '20','21','22','23', '24'];
        var weekCategories=['周一', '周二', '周三', '周四', '周五', '周六', '周日'];
        var monthCategories=['1', '2', '3', '4', '5', '6', '7','8', '9', '10', '11', '12', '13', '14','15', '16', '17', '18', '19', '20', '21',
                             '22', '23', '24', '25', '26', '27', '28','29', '30', '31'];
        var yearCategories=['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'];
        function todayChart(serrie){
            var chart = Highcharts.chart('today', {
            title: {
                text: '个人今日收益报表图',
                style:{
                    color:'blue',
                    fontFamily:'楷体',
                }
            },
            xAxis: {
                categories: todayCategories
            },
            yAxis: {
                title: {
                    text: ' 收益/元',
                 },
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true ,
                        style:{
                             color:'blue',
                        }
                    },
                enableMouseTracking: true
                 }
            },
            series: [{
                name: '收益',
                 data: serrie.income,
            }],
            credits: {
                text: '',
             },
            responsive: {
                    rules: [{
                            condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                 layout: 'horizontal',
                                 align: 'center',
                                 verticalAlign: 'bottom'
                             }
                         }
                    }]
                 }
            });
         }
        function weekChart(serrie){
            var chart = Highcharts.chart('week', {
                title: {
                    text: '个人本周收益报表图',
                    style:{
                        color:'blue',
                        fontFamily:'楷体',
                    }
                },
                xAxis: {
                    categories: weekCategories
                },
                yAxis: {
                    title: {
                        text: ' 收益/元',
                    },
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true ,
                            style:{
                                color:'blue',
                            }
                        },
                        enableMouseTracking: true
                    }
                },
                series: [{
                    name: '收益',
                    data: serrie.income,
                }],
                credits: {
                    text: '',
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }
        function monthChart(serrie){
            var chart = Highcharts.chart('month', {
                title: {
                    text: '个人 本月收益报表图',
                    style:{
                        color:'blue',
                        fontFamily:'楷体',
                    }
                },
                xAxis: {
                    categories: monthCategories
                },
                yAxis: {
                    title: {
                        text: ' 收益/元',
                    },
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true ,
                            style:{
                                color:'blue',
                            }
                        },
                        enableMouseTracking: true
                    }
                },
                series: [{
                    name: '收益',
                    data: serrie.income,
                }],
                credits: {
                    text: '',
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }
        function yearChart(serrie){
            var chart = Highcharts.chart('year', {
                title: {
                    text: '个人今年收益报表图',
                    style:{
                        color:'blue',
                        fontFamily:'楷体',
                    }
                },
                xAxis: {
                    categories: yearCategories
                },
                yAxis: {
                    title: {
                        text: ' 收益/元',
                    },
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true ,
                            style:{
                                color:'blue',
                            }
                        },
                        enableMouseTracking: true
                    }
                },
                series: [{
                    name: '收益',
                    data: serrie.income,
                }],
                credits: {
                    text: '',
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }
        function seekChart(){

        }
    </script>
</head>
<body>
<header class="am-topbar header">
   <jsp:include page="include/head.jsp"></jsp:include>
</header>
<div class="toppic" style="background-image: url('img/gzbb.jpg')">
    <div class="am-container-1">
        <div class="toppic-title left">
            <span class="toppic-title-span" ></span>
        </div>
    </div>
</div>

<div class=" am-container-1">
    <div class="container">
        <div class="row">
            <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <ul id="lis" class="nav nav-tabs" style="font-size: 3px;width: 100%">
                    <li class="active"><a href="javascript:void(0)" style="font-size: 15px">日报表</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">周报表</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">月报表</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">年报表</a></li>
                    <li ><a href="javascript:void(0)" style="font-size: 15px">查询</a></li>
                </ul>
            </div>
            <div id="today" class="col-xs-11 col-xs-offset-0 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <script>
                    todayChart(serrie);
                </script>
            </div>
            <div id="week" class="col-xs-11 col-xs-offset-0 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <script>
                     weekChart(serrie);
                </script>
            </div>
            <div id="month" class="col-xs-11 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <script>
                    monthChart(serrie);
                </script>
            </div>
            <div id="year" class="col-xs-11  col-sm-8 col-sm-offset-1 col-md-8 col-md-offset-2">
                <script>
                    yearChart(serrie);
                </script>
            </div>
            <div id="equry" class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
                <form id="seekForm">
                    <div class="form-group">
                        <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2" style="margin-bottom: 15px">
                            <select class="form-control" id="selectdate">
                                <option value="1">一天</option>
                                <option value="2">七天</option>
                                <option value="3">三十天</option>
                            </select>
                        </div>
                        <div class="col-xs-12  col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2" style="margin-bottom: 15px">
                            <input type="date" name="date" class="form-control" placeholder="选择其实日期 ">
                        </div >
                        <div class="col-xs-6 col-xs-offset-4 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2" style="margin-bottom: 15px">
                            <input type="button" onclick="seekChart()" class="btn btn-primary" value="&nbsp;查询&nbsp;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<!--[if lt IE 9]>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="js/amazeui.min.js"></script>
<!--[if (gte IE 9)|!(IE)]><!-->

</html>
