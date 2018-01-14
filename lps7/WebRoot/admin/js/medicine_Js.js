function showdata(medicineData) {
//	var medicineData = {"medicines":
//[{"medicineId":1,"medicineNum":"001","medicineName":"云南白药","medicineVender":"江西南昌***厂","medicineShelfLife":"2017-12-1 2018-12-1","medicinePrice":35.2,"medicineInventory":23,"medicineSales":3},
//{"medicineId":2,"medicineNum":"002","medicineName":"云南白药1","medicineVender":"江西吉安***厂","medicineShelfLife":"2017-12-1 2019-12-1","medicinePrice":45.2,"medicineInventory":53,"medicineSales":5},
//{"medicineId":3,"medicineNum":"003","medicineName":"**药","medicineVender":"湖南***厂","medicineShelfLife":"2017-12-1 2018-12-1","medicinePrice":30.2,"medicineInventory":63,"medicineSales":31}]}
    var dataTable=document.getElementById("dataTable");
    var hrefId=document.getElementById("hrefId");
    var allCount=document.getElementById("allCount");
    var allPage=document.getElementById("allPage");
    var currentPage=document.getElementById("currentPage");
    var i;
    for(i in medicineData.medicines){
        var sTr=document.createElement("tr");
        sTr.innerHTML="<td><input type='checkbox' name='medicineIds' value="+medicineData.medicines[i].medicineId+"></td>"+
            "<td>"+medicineData.medicines[i].medicineNum+"</td>"+
            "<td>"+medicineData.medicines[i].medicineName+"</td>"+
            "<td>"+medicineData.medicines[i].medicineVender+"</td>"+
            "<td>"+medicineData.medicines[i].medicineShelfLife+"</td>"+
            "<td>"+medicineData.medicines[i].medicinePrice+"</td>"+
            "<td>"+medicineData.medicines[i].medicineInventory+"</td>"+
            "<td>"+medicineData.medicines[i].medicineSales+"</td>";
        dataTable.appendChild(sTr);
       
    }
    allCount.innerHTML=medicineData.page[0].allCount;
    allPage.innerHTML=medicineData.page[0].allPage;
    currentPage.innerHTML=medicineData.page[0].currentPage;
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+medicineData.transform[0].back+"><<</a>";
    hrefId.appendChild(l);
    for(i in medicineData.number){
        var l=document.createElement("li");
        l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+medicineData.number[i].link+">"+medicineData.number[i].value+"</a>";
        hrefId.appendChild(l);
    }
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+medicineData.transform[0].front+">>></a>";
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
    var orderId=document.getElementsByName("stuffId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=true;
    }
}
function allUnChecked() {
    var orderId=document.getElementsByName("stuffId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=false;
    }
}
function opposeChecked() {
    var orderId=document.getElementsByName("stuffId");
    var i;
    for(i=0;i<orderId.length;i++){
        if(orderId[i].checked==true){
            orderId[i].checked=false;
        }else{
            orderId[i].checked=true;
        }
    }
}
