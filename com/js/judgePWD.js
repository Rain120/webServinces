//判断输入密码的类型  
function CharMode(pwd) {
	if(pwd >= 48 && pwd <= 57) //数字  
		return 1;
	if(pwd >= 65 && pwd <= 90) //大写  
		return 2;
	if(pwd >= 97 && pwd <= 122) //小写  
		return 4;
	else
		return 8;
}
//bitTotal函数  
//计算密码模式
function bitTotal(num) {
	modes = 0;
	for(i = 0; i < 4; i++) {
		if(num & 1) {
			modes++;
		}
		num >>>= 1;
	}
	return modes;
}
//返回强度级别  
function checkStrong(sPW) {
	if(sPW.length <= 5 || sPW.length >= 20) {
		return 0; //密码太短 
	}
	Modes = 0;
	for(i = 0; i < sPW.length; i++) {
		//密码模式  
		Modes |= CharMode(sPW.charCodeAt(i));
	}
	return bitTotal(Modes);
}
//显示颜色  
function pwStrength(pwd) {
	O_color = "#999999";
	L_color = "#7CFC00";
	M_color = "#FFD700";
	H_color = "#FF0000";
	if(pwd == null || pwd == '') {
		Lcolor = Mcolor = Hcolor = O_color;
	} else {
		S_level = checkStrong(pwd);
		switch(S_level) {
			case 0:
				Lcolor = Mcolor = Hcolor = O_color;
			case 1:
				Lcolor = L_color;
				Mcolor = Hcolor = O_color;
				break;
			case 2:
				Mcolor = M_color;
				Hcolor = O_color;
				break;
			default:
				Hcolor = H_color;
		}
	}
	document.getElementById("strength_L").style.background = Lcolor;
	document.getElementById("strength_M").style.background = Mcolor;
	document.getElementById("strength_H").style.background = Hcolor;
	return;
}
