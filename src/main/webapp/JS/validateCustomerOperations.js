/**
 * 
 */
function deposit(){
	document.getElementById("depositSection").style.display="block";
	document.getElementById("withdrawSection").style.display="none";
	document.getElementById("transferSection").style.display="none";
	document.getElementById("getBalance").style.display="none";
}
function withdraw(){
	document.getElementById("withdrawSection").style.display="block";
	document.getElementById("transferSection").style.display="none";
	document.getElementById("depositSection").style.display="none";
	document.getElementById("getBalance").style.display="none";
}
function transfer(){
	document.getElementById("transferSection").style.display="block";
	document.getElementById("depositSection").style.display="none";
	document.getElementById("withdrawSection").style.display="none";
	document.getElementById("getBalance").style.display="none";
}

function validateCreditAmount(){
	
	var amount=document.getElementById("creditamount").value;
	var amount_error=document.getElementById("amount_error_deposit");
	amount_error.innerHTML=null;
	if(amount.length==0){
		amount_error.innerHTML="please enter amount to deposit"
		return false;
	}
	else if(amount<0){
		amount_error.innerHTML="please enter valid amount"
		return false;
	}
	else if(amount<500){
		amount_error.innerHTML="deposit amount must be 500 or above"
		return false;
	}
	else if(amount>25000){
		amount_error.innerHTML="you can't deposit more than 25000"
		return false;
	}
	else{
		return true;
	}
}
function validateDebitAmount(){

	var amount=document.getElementById("debitamount").value;
	var amount_error=document.getElementById("amount_error_withdraw");
	amount_error.innerHTML=null;
	if(amount.length==0){
		amount_error.innerHTML="please enter amount to withdraw"
		return false;
	}
	else if(amount<0){
		amount_error.innerHTML="please enter valid amount"
		return false;
	}
	else if(amount<500){
		amount_error.innerHTML="withdraw amount must be 500 or above"
		return false;
	}
	else if(amount>25000){
		amount_error.innerHTML="you can't withdraw more than 25000"
		return false;
	}
	else{
		return true;
	}
}
function validateTransferAmount(){
	
	var amount=document.getElementById("transferamount").value;
	var amount_error=document.getElementById("amount_error_transfer");
	var accountNumber=document.getElementById("accountNumber").value;
	var accountNumber_error=document.getElementById("accountNumber_error");
	amount_error.innerHTML=null;
	accountNumber_error.innerHTML=null;
	
	if(accountNumber.length==0){
		accountNumber_error.innerHTML="please enter sender account Number"
		return false;
	}
	if(amount.length==0){
		amount_error.innerHTML="please enter money to transfer"
		return false;
	}
	else if(amount<0){
		amount_error.innerHTML="please enter valid amount"
		return false;
	}
	else if(amount<500){
		amount_error.innerHTML="transfer amount must be 500 or above"
		return false;
	}
	else if(amount>25000){
		amount_error.innerHTML="you can't transfer more than 25000"
		return false;
	}
	else{
		return true;
	}
}