package com.revature.ibaw.repository;

import com.revature.ibaw.model.Customer;

public interface CustomerRepository {

	public boolean addCustomer(Customer customer);
	public Customer makeWithdrawal(Customer customer,long debitAmount);
	public Customer makeDeposit(Customer customer,long creditAmount);
	public Customer makeMoneyTransfer(Customer customer,long customerAccountNumber,long amount);
	public void aboutApp();
	public Customer loadCustomerDetails(String customerUserName);
	public Customer validateCustomer(String customerUserName,String customerPassword);
	//for testing purpose
	public boolean deleteCustomer(String customerUserName);
}
