window.onload=function () {
    var signbutton=document.getElementById("signbutton");
    signbutton.disabled=true;
}
function blue() {
    var name=document.getElementById("name");
    var phonenumber=document.getElementById("phonenumber");
    var password1=document.getElementById("password");
    var password2=document.getElementById("re-password");
    var company=document.getElementById("company");
    var title=document.getElementById("title");
    var signbutton=document.getElementById("signbutton");
    var select=document.getElementById("select");
    var answer=document.getElementById("answer");
    var reg=/^[A-Za-z0-9]+$/;
    var reg2= /^1[34578]\d{9}$/;
    if(name.value.length<6||name.value.length>20){
        title.innerHTML="用户名应大于6位小于12位";
        title.style.color="red";
        name.style.color="black";
        signbutton.disabled=true;
        return false;
    }else{
        name.style.color="green";
    }
    if(phonenumber.value.length<1){
        title.innerHTML="手机号不能为空";
        title.style.color="red";
        phonenumber.style.color="black";
        signbutton.disabled=true;
        return false
    }
    if(reg2.test(phonenumber.value)==false){
        signbutton.disabled=true;
        title.innerHTML="手机号格式不正确";
        title.style.color="red";
        phonenumber.style.color="black";
        return false
    }else{
        phonenumber.style.color="green";
    }
    if(password1.value.length<6||password1.value.length>25){
        signbutton.disabled=true;
        title.innerHTML="密码长度应大于6位小于26位";
        title.style.color="red";
        password1.style.color="black";
        return false
    }else{
        password1.style.color="green";
    }
    if(password1.value!=password2.value){
        signbutton.disabled=true;
        title.innerHTML="两次密码不一致";
        title.style.color="red";
        password2.style.color="black";
        return false
    }else{
        password2.style.color="green";
    }
    if(company.value.length<1){
        signbutton.disabled=true;
        title.innerHTML="所在公司不能为空";
        title.style.color="red";
        company.style.color="black";
        return false
    }else{
        title.innerHTML="恭喜，输入全部合法";
        company.style.color="green";
        signbutton.disabled=false;
    }
    if(select.value=="选择一个密码问题"){
        signbutton.disabled=true;
        title.innerHTML="未选择问题";
        title.style.color="red";
        select.style.color="green";
        return false;
    }
    if(answer.value.length==0){
        signbutton.disabled=true;
        title.innerHTML="答案未填写";
        title.style.color="red";
        answer.style.color="black"
        return false;
    }else{
        title.innerHTML="恭喜，输入全部合法";
        answer.style.color="answer"
        signbutton.disabled=false;
    }
}
function focus1(){
    var signbutton=document.getElementById("signbutton");
    var title=document.getElementById("title");
    title.innerHTML="字段变为绿色则输入合法";
    signbutton.disabled=false;
    title.style.color="green";
}
