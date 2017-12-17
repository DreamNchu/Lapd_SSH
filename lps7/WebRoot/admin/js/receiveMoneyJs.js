//接收待支付订单
function receivePayOrder(orderData) {
    var payTable=document.getElementById("payTable");
    deleteTr(payTable);
/*    var orderData={
        "order":[{"idOrder":"idOrder1","roomId":"roomId1","stuffId":"stuffId1","realName":"realName1","initTime":"initTime1","clockCategory":"clockCategory1","roomCategory":"roomCategory1"},
            {"idOrder":"idOrder2","roomId":"roomId2","stuffId":"stuffId2","realName":"realName2","initTime":"initTime2","clockCategory":"clockCategory2","roomCategory":"roomCategory2"}]
    }*/
    var i;
    for(i in orderData.order){
        var orderTr=document.createElement("tr");
        orderTr.innerHTML="<td>"+orderData.order[i].idOrder+"</td>" +
            "<td>"+orderData.order[i].room+"</td>" +
            "<td>"+orderData.order[i].stuff+"</td>" +
            "<td>"+orderData.order[i].realName+"</td>" +
            "<td>"+orderData.order[i].initTime+"</td>" +
            "<td>"+orderData.order[i].clockCategory+"</td>" +
            "<td>"+orderData.order[i].roomCategory+"</td>" +
            "<td><a href='javascript:void(0)' onclick='payClick()'>支付</a></td>";
        payTable.appendChild(orderTr);
    }
}
//接收服务中订单
function receiveServingOrder(orderData) {
    serveTable=document.getElementById("serveTable");
    deleteTr(serveTable);
/*    var orderData={
        "order":[{"idOrder":"idOrder1","roomId":"roomId1","stuffId":"stuffId1","realName":"realName1","receiveTime":"receiveTime1","workTime":"workTime1"},
            {"idOrder":"idOrder2","roomId":"roomId2","stuffId":"stuffId1","realName":"realName2","receiveTime":"receiveTime2","workTime":"workTime2"}]
    }*/
    var i;
    for(i in orderData.order){
        var orderTr=document.createElement("tr");
        orderTr.innerHTML="<td>"+orderData.order[i].idOrder+"</td>"+
            "<td>"+orderData.order[i].room+"</td>"+
            "<td>"+orderData.order[i].stuff+"</td>"+
            "<td>"+orderData.order[i].realName+"</td>"+
            "<td>"+orderData.order[i].receiveTime+"</td>"
        /*    +"<td>"+orderData.order[i].workTime+"</td>"*/;
        serveTable.appendChild(orderTr);
    }
}
function payClick() {
    var myModal=document.getElementById("myModal");
    $("#myModal").modal("show");
    var orderdata={
        "data":{"idOrder":"idOrder1","roomId":"rommId1","stuffId":"stuffId","realName":"realName1","initTime":"initTime1","roomCategory":"roomCategory1","receiveTime":"receiveTime1","finishTime":"finishTime1","pay":"pay1"}
        ,"payPath":["现金","支付宝","微信"]
    };
    document.getElementById("idOrder").innerHTML=orderdata.data.idOrder;
    document.getElementById("roomId").innerHTML=orderdata.data.roomId;
    document.getElementById("stuffId").innerHTML=orderdata.data.stuffId;
    document.getElementById("realName").innerHTML=orderdata.data.realName;
    document.getElementById("initTime").innerHTML=orderdata.data.initTime;
    document.getElementById("roomCategory").innerHTML=orderdata.data.roomCategory;
    document.getElementById("receiveTime").innerHTML=orderdata.data.receiveTime;
    document.getElementById("finishTime").innerHTML=orderdata.data.finishTime;
    document.getElementById("pay").innerHTML=orderdata.data.pay;
    document.getElementById("id").value=orderdata.data.idOrder;
    var payTr=document.getElementById("payTr");
    var i,str="";
    for(i in orderdata.payPath){
        str+="<input type='radio' name='payPath'>"+orderdata.payPath[i];
    }
    document.getElementById("payTd").innerHTML=str;
    document.getElementsByName("payPath")[0].checked=true;
}
function surePay() {
    var realPay=document.getElementById("realpay");
    var reg=/^[0-9]+$/;
    if(realPay.value.length<0||reg.test(realPay.value)==false){
        bootbox.alert("支付金额输入错误!");
        return false;
    }
    bootbox.confirm({
        message : "是否确认支付？",
        callback : function(result) {
            if (result == true) {
                formSubmitWithEvent("updateOrder", "serverForm", receivePayOrder);
            }
        }
    });
}
//查找订单
function searshOrder() {
    formSubmitWithEvent("updateOrder", "payForm", receivePayOrder);
}
function deleteTr(orderTable) {
    var i=0;
    for(i=1;i<orderTable.rows.length;i++){
        orderTable.deleteRow(i);
        i=i-1;
    }
}
function initTime() {
    var currentTime=document.getElementById("currentTime");
    var myDate=new Date();
    currentTime.innerHTML=myDate.toLocaleDateString()+"--"+myDate.toLocaleTimeString();
    setTimeout("initTime()",1000);
}