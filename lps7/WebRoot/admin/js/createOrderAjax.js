

function submitOrder(ajaxUrl){
            var AjaxURL= ajaxUrl;       
            alert($('#createOrder').serialize());
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: AjaxURL,
                    data: $('#createOrder').serialize(),
                    success: function (data) {
                        var strresult=JSON.parse(data);
                        alert(strresult.msg);
                    },
                    error: function(data) {
                    	var strresult=JSON.parse(data);
                        alert("error:"+strresult.msg);
                     }
                });
}
        