function showdata(comboData) {
	
	var dataTable = document.getElementById("dataTable");
	var hrefId = document.getElementById("hrefId");
	var allCount = document.getElementById("allCount");
	var allPage = document.getElementById("allPage");
	var currentPage = document.getElementById("currentPage");
	var i;
	for (i in comboData.combos) {
		var sTr = document.createElement("tr");
		sTr.innerHTML = "<td><input type='checkbox' name='comboIds' value=" + comboData.combos[i].comboId + "></td>" +
			"<td>" + comboData.combos[i].comboName + "</td>" +
			"<td>" + comboData.combos[i].comboPrice + "</td>" +
			"<td>" + comboData.combos[i].serverItem[0].serverItemName + "</td>" +
			"<td>" + comboData.combos[i].comboBeginTime + "</td>" +
			"<td>" + comboData.combos[i].comboEndTime + "</td>" +
		dataTable.appendChild(sTr);

	}
	allCount.innerHTML = comboData.page[0].allCount;
	allPage.innerHTML = comboData.page[0].allPage;
	currentPage.innerHTML = comboData.page[0].currentPage;
	var l = document.createElement("li");
	l.innerHTML = "<a class='c_page' href='javascript:void(0)' key=" + comboData.transform[0].back + "><<</a>";
	hrefId.appendChild(l);
	for (i in comboData.number) {
		var l = document.createElement("li");
		l.innerHTML = "<a class='c_page' href='javascript:void(0)' key=" + comboData.number[i].link + ">" + comboData.number[i].value + "</a>";
		hrefId.appendChild(l);
	}
	var l = document.createElement("li");
	l.innerHTML = "<a class='c_page' href='javascript:void(0)' key=" + comboData.transform[0].front + ">>></a>";
	hrefId.appendChild(l);

	$(".c_page").click(function() {
		deleteTr()
		deleteLi()
		ajaxRequest($(this).attr('key'), showdata);
	});
}
function deleteTr() {
	var orderTable = document.getElementById("dataTable");
	var i = 0;
	for (i = 1; i < orderTable.rows.length; i++) {
		orderTable.deleteRow(i);
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
function allChecked() {
	var orderId = document.getElementsByName("stuffId");
	var i;
	for (i = 0; i < orderId.length; i++) {
		orderId[i].checked = true;
	}
}
function allUnChecked() {
	var orderId = document.getElementsByName("stuffId");
	var i;
	for (i = 0; i < orderId.length; i++) {
		orderId[i].checked = false;
	}
}
function opposeChecked() {
	var orderId = document.getElementsByName("stuffId");
	var i;
	for (i = 0; i < orderId.length; i++) {
		if (orderId[i].checked == true) {
			orderId[i].checked = false;
		} else {
			orderId[i].checked = true;
		}
	}
}