
//接收待支付订单
function receivePayOrder(orderData) {
	var payTable = $("#payTable");
	payTable.html($(""));
	//deleteTr(payTable);
	
	var i;
	for (i in orderData.orders) {
		
		var orderTr = $("<tr></tr>")
		payTable.append(orderTr);
		orderTr.append($("<td id='orderId" + i + "'>" + orderData.orders[i].orderId + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].roomName + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].stuff.workId + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].stuff.realName + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].initTime + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].clockCategoryName + "</td>"))
		orderTr.append($("<td>" + orderData.orders[i].serverItem[0].serverItemName + "</td>"))
		orderTr.append($("<td><button  id='payTo" + i + "' value='"+ orderData.orders[i].orderId +"' >支付</button></td>"));
		
		$("#payTo" + i).click(function() {
			ajaxRequest("queryOrder?orderId="+$(this).attr("value"), payClick);
		})
		
	}
}
//接收服务中订单
function receiveServingOrder(orderData) {
	
	
	
	serveTable = document.getElementById("serveTable");
//	deleteTr(serveTable);
	/*    var orderData={
	        "orders":[{"orderId":"orderId1","roomId":"roomId1","stuffId":"stuffId1","stuff.realName":"realName1","receiveTime":"receiveTime1","workTime":"workTime1"},
	            {"orderId":"orderId2","roomId":"roomId2","stuffId":"stuffId1","stuff.realName":"realName2","receiveTime":"receiveTime2","workTime":"workTime2"}]
	    }*/
	var i;
	for (i in orderData.orders) {
		var orderTr = document.createElement("tr");
		orderTr.innerHTML = "<td>" + orderData.orders[i].orderId + "</td>" +
			"<td>" + orderData.orders[i].roomName + "</td>" +
			"<td>" + orderData.orders[i].stuff.workId + "</td>" +
			"<td>" + orderData.orders[i].stuff.realName + "</td>" +
			"<td>" + orderData.orders[i].receiveTime + "</td>"
		/*    +"<td>"+orderData.orders[i].workTime+"</td>"*/ ;
		serveTable.appendChild(orderTr);
	}
}


function payClick(orderdata) {
	var myModal = document.getElementById("myModal");
	$("#myModal").modal("show");
	
	document.getElementById("orderId").innerHTML = orderdata.orderId;
	document.getElementById("orderIdTure").value = orderdata.orderId;
	document.getElementById("roomId").innerHTML = orderdata.roomName;
	document.getElementById("stuffId").innerHTML = orderdata.stuff.workId;
	document.getElementById("realName").innerHTML = orderdata.stuff.realName;
	document.getElementById("initTime").innerHTML = orderdata.initTime;
	document.getElementById("serverItem").innerHTML = orderdata.serverItem[0].serverItemName;
	document.getElementById("receiveTime").innerHTML = orderdata.receiveTime;
	document.getElementById("finishTime").innerHTML = orderdata.finishTime;
	document.getElementById("pay").innerHTML = orderdata.pay;
	document.getElementById("id").value = orderdata.orderId;
	var payTr = document.getElementById("payTr");
	var i,
	str = "";
	
	str += "<input id='aliPay' type='radio' checked='true' value='1' name='updateOrderNormalOperationDto.payPath'>" + "<label for='aliPay'>支付宝</label>";
	str += "<input id='wechat' type='radio' value='2' name='updateOrderNormalOperationDto.payPath'>" + "<label for='wechat'>微信</label>";
	str += "<input id='cash' type='radio' value='3' name='updateOrderNormalOperationDto.payPath'>" + "<label for='cash'>现金</label>";
	str += "<input id='unionPay' type='radio' value='4' name='updateOrderNormalOperationDto.payPath'>" + "<label for='unionPay'>银联</label>";
	
	document.getElementById("payTd").innerHTML = str;
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
     
/*       ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=2"+"&pageLinkTransformOrderDto.timeType=1",
     receiveServingOrder);*/
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