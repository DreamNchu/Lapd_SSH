<%@ page language="java" pageEncoding="UTF-8"%>
<%
	StringBuffer basePath = request.getRequestURL();
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>房间管理</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
    <script src="js/roomJs.js"></script>
    <script type="js/testInput.js"></script>
    <script src="../js/ajax_js.js"></script>
    <script src="js/initClass.js"></script>
    <script type="text/javascript">
     	window.onload=function () {
            //initActive();
            initBasicClass("roomManage");
            initTime();
      
           ajaxRequest("queryRoomsByPage?pageUtil.page=1" ,showData);		//  请求第一页的房间信息
        }
        
        function sureRevise(){
        	alert(document.getElementById("myModalLabel").innerHTML=="修改信息");
        	if(document.getElementById("myModalLabel").innerHTML=="修改信息"){
        		sureReviseEdit();
        	}else{
        		sureReviseAdd();
        	}
        }
        function  sureReviseAdd() {		//  增加房间
            bootbox.confirm({
                message:"确认执行此操作？",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("addRoom","roomForm",reQueryBasic);
                    }
                }
            });
        }
        
         function  sureReviseEdit() {		
            bootbox.confirm({
                message:"确认执行此操作？",
                callback :function (result) {
                    if(result==true){
                        ajaxRequest('queryBasicUser',showdata);
                    }
                }
            });
        }
        
        function deleteRoom() {			//  删除房间
            var roomArray=document.getElementsByName("roomIds");
            var i;
            alert(roomArray.length);
            for(i = 0; i < roomArray.length; i++){
                if(roomArray[i].checked == true){
                    break;
                }
                if(i == roomArray.length-1){
                    bootbox.alert("请选择房间",function () {});
                    return ;
                }
            }
            bootbox.confirm({
                message:"是否删除选中数据",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEvent("deleteRooms","roomShow",reQueryBasic);
                    }
                }
            });
        }
       
		
        function addRoom(){		//  增加房间
        	var roomId=document.getElementById("roomId");
            var roomName=document.getElementById("roomName");
            var customerNum=document.getElementById("customerNum");
            var roomSize=document.getElementById("roomSize");
            roomId.value="";
            roomName.value="";
            customerNum.value="";
            roomSize.value="";
            document.getElementById("myModalLabel").innerHTML="增加房间";
        }
        
        function editRoom() {		//  修改房间
            var roomArray=document.getElementsByName("roomIds");
            var i,count = 0,op;
            for(i = 0; i < roomArray.length; i++){
                if(roomArray[i].checked == true){
                    count++;
                    if(count==2){
                        bootbox.alert("只能选择一个房间修改",function () {});
                        return false;
                    }
                }
                if(i == roomArray.length-1 && count==0){
                    bootbox.alert("至少选择一个房间",function () {});
                    return false;
                }
            }
            document.getElementById("myModalLabel").innerHTML="修改信息";
            formSubmitWithEventData("queryRoom", "roomShow" ,queryRoom);
            //ajaxRequest("queryRoom?roomId="+roomArray[0].value, queryRoom);
        }
        
        function queryRoom(roomData){			//  显示房间信息
       /*  var userData={
                "user":[{"workId":"workId1","realName":"realName1","userName":"userName1","birthday":"birthday1","telephonePhone":"telephonePhone1","email":"email1","address":"address1","question":"question1","answer":"answer1","registerTime":"registerTime1","IDCardNo":"IDCardNo1"}]
            } */
            var roomId=document.getElementById("roomId");
            var roomName=document.getElementById("roomName");
            var customerNum=document.getElementById("customerNum");
            var roomSize=document.getElementById("roomSize");
            
            roomId.value=roomData.roomId;
            roomName.value=roomData.roomName;
            customerNum.value=roomData.customerNum;
	        roomSize.value=roomData.roomSize;
	        
	        $("#roomFloor option[text='"+ roomData.roomFloor +"']").attr("selected", true); //设置Select的Text值为"+ roomFloor +"的项选中 
	        $("#roomCategory option[text='"+ roomData.roomCategory +"']").attr("selected", true);
	        $("#isFree option[text='"+ roomData.isFree +"']").attr("selected", true);
	        $("#isClean option[text='"+ roomData.isClean +"']").attr("selected", true);
    		$("#myModal").modal("show");
        }
        
        function initTime() {
            var currentTime=document.getElementById("currentTime");
            var myDate=new Date();
            currentTime.innerHTML=myDate.toLocaleDateString()+"--"+myDate.toLocaleTimeString();
            setTimeout("initTime()",1000);
        }
        
         function reQueryBasic(){
        	alert(444);
			deleteLi();
        	deleteTr();
			ajaxRequest("queryRoomsByPage?pageUtil.page=1",showData);
		}
        
    </script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header" style="background-color: #333333">
        <jsp:include page="include/header.jsp"/>
    </header>
    <aside class="main-sidebar" style="background-color: #555555">
     <jsp:include page="include/left.jsp"/>
    </aside>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                房间管理
            </h1>
        </section>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <button class="btn btn-success" id="addbutton" onclick="addRoom()" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>增加房间</button>
                            <button class="btn btn-danger" id="divisonbutton" onclick="deleteRoom()"><span class="glyphicon glyphicon-remove"></span>删除房间</button>
                            <button class="btn btn-warning" id="editbutton" onclick="editRoom()"><span class="glyphicon glyphicon-wrench"></span>修改房间</button>
                            <button class="btn btn-primary" id="allChecked" onclick="allChecked()"><span class="glyphicon glyphicon-ok"></span>全选</button>
                            <button class="btn btn-primary" id="allUnChecked" onclick="allUnChecked()"><span class="glyphicon glyphicon-remove"></span>全不选</button>
                            <button class="btn btn-primary" id="opposeChecked" onclick="opposeChecked()"> <span class="glyphicon glyphicon-refresh"></span>反选</button>
                            <button class="btn btn-info" id="exportChecked"onclick="exportChecked()"><span class="glyphicon glyphicon-download-alt"></span>导出Excel</button>
                           
                        </div>
                        <div class="box-body table-responsive no-padding">
                            <form id="roomShow">
	                            <table class="table table-hover" id="dataTable">
	                                    <th></th>
	                                    <th>房间号</th>
	                                    <th>房间人数</th>
	                                    <th>所在楼层</th>
	                                    <th>房间类型</th>
	                                    <th>房间大小</th>
	                                    <th>是否空闲</th>
	                                    <th>是否打扫</th>
	                            </table>
                            </form>
                            <div class="box-footer clearfix">
                                <label style="font-family: 仿宋;color: #4cae4c;font-size: 20px">共<span id="allCount"></span>条数据-共<span id="allPage"></span>页-当前第<span id="currentPage"></span>页</label>
                                <ul id="hrefId" class="pagination pagination-sm no-margin pull-right">
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            	修改房间
                        </h4>
                    </div>
                    <form id="roomForm" action="post">
                        <div class="modal-body">
                            <div class="form-group" >
                                <label>房间号</label>
                                <input type="number" name="data.roomName" id="roomName" class="form-control">
                                <label>房间大小</label>
                                <input type="number" name="data.roomSize" id="roomSize" class="form-control">
                                <label>房间人数</label>
                                <input type="number" name="data.customerNum" id="customerNum" class="form-control">
                               	<label>所在楼层</label>
                                <select name="data.roomFloor" id="roomFloor" class="form-control">
                                	<option value="1">1 楼</option>
                                	<option value="2">2 楼</option>
                                	<option value="3">3 楼</option>
                                	<option value="4">4 楼</option>
                                	<option value="5">5 楼</option>
                                </select>
                                <label>房间类型</label>
                                <select name="data.roomCategoryId" id="roomCategory" class="form-control">
                                	<option value="1">洗脚</option>
                                	<option value="2">按摩</option>
                                	<option value="3">澡堂</option>
                                </select>
                                <label>是否空闲</label>
                                <select name="data.isFree" id="isFree" class="form-control">
                                	<option value="true">空闲</option>
                                	<option value="false">在使用</option>
                                </select>
                                <label>是否打扫</label>
                                <select name="data.isClean" id="isClean" class="form-control">
                                	<option value="true">已打扫</option>
                                	<option value="false">未打扫</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <input type="button" onclick="sureRevise()" value="确定" class="btn btn-primary">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>
    <aside class="control-sidebar control-sidebar-dark">
        <jsp:include page="include/right.jsp"/>
    </aside>
    <div class="control-sidebar-bg"></div>
</div>


<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="js/bootbox.min.js"></script>
</body>
</html>