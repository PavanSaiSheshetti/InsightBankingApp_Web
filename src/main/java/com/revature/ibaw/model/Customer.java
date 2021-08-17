package com.revature.ibaw.model;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.NamedQueries;

//POJO Class

@Entity
@Table(name="ibaw.customers")
@NamedQueries({
	@NamedQuery(name="makeWithdrawalQuery",
			query = "update Customer set accountBalance=accountBalance-:debitAmount where accountNumber=:accountNumber"),
	@NamedQuery(name="makeDepositQuery",
			query="update Customer set accountBalance=accountBalance+:creditAmount where accountNumber=:accountNumber"),
	@NamedQuery(name="validateCustomerQuery",
			query="from com.revature.ibaw.model.Customer where customerUserName=:userName and customerPassword=:password")
})
public class Customer {

	
	@Column
	private long customerCifId;
	@Column
	private String customerFirstName;
	@Column
	private String customerLastName;
	@Id
	@Column
	private String customerUserName;
	@Column
	private String customerPassword;
	@Column
	private long accountNumber;
	@Column
	private long accountBalance;
	@Column
	private String dateOfAccountCreation;
	
	//Default Constructor
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	//Parameterized Constructor
	public Customer(long customerCifId, String customerFirstName, String customerLastName, String customerUserName,
			String customerPassword, long accountNumber, long accountBalance, String dateOfAccountCreation) {
		super();
		this.customerCifId = customerCifId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.dateOfAccountCreation = dateOfAccountCreation;
	}
	
	//Getter and Setter methods
	public long getCustomerCifId() {
		return customerCifId;
	}


	public void setCustomerCifId(long customerCifId) {
		this.customerCifId = customerCifId;
	}


	public String getCustomerFirstName() {
		return customerFirstName;
	}


	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}


	public String getCustomerLastName() {
		return customerLastName;
	}


	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}


	public String getCustomerUserName() {
		return customerUserName;
	}


	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}


	public String getCustomerPassword() {
		return customerPassword;
	}


	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public long getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}


	public String getDateOfAccountCreation() {
		return dateOfAccountCreation;
	}


	public void setDateOfAccountCreation(String dateOfAccountCreation) {
		this.dateOfAccountCreation = dateOfAccountCreation;
	}


	@Override
	public String toString() {
		return "\nCustomer [customerCifId=" + customerCifId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerUserName=" + customerUserName
				+ ", customerPassword=" + customerPassword + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", dateOfAccountCreation=" + dateOfAccountCreation + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountBalance, accountNumber, customerCifId, customerFirstName, customerLastName,
				customerPassword, customerUserName, dateOfAccountCreation);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return accountBalance == other.accountBalance && accountNumber == other.accountNumber
				&& customerCifId == other.customerCifId && Objects.equals(customerFirstName, other.customerFirstName)
				&& Objects.equals(customerLastName, other.customerLastName)
				&& Objects.equals(customerPassword, other.customerPassword)
				&& Objects.equals(customerUserName, other.customerUserName)
				&& Objects.equals(dateOfAccountCreation, other.dateOfAccountCreation);
	}
	
}
