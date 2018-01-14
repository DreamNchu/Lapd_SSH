function showData(roomData) {
//	var roomData = {"rooms":[{"roomId":1,"roomName":"101","roomFloor":1,"roomSize":4,"isFree":true,"isClean":true,"roomRemark":"此房间经过精装修"},{"roomId":2,"roomName":"201","roomFloor":1,"roomSize":4,"isFree":true,"isClean":true,"roomRemark":"此房间经过精装修"},{"roomId":3,"roomName":"202","roomFloor":1,"roomSize":4,"isFree":true,"isClean":true,"roomRemark":"此房间经过精装修"},{"roomId":4,"roomName":"204"}],"serverItems":[{"serverItemId":2,"serverItemName":"按摩"},{"serverItemId":1,"serverItemName":"洗脚"},{"serverItemId":3,"serverItemName":"澡堂"}]}
    var dataTable=document.getElementById("dataTable");
    var hrefId=document.getElementById("hrefId");
    var allCount=document.getElementById("allCount");
    var allPage=document.getElementById("allPage");
    var currentPage=document.getElementById("currentPage");
    var i, freeInfo, cleanInfo;
    if(roomData.rooms.length == 0) {
    	editPageInfo();
    	alert("无房间信息");
    	return ;
    }
    deleteTr();
    for(i in roomData.rooms){
        var sTr=document.createElement("tr");
        if(roomData.rooms[i].isFree) {
        	freeInfo = "空闲";
        } else {
        	freeInfo = "在使用";
        }
        if(roomData.rooms[i].isFree) {
        	cleanInfo = "已打扫";
        } else {
        	cleanInfo = "未打扫";
        }
        sTr.innerHTML="<td><input type='checkbox' name='roomIds' value="+roomData.rooms[i].roomId+"></td>"+
            "<td>"+roomData.rooms[i].roomName+"</td>"+
            "<td>"+roomData.rooms[i].customerNum+"</td>"+
            "<td>"+roomData.rooms[i].roomFloor+"</td>"+
            "<td>"+roomData.rooms[i].roomCategoryName+"</td>"+
            "<td>"+roomData.rooms[i].roomSize+"</td>"+
            "<td>"+freeInfo+"</td>"+
            "<td>"+cleanInfo+"</td>";
        dataTable.appendChild(sTr);
    }
    allCount.innerHTML=roomData.page[0].allCount;
    allPage.innerHTML=roomData.page[0].allPage;
    currentPage.innerHTML=roomData.page[0].currentPage;			
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+roomData.transform[0].back+"><<</a>";
    hrefId.appendChild(l);
    for(i in roomData.number){
        var l=document.createElement("li");
        l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+roomData.number[i].link+">"+roomData.number[i].value+"</a>";
        hrefId.appendChild(l);
    }
    var l=document.createElement("li");
    l.innerHTML="<a class='c_page' href='javascript:void(0)' key="+roomData.transform[0].front+">>></a>";
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

function allChecked() {			//  全选
    var orderId=document.getElementsByName("roomId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=true;
    }
}

function allUnChecked() {		//  全不选
    var orderId=document.getElementsByName("roomId");
    var i;
    for(i=0;i<orderId.length;i++){
        orderId[i].checked=false;
    }
}

function opposeChecked() {		//  反选
    var orderId=document.getElementsByName("roomId");
    var i;
    for(i=0;i<orderId.length;i++){
        if(orderId[i].checked==true){
            orderId[i].checked=false;
        }else{
            orderId[i].checked=true;
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

$(function (){
	var name = $('#roomName');
	var size = $('#roomSize');
	var customerNum = $('#customerNum'); 
	name.blur(function () {
		if(!testNumber(name.val())) {
			alert("房间名不能输入非数字");
			return ;
		}
		
		if(name.val() == "") {
			alert("房间名不能空");
			return ;
		}
	})
	
	size.blur(function () {
		if(!testNumber(size.val())) {
			alert("房间大小不能为非数字");
			return ;
		}
		
		if(size.val() == "") {
			alert("房间大小不能为空");
			return ;
		}
	})
	
	customerNum.blur(function () {
		if(testNumber(customerNum.val())) {
			alert("用户人数不能为非数字")
		}
	})
})