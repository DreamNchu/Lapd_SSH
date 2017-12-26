function showdata(userData) {
    var dataTable=document.getElementById("dataTable");
    var hrefId=document.getElementById("hrefId");
    var allCount=document.getElementById("allCount");
    var allPage=document.getElementById("allPage");
    var currentPage=document.getElementById("currentPage");
    var i;
    for(i in userData.user){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td><input type='checkbox' name='userId' value="+userData.user[i].id+"></td>"+
            "<td>"+userData.user[i].workId+"</td>"+
            "<td>"+userData.user[i].realName+"</td>"+
            "<td>"+userData.user[i].userName+"</td>"+
            "<td>"+userData.user[i].birthday+"</td>"+
            "<td>"+userData.user[i].telephonePhone+"</td>"+
            "<td>"+userData.user[i].email+"</td>"+
            "<td>"+userData.user[i].address+"</td>"+
            "<td>"+userData.user[i].question+"</td>"+
            "<td>"+userData.user[i].answer+"</td>"+
            "<td>"+userData.user[i].registerTime+"</td>"+
            "<td>"+userData.user[i].IDCardNo+"</td>";
        dataTable.appendChild(sTr);
    }
    allCount.innerHTML=userData.page[0].allCount;
    allPage.innerHTML=userData.page[0].allPage;
    currentPage.innerHTML=userData.page[0].currentPage;
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+userData.transform[0].back+"><<</a>";
    hrefId.appendChild(l);
    for(i in userData.number){
        var l=document.createElement("li");
        l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+userData.number[i].link+">"+userData.number[i].value+"</a>";
        hrefId.appendChild(l);
    }
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+userData.transform[0].front+">>></a>";
    hrefId.appendChild(l);
    
    $(".c_page").click(function(){
    	deleteTr()
    	deleteLi()
    	ajaxRequest($(this).attr('key'),showdata);
    });
}
function deleteTr() {
    var orderTable=document.getElementById("dataTable");
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
    var orderId=document.getElementsByName("userId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=true;
    }
}
function allUnChecked() {
    var orderId=document.getElementsByName("userId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=false;
    }
}
function opposeChecked() {
    var orderId=document.getElementsByName("userId");
    var i;
    for(i=0;i<orderId.length;i++){
        if(orderId[i].checked==true){
            orderId[i].checked=false;
        }else{
            orderId[i].checked=true;
        }
    }
}