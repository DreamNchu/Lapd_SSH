function checkblue() {
    var signbutton=document.getElementById("signbutton")
    var checkinput=document.getElementById("checkinput")
    var userName=document.getElementById("userName");
    var password=document.getElementById("password");
    var repassword=document.getElementById("re-password");
    var email=document.getElementById("email");
    var telephonePhone=document.getElementById("telephonePhone");
    var date=document.getElementById("date");
    var remember=document.getElementById("remember-me");
    var reg=/^[A-Za-z0-9]+$/;
    var reg2= /^1[34578]\d{9}$/;
    var reg3=/^[A-Za-z0-9d]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/
    if(userName.value.length<5||userName.value.length>16){
        checkinput.innerHTML="亲，账号长度要在6至16位之间哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        userName.style.color="blue";
    }
    if(password.value.length<5||password.value.length>25){
        checkinput.innerHTML="亲，密码长度要在6至26位之间哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }
    if(reg.test(password.value)==false){
        checkinput.innerHTML="亲，密码不能含有非法字符哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        password.style.color="blue";
    }
    if(password.value.length<12){
        checkinput.innerHTML="亲,密码输入合法，但不是很安全喔！"
        checkinput.style.backgroundColor="coral";
        checkinput.style.borderColor="coral";
    }
    if(password.value!=repassword.value){
        checkinput.innerHTML="亲，两次密码不一致哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        repassword.style.color="blue";
    }
    if(reg3.test(email.value)==false){
        checkinput.innerHTML="亲，邮箱格式不正确喔哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        email.style.color="blue";
    }
    if(reg2.test(telephonePhone.value)==false){
        checkinput.innerHTML="亲，手机号格式不正确喔哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        telephonePhone.style.color="blue";
    }
    if(date.value.length<7){
        checkinput.innerHTML="亲，填写一下你的出生日期吧哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
        return false;
    }else{
        date.style.color="blue";
    }
    if(remember.checked==false){
        checkinput.innerHTML="亲，请同意协议哦！"
        checkinput.style.backgroundColor="red";
        checkinput.style.borderColor="red";
        signbutton.disabled=true;
    }else{
        checkinput.innerHTML="亲，全部输入合法哦！"
        checkinput.style.backgroundColor="blue";
        checkinput.style.borderColor="blue";
        signbutton.disabled=false;
    }
}
function checkfocus() {
    var signbutton=document.getElementById("signbutton");
    var checkinput=document.getElementById("checkinput");
    signbutton.disabled=false;
    checkinput.innerHTML="这里的信息将会提示您的信息是否输入合法哦！O.O "
    checkinput.style.backgroundColor="blue";
    checkinput.style.borderColor="blue";
}