var username = document.getElementById("username").values;
function checkUser(str){
    var re = /^[a-zA-z]\w{3,15}$/;
    if(re.test(str)){
        alert("正确");
    }else{
        alert("错误");
    }          
}
