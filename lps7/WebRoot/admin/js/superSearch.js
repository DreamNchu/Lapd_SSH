function sureSuperSearch() {
	showSearchInfo();
	alert($('#superSearchFrom').serialize());
	//formSubmitWithEventData("queryAdvancedOrder", "superSearchFrom", queryAdvancedOrder);
	var data = {"orders":[{"orderId":"000901011201801021953560001","roomName":"101","workId":"9","realName":"安琪","initTime":"2018-01-02 19:53","clockCategoryName":"点钟","orderStatusName":"待接收","serverItemName":"按摩","pledgeName":"","pay":"","realPay":"100","payPath":"支付宝","receiveTime":"","finishTime":"","payTime":"","orderRemark":""},{"orderId":"000901011201801022031530001","roomName":"101","workId":"9","realName":"安琪","initTime":"2018-01-02 20:31","clockCategoryName":"点钟","orderStatusName":"待接收","serverItemName":"按摩","pledgeName":"","pay":"","realPay":"200","payPath":"微信","receiveTime":"","finishTime":"","payTime":"","orderRemark":""}]}
//	alert("success");
//	alert(JSON.parse(data));
	queryAdvancedOrder(data);
}	

function commonSearsh(){		//  普通搜索,隐藏显示除的高级搜索的条件
	deleteTr();
	ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId=" + $('.statusId:checked').val() + "&pageLinkTransformOrderDto.timeType=" + $('.dateType:checked').val(),
				 funcs[parseInt($('.statusId:checked').val()) - 1]);		//  当高级搜索改成普通搜索时，重新按普通搜索的条件显示数据
    document.getElementById("showSuperSearch").style.display="none";
    document.getElementById("time").style.display="block";
    document.getElementById("orderType").style.display="block";
}
function superSearsh() {		//  高级搜索
	$('#sWorkId').empty();
	$('#sRoomName').empty();
	$('#sServerItemName').empty();
	ajaxRequest("initOrderData", createSuper);
	document.getElementById("time").style.display="none";
    document.getElementById("orderType").style.display="none";
}

function queryAdvancedOrder(reciveOrder) {
	var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    var emptyStr = "&nbsp;&nbsp;&nbsp;";		//  增加空格  
    deleteLi();
    deleteTr();
    firsttr.innerHTML="<th></th>"+
        "<th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        "<th>所做项目</th>\n" +
        "<th>价格</th>\n" +
        "<th>支付方式</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        var abbrStr = reciveOrder.orders[i].orderId.substr(0, 10);
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+emptyStr+" <abbr title="+reciveOrder.orders[i].orderId+">"+abbrStr+"</abbr></td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].workId+"</td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].orderStatusName+"</td>"+
            "<td>"+emptyStr+" "+reciveOrder.orders[i].serverItemName+"</td>"+
	        "<td>"+emptyStr+" "+reciveOrder.orders[i].realPay+"</td>"+
	        "<td>"+emptyStr+" "+reciveOrder.orders[i].payPath+"</td>";
        orderTable.appendChild(sTr);
    }
}

function showSearchInfo() {			//  输出高级搜索的搜索条件
//	var startTime = $('#sMinDate');
//	var endTime = $('#sMaxDate');
	var minPrice = $('#sMinPrice');
	var maxPrice = $('#sMaxPrice');
	var stuffId = $('#sWorkId');
	var userName = $('#sUserName');
	var roomId = $('#sRoomName');
	var workStatusName = $('#sWorkStatusName');
	var serverItemName = $('#sServerItemName');
	var payPathName = $('#sPayPathName');
	var showSearchInfo = $('#showSuperSearch');
	showSearchInfo.empty();		//  清除已显示的信息
	showSearchInfo.show();		//  把showSearchInfo改为显示
	var str = "高级搜索的条件是：";
	var count = 0
//	if((startTime.val()).length != 0) {
//		str += "开始时间："+ startTime.val(); 
//		count++;
//		lineFeed(count);
//	}
//	if(endTime.val() != "") {				
//		str += "截止时间："+ endTime.val(); 
//		count++;
//		lineFeed(count);
//	}
	if(minPrice.val() != "") {
		//showSearchInfo.append("<label>开始时间："+ minPrice.val() +"</label>");
		str += "最低价：" + minPrice.val();
		count++;
		lineFeed(count);
	}
	if(maxPrice.val() != "") {
		str += "最高价：" + maxPrice.val();	
		if(maxPrice.val() <= minPrice.val()){
			alert("最低价应小于等于最高价");
			return;
		}
		count++;
		lineFeed(count);
	}
	if(userName.val() != "") {
		str += "员工姓名：" + userName.val();
		count++;
		lineFeed(count);
	}
	if(stuffId.val() != "") {
		str += "员工工作号：" + stuffId.find("option:selected").text();
		count++;
		lineFeed(count);
	}	
	if(roomId.val() != "") {
		str += "房间号：" + roomId.find("option:selected").text();
		count++;
		lineFeed(count);
	}
	if(workStatusName.val() != "") {
		str += "订单类型：" + workStatusName.find("option:selected").text();
		count++;
		lineFeed(count);
	}
	if(serverItemName.val() != "") {
		str += "项目类型：" + serverItemName.find("option:selected").text();
		count++;
		lineFeed(count);
	}
	if(payPathName.val() != "") {
		str += "支付方式：" + payPathName.find("option:selected").text();
		count++;
		lineFeed(count);
	}
	showSearchInfo.append(str);
	function lineFeed(count) {			//  换行
		if(count == 5) {
			str += "<br>";
			count = 0;
		}
		if(count != 0) {
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp";
		}
	}	
}	

function editPageInfo() {		//  当返回值为空时，设置有关分页信息的值
	 var allCount=document.getElementById("allCount");
	 var allPage=document.getElementById("allPage");
	 var currentPage=document.getElementById("currentPage");
	 allCount.innerHTML="0";
	 allPage.innerHTML="1";
	 currentPage.innerHTML="1";
}

function createSuper(createOrder) {		//  初始化高级搜索中员工工号、房间号、项目名的下拉框的值
	var stuffId = document.getElementById("sWorkId");
	var roomId = document.getElementById("sRoomName");
	var serverItem = document.getElementById("sServerItemName");
	var i,
		userDatab,
		op,
		createOrder;
	createOptionEmpty(stuffId);
	for (i in createOrder.users) {
		op = document.createElement("option");
		op.setAttribute("value", createOrder.users[i].stuffId);
		op.innerHTML = createOrder.users[i].workId;
		stuffId.appendChild(op);
	}
	createOptionEmpty(roomId);
	for (i in createOrder.rooms) {
		op = document.createElement("option");
		op.setAttribute("value", createOrder.rooms[i].roomId);
		op.innerHTML = createOrder.rooms[i].roomName;
		roomId.appendChild(op);
	}
	createOptionEmpty(serverItem);
	for (i in createOrder.serverItems){
		op = document.createElement("option");
		op.setAttribute("value", createOrder.serverItems[i].serverItemId);
		op.innerHTML = createOrder.serverItems[i].serverItemName;
		serverItem.appendChild(op);
	}
	
	function createOptionEmpty(element) {		//  生成option的值为空，text为空
		var op = document.createElement("option");
		op.setAttribute("value", "");
		op.innerHTML = "";
		element.appendChild(op);
	}
}	


