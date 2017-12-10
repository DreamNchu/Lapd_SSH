var str=new Array('/lps7/admin/initOrder','/lps7/admin/orderManage','/lps7/admin/userManage'
    ,'/lps7/admin/orderChart','/lps7/admin/companyProfile');
function initActive() {
    var list=document.getElementsByName("activeLi");
    var i;
    for(i=0;i<list.length;i++){
        list[i].className="";
        if(str[parseInt(list[i].value)-1]==window.location.pathname){
            list[i].className="active";
        }
    }
}