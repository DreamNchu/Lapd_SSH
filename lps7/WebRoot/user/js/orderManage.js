
function acceptOrder(){
	
	var orderId = $("#waitingOrderId").html();
	//alert(orderId);
	ajaxRequest("receiveOrder?orderId="+orderId, function(reciveOrder){
		document.getElementById("lis").getElementsByTagName("li")[1].onclick();
	});
	
}

function completeWork(){
	var orderId = $("#servicingOrderId").html();
	var pay = $("#pay").val();
	
	ajaxRequest("finishOrder?orderId="+orderId+"&pay="+pay, function(reciveOrder){
		
		document.getElementById("lis").getElementsByTagName("li")[2].onclick();
		
	});
}


function singleOrder(reciveOrder) {
	var si ="";
	
	 $(".orderId").html("");
	  $(".roomName").html("");
	  $(".initTime").html("");
	  $(".clockCategoryName").html("");
	  $(".serverItem").html("");
	  $(".pledgeName").html("");
	  $(".payPath").html("");
		
		  for(i in reciveOrder.orders){
			  
			  $(".orderId").html( reciveOrder.orders[i].orderId);
			  $(".roomName").html(reciveOrder.orders[i].roomName);
			  $(".initTime").html(reciveOrder.orders[i].initTime);
			  $(".clockCategoryName").html(reciveOrder.orders[i].clockCategoryName);
			  split = " - ";
			  for(j in reciveOrder.orders[i].serverItem){
				  si += reciveOrder.orders[i].serverItem[j].serverItemName + split;
			  }
			  $(".serverItem").html(si.substr(0, si.length - split.length));
			  $(".pledgeName").html(reciveOrder.orders[i].pledgeName);
			  $(".payPath").html(reciveOrder.orders[i].payPath);
		  }
    }


function waitingPayUser(reciveOrder){
//alert(JSON.stringify(reciveOrder));
	var tr;
	var tbody = $("#waitingPay");
	
	tbody.html($(""));
	for(i in reciveOrder.orders){
		 tr = $("<tr id='orderId"+ i +"' value='"+ reciveOrder.orders[i].orderId +"'></tr>");
		 tbody.append(tr);
		 tr.append($("<td>"+reciveOrder.orders[i].roomName +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].serverItem[0].serverItemName +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].finishTime +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].clockCategoryName +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].pay +"</td>"));
		 $("#orderId"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?orderId='+$(this).attr('value'));
		 })
		 
	  }
}

function finish(reciveOrder){
	var tr;
	var tbody = $("#finish");
	//tbody.empty();
	 for(i in reciveOrder.orders){
		 tr = $("<tr id='orderIdF"+ i +"' value='"+ reciveOrder.orders[i].orderId +"'></tr>");
		 tbody.html(tr);
		 tr.append($("<td>"+reciveOrder.orders[i].roomName +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].serverItem +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].clockCategoryName +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].pay +"</td>"));
		 tr.append($("<td>"+reciveOrder.orders[i].realPay +"</td>"));
		 $("#orderIdF"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?orderId='+$(this).attr('value'));
		 })
	  }
}