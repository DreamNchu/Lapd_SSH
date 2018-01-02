

//接收待支付订单
function receivePayOrder(orderData) {
	var payTable = $("#payTable");
	payTable.html($(""));
	//deleteTr(payTable);
	/*    var orderData={
	        "order":[{"orderId":"orderId1","roomId":"roomId1","stuffId":"stuffId1","realName":"realName1","initTime":"initTime1","clockCategory":"clockCategory1","serverItem":"serverItem1"},
	            {"orderId":"orderId2","roomId":"roomId2","stuffId":"stuffId2","realName":"realName2","initTime":"initTime2","clockCategory":"clockCategory2","serverItem":"serverItem2"}]
	    }*/
	var i;
	for (i in orderData.order) {
		//		var orderTr = document.createElement("tr");
		var orderTr = $("<tr></tr>")
		payTable.append(orderTr);
		orderTr.append($("<td id='orderId" + i + "'>" + orderData.order[i].orderId + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].room + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].stuff + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].realName + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].initTime + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].clockCategory + "</td>"))
		orderTr.append($("<td>" + orderData.order[i].serverItem + "</td>"))
		orderTr.append($("<td><button  id='payTo" + i + "' value='"+ orderData.order[i].orderId +"' >支付</button></td>"));
		//alert(i);
		$("#payTo" + i).click(function() {
//			alert(0);
			ajaxRequest("queryOrder?orderId="+$(this).attr("value"), payClick);
		})
		//payTable.appendChild(orderTr);
	}
}
//接收服务中订单
function receiveServingOrder(orderData) {
	serveTable = document.getElementById("serveTable");
	deleteTr(serveTable);
	/*    var orderData={
	        "order":[{"orderId":"orderId1","roomId":"roomId1","stuffId":"stuffId1","realName":"realName1","receiveTime":"receiveTime1","workTime":"workTime1"},
	            {"orderId":"orderId2","roomId":"roomId2","stuffId":"stuffId1","realName":"realName2","receiveTime":"receiveTime2","workTime":"workTime2"}]
	    }*/
	var i;
	for (i in orderData.order) {
		var orderTr = document.createElement("tr");
		orderTr.innerHTML = "<td>" + orderData.order[i].orderId + "</td>" +
			"<td>" + orderData.order[i].room + "</td>" +
			"<td>" + orderData.order[i].stuff + "</td>" +
			"<td>" + orderData.order[i].realName + "</td>" +
			"<td>" + orderData.order[i].receiveTime + "</td>"
		/*    +"<td>"+orderData.order[i].workTime+"</td>"*/ ;
		serveTable.appendChild(orderTr);
	}
}


function payClick(orderdata) {
	var myModal = document.getElementById("myModal");
	$("#myModal").modal("show");
	/*var orderdata = {
		"data" : {
			"orderId" : "orderId1",
			"roomId" : "rommId1",
			"stuffId" : "stuffId",
			"realName" : "realName1",
			"initTime" : "initTime1",
			"serverItem" : "serverItem1",
			"receiveTime" : "receiveTime1",
			"finishTime" : "finishTime1",
			"pay" : "pay1"
		},
		"payPath" : [ "现金", "支付宝", "微信" ]
	};*/
	document.getElementById("orderId").innerHTML = orderdata.orderId;
	document.getElementById("orderIdTure").value = orderdata.orderId;
	document.getElementById("roomId").innerHTML = orderdata.room;
	document.getElementById("stuffId").innerHTML = orderdata.stuff;
	document.getElementById("realName").innerHTML = orderdata.realName;
	document.getElementById("initTime").innerHTML = orderdata.initTime;
	document.getElementById("serverItem").innerHTML = orderdata.serverItem;
	document.getElementById("receiveTime").innerHTML = orderdata.receiveTime;
	document.getElementById("finishTime").innerHTML = orderdata.finishTime;
	document.getElementById("pay").innerHTML = orderdata.pay;
	document.getElementById("id").value = orderdata.orderId;
	var payTr = document.getElementById("payTr");
	var i,
	str = "";
	
	str += "<input type='radio' checked='true' value='1' name='updateOrderNormalOperationDto.payPath'>" + "支付宝";
	str += "<input type='radio' value='2' name='updateOrderNormalOperationDto.payPath'>" + "微信";
	str += "<input type='radio' value='3' name='updateOrderNormalOperationDto.payPath'>" + "现金";
	str += "<input type='radio' value='4' name='updateOrderNormalOperationDto.payPath'>" + "银联";
	/*for (i = 1 ;i <= 3; i ++) {
		str += "<input type='radio' id='"+i+"' name='payPath'>" + orderdata.payPath[i];
	}*/
	
	/*for (i in orderdata.payPath) {
		str += "<input type='radio' name='payPath'>" + orderdata.payPath[i];
	}*/
	document.getElementById("payTd").innerHTML = str;
	//document.getElementsByName("payPath")[0].checked = true;
}
function surePay() {
	var realPay = document.getElementById("realpay");
	var reg = /^[0-9]+$/;
	if (realPay.value.length < 0 || reg.test(realPay.value) == false) {
		bootbox.alert("支付金额输入错误!");
		return false;
	} 
	bootbox.confirm({
		message : "是否确认支付？",
		callback : function(result) {
			if (result == true) {
				formSubmitWithEventData("toPayOrders", "serverForm", initDataMsg);
			}
		}
	});
}

function initDataMsg(data){
	alert(data.msg);
	initData();
}

function initData(){
	ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=3"+"&pageLinkTransformOrderDto.timeType=1",
     receivePayOrder);
     
       ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=2"+"&pageLinkTransformOrderDto.timeType=1",
     receiveServingOrder);
}

//查找订单
function searshOrder() {
	formSubmitWithEvent("updateOrder", "payForm", receivePayOrder);
}
function deleteTr(orderTable) {
	var i = 0;
	for (i = 1; i < orderTable.rows.length; i++) {
		orderTable.deleteRow(i);
		i = i - 1;
	}
}
function initTime() {
	var currentTime = document.getElementById("currentTime");
	var myDate = new Date();
	currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
	setTimeout("initTime()", 1000);
}