
	function create(createOrder) {
		var stuffId = document.getElementById("stuffId");
		var roomId = document.getElementById("roomId");
		var serverItem = document.getElementById("serverItem");
		var i,
			userDatab,
			op,
			createOrder;

		//document.getElementById("rad1").value = createOrder.createWays[0];
		//document.getElementById("rad2").value = createOrder.createWays[1];
		//document.getElementById("rad3").value = createOrder.createWays[2];
		for (i in createOrder.users) {
			//ajaxRequest("viewAdminUserWorkData?userIdDto.stuffId="+$("#stuffId option:selected").val(),viewAdminUserWorkData);
			op = document.createElement("option");
			op.setAttribute("value", createOrder.users[i].stuffId);
			op.setAttribute("selected","unselected")
		
			op.className="stuffChoice";
			op.innerHTML = createOrder.users[i].workId;
			stuffId.appendChild(op);
		}
		for (i in createOrder.rooms) {
			op = document.createElement("option");
			op.setAttribute("value", createOrder.rooms[i].roomId);
			op.innerHTML = createOrder.rooms[i].roomName;
			roomId.appendChild(op);
		}
		for (i in createOrder.serverItems){
			op = document.createElement("option");
			op.setAttribute("value", createOrder.serverItems[i].serverItemId);
			op.innerHTML = createOrder.serverItems[i].serverItemName;
			serverItem.appendChild(op);
		}
	}

	function hideOf() {
		document.getElementById("stuffId").disabled = "disabled";
	}
	function showOf() {
		document.getElementById("stuffId").disabled = "";
	}
	function initTime() {
		var currentTime = document.getElementById("currentTime");
		var myDate = new Date();
		currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
		setTimeout("initTime()", 1000);
	}
	$(document).ready(function(){
	   $("#stuffId ").change(function(){
//		alert($("#stuffId option:selected").val());

	  ajaxRequest("queryUser?stuffId="+$("#stuffId option:selected").val(),queryUser);
	   })
	      
	     
	   
	   //var userdata={"roomName":"101","roomCategory":"洗脚","roomFloor":1,"roomSize":2,"customerNum":0,"isFree":true,"isClean":true};
	
	   $("#roomId").change(function(){
		  // alert("ff");
		   ajaxRequest("viewWorkRoomData?roomIdDto.roomId="+$("#roomId option:selected").val() ,viewWorkRoomData);
	   })
	  
	   
	})
	function queryUser(userData){
	
	   var workId=document.getElementById("workId");
   	   var workStatusName=document.getElementById("workStatus") ;
       var realName=document.getElementById("realName");
      
       workId.innerHTML  ="员工工号: "+userData.workId;
       workStatusName.innerHTML="员工状态: "+userData.workStatusName;
       realName.innerHTML = "员工姓名: "+userData.realName;      
        
       $("#workShow").css("display","block");
	}
	function viewWorkRoomData(userdata){
		var roomName=document.getElementById("roomName");
	   	var roomCategory=document.getElementById("roomCategory") ;
	    var roomFloor=document.getElementById("roomFloor");
	    var roomSize=document.getElementById("roomSize");
	   	var customerNum=document.getElementById("customerNum") ;
	    var isFree=document.getElementById("isFree");
	    var isClean=document.getElementById("isClean");
	    roomName.innerHTML="房 间 号  : "+userdata.roomName;
	    roomCategory.innerHTML="房间类型: "+userdata.roomCategoryName;
	    roomFloor.innerHTML="房间楼层: "+userdata.roomFloor;
	    roomSize.innerHTML="房间大小: "+userdata.roomSize;
	    customerNum.innerHTML="客人数目: "+userdata.customerNum;
	    if(userdata.isClean){
	    	isFree.innerHTML="房间状态: 使用";
	    }
	    else{
	    	isFree.innerHTML="房间状态: 空";
	    }
	   // isFree.innerHTML="房间状态:"+userdata.isFree;
	    if(userdata.isClean){
	    	isClean.innerHTML="是否打扫: 是";
	    }
	    else{
	    	isClean.innerHTML="是否打扫: 否";
	    }
	   // isClean.innerHTML="是否打扫"+((userdata.isClean==true):"是"?"否");
	   
	   	  
	}



