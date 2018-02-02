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
    <title>药品管理</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="shortcut icon" href="image/center.ico" type="image/x-icon"/>
    <script src="js/medicine_Js.js"></script>
    <script src="../js/ajax_js.js"></script>
    <script src="js/initClass.js"></script>
    <script type="text/javascript">
     	window.onload=function () {
            //initActive();
            initBasicClass("medicineManage");
            initTime();
      
      		//ajaxRequest("queryMedicine?medicineIds=4" ,showdata);
           ajaxRequest("queryMedicinesByPage?pageUtil.page=1" ,showdata);
          // showdata();
        }
    
        
        
        function sureRevise(){
        	//alert(document.getElementById("myModalLabel").innerHTML=="修改药品信息");
        	if(document.getElementById("myModalLabel").innerHTML=="修改药品信息"){
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
                        formSubmitWithEventData("addMedicine","medicineForm",reQueryBasic);
                     //   ajaxRequest('queryBasicUser',showdata);
                    }
                }
            });
        }
        
         function  sureReviseEdit() {
            bootbox.confirm({
                message:"确认执行此操作？",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("updateMedicine","medicineForm",reQueryBasic);
                     //   ajaxRequest('queryBasicUser',showdata);
                    }
                }
            });
        }
        
        function deleteUser() {
            var userArray=document.getElementsByName("medicineIds");
            var i;
            for(i=0;i<userArray.length;i++){
                if(userArray[i].checked==true){
                    break;
                }
                if(i==userArray.length-1){
                    bootbox.alert("请选择药品",function () {});
                    return ;
                }
            }
            bootbox.confirm({
                message:"是否删除选中药品数据",
                callback :function (result) {
                    if(result==true){
                        formSubmitWithEventData("deleteMedicines","medicineShow",reQueryBasic);
                        //ajaxRequest('queryBasicUser',reQueryBasic);
                    }
                }
            });
        }
        function reQueryBasic(){
        	alert(444);
			deleteLi();
        	deleteTr();
			ajaxRequest("queryMedicinesByPage",showdata);
		}
        
        function editUser() {
            var userArray=document.getElementsByName("medicineIds");
            var i,count=0,op;
          //  alert(userArray.length);
            for(i=0;i<userArray.length;i++){
                if(userArray[i].checked==true){
                    count++;
                    if(count==2){
                        bootbox.alert("只能选择一个药品修改",function () {});
                        return false;
                    }
                }
                if(i==userArray.length-1&&count==0){
                    bootbox.alert("至少选择一个药品",function () {});
                    return false;
                }
            }
            
            document.getElementById("myModalLabel").innerHTML="修改药品信息";
            formSubmitWithEventData("queryMedicine", "medicineShow" ,queryMedicine);
            
        }
        
        function queryMedicine(medicineData){
       /*  var medicineData={
                "user":[{"workId":"workId1","realName":"realName1","userName":"userName1","birthday":"birthday1","telephonePhone":"telephonePhone1","email":"email1","address":"address1","question":"question1","answer":"answer1","registerTime":"registerTime1","IDCardNo":"IDCardNo1"}]
            } */
            var medicineId=document.getElementById("medicineId");
            var medicineNum=document.getElementById("medicineNum");
            var medicineName=document.getElementById("medicineName");
            var medicineVender=document.getElementById("medicineVender");
            var medicineShelfLife=document.getElementById("medicineShelfLife");
            var medicinePrice=document.getElementById("medicinePrice");
            var medicineInventory=document.getElementById("medicineInventory");
            var medicineSales=document.getElementById("medicineSales");
//            {"medicineId":1,"medicineNum":"001","medicineName":"云南白药","medicineVender":"江西南昌***厂","medicineShelfLife":"2017-12-1 2018-12-1","medicinePrice":35.2,"medicineInventory":23,"medicineSales":3},
             medicineId.value=medicineData.medicineId;
            medicineNum.value=medicineData.medicineNum;
            medicineName.value=medicineData.medicineName;
            medicineVender.value=medicineData.medicineVender;
            medicineShelfLife.value=medicineData.medicineShelfLife;
            medicinePrice.value=medicineData.medicinePrice;
            medicineInventory.value=medicineData.medicineInventory;
            medicineSales.value=medicineData.medicineSales; 
/*             medicineId.value=1;
            medicineNum.value="001";
            medicineName.value="云南白药";
            medicineVender.value="江西南昌***厂";
            medicineShelfLife.value="2017-12-1 2018-12-1";
            medicinePrice.value=35.2;
            medicineInventory.value=23;
            medicineSales.value=2;  */
          
            
            $("#myModal").modal("show");
        }
        
        function  reviseLable(){
            document.getElementById("myModalLabel").innerHTML="增加药品";
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
                药品管理
            </h1>
        </section>
        <section class="content container-fluid">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <hr>
                            <button class="btn btn-success" onclick="reviseLable()"  data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>增加药品</button>
                            <button class="btn btn-danger" id="divisonbutton" onclick="deleteUser()"><span class="glyphicon glyphicon-remove"></span>删除药品</button>
                            <button class="btn btn-warning" id="editbutton" onclick="editUser()"><span class="glyphicon glyphicon-wrench"></span>修改药品</button>
                            <button class="btn btn-primary" id="allChecked" onclick="allChecked()"><span class="glyphicon glyphicon-ok"></span>全选</button>
                            <button class="btn btn-primary" id="allUnChecked" onclick="allUnChecked()"><span class="glyphicon glyphicon-remove"></span></span>全不选</button>
                            <button class="btn btn-primary" id="opposeChecked" onclick="opposeChecked()"> <span class="glyphicon glyphicon-refresh"></span>反选</button>
                            <button class="btn btn-info" id="exportChecked"onclick="exportChecked()"><span class="glyphicon glyphicon-download-alt"></span>导出Excel</button>
                            <hr>
                        </div>
                        <div class="box-body table-responsive no-padding">
                            <form id="medicineShow">
                            <table class="table table-hover" id="dataTable">
                                <thead>
                                    <th></th>
                                    <th>药品编号</th>
                                    <th>药品名称</th>
                                    <th>厂家</th>
                                    <th>保质期</th>
                                    <th>药品价格</th>
                                    <th>库存</th>
                                    <th>销量</th>
                                    
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
                    <form id="medicineForm">
                        <div class="modal-body">
                            <div class="form-group" >
                            	<input type="hidden" name="data.medicineId"  id="medicineId" style="display: none">
                                <label>药品编号</label>
                                <input type="text" name="data.medicineNum" id="medicineNum" class="form-control" >
                                <label>药品名称</label>
                                <input type="text" name="data.medicineName" id="medicineName" class="form-control" >
                                <label>厂家</label>
                                <input type="text" name="data.medicineVender" id="medicineVender" class="form-control" >
                                <label>保质期</label>
                                <input type="date" name="data.medicineShelfLife" id="medicineShelfLife" class="form-control" >
                                <label>药品价格</label>
                                <input type="text" name="data.medicinePrice" id="medicinePrice" class="form-control" >
                                <label>库存</label>
                                <input type="text" name="data.medicineInventory" id="medicineInventory" class="form-control" >
                                <label>销量</label>
                                <input type="text" name="data.medicineSales" id="medicineSales" class="form-control" >
                                
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