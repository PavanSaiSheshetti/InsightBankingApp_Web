package com.revature.ibaw.service;

import org.apache.log4j.Logger;

import com.revature.ibaw.model.Customer;
import com.revature.ibaw.repository.CustomerRepository;
import com.revature.ibaw.repository.CustomerRepositoryAlpha;

public class CustomerServiceAlpha implements CustomerService {

	Logger logger=Logger.getLogger("Loggin Info--Insight Banking App");
	Customer customer=new Customer();
	CustomerRepository customerRepository=new CustomerRepositoryAlpha();
	public CustomerServiceAlpha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.addCustomer(customer);
		return true;
	}

	@Override
	public Customer makeWithdrawal(Customer customer, long debitAmount) {
		// TODO Auto-generated method stub
//		********************************************************************
		logger.info("customer entered withdraw money section");
//		********************************************************************
		customer=customerRepository.makeWithdrawal(customer, debitAmount);
		return customer;
	}

	@Override
	public Customer makeDeposit(Customer customer, long creditAmount) {
		// TODO Auto-generated method stub
//		********************************************************************
		logger.info("customer entered deposit money section");
//		********************************************************************
		customer=customerRepository.makeDeposit(customer, creditAmount);
		return customer;
	}

	@Override
	public Customer makeMoneyTransfer(Customer customer, long customerAccountNumber, long amount) {
		// TODO Auto-generated method stub
//		********************************************************************
		logger.info("Customer entered TRANSFER MONEY section ");
//		********************************************************************
		customer=customerRepository.makeMoneyTransfer(customer, customerAccountNumber, amount);
		return customer;
	}

	@Override
	public void aboutApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer loadCustomerDetails(String customerUserName) {
		// TODO Auto-generated method stub
		customer=customerRepository.loadCustomerDetails(customerUserName);
		return customer;
	}

	@Override
	public Customer validateCustomer(String customerUserName, String customerPassword) {
		// TODO Auto-generated method stub
		customer=customerRepository.validateCustomer(customerUserName, customerPassword);
		return customer;
	}

	@Override
	public boolean deleteCustomer(String CustomeruserName) {
		// TODO Auto-generated method stub
		customerRepository.deleteCustomer(CustomeruserName);
		return true;
	}

}
