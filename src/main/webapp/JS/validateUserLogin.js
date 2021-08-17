/**
 * 
 */
function validate() {
	var username = document.getElementById("userName").value;
	var password = document.getElementById("password").value;
	
	var username_error=document.getElementById("userName_error");
	var password_error=document.getElementById("password_error");
	
	username_error.innerHTML="";
	password_error.innerHTML="";
	
	if (username.length == 0) {
		username_error.innerHTML="please enter username";
		return false;
	}
	else if (password.length == 0) {
		password_error.innerHTML="please enter password";
		return false;
	}
	else {
		return true;
	}
}