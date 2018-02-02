
function resolveUserData(data){
	$("#realName").html(data.realName);
	$("#workId").html(data.workId);
	$("#userName").html(data.userName);
	$("#IDCardNo").html(data.IDCardNo);
	$("#registerTime").html(data.registerTime);
	$("#address").html(data.address);
	$("#birthday").html(data.birthday);
	$("#telephone").html(data.telephone);
	$("#email").html(data.email);
};

/*$(document).ready(function(){
	
	$(".modifiable").click(function(){
		
		if($(this).find("input").size() == 0){
			$(this).html("<input name='" + $(this).attr("id") +"' style=\"border-style:none\" value='" + $(this).html() +"'/>")
		}
		
		$("input").blur(function(){
			$(this).html($(this).find("input").attr("value"));
		})
		
	})
	
})*/


