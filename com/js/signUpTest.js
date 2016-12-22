function signUpTest() {
	var error = "";

	var username = document.getElementById("username").value;
	var PWD = document.getElementById("PWD").value;
	var comfirmPWD = document.getElementById("comfirmPWD").value;
	var realName = document.getElementById("realName").value;
	var province = document.getElementById("province").value;
	var city = document.getElementById("city").value;
	var IDType = document.getElementById("IDType").value;
	var IDNumber = document.getElementById("IDNumber").value;
	var calendar = document.getElementById("calendar").value;

	var usernameReg = /^[a-zA-Z]{1}\w{2,29}$/;
	
	var PWDReg = /^(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}$/;
	var comfirmPWDReg = /^(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}$/;
	
	var realNameReg = /^[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*||[a-zA-Z]$/;
	
	var IDNumberReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X|x)$/;
	var passportReg = /^1[45][0-9]{7}|([P|p|S|s]\d{7})|([S|s|G|g]\d{8})|([Gg|Tt|Ss|Ll|Qq|Dd|Aa|Ff]\d{8})|([H|h|M|m]\d{8，10})$/;
	var HongKongMacauLaissezPasserReg = /^[HMhm]{1}([0-9]{10}|[0-9]{8})$/;
	var TaiwanPassProcessReg = /^T{1}([0-9]{10}|[0-9]{8})$/;

	if(username == "" || null == username) {
		error += "Username can't be null!\n\n";
	} else if(!username.match(usernameReg)) {
		error += "Username not match!\n\n"
	}
	//	else{
	//		document.getElementById("hintUsername").innerHTML = "OK!";
	//	}

	if(PWD == "" || null == PWD) {
		error += "Password can't be null!\n\n";
	} else if(PWD.length < 6) {
		error += "Password'length can't be less than 6!\n"
	} else if(PWD.length > 20) {
		error += "Password'length can't be more than 20!\n"
	} else if(!PWD.match(PWDReg)) {
		error += "Password can't match!\n\n";
	}

	if(comfirmPWD == "" || null == comfirmPWD) {
		error += "Comfirempassword can't be null!\n\n";
	} else if(!comfirmPWD.match(comfirmPWDReg)) {
		error += "Comfirmpassword can't match!\n\n";
	} else if(PWD != comfirmPWD) {
		error += "Password can't match comfirmPassword!\n\n";
	}

	if(realName == "" || null == realName) {
		error += "RealName can't be null!\n\n";
	} else if(!realName.match(realNameReg)) {
		error += "RealName can't match!\n\n";
	}

	if(province == "请选择省份") {
		error += "Province can't be null!\n\n";
	}

	if(city == "请选择城市") {
		error += "City can't be null!\n\n";
	}

	if(IDType == "二代身份证") {
		if(IDNumber == "" || null == IDNumber) {
			error += "IDNumber can't be null!\n\n";
		} else if(!IDNumber.match(IDNumberReg)) {
			error += "IDNumber not match!\n\n"
		}
	} else if(IDType == "护照") {
		if(IDNumber == "" || null == IDNumber) {
			error += "Passport can't be null!\n\n";
		} else if(!IDNumber.match(passportReg)) {
			error += "Passport not match!\n\n"
		}
	} else if(IDType == "港澳通行证") {
		if(IDNumber == "" || null == IDNumber) {
			error += "Hong Kong-Macau laissez-passer can't be null!\n\n";
		} else if(!IDNumber.match(HongKongMacauLaissezPasserReg)) {
			error += "Hong Kong-Macau laissez-passer not match!\n\n"
		}
	} else if(IDType == "台湾通行证") {
		if(IDNumber == "" || null == IDNumber) {
			error += "Taiwan pass process can't be null!\n\n";
		} else if(!IDNumber.match(TaiwanPassProcessReg)) {
			error += "Taiwan pass process not match!\n\n"
		}
	}

	if(calendar == "" || null == calendar) {
		error += "Calendar can't be null!\n\n";
	}
	
	if(error == "") {
		window.location.href = "top.html";
	} else {
		alert(error);
	}
}
