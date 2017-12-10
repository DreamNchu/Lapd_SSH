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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
    <script type="text/javascript">
        var str=new Array('/YQB_qianduan1.1.2/fbdd.html','/YQB_qianduan1.1.2/ddqk.html','/YQB_qianduan1.1.2/yggl.html'
            ,'/YQB_qianduan1.1.2/tbfx.html','/YQB_qianduan1.1.2/gsjj.html');
        $(document).ready(function () {
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

    <div class="content-wrapper">
        <pre style="font-family: 仿宋;font-size: 20px" >
            香港世界通国际科技有限公司成立于2007年初，总部位于香港，由美国IT领域实力雄厚的投
            资集团与资深IT人士戴兵先生联合投资创建而成，目前旗下已拥有海南世纪通网络信息科技
            有限公司、世界通信息科技（长春）有限公司、海南世界通信息科技投资有限公司等多家子
            公司，以及中国大陆、东南亚等国家多个办事处。世界通国际第一阶段所推出的Link World
            手机增值服务软件产品，由世界通软件研发中心经三年苦心钻研、反复检测验证而成功推出
            的一款手机无线流媒体信息交流与播放软件，为世界通数码经济平台的第一款智能化软件产
            品，集文件压缩传输（短信、图片、语音、视频等信息或文件）、视频对聊，无线影音娱乐
            、手机广告播放与收看等增值技术或服务功能于一体，可实现对各种电子文件的高倍压缩与
            快速传输 ，已在香港申请L-WORLD软件的知识产权保护，亦在中国大陆申请获得海南省增值
            电信业务经营许可证（琼B2-20080015 ），申请获得广电总局颁发、海南省文体厅主管的广
            播电视节目制作经营许可证（琼第038号）,并于2007年11月获得国家工商总局审核批准的“
            外企常驻代表机构登 记证”，目前，由国家工业与信息化部颁发的全国电信增值业务许可
            证、文化部颁发的网络文化许可证、国家食品药品监督管理局颁发的互联网药品信息服务许
            可证书正在受理中，国家工业和信息化部对软件的积极验证亦正在评估之中。
        </pre>
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