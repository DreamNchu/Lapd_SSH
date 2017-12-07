window.onload=function () {
    var signbutton=document.getElementById("signbutton");
    signbutton.disabled=true;
}
function  blue() {
    var signbutton=document.getElementById("signbutton");
    var name=document.getElementById("name");
    var password=document.getElementById("password");
    var title=document.getElementById("title");
    if(name.value.length<6){
        signbutton.disabled=true;
        title.innerHTML="用户名应大于6位小于12位";
        title.style.color="red";
        name.style.color="black";
        return false;
    }else{
        name.style.color="green";
    }

    if(password.value.length<6){
        signbutton.disabled=true;
        title.innerHTML="密码长度应大于6位小于26位";
        title.style.color="red";
        password1.style.color="black";
        return;
    } else{
        password1.style.color="green";
        signbutton.disabled=false;
    }
}
function focus1() {
    var signbutton=document.getElementById("signbutton");
    var title=document.getElementById("title");
    title.innerHTML="字段变为绿色则输入合法";
    signbutton.disabled=false;
    title.style.color="green";
}

