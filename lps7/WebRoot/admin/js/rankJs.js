
function receiveRank(rankData) {
	var rankTable = document.getElementById("rankTable");
	deleteTr();
	/*  var rankData={
	      "data":[{"rank":"rank1","stuffId":"stuffId1","realName":"realName1","rankNum":"rankNum1","spotNum":"spotNum1"},
	          {"rank":"rank2","stuffId":"stuffId2","realName":"realName2","rankNum":"rankNum2","spotNum":"spotNum2"}],
	      "page":[{"allCount":"6","allPage":"5","currentPage":"3"}],
	      "transform":[{"back":"javascript:void(0)","front":"javascript:void(0)"}],
	      "number":[{"key":"javascript:void(0)","value":"1"},{"key":"javascript:void(0)","value":"2"}]
	  }*/
	recivePage(rankData);

	for (i in rankData.workRanks) {
		var rankTr = document.createElement("tr");

		rankTr.innerHTML = "<td style='text-align:center'>" + (parseInt(i) + 1) + "</td>" +
			"<td  style='text-align:center'>" + rankData.workRanks[i].workId + "</td>" +
			"<td  style='text-align:center' >" + rankData.workRanks[i].realName + "</td>" +
			"<td style='text-align:center' >" + rankData.workRanks[i].rankNum + "</td>" +
			"<td  style='text-align:center'>" + rankData.workRanks[i].spotNum + "</td>";

		rankTr.className = "z_v";
		rankTr.setAttribute("key", rankData.workRanks[i].stuffId);
		rankTable.appendChild(rankTr);
	}
	$('.z_v').click(function() {
		var obj = $(this);

		//alert(obj.attr('key'));
		ajaxRequest("queryUser?stuffId=" + obj.attr('key'), queryUser);


	})

	function queryUser(userData) {
		var workId = document.getElementById("workId");
		var workStatus = document.getElementById("workStatus");
		var realName = document.getElementById("realName");
		var userName = document.getElementById("userName");
		var birthday = document.getElementById("birthday");
		var telephonePhone = document.getElementById("telephonePhone");
		var email = document.getElementById("email");
		var address = document.getElementById("address");


		workId.innerHTML = userData.workId;
		workStatus.innerHTML = userData.workStatusName;
		realName.innerHTML = userData.realName;
		userName.innerHTML = userData.userName;
		birthday.innerHTML = userData.birthday;
		telephonePhone.innerHTML = userData.telephonePhone;
		email.innerHTML = userData.email;


		address.innerHTML = userData.address;

		$("#myModal").modal("show");
	}
}

/*

function receiveRank(rankData) {
//	alert(1);
    var rankTable=document.getElementById("rankTable");
    deleteTr();
    var rankData={
        "data":[{"rank":"rank1","stuffId":"stuffId1","realName":"realName1","rankNum":"rankNum1","spotNum":"spotNum1"},
            {"rank":"rank2","stuffId":"stuffId2","realName":"realName2","rankNum":"rankNum2","spotNum":"spotNum2"}],
        "page":[{"allCount":"6","allPage":"5","currentPage":"3"}],
        "transform":[{"back":"javascript:void(0)","front":"javascript:void(0)"}],
        "number":[{"key":"javascript:void(0)","value":"1"},{"key":"javascript:void(0)","value":"2"}]
    }
   
    recivePage(rankData);

    for(i in rankData.workRanks){
        var rankTr=document.createElement("tr");
        rankTr.innerHTML="<td>"+ (parseInt(i)+1) +"</td>"+
            "<td>"+rankData.workRanks[i].workId+"</td>"+
            "<td>"+rankData.workRanks[i].realName+"</td>"+
            "<td>"+rankData.workRanks[i].rankNum+"</td>"+
            "<td>"+rankData.workRanks[i].spotNum+"</td>";
        rankTable.appendChild(rankTr);
    }
}*/
function recivePage(rankData) {
	var hrefId = document.getElementById("hrefId");
	var allCount = document.getElementById("allCount");
	var allPage = document.getElementById("allPage");
	var currentPage = document.getElementById("currentPage");
	deleteLi();
	allCount.innerHTML = rankData.page[0].allCount;
	allPage.innerHTML = rankData.page[0].allPage;
	currentPage.innerHTML = rankData.page[0].currentPage;
	var l = document.createElement("li");
	var linkHref = rankData.transform[0].back;
	l.innerHTML = "<a class='pageClass' key='" + linkHref + "' href='javascript:void(0)'><<</a>";
	hrefId.appendChild(l);
	for (i in rankData.number) {
		var l = document.createElement("li");
		linkHref = rankData.number[i].link;
		l.innerHTML = "<a class='pageClass'  key='" + linkHref + "' href='javascript:void(0)'>" + rankData.number[i].value + "</a>";
		hrefId.appendChild(l);
	}
	var l = document.createElement("li");
	linkHref = rankData.transform[0].front;
	l.innerHTML = "<a class='pageClass' key='" + linkHref + "' href='javascript:void(0)'>>></a>";
	hrefId.appendChild(l);
	$('.pageClass').click(function() {
		deleteLi();
		deleteTr();
		ajaxRequest($(this).attr('key'), receiveRank);
	})
}
function initTime() {
	var currentTime = document.getElementById("currentTime");
	var myDate = new Date();
	currentTime.innerHTML = myDate.toLocaleDateString() + "--" + myDate.toLocaleTimeString();
	setTimeout("initTime()", 1000);
}
function deleteTr() {
	var rankTable = document.getElementById("rankTable");
	var i = 0;
	for (i = 1; i < rankTable.rows.length; i++) {
		rankTable.deleteRow(i);
		i = i - 1;
	}
}
function deleteLi() {
	var hrefId = document.getElementById("hrefId");
	var i = 0;
	for (i = 0; i < hrefId.childNodes.length; i++) {
		hrefId.removeChild(hrefId.childNodes[i]);
		i = i - 1;
	}
}