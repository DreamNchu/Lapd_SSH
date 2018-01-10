function recivePage(reciveOrder) {
    var hrefId=document.getElementById("hrefId");
    var allCount=document.getElementById("allCount");
    var allPage=document.getElementById("allPage");
    var currentPage=document.getElementById("currentPage");
    deleteLi();
   
    allCount.innerHTML=reciveOrder.page[0].allCount;
//    alert(reciveOrder.page[0].allCount);
    allPage.innerHTML=reciveOrder.page[0].allPage;
    currentPage.innerHTML=reciveOrder.page[0].currentPage;
    var l=document.createElement("li");
    var linkHref=reciveOrder.transform[0].back;
    l.innerHTML="<a class='pageClass' key='"+linkHref+"' href='javascript:void(0)'><<</a>";
    hrefId.appendChild(l);
    for(i in reciveOrder.number){
        var l=document.createElement("li");
        linkHref=reciveOrder.number[i].link;
        l.innerHTML="<a class='pageClass'  key='"+linkHref+"' href='javascript:void(0)'>"+reciveOrder.number[i].value+"</a>";
        hrefId.appendChild(l);
    }
   
    var l=document.createElement("li");
    linkHref=reciveOrder.transform[0].front;
    l.innerHTML="<a class='pageClass' key='"+linkHref+"' href='javascript:void(0)'>>></a>";
    hrefId.appendChild(l);
    $('.pageClass').click(function () {
//  	   alert($(this).attr('key'));
  	    deleteLi();
        deleteTr();
         
         ajaxRequest($(this).attr('key'),funcs[parseInt($('.statusId:checked').val()) - 1]);
         
     })
}
function waitingReceive(reciveOrder) {
//alert("waitingReceive："  + JSON.stringify(reciveOrder));
    var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    firsttr.innerHTML="<th ></th>"+
        " <th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        " <th>所做项目</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>";
        orderTable.appendChild(sTr);
    }
    recivePage(reciveOrder);
}
function servicing(reciveOrder) {
    var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    firsttr.innerHTML="<th ></th>"+
        " <th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        " <th>所做项目</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>";
        orderTable.appendChild(sTr);
    }
    recivePage(reciveOrder);
}
function suspend(reciveOrder) {
	
    var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    firsttr.innerHTML="<th ></th>"+
        " <th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        " <th>所做项目</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>";
        orderTable.appendChild(sTr);
    }
    recivePage(reciveOrder);
}
function invalid(reciveOrder) {
    var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    firsttr.innerHTML="<th ></th>"+
        " <th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        " <th>所做项目</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>";
        orderTable.appendChild(sTr);
    }
    
    recivePage(reciveOrder);
}
function waitingPay(reciveOrder) {
    var firsttr=document.getElementById("firsttr");
    var i;
    var orderTable=document.getElementById("orderTable");
    firsttr.innerHTML="<th></th>"+
        "<th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        "<th>所做项目</th>\n" +
        " <th>所要药品</th>\n" +
        " <th>所需支付</th>\n" ;
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>"+
            "<td>"+reciveOrder.orders[i].pledgeName+"</td>"+
            "<td>"+reciveOrder.orders[i].pay+"</td>";
        orderTable.appendChild(sTr);
    }
    recivePage(reciveOrder);
}
function finish(reciveOrder) {
    var firsttr=document.getElementById("firsttr");
    var orderTable=document.getElementById("orderTable");
    var i;
    firsttr.innerHTML="<th></th>"+
        "<th>订单号</th>\n" +
        "<th>房间号</th>\n" +
        "<th>员工号</th>\n" +
        "<th>员工姓名</th>\n" +
        "<th>发布时间</th>\n" +
        "<th>订单类型</th>\n" +
        "<th>所做项目</th>\n" +
        " <th>所要药品</th>\n" +
        " <th>所需支付</th>\n" +
        " <th>实际支付</th>\n" +
        "  <th>支付方式</th>";
    for(i in reciveOrder.orders){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td align='center'><input type='checkbox' name='orderId' value="+reciveOrder.orders[i].orderId+"></td>"+
            "<td>"+reciveOrder.orders[i].orderId+"</td>"+
            "<td>"+reciveOrder.orders[i].roomName+"</td>"+
            "<td>"+reciveOrder.orders[i].stuff+"</td>"+
            "<td>"+reciveOrder.orders[i].realName+"</td>"+
            "<td>"+reciveOrder.orders[i].initTime+"</td>"+
            "<td>"+reciveOrder.orders[i].clockCategoryName+"</td>"+
            "<td>"+reciveOrder.orders[i].serverItem+"</td>"+
            "<td>"+reciveOrder.orders[i].pledgeName+"</td>"+
            "<td>"+reciveOrder.orders[i].pay+"</td>"+
            "<td>"+reciveOrder.orders[i].realPay+"</td>"+
            "<td>"+reciveOrder.orders[i].payPath+"</td>";
        orderTable.appendChild(sTr);
    }
    recivePage(reciveOrder);
}
var funcs=new Array(waitingReceive,servicing,waitingPay,finish,suspend,invalid);


$(document).ready(function () {
    $('.dateType').click(function () {
    	deleteLi();
        deleteTr();
//        alert("queryBasicOrders?queryOrderDto.statusId="+$('.statusId:checked').val()+"&queryOrderDto.timeType="+$(this).attr('value'));
        ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId="+$('.statusId:checked').val()+"&pageLinkTransformOrderDto.timeType="+$(this).attr('value'),funcs[parseInt($('.statusId:checked').val()) - 1]);
    })
    $('.statusId').click(function () {
    	deleteLi();
        deleteTr();
//        alert(parseInt($(this).attr('value')) - 1);
//        alert("queryBasicOrders?queryOrderDto.statusId="+$(this).attr('value')+"&queryOrderDto.timeType="+$('.dateType:checked').val());
        ajaxRequest("queryBasicOrders?pageLinkTransformOrderDto.statusId="+$(this).attr('value')+"&pageLinkTransformOrderDto.timeType="+$('.dateType:checked').val(),funcs[parseInt($(this).attr('value')) - 1]);
    })
   
})

function linkRequest(linkHref) {
    var f = $('.statusId').attr("key");
//    alert(f);
    var reciveOrder={
        "orders":[{"orderId":"orderId3","roomName":"roomName1","stuff":"stuff1","userName":"userName1","initTime":"initTtime1","clockCategoryName":"clockCategory1","serverItem":"serverItem1,"}
            ,{"orderId":"orderId2","roomName":"roomName2","stuff":"stuff2","userName":"userName2","initTime":"initTtime2","clockCategoryName":"clockCategory2","serverItem":"serverItem2,"}]
        , "page":[{"currentPage":"1","allCount":"10","allPage":"10"}],
        "transform":[{"back":"TestHref","front":"TestHref"}],
        "number":[{"value":"1","link":"TestHref"},{"value":"2","link":"TestHref"},{"value":"3","link":"TestHref"},{"value":"4","link":"TestHref"}]
    }
    f(reciveOrder);
    //ajaxRequest(linkHref,$('.statusId').attr("key"));
}
function commonSearsh(){
    document.getElementById("timeTr").style.display="none";
}
function superSearsh() {
    document.getElementById("timeTr").style.display="block";
}
function add() {
    window.location.href="fbdd.html";
}
function deleteTr() {
    var orderTable=document.getElementById("orderTable");
    var i=0;
    for(i=1;i<orderTable.rows.length;i++){
        orderTable.deleteRow(i);
        i=i-1;
    }
}
function deleteLi() {
    var hrefId=document.getElementById("hrefId");
    var i=0;
    for(i=0;i<hrefId.childNodes.length;i++){
        hrefId.removeChild(hrefId.childNodes[i]);
        i=i-1;
    }
}
function allChecked() {
    var orderId=document.getElementsByName("orderId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=true;
    }
}
function allUnChecked() {
    var orderId=document.getElementsByName("orderId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=false;
    }
}
function opposeChecked() {
    var orderId=document.getElementsByName("orderId");
    var i;
    for(i=0;i<orderId.length;i++){
        if(orderId[i].checked==true){
            orderId[i].checked=false;
        }else{
            orderId[i].checked=true;
        }
    }
}