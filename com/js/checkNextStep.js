function isaccepted(){
	var checkAgreement = document.getElementById("checkAgreement");
	if (checkAgreement.checked == true){
		document.getElementById("nextStep").style.backgroundColor="#FF8000";
        document.getElementById("nextStep").removeAttribute("disabled");//移除disabled
        }else{
        	document.getElementById("nextStep").style.backgroundColor="#999999";
            document.getElementById("nextStep").disadled="disabled";
     }
}
