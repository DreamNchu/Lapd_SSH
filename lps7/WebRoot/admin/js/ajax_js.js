
function submitOrder(ajaxUrl,id) {
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

