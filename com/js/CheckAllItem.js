//复选框onclick事件：点击全选，再次点击全不选
function CheckItem() {
	//添加外部判断：奇数点击时value为1，全不选，否则全选，如此可以在反选与全选间衍生出极端选择的方案
	var checkbox = document.getElementById("allChecked");
	//value初始化为1，此处的三目执行后value一定不为1，而页面初始化时checkbox都为未选中状态，所以value为1时全不选
	checkbox.value == "checkAllItem" ? checkbox.value = "checkItem" : checkbox.value = "checkAllItem";
	var checkboxs = document.getElementsByName("checkItem");
	for(var i = 0; i < checkboxs.length; i++) {
		//************
		if(checkbox.value == "checkAllItem") {
			checkboxs[i].checked = true; //全选
		} else {
			checkboxs[i].checked = false; //全不选
		}
		//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//反选
	}
}
