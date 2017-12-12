
function formSubmit(ajaxUrl, id) {
    var AjaxURL = ajaxUrl;
    alert($('#' + id).serialize());
    $.ajax({
        type: "POST",
        dataType: "json",
        url: AjaxURL,
        data: $('#' + id).serialize(),
        success: function (data) {
            var strresult = JSON.parse(data);
            alert(strresult.msg);
        },
        error: function (data) {
            var strresult = JSON.parse(data);
            alert("error:" + strresult.msg);
        }
    })
}


function formSubmitWithEventData(ajaxUrl, id, func) {
    var AjaxURL = ajaxUrl;
    alert($('#' + id).serialize());
    $.ajax({
        type: "POST",
        dataType: "json",
        url: AjaxURL,
        data: $('#' + id).serialize(),
        success: function (data) {
        	//alert("formSubmitWithEventForData : "+ data);
            var strresult = JSON.parse(data);
            //alert(strresult.msg);
            func(strresult);
        },
        error: function (data) {
            var strresult = JSON.parse(data);
            alert("error:" + strresult.msg);
        }
    })
}


function formSubmitWithEvent(ajaxUrl, id, func) {
    var AjaxURL = ajaxUrl;
    alert($('#' + id).serialize());
    $.ajax({
        type: "POST",
        dataType: "json",
        url: AjaxURL,
        data: $('#' + id).serialize(),
        success: function (data) {
            var strresult = JSON.parse(data);
            //alert(strresult.msg);
            func();
        },
        error: function (data) {
            var strresult = JSON.parse(data);
            alert("error:" + strresult.msg);
        }
    })
}

function ajaxRequest(url,func){
    $.ajax({
        dataType : "json",
        url : url,
        success : function(data) {
            var strresult = JSON.parse(data);
            //alert("ddd");
//alert("ajaxRequest" + data);
            func(strresult);
        },
        error : function(data) {
            var strresult = JSON.parse(data);
            alert("error:" + strresult.msg);
        }
    })
}
