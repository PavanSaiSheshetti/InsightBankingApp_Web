/**
 * 
 */
function validateCustomer(){
	
console.log("hello");
var firstName=document.getElementById("firstName").value;
var lastName=document.getElementById("lastName").value;
var userName=document.getElementById("userName").value;
var password=document.getElementById("password").value;
var rePassword=document.getElementById("rePassword").value;
var openingDeposit=document.getElementById("openingDeposit").value;

var firstName_error=document.getElementById("firstName_error");
var lastName_error=document.getElementById("lastName_error");
var userName_error=document.getElementById("userName_error");
var password_error=document.getElementById("password_error");
var rePassword_error=document.getElementById("rePassword_error");
var openingDeposit_error=document.getElementById("openingDeposit_error");

firstName_error.innerHTML=null;
lastName_error.innerHTML=null;
userName_error.innerHTML=null;
password_error.innerHTML=null;
rePassword_error.innerHTML=null;
openingDeposit_error.innerHTML=null;

var format1 = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;
var format2 = /[A-Z]/;
var format3=/[0-9]/;
if(firstName.length==0){
	firstName_error.innerHTML="please enter firstname"
	return false;
}
else if(lastName.length==0){
	lastName_error.innerHTML="please enter lastname"
	return false;
}
else if(userName.length==0){
	userName_error.innerHTML="please enter username"
	return false;
}
else if(password.length==0){
	password_error.innerHTML="please enter password"
	return false;
}
else if(password.length<8){
	password_error.innerHTML="password must be of 8 characters"
	return false;
}


else if(format1.test(password)==false){
	password_error.innerHTML="password must contain atleast one special character"
	return false;
}
else if(format2.test(password)==false){
	password_error.innerHTML="password must contain atleast one Capital letter"
	return false;
}
else if(format3.test(password)==false){
	password_error.innerHTML="password must contain atleast one number[0-9]"
	return false;
}


else if(rePassword.length==0){
	rePassword_error.innerHTML="please enter repassword"
	return false;
}
else if(password.localeCompare(rePassword)){

	rePassword_error.innerHTML="password mismatch.password and repassword must be same"
	return false;
}

else if(openingDeposit.length==0){
	openingDeposit_error.innerHTML="please enter opening deposit"
	return false;
}
else if(openingDeposit<0){
	openingDeposit_error.innerHTML="please enter valid amount"
	return false;
}
else if(openingDeposit<1000){
	openingDeposit_error.innerHTML="opening balance must be 1000 or above"
	return false;
}
else{
	return true;
}
}


