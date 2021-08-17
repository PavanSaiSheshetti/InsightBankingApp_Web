package com.revature.ibaw.service;

import java.util.List;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.repository.EmployeeRepository;
import com.revature.ibaw.repository.EmployeeRepositoryAlpha;

public class EmployeeServiceAlpha implements EmployeeService {

	EmployeeRepository employeeRepository=new EmployeeRepositoryAlpha();
	Customer customer;
	public EmployeeServiceAlpha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long viewAccountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		long balance=employeeRepository.viewAccountBalance(accountNumber);
		return balance;
	}

	@Override
	public List<Customer> getCustomerBankAccounts() {
		// TODO Auto-generated method stub
		List list=employeeRepository.getCustomerBankAccounts();
		return list;
	}

	@Override
	public Customer getCustomerDetails(long accountNumber) {
		// TODO Auto-generated method stub
		customer=employeeRepository.getCustomerDetails(accountNumber);
		return customer;
	}

	@Override
	public String validateEmployee(String employeeUserName, String employeePassword) {
		// TODO Auto-generated method stub
		String result=employeeRepository.validateEmployee(employeeUserName, employeePassword);
		return result;
	}

	@Override
	public String isCustomerExist(long accountNumber) {
		// TODO Auto-generated method stub
		String result=employeeRepository.isCustomerExist(accountNumber);
		return result;
	}

	@Override
	public boolean approveAccount(long accountNumber) {
		// TODO Auto-generated method stub
		boolean result=employeeRepository.approveAccount(accountNumber);
		return result;
	}

}
