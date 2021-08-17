/**
 * 
 */
function getBalance(){
	document.getElementById("getBalanceSection").style.display="block";
	document.getElementById("getCustomerDetails").style.display="none";
	document.getElementById("approveAccount").style.display="none";
}
function getCustomerDetails(){
	document.getElementById("getBalanceSection").style.display="none";
	document.getElementById("getCustomerDetails").style.display="block";
	document.getElementById("approveAccount").style.display="none";
}
function approve(){
	document.getElementById("getBalanceSection").style.display="none";
	document.getElementById("getCustomerDetails").style.display="none";
	document.getElementById("approveAccount").style.display="block";
}
function validateAccount(){
	var accountNumber=document.getElementById("accountNumberB").value;
	var account_error=document.getElementById("account_errorB");
	account_error.innerHTML=null;
	if(accountNumber.length==0){
		account_error.innerHTML="please enter account number";
		return false;
	}
	else if(accountNumber.length!=9){
		account_error.innerHTML="account number must be of 9 digits";
		return false;
	}
	else{
		return true;
	}
	
}
function validateAccountt(){
	var accountNumber=document.getElementById("accountNumberC").value;
	var account_error=document.getElementById("account_errorC");
	account_error.innerHTML=null;
	if(accountNumber.length==0){
		account_error.innerHTML="please enter account number";
		return false;
	}
	else if(accountNumber.length!=9){
		account_error.innerHTML="account number must be of 9 digits";
		return false;
	}
	else{
		return true;
	}
	
}
function validateAccounttt(){
	var accountNumber=document.getElementById("accountNumberA").value;
	var account_error=document.getElementById("account_errorA");
	account_error.innerHTML=null;
	if(accountNumber.length==0){
		account_error.innerHTML="please enter account number";
		return false;
	}
	else if(accountNumber.length!=9){
		account_error.innerHTML="account number must be of 9 digits";
		return false;
	}
	else{
		return true;
	}
	
}