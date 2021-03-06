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
    <title>员工管理</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="js/userJs.js"></script>
    <script src="../js/ajax_js.js"></script>
    <script src="js/initClass.js"></script>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <script type="text/javascript">
     	window.onload=function () {
            //initActive();
                initBasicClass("userManage");
            initTime();
      
           ajaxRequest("queryBasicUser?pageLinkTransformUserDto.page=1" ,showdata);
        }
    
        function receiveData() {
            showdata(userData);
        }
        
        function sureRevise(){
        	alert(document.getElementById("myModalLabel").innerHTML=="修改信息");
        	if(document.getElementById("myModalLabel").innerHTML=="修改信息"){
        		sureReviseEdit();
        	}else{
        		sureReviseAdd();
        	}
        }
        function  sureReviseAdd() {
            bootbox.confirm({
                message:"确认执行此操作？",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("addUser","userForm",reQueryBasic);
//                        ajaxRequest('queryBasicUser',showdata);
                    }
                }
            });
        }
        
         function  sureReviseEdit() {
            bootbox.confirm({
                message:"确认执行此操作？",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("updateUser","userForm",reQueryBasic);
                     //   ajaxRequest('queryBasicUser',showdata);
                    }
                }
            });
        }
        
        function deleteUser() {
            var userArray=document.getElementsByName("userId");
            var i;
            for(i=0;i<userArray.length;i++){
                if(userArray[i].checked==true){
                    break;
                }
                if(i==userArray.length-1){
                    bootbox.alert("请选择员工",function () {});
                    return ;
                }
            }
            bootbox.confirm({
                message:"是否删除选中数据",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("deleteUsers","userShow",reQueryBasic);
                        //ajaxRequest('queryBasicUser',reQueryBasic);
                    }
                }
            });
        }
        function reQueryBasic(data){
            alertBasicMsg(data);
			deleteLi();
        	deleteTr();
			ajaxRequest("queryBasicUser",showdata);
		}
        
        function editUser() {
            var userArray=document.getElementsByName("stuffId");
            var i,count=0,op;
           // alert(userArray.length);
            for(i=0;i<userArray.length;i++){
                if(userArray[i].checked==true){
                    count++;
                    if(count==2){
                        bootbox.alert("只能选择一个员工修改",function () {});
                        return false;
                    }
                }
                if(i==userArray.length-1&&count==0){
                    bootbox.alert("至少选择一个员工",function () {});
                    return false;
                }
            }
            
            document.getElementById("myModalLabel").innerHTML="修改信息";
            formSubmitWithEventData("queryUser", "userShow" ,queryUser);
            
        }
        
        function queryUser(userData){
       /*  var userData={
                "user":[{"workId":"workId1","realName":"realName1","userName":"userName1","birthday":"birthday1","telephonePhone":"telephonePhone1","email":"email1","address":"address1","question":"question1","answer":"answer1","registerTime":"registerTime1","IDCardNo":"IDCardNo1"}]
            } */
            var userId=document.getElementById("userId");
            var workId=document.getElementById("workId");
            var realName=document.getElementById("realName");
            var userName=document.getElementById("userName");
            var birthday=document.getElementById("birthday");
            var telephonePhone=document.getElementById("telephonePhone");
            var email=document.getElementById("email");
            var address=document.getElementById("address");
            var question=document.getElementById("question");
            var answer=document.getElementById("answer");
            var registerTime=document.getElementById("registerTime");
            var IDCardNo=document.getElementById("IDCardNo");
            userId.value=userData.stuffId;
            workId.value=userData.workId;
            realName.value=userData.realName;
            userName.value=userData.userName;
            birthday.value=userData.birthday;
            telephonePhone.value=userData.telephonePhone;
            email.value=userData.email;
            address.value=userData.address;
            question.value=userData.question;
            answer.value=userData.answer;
            registerTime.value=userData.registerTime;
            IDCardNo.value=userData.IDCardNo;
            $("#myModal").modal("show");
        }
        
        function reviseLable(){
            document.getElementById("myModalLabel").innerHTML="增加员工";
        }
        function initTime() {
            var currentTime=document.getElementById("currentTime");
            var myDate=new Date();
            currentTime.innerHTML=myDate.toLocaleDateString()+"--"+myDate.toLocaleTimeString();
            setTimeout("initTime()",1000);
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
                员工管理
            </h1>
        </section>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <hr>
                            <button class="btn btn-success" onclick="reviseLable()"  data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>增加员工
								</button>
                            <button class="btn btn-danger" id="divisonbutton" onclick="deleteUser()"><span class="glyphicon glyphicon-remove"></span>删除员工</button>
                            <button class="btn btn-warning" id="editbutton" onclick="editUser()"><span class="glyphicon glyphicon-wrench"></span>修改员工</button>
                            <button class="btn btn-primary" id="allChecked" onclick="allChecked()"><span class="glyphicon glyphicon-ok"></span>全选</button>
                            <button class="btn btn-primary" id="allUnChecked" onclick="allUnChecked()"><span class="glyphicon glyphicon-remove"></span></span>全不选</button>
                            <button class="btn btn-primary" id="opposeChecked" onclick="opposeChecked()"> <span class="glyphicon glyphicon-refresh"></span>反选</button>
                            <button class="btn btn-info" id="exportChecked"onclick="exportChecked()"><span class="glyphicon glyphicon-download-alt"></span>导出Excel</button>
                            <hr>
                        </div>
                        <div class="box-body table-responsive no-padding">
                            <form id="userShow">
                            <table class="table table-hover" id="dataTable">
                                <thead>
                                    <th></th>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>用户名</th>
                                    <th>出生日期</th>
                                    <th>电话号码</th>
                                    <th>电子邮箱</th>
                                    <th>家庭地址</th>
                                    <th>密保问题</th>
                                    <th>密保答案</th>
                                    <th>注册时间</th>
                                    <th>身份证号</th>
                                </thead>
                            </table>
                            </form>
                            <div class="box-footer clearfix">
                                <lable style="font-family: 仿宋;color: #4cae4c;font-size: 20px">共<span id="allCount"></span>条数据-共<span id="allPage"></span>页-当前第<span id="currentPage"></span>页</lable>
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
                            修改订单
                        </h4>
                    </div>
                    <form id="userForm">
                        <div class="modal-body">
                            <div class="form-group" >
                            	<input type="hidden" name="data.stuffId"  id="userId" style="display: none">
                                <label>工号</label>
                                <input type="text" name="data.workId" id="workId" class="form-control" >
                                <label>姓名</label>
                                <input type="text" name="data.realName" id="realName" class="form-control" >
                                <label>用户名</label>
                                <input type="text" name="data.userName" id="userName" class="form-control" >
                                <label>身份证号</label>
                                <input type="text" name="data.IDCardNo" id="IDCardNo" class="form-control" >
                                <label>出生日期</label>
                                <input type="date" name="data.birthday" id="birthday" class="form-control" >
                                <label>电话号码</label>
                                <input type="tel" name="data.telephonePhone" id="telephonePhone" class="form-control" >
                                <label>电子邮箱</label>
                                <input type="email" name="data.email" id="email" class="form-control" >
                                <label>家庭地址</label>
                                <input type="text" name="data.address" id="address" class="form-control" >
                                <label>密保问题</label>
                                <input type="text" name="data.question" id="question" class="form-control" >
                                <label>密保答案</label>
                                <input type="text" name="data.answer" id="answer" class="form-control" >
                                <label>入职时间</label>
                                <input type="date" name="data.registerTime" id="registerTime" class="form-control" >
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