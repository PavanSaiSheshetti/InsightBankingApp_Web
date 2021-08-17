package com.revature.ibaw.service;

import java.util.List;

import com.revature.ibaw.model.Customer;

public interface EmployeeService {
	public long viewAccountBalance(long accountNumber);
	public List<Customer> getCustomerBankAccounts();
	public Customer getCustomerDetails(long accountNumber);
	public String validateEmployee(String employeeUserName,String employeePassword);
	public String isCustomerExist(long accountNumber);
	public boolean approveAccount(long accountNumber);
}
