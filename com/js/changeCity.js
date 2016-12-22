var provinceArr = new Array();
provinceArr[0] = "请选择省份";
provinceArr[1] = "江西";
provinceArr[2] = "广东";
var cityArr = new Array();
var cityArr[0] = new Array();
var cityArr[1] = new Array();
var cityArr[2] = new Array();
cityArr[0][0] = "请选择城市";

cityArr[1][0] = "南昌市";
cityArr[1][1] = "吉安市";
cityArr[1][2] = "赣州市";

cityArr[2][0] = "南昌市";
cityArr[2][1] = "吉安市";
cityArr[2][2] = "赣州市";
function changeCity(obj){
	var province  = document.getElementById("province");
	var city = document.getElementById("city");
	var pvalue = province.options(province.selectedIndex).value;
	for (var i = 0;i < cityArr[pvalue].length;i++){
		var text = cityArr[pvalue][i];
		var value = i;
		city.options(city.optins.length) = new Option(text,value);
	}
}
