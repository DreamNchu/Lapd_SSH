
$(document).ready(function () {
	
	
    
})

function acceptOrder(){
	
	var orderId = $("#waitingOrderId").html();
	//alert(orderId);
	ajaxRequest("receiveOrder?orderId="+orderId, function(reciveOrder){
		alert(reciveOrder.msg);
		document.getElementById("lis").getElementsByTagName("li")[1].onclick();
	});
	
}

function completeWork(){
	var orderId = $("#servicingOrderId").html();
	var pay = $("#pay").val();
	
	ajaxRequest("finishOrder?orderId="+orderId+"&pay="+pay, function(reciveOrder){
		alert(reciveOrder.msg);
		document.getElementById("lis").getElementsByTagName("li")[2].onclick();
	});
}


function singleOrder(reciveOrder) {
	
	 $(".orderId").html("");
	  $(".room").html("");
	  $(".initTime").html("");
	  $(".clockCategory").html("");
	  $(".serverItem").html("");
	  $(".pledgeName").html("");
	  $(".payPath").html("");
		
		  for(i in reciveOrder.order){
			  
			  $(".orderId").html( reciveOrder.order[i].orderId);
			  $(".room").html(reciveOrder.order[i].room);
			  $(".initTime").html(reciveOrder.order[i].initTime);
			  $(".clockCategory").html(reciveOrder.order[i].clockCategory);
			  $(".serverItem").html(reciveOrder.order[i].serverItem);
			  $(".pledgeName").html(reciveOrder.order[i].pledgeName);
			  $(".payPath").html(reciveOrder.order[i].payPath);
		  }
    }


function waitingPayUser(reciveOrder){
//alert(JSON.stringify(reciveOrder));
	var tr;
	var tbody = $("#waitingPay");
	
	tbody.html($(""));
	for(i in reciveOrder.order){
		 tr = $("<tr id='orderId"+ i +"' value='"+ reciveOrder.order[i].orderId +"'></tr>");
		 tbody.append(tr);
		 tr.append($("<td>"+reciveOrder.order[i].room +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].serverItem +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].finishTime +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].clockCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].pay +"</td>"));
		 $("#orderId"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?orderId='+$(this).attr('value'));
		 })
		 
	  }
}

function finish(reciveOrder){
	var tr;
	var tbody = $("#finish");
	//tbody.empty();
	 for(i in reciveOrder.order){
		 tr = $("<tr id='orderIdF"+ i +"' value='"+ reciveOrder.order[i].orderId +"'></tr>");
		 tbody.html(tr);
		 tr.append($("<td>"+reciveOrder.order[i].room +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].serverItem +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].clockCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].pay +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].realPay +"</td>"));
		 $("#orderIdF"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?orderId='+$(this).attr('value'));
		 })
	  }
}