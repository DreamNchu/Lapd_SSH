
$(document).ready(function () {
	
	
    
})

function acceptOrder(){
	
	var idOrder = $("#waitingOrderId").html();
	alert(idOrder);
	ajaxRequest("receiveOrder?idOrder="+idOrder, function(reciveOrder){
		alert(reciveOrder.msg);
	});
	
}

function completeWork(){
	var idOrder = $("#servicingOrderId").html();
	var pay = $("#pay").val();
	
	ajaxRequest("finishOrder?idOrder="+idOrder+"&pay="+pay, function(reciveOrder){
		alert(reciveOrder.msg);
	});
}


function singleOrder(reciveOrder) {
	
	 $(".idOrder").html("");
	  $(".room").html("");
	  $(".initTime").html("");
	  $(".clockCategory").html("");
	  $(".roomCategory").html("");
	  $(".pledgeName").html("");
	  $(".payPath").html("");
		
		  for(i in reciveOrder.order){
			  
			  $(".idOrder").html( reciveOrder.order[i].idOrder);
			  $(".room").html(reciveOrder.order[i].room);
			  $(".initTime").html(reciveOrder.order[i].initTime);
			  $(".clockCategory").html(reciveOrder.order[i].clockCategory);
			  $(".roomCategory").html(reciveOrder.order[i].roomCategory);
			  $(".pledgeName").html(reciveOrder.order[i].pledgeName);
			  $(".payPath").html(reciveOrder.order[i].payPath);
		  }
    }


function waitingPay(reciveOrder){
	//alert(reciveOrder);
	var tr;
	var tbody = $("#waitingPay");
	//tbody.empty();
	 for(i in reciveOrder.order){
		 tr = $("<tr id='orderId"+ i +"' value='"+ reciveOrder.order[i].idOrder +"'></tr>");
		 tbody.html(tr);
		 tr.append($("<td>"+reciveOrder.order[i].room +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].roomCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].finishTime +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].clockCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].pay +"</td>"));
		 $("#orderId"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?idOrder='+$(this).attr('value'));
		 })
	  }
}

function finish(reciveOrder){
	var tr;
	var tbody = $("#finish");
	//tbody.empty();
	 for(i in reciveOrder.order){
		 tr = $("<tr id='orderIdF"+ i +"' value='"+ reciveOrder.order[i].idOrder +"'></tr>");
		 tbody.html(tr);
		 tr.append($("<td>"+reciveOrder.order[i].room +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].roomCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].clockCategory +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].pay +"</td>"));
		 tr.append($("<td>"+reciveOrder.order[i].reayPay +"</td>"));
		 $("#orderIdF"+i).click(function(){
			 $(location).attr('href', 'detailOrderInfo?idOrder='+$(this).attr('value'));
		 })
	  }
}