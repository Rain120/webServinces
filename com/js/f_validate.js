function f_validata() {
	var username = document.getElementById("username").value;
	var passwd = document.getElementById("password").value;
	var error = "";
	if(username == null || username == " ") {
		error = error + "Username can't be null\n";
	} else if(username.length < 6) {
		error = error + "Username'length can not  be less than 6!\n";
	} else if(username.length > 30) {
		error = error + "Username'length can not  be more than 30!\n";
	}

	if(passwd == null || passwd == " ") {
		error = error + "Password can't be null\n";
	} else if(passwd.length < 6 || passwd.length > 20) {
		error = error + "Password'length must be 6 to 20!\n";
	}

	if(error == "") {
		window.location.href = "frameTest.html";
	} else {
		alert(error);
	}
}

function setInfo() {
	var username = document.getElementById("username");
	username.value = "请输入用户名";
}

function clickInfo() {
	var username = document.getElementById("username");
	if(username.value == "请输入用户名") {
		username.value = "";
	}
}

function saveInfo() {
	var username = document.getElementById("username");
	if(username.value == "") {
		username.value = "请输入用户名";
	}
}

function UserRegistration() {
	window.location.href = "signup.html";
}
